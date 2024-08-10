package dao;

import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Usuario;

public class DAO {
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    private static String CADASTRAR_CLIENTE = " INSERT INTO CLIENTE "
            + " (ID, NOME, CPF/CPNJ, EMAIL, TELEFONE, ENDERECO ) "
            + "VALUES(NULL,?,?,?,?,?)";

    private static String CONSULTAR_CLIENTE = " SELECT * FROM CLIENTE " + " WHERE ID = ? ";

    private static String ALTERAR_CLIENTE = " UPDATE CLIENTE SET "
            + " ( NOME =? , CPF/CPNJ = ?, EMAIL = ?, TELEFONE = ?, ENDERECO = ?) "
            + " WHERE ID = ? ";

    private static String EXCLUIR_CLIENTE = " DELETE FROM CLIENTE " + " WHERE ID = ? ";

    private static String LISTAR_CLIENTE = " SELECT * FROM CLIENTE "+ " WHERE 1 = 1 ";

    private static String CONSULTAR_USUARIO = " SELECT USUARIO, SENHA " + " FROM USUARIO "
            + "WHERE USUARIO + ?" + "SND SENHA + ?";

    public DAO() {

    }

    public void cadastrarCliente(Cliente cliente) {
        Connection connection = Conexao.getInstancia().abrirConexao();

        String query = CADASTRAR_CLIENTE;
        try {
            preparedStatement = connection.prepareStatement(query);

            int i = 1;
            // ID, NOME, CPF/CPNJ, EMAIL, TELEFONE, ENDERECO
            preparedStatement.setString(i++, cliente.getNome());
            preparedStatement.setString(i++, cliente.getCpfCnpj());
            preparedStatement.setString(i++, cliente.getEmail());
            preparedStatement.setString(i++, cliente.getTelefone());
            preparedStatement.setString(i++, cliente.getEndereco());

            connection.commit();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso ");

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            fecharConexao();
        }

    }

    public Cliente consultarCliente(String id) throws Exception {
        Connection connection = Conexao.getInstancia().abrirConexao();

        String query = CONSULTAR_CLIENTE;
        Cliente cliente = null;
        try {
            preparedStatement = connection.prepareStatement(query);

            int i = 1;
            // ID, NOME, CPF/CPNJ, EMAIL, TELEFONE, ENDERECO
            preparedStatement.setString(i++, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // String id, String nome, String email, String cpfCnpj, String telefone, String
                // endereco
                cliente = new Cliente(resultSet.getString("ID"),
                        resultSet.getString("nome"),
                        resultSet.getString("email"),
                        resultSet.getString("cpfCnpj"),
                        resultSet.getString("telefone"),
                        resultSet.getString("endereco"));

            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            fecharConexao();
        }

        {
            if (cliente == null) {

                JOptionPane.showMessageDialog(null, "Nao foi possivel localizar o cliente selecionado", "",
                        JOptionPane.WARNING_MESSAGE);
                throw new Exception("Nao foi possivel localizar o cliente selecionado");
            }
            return cliente;
        }
    }

    public void alterarCliente(String id, Cliente cliente) {
        Connection connection = Conexao.getInstancia().abrirConexao();

        String query = ALTERAR_CLIENTE;
        try {
            preparedStatement = connection.prepareStatement(query);

            int i = 1;
            // ID, NOME, CPF/CPNJ, EMAIL, TELEFONE, ENDERECO
            preparedStatement.setString(i++, cliente.getNome());
            preparedStatement.setString(i++, cliente.getCpfCnpj());
            preparedStatement.setString(i++, cliente.getEmail());
            preparedStatement.setString(i++, cliente.getTelefone());
            preparedStatement.setString(i++, cliente.getEndereco());
            preparedStatement.setString(i++, id);

            connection.commit();
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso ");

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            fecharConexao();
        }

    }

    public void excluirCliente(String id) {
        Connection connection = Conexao.getInstancia().abrirConexao();

        String query = EXCLUIR_CLIENTE;
        try {
            preparedStatement = connection.prepareStatement(query);

            int i = 1;

            preparedStatement.setString(i++, id);

            connection.commit();
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso ");

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            fecharConexao();
        }

    }

    public ArrayList<Cliente> listarCliente() throws Exception {
        Connection connection = Conexao.getInstancia().abrirConexao();
        ArrayList<Cliente> clientes = new ArrayList<>();
        String query = LISTAR_CLIENTE;
        Cliente cliente = null;
        try {
            preparedStatement = connection.prepareStatement(query);

          

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // String id, String nome, String email, String cpfCnpj, String telefone, String
                // endereco
                clientes.add ( new Cliente(resultSet.getString("ID"),
                        resultSet.getString("nome"),
                        resultSet.getString("email"),
                        resultSet.getString("cpfCnpj"),
                        resultSet.getString("telefone"),
                        resultSet.getString("endereco")));

            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            fecharConexao();
        }

        {
            if (clientes.size() < 0) {

                JOptionPane.showMessageDialog(null, "Nao ha clientes cadastrados ", "",
                        JOptionPane.WARNING_MESSAGE);
                throw new Exception("Nao ha clientes cadastrados");
            }
            return clientes;
        }
    }

    public Usuario consultarUsuario(String nomeUsuario, String senhaCriptografada) throws Exception {
        Connection connection = Conexao.getInstancia().abrirConexao();

        String query = CONSULTAR_USUARIO;
        Usuario usuario = null;
        try {
            preparedStatement = connection.prepareStatement(query);

            int i = 1;
            
            preparedStatement.setString(i++, nomeUsuario);
            preparedStatement.setString(i++, senhaCriptografada);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                usuario = new Usuario(resultSet.getInt("ID"),resultSet.getString("USUARIO"),resultSet.getString("SENHA"));

            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            fecharConexao();
        }

        {
            if (usuario == null) {

                JOptionPane.showMessageDialog(null, "Nao foi possivel localizar o usuario selecionado", "",
                        JOptionPane.WARNING_MESSAGE);
                throw new Exception("Nao foi possivel localizar o usuario selecionado");
            }
            return usuario;
        }
    }

    private void fecharConexao() {
        try {
            if (resultSet != null) {
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            Conexao.getInstancia().fecharConexao();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}