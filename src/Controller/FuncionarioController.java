
package Controller;

import Dao.Conexao;
import Dao.FuncionarioDAO;
import Models.Funcionario;
import View.Cadastro;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FuncionarioController {
    
    private Cadastro view;

    public FuncionarioController(Cadastro view) {
        this.view = view;
    }
    
    public void salvarFuncionario(){
            
            String nome = view.getjTextNomeFun().getText();
            String email = view.getjTextEmailFun().getText();
            String senha = view.getjTextSenhaFun().getText();
                
            Funcionario funcionario = new Funcionario(nome,email,senha);
            try {
     
            
            Connection conexao = new Conexao().getConnection();
            FuncionarioDAO funcionarioDao = new FuncionarioDAO(conexao);
            funcionarioDao.insert(funcionario);
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException ex) {

            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);

           
        }
    }
}
