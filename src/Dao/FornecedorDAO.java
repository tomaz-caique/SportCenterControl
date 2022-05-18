
package Dao;

import Models.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class FornecedorDAO {
    
    private final Connection connection;

    public FornecedorDAO(Connection connection) {
        this.connection = connection;
    }
    
     public void insert(Fornecedor fornecedor) throws SQLException{
            
            String sql = " INSERT INTO Provider (ID_Provider, Provider_Name, Start_Contract)"
                    + " VALUES (ID_Employee,'"+ fornecedor.getNome() +"', '"+fornecedor.getEmail()+"', '"+fornecedor.getContrato()+"');";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute(); 
            connection.close();

    }
     
}

