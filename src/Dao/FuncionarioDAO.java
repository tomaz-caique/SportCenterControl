
package Dao;

import Models.Funcionario;
import View.Cadastro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDAO {
    
    private final Connection connection;

    public FuncionarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Funcionario funcionario) throws SQLException{
            
            String sql = " INSERT INTO employee_login(ID_Employee, Employee_Name, Employee_Email, Employee_Password)"
                    + " VALUES (ID_Employee,'"+ funcionario.getNome() +"', '"+funcionario.getEmail()+"', '"+funcionario.getSenha()+"');";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute(); 
            connection.close();

    }
}
