package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

  
public class ModeloTabela  extends  AbstractTableModel {

    private static final String[] colunas = {
        "10", "CPF/CNPJ", "Nome", "E-mail", "Telefone", "Endereço"
    };
    private ArrayList<Cliente> clientes;

    public ModeloTabela(ArrayList<Cliente> clientes) {
        super();
        this.clientes = clientes;
    }

    @Override
    public  int getRowCount(){
        return clientes.size();
    }

    @Override
    public int getColumnCount(){
       
        return colunas.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columIndex){
        Cliente cliente = clientes.get(rowIndex);

        if(columIndex == 0 ){
            return cliente.getId();

        } else if(columIndex == 1){
                return cliente.getNome();
        } else if (columIndex == 2) {
            return cliente.getEmail();
        } else if(columIndex == 3){
                return cliente.getCpf();
        } else if(columIndex == 4){
                return cliente.getCpfCnpj();
        } else if(columIndex == 5){
                return cliente.getTelefone();
        } else if(columIndex == 6){
                return cliente.getEndereco();
        } else{
        return  null;
        }
    }

    
}
