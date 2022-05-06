
package Controller;


import Controller.Helper.ForConsultaHelper;
import Controller.Helper.FunConsultaHelper;
import Dao.Conexao;
import Dao.FornecedorDAO;
import Models.Fornecedor;
import View.Consulta;
//import View.Consultafornecedor;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;

public class ForConsultaController {
    
    private  Consulta view;
    //private  Consultafornecedor viewF;
    private  ForConsultaHelper helper;

 

 
    public ForConsultaController(Consulta view) {
        this.view = view;
        this.helper = new ForConsultaHelper(view);
    }

   // public ForConsultaController(consulta viewF) {
        //this.viewF = viewF;
    //}

    
    
    public void atualizaTabela() throws SQLException{
    
        Connection conexao = new Conexao().getConnection();
        FornecedorDAO fornecedorDAO = new FornecedorDAO(conexao);
        ArrayList<Fornecedor> fornecedores = fornecedorDAO.SelecionaTodos();
        
        helper.preencherTabela(fornecedores);
        
    }
    
//    public void carregaDados() throws SQLException{
//    
//        DefaultTableModel model = (DefaultTableModel) view.getjTableFornecedor().getModel();
//        int selectedRowIndex = view.getjTableFornecedor().getSelectedRow();
//        
//        String id =   model.getValueAt(selectedRowIndex, 0).toString();
//        String nome = model.getValueAt(selectedRowIndex, 1).toString();
//        String email = model.getValueAt(selectedRowIndex, 2).toString();
//        
//        
//        Consultafornecedor consultafor = new Consultafornecedor();
//        consultafun.setIdConsulta(id);
//        consultafun.getjTextAlterarNomefun().setText(nome);
//        consultafun.getjTextAlterarEmailFun().setText(email);
//        consultafun.setVisible(true);
//        
//    }

   
    
//    public void alterarDados() throws SQLException{
//        
//
//        String id = viewF.getIdConsulta();
//        String nome = viewF.getjTextAlterarNomefun().getText();
//        String email = viewF.getjTextAlterarEmailFun().getText();
//        int convertId = Integer.parseInt(id);
//     
//        var fornecedor = new fornecedor( convertId, nome, email);
//       
//        try{
//        Connection conexao = new Conexao().getConnection();
//        fornecedorDAO fornecedorDAO = new fornecedorDAO(conexao);
//        fornecedorDAO.update(fornecedor);
//        
//        
//        viewF.dispose();
//        JOptionPane.showMessageDialog(null, "Alterado com sucesso");
//        Consulta consulta = new Consulta();
//        consulta.setVisible(true);
//        
//        }
//          catch(SQLException ex){  
//                
//              System.out.println("ERRO");
//             
//             }  
//        
//        
//    }
//    
//    public void ProcurarPorNome(String texto){
//        
//            try {
//                   Connection conexao = new Conexao().getConnection();
//                    fornecedorDAO fornecedorDao = new fornecedorDAO(conexao);
//                    
//                    ArrayList<fornecedor> fornecedors = fornecedorDao.SelecionaPorNome(texto);
//                    FunConsultaHelper funConsuHelper = new FunConsultaHelper(view);
//                    funConsuHelper.preencherTabela(fornecedors);
//                    
//                } catch (SQLException ex) {
//                    Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
//                }
//    
//    }
//    
//     public void deletarfornecedor() throws SQLException{
//        
//
//        String id = viewF.getIdConsulta();
//        int convertId = Integer.parseInt(id);
//     
//        var fornecedor = new fornecedor(convertId);
//        
//         
//        int dialogButton = JOptionPane.showConfirmDialog(null, "Tem certeza que quer excluir ?"); 
//        if (dialogButton == JOptionPane.YES_OPTION) 
//        {
//        try{
//        Connection conexao = new Conexao().getConnection();
//        fornecedorDAO fornecedorDAO = new fornecedorDAO(conexao);
//        fornecedorDAO.delete(fornecedor);
//       
//        viewF.dispose();
//        JOptionPane.showMessageDialog(null, "Deletado com sucesso");
//        Consulta consulta = new Consulta();
//        consulta.setVisible(true);
//        
//        }
//          catch(SQLException ex){  
//                
//              System.out.println("ERRO");
//             
//             }  
//        
//        }
//        else {
//            
//        }
//        
//       
//    }
//     
    
}
