package view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.Cliente;
import model.ModeloTabela;

public class JPrincipal extends JFrame{
    private JPanel contentPane;
    private JTextField textField;
    private JTable table;
    private ArrayList<Cliente> clientes;

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

clientes = new ArrayList<>();
clientes.add(new Cliente("1","Caio","Caio00798@gmail.com","456.789.012-34","12.345.678/0001-90","(11) 91234-5678","Nao informado"));
clientes.add(new Cliente("2","Daniela","Dani00932@hmail.com","567.890.123-45","6.789.012/0001-34","(21) 99876-5432","Nao informado"));

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
    //tamanho do botao
    btnNewButton.setBounds(22,
 9, 92, 23);
    //fonte do botao.
    btnNewButton.setFont(new Font("Serif ", Font.BOLD, 12));
    //mudar a cor do botao.
    btnNewButton.setBackground(Color.white);
    //mudar a cor do texto do JButton
    btnNewButton.setForeground(Color.black);
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
    
    ModeloTabela modeloTabela = new ModeloTabela(clientes);

    //Cria uma tabela e a coloca em um painel com barras de rolagem. Define o modelo da tabela com uma linha de dados e cabeçalhos vazios.
    table = new JTable();
    table.setModel(modeloTabela);
    scrollPane.setViewportView(table);
    
}

    
    




























}
