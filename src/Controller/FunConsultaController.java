
package Controller;


import Controller.Helper.FunConsultaHelper;
import Dao.Conexao;
import Dao.FuncionarioDAO;
import Models.Funcionario;
import View.Consulta;
import View.ConsultaFuncionario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FunConsultaController {
    
    private  Consulta view;
    private  ConsultaFuncionario viewF;
    private  FunConsultaHelper helper;

    public FunConsultaController(Consulta view) {
        this.view = view;
        this.helper = new FunConsultaHelper(view);
    }

    public FunConsultaController(ConsultaFuncionario viewF) {
        this.viewF = viewF;
    }

    
    
    public void atualizaTabela() throws SQLException{
    
         Connection conexao = new Conexao().getConnection();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(conexao);
        ArrayList<Funcionario> funcionarios = funcionarioDAO.SelecionaTodos();
        
        helper.preencherTabela(funcionarios);
        
    }
    
    public void carregaDados() throws SQLException{
    
      DefaultTableModel model = (DefaultTableModel) view.getjTableFuncionario().getModel();
        int selectedRowIndex = view.getjTableFuncionario().getSelectedRow();
        
        String id = model.getValueAt(selectedRowIndex, 1).toString();
        String nome = model.getValueAt(selectedRowIndex, 1).toString();
        String email = model.getValueAt(selectedRowIndex, 2).toString();
    
        ConsultaFuncionario consultafun = new ConsultaFuncionario();

       
        consultafun.getjTextAlterarNomefun().setText(nome);
        consultafun.getjTextAlterarEmailFun().setText(email);
        consultafun.setVisible(true);

    }
    
    public void alterarDados() throws SQLException{
        
        ConsultaFuncionario consultafun = new ConsultaFuncionario();
        String nome = consultafun.getjTextAlterarNomefun().getText();
        String email = consultafun.getjTextAlterarEmailFun().getText();
        
        var funcionario = new Funcionario(1227, "Caique", "teste");
        
        
        try{
        Connection conexao = new Conexao().getConnection();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(conexao);
        funcionarioDAO.update(funcionario);
        
            JOptionPane.showMessageDialog(null, "BOAA");
        }
          catch(SQLException ex){  
                
              System.out.println("ERRO");
             
             }   
    }
}
