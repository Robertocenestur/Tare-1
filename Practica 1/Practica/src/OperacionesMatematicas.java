import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OperacionesMatematicas {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Operaciones Matemáticas");
        frame.setSize(450, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        colocarComponentes(panel);

        frame.setVisible(true);
    }

    private static void colocarComponentes(JPanel panel) {
        panel.setLayout(null);

        JLabel label1 = new JLabel("Valor 1:");
        label1.setBounds(10, 20, 80, 25);
        panel.add(label1);

        JTextField text1 = new JTextField(20);
        text1.setBounds(100, 20, 165, 25);
        panel.add(text1);

        JLabel label2 = new JLabel("Valor 2:");
        label2.setBounds(10, 50, 80, 25);
        panel.add(label2);

        JTextField text2 = new JTextField(20);
        text2.setBounds(100, 50, 165, 25);
        panel.add(text2);

        JLabel resultado = new JLabel("Resultado: ");
        resultado.setBounds(10, 150, 300, 25);
        panel.add(resultado);

        // Botón Sumar
        JButton sumaButton = new JButton("Sumar");
        sumaButton.setBounds(10, 90, 100, 25);
        panel.add(sumaButton);
        sumaButton.addActionListener(e -> calcular(text1, text2, resultado, "+"));

        // Botón Restar
        JButton restaButton = new JButton("Restar");
        restaButton.setBounds(120, 90, 100, 25);
        Component add = panel.add(restaButton);
        restaButton.addActionListener(e -> calcular(text1, text2, resultado, "-"));

        // Botón Multiplicar
        JButton multiplicaButton = new JButton("Multiplica");
        multiplicaButton.setBounds(230, 90, 120, 25);
        panel.add(multiplicaButton);
        multiplicaButton.addActionListener(e -> calcular(text1, text2, resultado, "*"));

        // Botón Dividir
        JButton divideButton = new JButton("Divide");
        divideButton.setBounds(360, 90, 100, 25);
        panel.add(divideButton);
        divideButton.addActionListener(e -> calcular(text1, text2, resultado, "/"));

        // Botón Borrar
        JButton borrarButton = new JButton("Borrar");
        borrarButton.setBounds(120, 180, 100, 25);
        panel.add(borrarButton);
        borrarButton.addActionListener(e -> {
            text1.setText("");
            text2.setText("");
            resultado.setText("Resultado: ");
        });
    }

    private static void calcular(JTextField text1, JTextField text2, JLabel resultado, String operador) {
        try {
            double num1 = Double.parseDouble(text1.getText());
            double num2 = Double.parseDouble(text2.getText());
            double res = switch (operador) {
                case "+" -> num1 + num2;
                case "-" -> num1 - num2;
                case "*" -> num1 * num2;
                case "/" -> {
                    if (num2 == 0) {
                        resultado.setText("Error: No se puede dividir por 0.");
                        yield Double.NaN;
                    }
                    yield num1 / num2;
                }
                default -> 0;
            };
            if (!Double.isNaN(res)) {
                resultado.setText("Resultado: " + res);
            }
        } catch (NumberFormatException ex) {
            resultado.setText("Error: Ingrese números válidos.");
        }
    }
}