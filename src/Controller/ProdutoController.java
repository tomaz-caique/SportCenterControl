
//package Controller;
//
//import Dao.Conexao;
//import Dao.ProdutoDAO;
//import Models.Produto;
//import View.Cadastro;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JOptionPane;
//
//public class ProdutoController {
//    
//    private Cadastro view;
//
//    public ProdutoController(Cadastro view) {
//        this.view = view;
//    }
//    
//    
//    public void salvarProduto(){
//            
//        
//
//            String nome = view.getjTextNomeFun().getText();
//            String email = view.getjTextEmailFun().getText();
//            String senha = view.getjTextSenhaFun().getText();
//                
//            Produto produto = new Produto(nome, 0, );
//            try {
//     
//            
//            Connection conexao = new Conexao().getConnection();
//            ProdutoDAO produtoDao = new ProdutoDAO(conexao);
//            produtoDao.insert(produto);
//            
//            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
//        } catch (SQLException ex) {
//
//            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
//
//           
//        }
//    }
//}
