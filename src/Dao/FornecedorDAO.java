
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
            
            String sql = " INSERT INTO Provider(ID_Provider, Provider_Name, Provider_Email, Provider_tell, Start_Contract)"
                    + " VALUES (ID_Provider,?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
           statement.setString(1,fornecedor.getNome());
           statement.setString(2,fornecedor.getEmail());
           statement.setString(3,fornecedor.getTelefone());
           statement.setString(4,fornecedor.getContrato());

              
            statement.execute(); 

    }
     
     public void update(Fornecedor fornecedor) throws SQLException{
            
            String sql = "UPDATE provider SET Provider_Name = ?, Provider_Email = ?, Provider_tell =?, Start_contract = ? WHERE ID_Provider = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
              statement.setString(1,fornecedor.getNome());
              statement.setString(2,fornecedor.getEmail());
              statement.setString(3,fornecedor.getTelefone());
              statement.setString(4,fornecedor.getContrato());
              statement.setInt(5,fornecedor.getId());
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
            String telefone = resultSet.getString("Provider_tell");
            String contrato = resultSet.getString("Start_Contract");

            
            
            Fornecedor fornecedorDados = new Fornecedor(id, nome, email, telefone, contrato);
            fornecedores.add(fornecedorDados);
        }
        return fornecedores;
    }
   
   public Fornecedor SelecionaPorId(Fornecedor fornecedor) throws SQLException{
       String sql = "SELECT * FROM provider where ID_Provider = ?";
       PreparedStatement statement = connection.prepareStatement(sql);
       
       statement.setInt(1,fornecedor.getId());
       
       return pesquisaBanco(statement).get(0);
   }
   
   
   
    public ArrayList<Fornecedor> SelecionaPorNome(String nomeC) throws SQLException{
        String test = ("%" + nomeC + "%");
        String sql = "SELECT * FROM provider where Provider_Name LIKE '"+test+"'";
       PreparedStatement statement;
        statement = connection.prepareStatement(sql);
      //  Cursor cursor = get
         statement.execute();
         ArrayList<Fornecedor> fornecedores = new ArrayList<>();
        ResultSet resultSet = statement.getResultSet();
         while(resultSet.next()){
            
            int id = resultSet.getInt("ID_Provider");
            String nome = resultSet.getString("Provider_Name");
            String email = resultSet.getString("Provider_Email");
            String telefone = resultSet.getString("Provider_tell");
            String contrato = resultSet.getString("Start_Contract");
            
            Fornecedor fornecedorDados = new Fornecedor(id ,nome, email, telefone, contrato);
            fornecedores.add(fornecedorDados);
            
         }
            return fornecedores; 
         }
   
   
      public void delete(Fornecedor fornecedor) throws SQLException{
            
            String sql = "DELETE FROM provider where ID_Provider = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
              statement.setInt(1,fornecedor.getId());
              statement.execute(); 

    }
         
   
}

