
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

import dao.DAO;
import model.Cliente;
import model.ModeloTabela;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

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
    	
DAO dao = new DAO();

try {
	clientes = dao.listarCliente();
} catch (Exception e) {
	
	e.printStackTrace();
}


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
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		JCadastro jcadastro = new JCadastro(null);
    		jcadastro.setLocationRelativeTo(jcadastro);
    		jcadastro.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    		jcadastro.setVisible(true);
    	}
    });
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
    //instancia o campo de texto
    textField = new JTextField();
    //onde o texto vai ficar 
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
    
    //continuar aqui!!!
    table.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		if(e.getButton()==1) {
    			try {
					Cliente clienteSelecionado = dao.consultarCliente(modeloTabela.getValueAt(table.getSelectedRow(), 0).toString());
					JCadastro jcadastro = new JCadastro(clienteSelecionado);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			
    		}
    		
    	}
    	
	});
    
    table.setModel(modeloTabela);
    scrollPane.setViewportView(table);
    
}

    
    




























}
