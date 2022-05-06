
package Dao;

import Models.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FornecedorDAO {
    
    private final Connection connection;

    public FornecedorDAO(Connection connection) {
        this.connection = connection;
    }
    
     public void insert(Fornecedor fornecedor) throws SQLException{
            
            String sql = " INSERT INTO Provider(ID_Provider, Provider_Name, Provider_Email, Start_Contract, Provider_tell)"
                    + " VALUES (ID_Provider,?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
           statement.setString(1,fornecedor.getNome());
           statement.setString(2,fornecedor.getEmail());
           statement.setString(3,fornecedor.getContrato());
           statement.setString(4,fornecedor.getTelefone());
              
            statement.execute(); 

    }
     
     public ArrayList<Fornecedor> SelecionaTodos() throws SQLException{
       
        String sql = "SELECT * FROM Provider";
       PreparedStatement statement;
        statement = connection.prepareStatement(sql);
       
       return pesquisaBanco(statement);
   }

    private ArrayList<Fornecedor> pesquisaBanco(PreparedStatement statement) throws SQLException {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while(resultSet.next()){
            
            int id = resultSet.getInt("ID_Provider");
            String nome = resultSet.getString("Provider_Name");
            String email = resultSet.getString("Provider_Email"); 
            String contrato = resultSet.getString("Start_Contract");
            String telefone = resultSet.getString("Provider_tell");
            
            
            Fornecedor fornecedorDados = new Fornecedor(id, nome, email, contrato, telefone);
            fornecedores.add(fornecedorDados);
        }
        return fornecedores;
    }
   
  // public Funcionario SelecionaPorId(Funcionario funcionario) throws SQLException{
     //  String sql = "SELECT * FROM employee_login where ID_Employee = ?";
     //  PreparedStatement statement = connection.prepareStatement(sql);
       
     //  statement.setInt(1,funcionario.getId());
       
      //  return pesquisaBanco(statement).get(0);
  // }
   
}

