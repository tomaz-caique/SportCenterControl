
package Dao;

import Models.Produto;
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

//public class ProdutoDAO {
//    
//    private final Connection connection;
//    String nomeTest = "";
//
//    public ProdutoDAO(Connection connection) {
//        this.connection = connection;
//    }
//    
//    public void insert(Produto produto) throws SQLException{
//            
//            String sql = " INSERT INTO employee_login(ID_Employee, Employee_Name, Employee_Email, Employee_Password)"
//                    + " VALUES (ID_Employee,?,?,?);";
//            PreparedStatement statement = connection.prepareStatement(sql);
//              statement.setString(1,produto.getNome());
//              statement.setString(2,produto.getEmail());
//              statement.setString(3,produto.getSenha());
//            statement.execute(); 
//
//    }
//
//    
//    public void update(Produto produto) throws SQLException{
//            
//            String sql = "UPDATE employee_login SET Employee_Name = ?, Employee_Email = ? WHERE ID_Employee = ?;";
//            PreparedStatement statement = connection.prepareStatement(sql);
//              statement.setString(1,produto.getNome());
//              statement.setString(2,produto.getEmail());
//              statement.setInt(3,produto.getId());
//              statement.execute(); 
//
//    }
//    public boolean AutenticarPorEmaileSenha(Produto produto) throws SQLException {
//        
//       String sql = "SELECT * FROM employee_login where Employee_Email = ? and Employee_Password = ? ";
//       PreparedStatement statement = connection.prepareStatement(sql);
//       
//       statement.setString(1,produto.getEmail());
//       statement.setString(2,produto.getSenha());
//       statement.execute(); 
//        
//       var resultSet =  statement.getResultSet();
//       return resultSet.next();
//    }
//    
//    
//   public ArrayList<Produto> SelecionaTodos() throws SQLException{
//       
//        String sql = "SELECT * FROM Employee_Login";
//       PreparedStatement statement;
//        statement = connection.prepareStatement(sql);
//       
//       return pesquisaBanco(statement);
//   }
//
//    private ArrayList<Produto> pesquisaBanco(PreparedStatement statement) throws SQLException {
//        ArrayList<Produto> produtos = new ArrayList<>();
//        statement.execute();
//        ResultSet resultSet = statement.getResultSet();
//        while(resultSet.next()){
//            
//            int id = resultSet.getInt("ID_Employee");
//            String nome = resultSet.getString("Employee_Name");
//            String email = resultSet.getString("Employee_Email");
//            String senha = resultSet.getString("Employee_Password");
//            
//            Produto produtoDados = new Produto(id ,nome, email, senha);
//            produtos.add(produtoDados);
//        }
//        return produtos;
//    }
//   
//   public Produto SelecionaPorId(Produto produto) throws SQLException{
//       String sql = "SELECT * FROM employee_login where ID_Employee = ?";
//       PreparedStatement statement = connection.prepareStatement(sql);
//       
//       statement.setInt(1,produto.getId());
//       
//        return pesquisaBanco(statement).get(0);
//   }
//   
//   
//    public ArrayList<Produto> SelecionaPorNome(String nomeC) throws SQLException{
//        String test = ("%" + nomeC + "%");
//        String sql = "SELECT * FROM Employee_Login where Employee_Name LIKE '"+test+"'";
//       PreparedStatement statement;
//        statement = connection.prepareStatement(sql);
//      //  Cursor cursor = get
//         statement.execute();
//         ArrayList<Produto> produtos = new ArrayList<>();
//        ResultSet resultSet = statement.getResultSet();
//         while(resultSet.next()){
//            
//            int id = resultSet.getInt("ID_Employee");
//            String nome = resultSet.getString("Employee_Name");
//            String email = resultSet.getString("Employee_Email");
//            String senha = resultSet.getString("Employee_Password");
//            
//            Produto produtoDados = new Produto(id ,nome, email, senha);
//            produtos.add(produtoDados);
//            
//         }
//            return produtos; 
//         }
//         
//    
//      public void delete(Produto produto) throws SQLException{
//            
//            String sql = "DELETE FROM employee_login WHERE ID_Employee = ?;";
//            PreparedStatement statement = connection.prepareStatement(sql);
//              statement.setInt(1,produto.getId());
//              statement.execute(); 
//
//    }
//         
//    
//    }
//   
