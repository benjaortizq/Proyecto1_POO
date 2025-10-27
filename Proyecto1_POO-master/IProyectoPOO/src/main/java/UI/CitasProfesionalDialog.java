package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.time.format.DateTimeFormatter;
import Abstractas.Personal;

public class CitasProfesionalDialog extends JDialog {
    private final Personal profesional;
    private final FramePersonal owner;
    private final DefaultTableModel model;
    private final JTable table;
    private final java.util.List<Abstractas.Cita> listaCitas;

    public CitasProfesionalDialog(FramePersonal owner, Personal profesional) {
        super(owner, "Citas programadas - " + profesional.getNombre(), true);
        this.owner = owner;
        this.profesional = profesional;

        // obtener la lista de citas del profesional
        if (profesional instanceof Concretas.Doctor) {
            listaCitas = ((Concretas.Doctor) profesional).getGestorCitas().getListaCitas();
        } else if (profesional instanceof Concretas.Enfermeria) {
            listaCitas = ((Concretas.Enfermeria) profesional).getGestorCitas().getListaCitas();
        } else {
            listaCitas = new java.util.ArrayList<>();
        }

        setLayout(new BorderLayout());
        model = new DefaultTableModel(new Object[] {"Fecha","Hora","Paciente","Profesional","Estado","Consultorio"}, 0) {
            @Override public boolean isCellEditable(int row, int col) { return false; }
        };
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnAgregarMedic = new JButton("Agregar Medicamentos");
        JButton btnCambiarEstado = new JButton("Cambiar Estado");
        JButton btnCerrar = new JButton("Cerrar");

        botones.add(btnAgregarMedic);
        botones.add(btnCambiarEstado);
        botones.add(btnCerrar);
        add(botones, BorderLayout.SOUTH);

        // cargar filas
        refreshTable();

        // acciones
        btnCerrar.addActionListener(e -> dispose());

        btnCambiarEstado.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Seleccione una cita.");
                return;
            }
            Abstractas.Cita cita = listaCitas.get(row);
            String[] opciones = {"Atendida", "Pendiente", "Cancelada", "Reagendada", "Pagada"};
            String nuevo = (String) JOptionPane.showInputDialog(
                    this, "Seleccione nuevo estado:", "Cambiar estado",
                    JOptionPane.PLAIN_MESSAGE, null, opciones, cita.getEstado() == null ? opciones[0] : cita.getEstado());
            if (nuevo != null) {
                cita.setEstado(nuevo);
                refreshTable();
                JOptionPane.showMessageDialog(this, "Estado cambiado a: " + nuevo);
            }
        });

        btnAgregarMedic.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Seleccione una cita.");
                return;
            }
            Abstractas.Cita cita = listaCitas.get(row);
            agregarProductoACita(cita);
        });

        // tamaño y centrado
        setPreferredSize(new Dimension(800, 400));
        pack();
        setLocationRelativeTo(owner);
    }

    private void refreshTable() {
        model.setRowCount(0);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter hf = DateTimeFormatter.ofPattern("HH:mm");
        for (Abstractas.Cita c : listaCitas) {
            model.addRow(new Object[] {
                c.getFecha().format(df),
                c.getHora().format(hf),
                c.getPacienteAsignado() != null ? c.getPacienteAsignado().getNombre() : "N/A",
                c.getProfesionalAsignado() != null ? c.getProfesionalAsignado().getNombre() : "N/A",
                c.getEstado(),
                "H" + c.getConsultorioAsignado()
            });
        }
    }

    private void agregarProductoACita(Abstractas.Cita cita) {
        // obtener inventario del hospital (viene desde owner.getHospital())
        Concretas.Inventario inventario = owner.getHospital().getInventario();
        if (inventario == null) {
            JOptionPane.showMessageDialog(this, "Inventario no disponible.");
            return;
        }

        // listar nombres disponibles
        java.util.Map<String, Concretas.Item> mapa = null;
        try {
            // asumimos que Inventario tiene un getter getInventario() que devuelve Map<String,Item>
            mapa = inventario.getInventario();
        } catch (Throwable ex) {
            // si no existe ese getter, intentamos buscar por otro método (buscarProducto)
        }

        String[] opciones;
        if (mapa != null && !mapa.isEmpty()) {
            opciones = mapa.keySet().toArray(new String[0]);
        } else {
            // intentar armar lista consultando getLista (fallback)
            java.util.List<String> names = new java.util.ArrayList<>();
            // si inventario tiene otro modo, puedes adaptarlo; aquí usamos buscarProducto si existe
            // para no romper la compilación: vamos a intentar usar getInventario(); si no está, mostramos mensaje.
            JOptionPane.showMessageDialog(this, "No hay productos en inventario o inventario no expuesto con getInventario().");
            return;
        }

        String elegido = (String) JOptionPane.showInputDialog(this, "Seleccione producto:", "Agregar producto",
                JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        if (elegido == null) return;

        Concretas.Item itemEnInventario = mapa.get(elegido);
        if (itemEnInventario == null) {
            JOptionPane.showMessageDialog(this, "Producto no encontrado en inventario.");
            return;
        }

        String cantidadStr = JOptionPane.showInputDialog(this, "Cantidad a usar (stock: " + itemEnInventario.getCantidad() + "):", "1");
        if (cantidadStr == null) return;
        int cantidad;
        try {
            cantidad = Integer.parseInt(cantidadStr);
            if (cantidad <= 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Cantidad inválida.");
            return;
        }

        if (cantidad > itemEnInventario.getCantidad()) {
            JOptionPane.showMessageDialog(this, "Stock insuficiente.");
            return;
        }

        // añadir al producto usado en la cita
        Concretas.Item uso = new Concretas.Item(itemEnInventario.getProducto(), cantidad);
        cita.anadirProducto(uso);

        // descontar del inventario (si cantidad llega a 0, remover)
        itemEnInventario.setCantidad(itemEnInventario.getCantidad() - cantidad);
        if (itemEnInventario.getCantidad() <= 0) {
            inventario.eliminarProducto(itemEnInventario.getProducto().getNombre());
        }

        refreshTable();
        JOptionPane.showMessageDialog(this, "Producto agregado a la cita y stock actualizado.");
    }
}