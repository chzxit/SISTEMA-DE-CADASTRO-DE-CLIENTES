package dao;

import controller.Conexao;
import java.sql.Connection;

public class BD {
    private  static Connection connection = null;
    public static void main(String[] args) {
        try{
        connection = Conexao.getInstancia().abrirConexao();
        System.out.println("Base criada com sucesso");
      } catch(Exception e){
        System.out.println(e.getMessage());
        System.exit(0);

    }

    }
}
