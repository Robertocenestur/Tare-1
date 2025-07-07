// PRACTICA 2: Login Simple

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        colocarComponentes(panel);

        frame.setVisible(true);
    }

    private static void colocarComponentes(JPanel panel) {
        panel.setLayout(null);

        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setBounds(10, 20, 80, 25);
        panel.add(usuarioLabel);

        JTextField usuarioText = new JTextField(20);
        usuarioText.setBounds(100, 20, 165, 25);
        panel.add(usuarioText);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Ingresar");
        loginButton.setBounds(10, 80, 100, 25);
        panel.add(loginButton);

        JLabel mensaje = new JLabel("");
        mensaje.setBounds(10, 110, 300, 25);
        panel.add(mensaje);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioText.getText();
                String password = new String(passwordText.getPassword());

                if (usuario.equals("CENESTUR") && password.equals("C1234")) {
                    mensaje.setText("Acceso permitido");
                } else {
                    mensaje.setText("Acceso denegado");
                }
            }
        });
    }
}