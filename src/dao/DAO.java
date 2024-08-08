package dao;

import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Cliente;

public class DAO {
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    private static String DRIVER = "org.sqlite.JDBC";
    private static String BD = "jdbc:sqlite:resources/bdcliente.db";

    private static String CADASTRAR_CLIENTE = " INSERT INTO CLIENTE " +" (ID, NOME, CPF/CPNJ, EMAIL, TELEFONE, ENDERECO ) "
    +"VALUES(NULL,?,?,?,?,?)";

    private static String CONSULTA_CLIENTE = " SELECT * FROM CLIENTE " + " WHERE ID = ? ";
      
    private static String ALTERAR_CLIENTE = " INSERT INTO CLIENTE " +" ( NOME =? , CPF/CPNJ = ?, EMAIL = ?, TELEFONE = ?, ENDERECO = ?) "
    +" WHERE ID = ? ";

    private static String EXCLUIR_CLIENTE = " INSERT INTO CLIENTE " +" ( NOME =? , CPF/CPNJ = ?, EMAIL = ?, TELEFONE = ?, ENDERECO = ?) "
    +" WHERE ID = ? ";

    private static String LISTAR_CLIENTE = " INSERT INTO CLIENTE " +" ( NOME =? , CPF/CPNJ = ?, EMAIL = ?, TELEFONE = ?, ENDERECO = ?) "
    +" WHERE 1 = 1 ";

    private static String CONSULTAR_USUARIO = " SELECT USUARIO " + " FROM USUARIO "
    +"WHERE USUARIO + ?" + "SND SENHA + ?";


    public DAO(){

    }

    public void cadastrarCliente(Cliente cliente){
    Connection connection = Conexao.getInstancia().abrirConexao();

    String query = CADASTRAR_CLIENTE;
        try {
            preparedStatement = connection.prepareStatement(query);

            int i = 0;
            //ID, NOME, CPF/CPNJ, EMAIL, TELEFONE, ENDERECO
            preparedStatement.setString(i ++, cliente.getNome());
            preparedStatement.setString(i ++, cliente.getCpfCnpj());
            preparedStatement.setString(i ++, cliente.getEmail());
            preparedStatement.setString(i ++, cliente.getTelefone());
            preparedStatement.setString(i ++, cliente.getEndereco());

            connection.commit();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso ");

        } catch (SQLException e) {
            e.printStackTrace();

        }finally{
            fecharConexao(); }

        }

       
    
    public Cliente consultarCliente(String id ) throws Exception{
        Connection connection = Conexao.getInstancia().abrirConexao();
    
        String query = CADASTRAR_CLIENTE;
        Cliente cliente = null;
            try {
                preparedStatement = connection.prepareStatement(query);
    
                int i = 0;
                //ID, NOME, CPF/CPNJ, EMAIL, TELEFONE, ENDERECO
                preparedStatement.setString(i ++, id);
               
                resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){
                     //String id, String nome, String email, String cpfCnpj, String telefone, String endereco
                    cliente = new Cliente(resultSet.getString("ID"),
                                          resultSet.getString("nome"),
                                          resultSet.getString("email"),  
                                          resultSet.getString("cpfCnpj"),
                                          resultSet.getString("telefone"),
                                          resultSet.getString("endereco"));

                }
             
                
            } catch (SQLException e) {
                e.printStackTrace();
    
            }finally{
                fecharConexao(); }
    
            { 
            if(cliente == null){

                JOptionPane.showMessageDialog(null, "Nao foi possivel localizar o cliente selecionado", "" ,JOptionPane.WARNING_MESSAGE);
                    throw new Exception("Nao foi possivel localizar o cliente selecionado");
            }
            return cliente;
}}







private void fecharConexao(){
    try{
    if(resultSet!= null){
    }
    if (preparedStatement != null) {
        preparedStatement.close();
    }

    Conexao.getInstancia().fecharConexao();

} catch(SQLException e){
    e.printStackTrace();
}
} 


 }