// PRACTICA 3: Cálculo de Subtotal, IVA y Total
import javax.swing.*;
import java.awt.*;

public class FacturaSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Factura Producto");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        colocarComponentes(panel);

        frame.setVisible(true);
    }

    private static void colocarComponentes(JPanel panel) {
        panel.setLayout(null);

        JLabel codigoLabel = new JLabel("Código:");
        codigoLabel.setBounds(10, 20, 80, 25);
        panel.add(codigoLabel);

        JTextField codigoText = new JTextField(20);
        codigoText.setBounds(100, 20, 165, 25);
        panel.add(codigoText);

        JLabel productoLabel = new JLabel("Producto:");
        productoLabel.setBounds(10, 50, 80, 25);
        panel.add(productoLabel);

        JTextField productoText = new JTextField(20);
        productoText.setBounds(100, 50, 165, 25);
        panel.add(productoText);

        JLabel precioLabel = new JLabel("Precio Unitario:");
        precioLabel.setBounds(10, 80, 110, 25);
        panel.add(precioLabel);

        JTextField precioText = new JTextField(20);
        precioText.setBounds(130, 80, 100, 25);
        panel.add(precioText);

        JLabel cantidadLabel = new JLabel("Cantidad:");
        cantidadLabel.setBounds(10, 110, 80, 25);
        panel.add(cantidadLabel);

        JTextField cantidadText = new JTextField(20);
        cantidadText.setBounds(100, 110, 100, 25);
        panel.add(cantidadText);

        JButton calcularButton = new JButton("Calcular");
        calcularButton.setBounds(10, 150, 100, 25);
        panel.add(calcularButton);

        JLabel subtotalLabel = new JLabel("Subtotal: ");
        subtotalLabel.setBounds(10, 190, 300, 30);
        subtotalLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Etiqueta grande
        panel.add(subtotalLabel);

        JLabel ivaLabel = new JLabel("IVA (15%): ");
        ivaLabel.setBounds(10, 230, 300, 30);
        ivaLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Etiqueta grande
        panel.add(ivaLabel);

        JLabel totalLabel = new JLabel("Total a pagar: ");
        totalLabel.setBounds(10, 270, 300, 30);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Etiqueta grande
        panel.add(totalLabel);

        calcularButton.addActionListener(e -> {
            try {
                double precio = Double.parseDouble(precioText.getText());
                int cantidad = Integer.parseInt(cantidadText.getText());

                double subtotal = precio * cantidad;
                double iva = subtotal * 0.15;
                double total = subtotal + iva;

                subtotalLabel.setText("Subtotal: $" + String.format("%.2f", subtotal));
                ivaLabel.setText("IVA (15%): $" + String.format("%.2f", iva));
                totalLabel.setText("Total a pagar: $" + String.format("%.2f", total));
            } catch (NumberFormatException ex) {
                subtotalLabel.setText("⚠️ Error en datos ingresados.");
                ivaLabel.setText("");
                totalLabel.setText("");
            }
        });
    }
}