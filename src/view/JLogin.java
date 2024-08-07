package view;

import controller.Criptografia;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

                        //********JLabel e tipo um titulo********
                        //********JTextField onde o usuario ira escrever ex: senhas, emails e etc..********
                        //********JButton e literalmente um botao.********
                        //********JPassWordField usado para senhas********




                        
public class JLogin extends JFrame{
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JLogin frame = new JLogin();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
  


    public JLogin(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,450,350);
        contentPane = new JPanel();
        contentPane.setBackground(Color.gray);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(100,11,251,269);
        panel.setBackground(new Color(204,207,208));
        contentPane.add(panel);
        panel.setLayout(null);

        //JLabel e tipo um titulo
        JLabel lblNewLabel = new JLabel("Usuário");
        lblNewLabel.setBounds(42,54,46,14);
        lblNewLabel.setFont(new Font("Serif ", Font.BOLD, 11));
        panel.add(lblNewLabel);


        JTextField textFieldUsuario = new JTextField();
        textFieldUsuario.setBounds(42,67,160,23);
        panel.add(textFieldUsuario);
        textFieldUsuario.setColumns(10);

        //quanto maior for o y ele ira para baixo e quanto menor for ele ele ira para cima
        //quanto menor for o valor do x ele vai pra esquerda e quanto maior for o valor ele ira para direita.
        JLabel lblNewLabel_1 = new JLabel("Senha");
        lblNewLabel_1.setBounds(42,118,46,14);
        panel.add(lblNewLabel_1);


        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(42,132,160,23);
        panel.add(passwordField); 



        //botao de para entrar
        JButton bntNewButton = new JButton("Entra");
        bntNewButton.setBounds(79,182,89,23);
        panel.add(bntNewButton);

        //evento de click no botao
        bntNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Criptografia criptografia = new Criptografia(passwordField.getText(), Criptografia.MD5);
                System.out.println(criptografia.criptografar());
                //usado para testar se tem alguma iformaçao nesse campo
                //vai verificar se ele e diferente de nulo
                //tambem ira verificar se o campo de esta vazio
                //tambem ira verificar se a password e diferente de nulo e se o campo dela esta vazio
                //! usado para negar 
                if (textFieldUsuario.getText() != null && !textFieldUsuario.getText().isEmpty() && passwordField.getText() != null && !passwordField.getText().isEmpty()) {
                    if(criptografia.criptografar().equals("E10ADC3949BAS9ABBE566057F20F883E")){

                    }
                    JOptionPane.showMessageDialog(bntNewButton, "Login concluido com sucesso!");
                    dispose();
                    JPrincipal jPrincipal = new JPrincipal();
                    jPrincipal.setLocationRelativeTo(jPrincipal);
                    jPrincipal.setVisible(true);
                    
                }else{
                    JOptionPane.showMessageDialog(bntNewButton, "Informações incorretas", "Aviso",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        

        //quanto menor for o valor do x ele vai pra esquerda e quanto maior for o valor ele ira para direita.
        //quanto maior for o y ele ira para baixo e quanto menor for ele ira para cima
        JLabel lblNewLabel_2 = new JLabel("Bem vindo");
        lblNewLabel_2.setBounds(74,11,99,14);
        lblNewLabel_2.setFont(new Font("Serif ", Font.BOLD, 18));
        panel.add(lblNewLabel_2);

        

       






    }



























}
