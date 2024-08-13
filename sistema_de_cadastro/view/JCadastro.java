package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.border.LineBorder;

import dao.DAO;
import model.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCpfCnpj;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefone;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastro frame = new JCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public JCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOME");
		lblNewLabel.setBounds(10, 11, 34, 14);
		contentPane.add(lblNewLabel);
		//instancia o campo de texto
		textFieldNome = new JTextField();
		textFieldNome.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldNome.setBounds(10, 25, 320, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPFCNPJ");
		lblNewLabel_1.setBounds(10, 56, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldCpfCnpj = new JTextField();
		textFieldCpfCnpj.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldCpfCnpj.setBounds(10, 70, 175, 20);
		contentPane.add(textFieldCpfCnpj);
		textFieldCpfCnpj.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("EMAIL");
		lblNewLabel_2.setBounds(205, 56, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldEmail.setBounds(205, 70, 215, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("TELEFONE");
		lblNewLabel_3.setBounds(10, 111, 78, 14);
		contentPane.add(lblNewLabel_3);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldTelefone.setBounds(10, 125, 175, 20);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ENDEREÇO");
		lblNewLabel_4.setBounds(10, 166, 68, 14);
		contentPane.add(lblNewLabel_4);
		
		JTextArea textAreaEndereco = new JTextArea();
		textAreaEndereco.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaEndereco.setBounds(10, 179, 320, 48);
		contentPane.add(textAreaEndereco);
		
		JButton btnNewButton = new JButton("INCLUIR ");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO dao = new DAO();
				//String id, String nome, String email, String cpfCnpj, String telefone, String endereco
				dao.cadastrarCliente(new Cliente(null, textFieldNome.getText(), textFieldEmail.getText(), textFieldCpfCnpj.getText(), textFieldTelefone.getText(), textAreaEndereco.getText()));
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnNewButton.setBounds(347, 0, 87, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
