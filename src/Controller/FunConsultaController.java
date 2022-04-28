
package Controller;


import Controller.Helper.FunConsultaHelper;
import Dao.Conexao;
import Dao.FuncionarioDAO;
import Models.Funcionario;
import View.Consulta;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class FunConsultaController {
    
    private final Consulta view;
    private final FunConsultaHelper helper;

    public FunConsultaController(Consulta view) {
        this.view = view;
        this.helper = new FunConsultaHelper(view);
    }
    
    public void atualizaTabela() throws SQLException{
    
         Connection conexao = new Conexao().getConnection();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(conexao);
        ArrayList<Funcionario> funcionarios = funcionarioDAO.SelecionaTodos();
        
        helper.preencherTabela(funcionarios);
        
    }
    
}
