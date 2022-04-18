
package Controller;

//import View.Login;
import Controller.Helper.LoginHelper;
import Models.Funcionario;
import View.Login;

public class LoginController {

    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;  
        this.helper = new LoginHelper(view);
    }

    public void entrarNoSistema(){
       Funcionario funcionario =  helper.obterModelo();
         
    }
    public void validar(){
        System.out.println("Buscou algo do banco");
        
        this.view.msg("Erro");
    }
}


