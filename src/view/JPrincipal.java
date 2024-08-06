package view;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class JPrincipal extends JFrame{
    private JPanel contentPane;
    private JTextField textField;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JPrincipal frame = new JPrincipal();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JPrincipal() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //tamnho da tela que ira aparecer para os usuarios.
    setBounds(100, 100, 746, 479);
    contentPane = new JPanel();
    contentPane.setBackground(new Color(255, 255, 255));
    contentPane.setBorder(new EmptyBorder(5, 5, 
 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    //botao de cadastrar.
    JButton btnNewButton = new JButton("Cadastrar");
    btnNewButton.setBounds(29,
 19, 29, 23);
    contentPane.add(btnNewButton);
    //espaço de texto.
    textField = new JTextField();
    textField.setBounds(123, 40, 418, 22);
    contentPane.add(textField);
    textField.setColumns(18);
    //barras de rolagem horizontal e vertical
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(29, 111, 665, 291);
    contentPane.add(scrollPane);
    //Cria uma tabela e a coloca em um painel com barras de rolagem. Define o modelo da tabela com uma linha de dados e cabeçalhos vazios.
    table = new JTable();
    scrollPane.setViewportView(table);
    table.setModel(new DefaultTableModel(
        new Object[][] {
            new String[]
 {"10", "CPF/CNPJ", "Home", "E-mail", "Telefone", "Endereço"}
        },
        new String[] {"", "", "", "", "", ""}
    ));
}

    
    




























}
