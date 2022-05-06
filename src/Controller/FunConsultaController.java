
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
import javax.swing.text.View;

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
        
        String id =   model.getValueAt(selectedRowIndex, 0).toString();
        String nome = model.getValueAt(selectedRowIndex, 1).toString();
        String email = model.getValueAt(selectedRowIndex, 2).toString();
        
        
        ConsultaFuncionario consultafun = new ConsultaFuncionario();
        consultafun.setIdConsulta(id);
        consultafun.getjTextAlterarNomefun().setText(nome);
        consultafun.getjTextAlterarEmailFun().setText(email);
        consultafun.setVisible(true);
        
    }

   
    
    public void alterarDados() throws SQLException{
        

        String id = viewF.getIdConsulta();
        String nome = viewF.getjTextAlterarNomefun().getText();
        String email = viewF.getjTextAlterarEmailFun().getText();
        int convertId = Integer.parseInt(id);
     
        var funcionario = new Funcionario( convertId, nome, email);
       
        try{
        Connection conexao = new Conexao().getConnection();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(conexao);
        funcionarioDAO.update(funcionario);
        
        
        viewF.dispose();
        JOptionPane.showMessageDialog(null, "Alterado com sucesso");
        Consulta consulta = new Consulta();
        consulta.setVisible(true);
        
        }
          catch(SQLException ex){  
                
              System.out.println("ERRO");
             
             }  
        
        
    }
    
    public void ProcurarPorNome(String texto){
        
            try {
                   Connection conexao = new Conexao().getConnection();
                    FuncionarioDAO funcionarioDao = new FuncionarioDAO(conexao);
                    
                    ArrayList<Funcionario> funcionarios = funcionarioDao.SelecionaPorNome(texto);
                    FunConsultaHelper funConsuHelper = new FunConsultaHelper(view);
                    funConsuHelper.preencherTabela(funcionarios);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
                }
    
    }
    
     public void deletarFuncionario() throws SQLException{
        

        String id = viewF.getIdConsulta();
        int convertId = Integer.parseInt(id);
     
        var funcionario = new Funcionario(convertId);
        
         
        int dialogButton = JOptionPane.showConfirmDialog(null, "Tem certeza que quer excluir ?"); 
        if (dialogButton == JOptionPane.YES_OPTION) 
        {
        try{
        Connection conexao = new Conexao().getConnection();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(conexao);
        funcionarioDAO.delete(funcionario);
       
        viewF.dispose();
        JOptionPane.showMessageDialog(null, "Deletado com sucesso");
        Consulta consulta = new Consulta();
        consulta.setVisible(true);
        
        }
          catch(SQLException ex){  
                
              System.out.println("ERRO");
             
             }  
        
        }
        else {
            
        }
        
       
    }
     
    
}
