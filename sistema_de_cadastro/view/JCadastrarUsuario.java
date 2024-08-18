package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DAO;
import model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class JCadastrarUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNomedeUsuario;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastrarUsuario frame = new JCadastrarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JCadastrarUsuario() {
		DAO dao = new DAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("NOME DE USUARIO");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(138, 79, 119, 14);
		contentPane.add(lblNewLabel_3);

		textFieldNomedeUsuario = new JTextField();
		textFieldNomedeUsuario.setBorder(new LineBorder(new Color(128, 128, 128)));
		textFieldNomedeUsuario.setBounds(138, 94, 135, 20);
		contentPane.add(textFieldNomedeUsuario);
		textFieldNomedeUsuario.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("SENHA");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(138, 125, 79, 14);
		contentPane.add(lblNewLabel_2);

		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(128, 128, 128)));
		passwordField.setBounds(139, 140, 135, 20);
		contentPane.add(passwordField);

		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario(textFieldNomedeUsuario.getText(), passwordField.getText());
				if (usuario != null) {
					if (!"".equalsIgnoreCase(textFieldNomedeUsuario.getText())
							&& !"".equalsIgnoreCase(passwordField.getText())) {
						dao.cadastrarUsuario(usuario);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Confira os campos NOME DE USUARIO e SENHA! ");

					}

				}

			}
		});
		btnNewButton.setBounds(305, 227, 119, 23);
		contentPane.add(btnNewButton);
	}
}
