
package Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Fornecedor {
    
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private Date contrato;

    public Fornecedor(int id, String nome, String email, String contrato) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        try {
            this.contrato = new SimpleDateFormat("dd/MM/yyyy)").parse(contrato);
        } catch (ParseException ex) {
            Logger.getLogger(Fornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Fornecedor(String nome, String email,String telefone, String contrato) {
        this.nome = nome;
        this.email = email;
        this.email = telefone;
        try {
            this.contrato = new SimpleDateFormat("dd/MM/yyyy)").parse(contrato);
        } catch (ParseException ex) {
            Logger.getLogger(Fornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getContrato() {
        return contrato;
    }

    public void setContrato(Date contrato) {
        this.contrato = contrato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
