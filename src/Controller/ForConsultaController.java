
package Controller;


import Controller.Helper.ForConsultaHelper;
import Dao.Conexao;
import Dao.FornecedorDAO;
import Models.Fornecedor;
import View.Consulta;
import View.ConsultaFornecedor;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ForConsultaController {
    
    private  Consulta view;
    private  ConsultaFornecedor viewF;
    private  ForConsultaHelper helper;

 

 
    public ForConsultaController(Consulta view) {
        this.view = view;
        this.helper = new ForConsultaHelper(view);
    }

    public ForConsultaController(ConsultaFornecedor viewF) {
        this.viewF = viewF;
    }

    
    
    public void atualizaTabela() throws SQLException{
    
        Connection conexao = new Conexao().getConnection();
        FornecedorDAO fornecedorDAO = new FornecedorDAO(conexao);
        ArrayList<Fornecedor> fornecedores = fornecedorDAO.SelecionaTodos();
        
        helper.preencherTabela(fornecedores);
        
    }
    
    public void carregaDados() throws SQLException{
    
        DefaultTableModel model = (DefaultTableModel) view.getjTableFornecedor().getModel();
        int selectedRowIndex = view.getjTableFornecedor().getSelectedRow();
        
        String id =   model.getValueAt(selectedRowIndex, 0).toString();
        String nome = model.getValueAt(selectedRowIndex, 1).toString();
        String email = model.getValueAt(selectedRowIndex, 2).toString();
        String telefone = model.getValueAt(selectedRowIndex, 3).toString();
        String contrato = model.getValueAt(selectedRowIndex, 4).toString();
        
        ConsultaFornecedor consultafor = new ConsultaFornecedor();
        consultafor.setIdConsulta(id);
        consultafor.getjTextAlterarNomeFor().setText(nome);
        consultafor.getjTextAlterarEmailFor().setText(email);
        consultafor.getjTextAlterarTelFor().setText(telefone);
        consultafor.getjTextAlterarTelFor().setText(contrato);

        consultafor.setVisible(true);
        
    }

   
    
    public void alterarDados() throws SQLException{
        

        String id = viewF.getIdConsulta();
        String nome = viewF.getjTextAlterarNomeFor().getText();
        String email = viewF.getjTextAlterarEmailFor().getText();
        String telefone = viewF.getjTextAlterarTelFor().getText();
        int convertId = Integer.parseInt(id);
     
        var fornecedor = new Fornecedor(convertId, nome, email, telefone);
       
        try{
        Connection conexao = new Conexao().getConnection();
        FornecedorDAO fornecedorDAO = new FornecedorDAO(conexao);
        fornecedorDAO.update(fornecedor);
        
        
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
                    FornecedorDAO fornecedorDao = new FornecedorDAO(conexao);
                    
                    ArrayList<Fornecedor> fornecedores = fornecedorDao.SelecionaPorNome(texto);
                    ForConsultaHelper funConsuHelper = new ForConsultaHelper(view);
                    funConsuHelper.preencherTabela(fornecedores);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
                }
    
    }
    
     public void deletarFornecedor() throws SQLException{
        

        String id = viewF.getIdConsulta();
        int convertId = Integer.parseInt(id);
     
        var fornecedor = new Fornecedor(convertId);
        
         
        int dialogButton = JOptionPane.showConfirmDialog(null, "Tem certeza que quer excluir ?"); 
        if (dialogButton == JOptionPane.YES_OPTION) 
        {
        try{
        Connection conexao = new Conexao().getConnection();
        FornecedorDAO fornecedorDAO = new FornecedorDAO(conexao);
        fornecedorDAO.delete(fornecedor);
       
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
