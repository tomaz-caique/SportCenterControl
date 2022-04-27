
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public Connection getConnection() throws SQLException{
       
        //Connection conexao = DriverManager.getConnection("jdbc:mysql://25.3.17.70/sport_center","TOMAZ","2010");
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/sport_center","root","2010copa");
        return conexao;
    }
    
    
}