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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JCadastrarUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JPasswordField passwordFieldSenha;

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

		JButton btnNewButtonCadastrar = new JButton("CADASTRAR");
		btnNewButtonCadastrar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Usuario usuario = new Usuario(textFieldNome.getText(), passwordFieldSenha.getText());

				if (usuario != null) {
					if (!"".equalsIgnoreCase(textFieldNome.getText())
							&& !"".equalsIgnoreCase(passwordFieldSenha.getText())) {
						dao.cadastrarUsuario(usuario);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Confira os campos NOME DE USUARIO e SENHA! ");

					}

				}

			}
		});
		btnNewButtonCadastrar.setForeground(new Color(0, 0, 0));
		btnNewButtonCadastrar.setBackground(new Color(255, 255, 255));
		btnNewButtonCadastrar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButtonCadastrar.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		btnNewButtonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario(textFieldNome.getText(), passwordFieldSenha.getText());

				if (usuario != null) {
					if (!"".equalsIgnoreCase(textFieldNome.getText())
							&& !"".equalsIgnoreCase(passwordFieldSenha.getText())) {
						dao.cadastrarUsuario(usuario);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Confira os campos NOME DE USUARIO e SENHA! ");

					}

				}

			}
		});
		btnNewButtonCadastrar.setBounds(305, 227, 119, 23);
		contentPane.add(btnNewButtonCadastrar);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(53, 37, 322, 179);
		contentPane.add(panel);
		panel.setLayout(null);

		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					btnNewButtonCadastrar.requestFocus();

				}
			}
		});
		passwordFieldSenha.setBounds(79, 118, 157, 18);
		panel.add(passwordFieldSenha);
		passwordFieldSenha.setBorder(new LineBorder(new Color(128, 128, 128), 2));

		textFieldNome = new JTextField();
		textFieldNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					passwordFieldSenha.requestFocus();

				}

			}
		});
		textFieldNome.setBounds(79, 66, 157, 18);
		panel.add(textFieldNome);
		textFieldNome.setBorder(new LineBorder(new Color(128, 128, 128), 2));
		textFieldNome.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("NOME DE USUARIO");
		lblNewLabel_3.setBounds(79, 52, 94, 13);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 11));

		JLabel lblNewLabel_2 = new JLabel("SENHA");
		lblNewLabel_2.setBounds(79, 106, 35, 13);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 11));
	}
}
