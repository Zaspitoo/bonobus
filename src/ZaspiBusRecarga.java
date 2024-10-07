import javax.swing.*;
import com.toedter.calendar.JMonthChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZaspiBusRecarga extends JFrame {

    private JTextField numeroTarjetaField;
    private JTextField nombreUsuarioField;
    private JButton recargarAbonoButton;
    private JMonthChooser monthChooser;
    private String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public ZaspiBusRecarga() {
        // Configuración de la ventana
        setTitle("Zaspi Bus Recarga");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el panel principal con BoxLayout (para alineación vertical)
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBackground(Color.DARK_GRAY); // Fondo gris oscuro
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Icono Zaspi
        JLabel logoLabel = new JLabel("Ángel Muñiz", SwingConstants.RIGHT);
        logoLabel.setForeground(Color.LIGHT_GRAY); // Texto claro para contraste
        logoLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Etiqueta de Zaspi Bus
        JLabel redBusLabel = new JLabel("Zaspi Bus", SwingConstants.LEFT);
        redBusLabel.setFont(new Font("Arial", Font.BOLD, 20));
        redBusLabel.setForeground(Color.WHITE); // Texto blanco
        redBusLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Imagen de tarjeta (simulada con un ImageIcon)
        JLabel tarjetaImagen = new JLabel();
        ImageIcon icon = new ImageIcon("src/images/th.jpg");  // Cambia la ruta a tu imagen
        tarjetaImagen.setIcon(icon);
        tarjetaImagen.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Campo para el número de tarjeta
        numeroTarjetaField = new JTextField(20);
        JLabel numeroTarjetaLabel = new JLabel("Número de tarjeta Zaspi Bus");
        numeroTarjetaLabel.setForeground(Color.LIGHT_GRAY); // Texto claro
        numeroTarjetaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        numeroTarjetaField.setMaximumSize(new Dimension(350, 30));

        // Campo para el nombre de usuario
        nombreUsuarioField = new JTextField(20);
        JLabel nombreUsuarioLabel = new JLabel("Nombre Usuario");
        nombreUsuarioLabel.setForeground(Color.LIGHT_GRAY); // Texto claro
        nombreUsuarioLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        nombreUsuarioField.setMaximumSize(new Dimension(350, 30));
        nombreUsuarioField.setText("Ej: Angelito");
        nombreUsuarioField.setForeground(Color.GRAY);

        // Componente JMonthChooser para seleccionar el mes
        JLabel seleccionarMesLabel = new JLabel("Seleccione el mes para recargar su abono:");
        seleccionarMesLabel.setForeground(Color.LIGHT_GRAY); // Texto claro
        seleccionarMesLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        monthChooser = new JMonthChooser();
        monthChooser.setMaximumSize(new Dimension(350, 30));

        // Botón de recargar abono
        recargarAbonoButton = new JButton("Recargar Abono");
        recargarAbonoButton.setBackground(new Color(0, 150, 255));
        recargarAbonoButton.setForeground(Color.WHITE);
        recargarAbonoButton.setFocusPainted(false);
        recargarAbonoButton.setMaximumSize(new Dimension(350, 40));
        recargarAbonoButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Acción del botón "Recargar Abono"
        recargarAbonoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int mesSeleccionado = monthChooser.getMonth();
                String mesNombre = meses[mesSeleccionado];
                JOptionPane.showMessageDialog(null, "Su abono de transporte ha sido recargado para el mes de: " + mesNombre);
            }
        });

        // Agregar componentes al panel principal
        panelPrincipal.add(logoLabel);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));  // Espacio en blanco
        panelPrincipal.add(redBusLabel);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));  // Espacio en blanco
        panelPrincipal.add(tarjetaImagen);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));  // Espacio en blanco
        panelPrincipal.add(numeroTarjetaLabel);
        panelPrincipal.add(numeroTarjetaField);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));  // Espacio en blanco
        panelPrincipal.add(nombreUsuarioLabel);
        panelPrincipal.add(nombreUsuarioField);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));  // Espacio en blanco

        // Añadir el selector de mes
        panelPrincipal.add(seleccionarMesLabel);
        panelPrincipal.add(monthChooser);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));  // Espacio en blanco

        // Botón "Recargar Abono"
        panelPrincipal.add(recargarAbonoButton);

        // Añadir el panel principal al frame
        add(panelPrincipal);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ZaspiBusRecarga frame = new ZaspiBusRecarga();
            frame.setVisible(true);
        });
    }
}
