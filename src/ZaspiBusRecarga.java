import javax.swing.*;
import com.toedter.calendar.JMonthChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZaspiBusRecarga extends JFrame {

    private JTextField numeroTarjetaField;
    private JTextField nombreUsuarioField;
    private JTextField saldoAgregarField;
    private JLabel saldoActualLabel;
    private JButton recargarAbonoButton;
    private JMonthChooser monthChooser;
    private double saldoActual = 0.0;
    private String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public ZaspiBusRecarga() {
        // Configuración de la ventana
        setTitle("Zaspi Bus Recarga");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el panel principal con GridBagLayout
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setBackground(new Color(45, 52, 54));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Constraints para el layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        // Icono Zaspi
        JLabel logoLabel = new JLabel("Zaspi Bus", SwingConstants.CENTER);
        logoLabel.setForeground(new Color(223, 230, 233));
        logoLabel.setFont(new Font("Arial", Font.BOLD, 28));

        // Imagen de tarjeta (simulada con un ImageIcon)
        JLabel tarjetaImagen = new JLabel();
        ImageIcon icon = new ImageIcon("src/images/th.jpg");
        tarjetaImagen.setIcon(icon);
        tarjetaImagen.setHorizontalAlignment(SwingConstants.CENTER);

        // Campo para el número de tarjeta
        numeroTarjetaField = new JTextField(20);
        numeroTarjetaField.setFont(new Font("Arial", Font.PLAIN, 18));
        numeroTarjetaField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        numeroTarjetaField.setBackground(new Color(99, 110, 114));
        numeroTarjetaField.setForeground(Color.WHITE);

        JLabel numeroTarjetaLabel = new JLabel("Número de Tarjeta Zaspi Bus");
        numeroTarjetaLabel.setForeground(new Color(178, 190, 195)); // Texto claro
        numeroTarjetaLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Campo para el nombre de usuario
        nombreUsuarioField = new JTextField(20);
        nombreUsuarioField.setFont(new Font("Arial", Font.PLAIN, 18));
        nombreUsuarioField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        nombreUsuarioField.setBackground(new Color(99, 110, 114));
        nombreUsuarioField.setForeground(Color.WHITE);
        nombreUsuarioField.setText("Ej: Angelito");

        JLabel nombreUsuarioLabel = new JLabel("Nombre de Usuario");
        nombreUsuarioLabel.setForeground(new Color(178, 190, 195)); // Texto claro
        nombreUsuarioLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Componente JMonthChooser para seleccionar el mes
        JLabel seleccionarMesLabel = new JLabel("Seleccione el mes para recargar su abono:");
        seleccionarMesLabel.setForeground(new Color(178, 190, 195)); // Texto claro
        seleccionarMesLabel.setFont(new Font("Arial", Font.BOLD, 18));

        monthChooser = new JMonthChooser();
        monthChooser.setFont(new Font("Arial", Font.PLAIN, 18));
        monthChooser.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        monthChooser.setBackground(new Color(99, 110, 114));
        monthChooser.setForeground(Color.WHITE);

        // Campo para ingresar el saldo a recargar
        JLabel saldoAgregarLabel = new JLabel("Saldo a Agregar (€):");
        saldoAgregarLabel.setForeground(new Color(178, 190, 195));
        saldoAgregarLabel.setFont(new Font("Arial", Font.BOLD, 18));

        saldoAgregarField = new JTextField(20);
        saldoAgregarField.setFont(new Font("Arial", Font.PLAIN, 18));
        saldoAgregarField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        saldoAgregarField.setBackground(new Color(99, 110, 114));
        saldoAgregarField.setForeground(Color.WHITE);

        // Label para mostrar el saldo actual
        saldoActualLabel = new JLabel("Saldo actual: 0.00€");
        saldoActualLabel.setForeground(new Color(178, 190, 195));
        saldoActualLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Botón de recargar abono con efecto hover
        recargarAbonoButton = new JButton("Recargar Abono");
        recargarAbonoButton.setBackground(new Color(9, 132, 227));
        recargarAbonoButton.setForeground(Color.WHITE);
        recargarAbonoButton.setFont(new Font("Arial", Font.BOLD, 20));
        recargarAbonoButton.setFocusPainted(false);
        recargarAbonoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        recargarAbonoButton.setBorder(BorderFactory.createLineBorder(new Color(9, 132, 227), 2));

        // Añadir efecto de hover en el botón
        recargarAbonoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                recargarAbonoButton.setBackground(new Color(116, 185, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                recargarAbonoButton.setBackground(new Color(9, 132, 227));
            }
        });

        // Acción del botón "Recargar Abono"
        recargarAbonoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int mesSeleccionado = monthChooser.getMonth();
                    String mesNombre = meses[mesSeleccionado];
                    double saldoAgregar = Double.parseDouble(saldoAgregarField.getText());

                    saldoActual += saldoAgregar;
                    saldoActualLabel.setText("Saldo actual: " + String.format("%.2f", saldoActual) + "€");

                    // Mostrar mensaje de confirmación
                    JOptionPane.showMessageDialog(null, "Su abono de transporte ha sido recargado para el mes de: " + mesNombre + "\nSaldo agregado: " + String.format("%.2f", saldoAgregar) + "€\nSaldo total: " + String.format("%.2f", saldoActual) + "€");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un saldo válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Agregar componentes al panel principal
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(logoLabel, gbc);
        panelPrincipal.add(tarjetaImagen, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(numeroTarjetaLabel, gbc);
        panelPrincipal.add(numeroTarjetaField, gbc);

        panelPrincipal.add(nombreUsuarioLabel, gbc);
        panelPrincipal.add(nombreUsuarioField, gbc);

        panelPrincipal.add(seleccionarMesLabel, gbc);
        panelPrincipal.add(monthChooser, gbc);

        panelPrincipal.add(saldoAgregarLabel, gbc);
        panelPrincipal.add(saldoAgregarField, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(saldoActualLabel, gbc);
        panelPrincipal.add(recargarAbonoButton, gbc);

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
