
package Controller.Helper;

import Models.Funcionario;
import View.Consulta;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class FunConsultaHelper {
    
    private final Consulta view;
    private  int idFun;


    public int getIdFun() {
        return idFun;
    }

    public void setIdFun(int idFun) {
        this.idFun = idFun;
    }

    public FunConsultaHelper(Consulta view) {
        this.view = view;
    }

    public void preencherTabela(ArrayList<Funcionario> funcionarios) {
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableFuncionario().getModel();
        tableModel.setNumRows(0);
        
        for (Funcionario funcionario : funcionarios) {
            
            tableModel.addRow(new Object[]{
            
            funcionario.getId(),
            funcionario.getNome(),
            funcionario.getEmail(),
            
        });
          
   
        }
          
    } 
    
   
}

 
