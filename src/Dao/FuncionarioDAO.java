
package Dao;

import Models.Funcionario;
import View.Cadastro;
import com.mysql.cj.protocol.Resultset;
import java.awt.Cursor;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDAO {
    
    private final Connection connection;
    String nomeTest = "";

    public FuncionarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Funcionario funcionario) throws SQLException{
            
            String sql = " INSERT INTO employee_login(ID_Employee, Employee_Name, Employee_Email, Employee_Password)"
                    + " VALUES (ID_Employee,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(sql);
              statement.setString(1,funcionario.getNome());
              statement.setString(2,funcionario.getEmail());
              statement.setString(3,funcionario.getSenha());
            statement.execute(); 

    }

    
    public void update(Funcionario funcionario) throws SQLException{
            
            String sql = "UPDATE employee_login SET Employee_Name = ?, Employee_Email = ? WHERE ID_Employee = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
              statement.setString(1,funcionario.getNome());
              statement.setString(2,funcionario.getEmail());
              statement.setInt(3,funcionario.getId());
              statement.execute(); 

    }
    public boolean AutenticarPorEmaileSenha(Funcionario funcionario) throws SQLException {
        
       String sql = "SELECT * FROM employee_login where Employee_Email = ? and Employee_Password = ? ";
       PreparedStatement statement = connection.prepareStatement(sql);
       
       statement.setString(1,funcionario.getEmail());
       statement.setString(2,funcionario.getSenha());
       statement.execute(); 
        
       var resultSet =  statement.getResultSet();
       return resultSet.next();
    }
    
    
   public ArrayList<Funcionario> SelecionaTodos() throws SQLException{
       
        String sql = "SELECT * FROM Employee_Login";
       PreparedStatement statement;
        statement = connection.prepareStatement(sql);
       
       return pesquisaBanco(statement);
   }

    private ArrayList<Funcionario> pesquisaBanco(PreparedStatement statement) throws SQLException {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while(resultSet.next()){
            
            int id = resultSet.getInt("ID_Employee");
            String nome = resultSet.getString("Employee_Name");
            String email = resultSet.getString("Employee_Email");
            String senha = resultSet.getString("Employee_Password");
            
            Funcionario funcionarioDados = new Funcionario(id ,nome, email, senha);
            funcionarios.add(funcionarioDados);
        }
        return funcionarios;
    }
   
   public Funcionario SelecionaPorId(Funcionario funcionario) throws SQLException{
       String sql = "SELECT * FROM employee_login where ID_Employee = ?";
       PreparedStatement statement = connection.prepareStatement(sql);
       
       statement.setInt(1,funcionario.getId());
       
        return pesquisaBanco(statement).get(0);
   }
   
   
    public ArrayList<Funcionario> SelecionaPorNome(String nomeC) throws SQLException{
        String test = ("%" + nomeC + "%");
        String sql = "SELECT * FROM Employee_Login where Employee_Name LIKE '"+test+"'";
       PreparedStatement statement;
        statement = connection.prepareStatement(sql);
      //  Cursor cursor = get
         statement.execute();
         ArrayList<Funcionario> funcionarios = new ArrayList<>();
        ResultSet resultSet = statement.getResultSet();
         while(resultSet.next()){
            
            int id = resultSet.getInt("ID_Employee");
            String nome = resultSet.getString("Employee_Name");
            String email = resultSet.getString("Employee_Email");
            String senha = resultSet.getString("Employee_Password");
            
            Funcionario funcionarioDados = new Funcionario(id ,nome, email, senha);
            funcionarios.add(funcionarioDados);
            
         }
            return funcionarios; 
         }
         
    
      public void delete(Funcionario funcionario) throws SQLException{
            
            String sql = "DELETE FROM employee_login WHERE ID_Employee = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
              statement.setInt(1,funcionario.getId());
              statement.execute(); 

    }
         
    
    }
   
