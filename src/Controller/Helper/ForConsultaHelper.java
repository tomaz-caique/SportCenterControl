
package Controller.Helper;

import Models.Fornecedor;
import View.Consulta;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class ForConsultaHelper {
    
    private final Consulta view;
    private  int idFor;

    public int getIdFor() {
        return idFor;
    }

    public void setIdFor(int idFor) {
        this.idFor = idFor;
    }

    public ForConsultaHelper(Consulta view) {
        this.view = view;
    }

    public void preencherTabela(ArrayList<Fornecedor> fornecedores) {
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableFornecedor().getModel();
        tableModel.setNumRows(0);
        
        for (Fornecedor fornecedor : fornecedores) {
            
            tableModel.addRow(new Object[]{
            
            fornecedor.getId(),
            fornecedor.getNome(),
            fornecedor.getEmail(),
            fornecedor.getTelefone(),
            fornecedor.getContrato()
            
        });
          
   
        }
          
    } 
    
   
}

 
