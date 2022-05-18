 
package Controller;

//import View.Login;
//import Controller.Helper.LoginHelper;
import Dao.Conexao;
import Dao.FuncionarioDAO;
import Models.Funcionario;
import View.Login;
import View.Menu;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginController {

    private final Login view;
//    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;  
//        this.helper = new LoginHelper(view);
    }

    public void entrarNoSistema(){
//       Funcionario funcionario =  helper.obterModelo();
        
    }
    public void validar() throws SQLException{
        
        String email = view.getjTextEmail().getText();
        String senha = view.getjTextSenha().getText();
        
        Funcionario funcionarioAutenticar = new Funcionario(email, senha);
        
       Connection conexao = new Conexao().getConnection();
       FuncionarioDAO funcionarioDao = new FuncionarioDAO(conexao);
        
       boolean existe = funcionarioDao.AutenticarPorEmaileSenha(funcionarioAutenticar);
        
        if(existe){
           Menu telaMenu = new Menu();
        telaMenu.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(view,"Email ou Senha invalidos");
        } 
    }
    
}


