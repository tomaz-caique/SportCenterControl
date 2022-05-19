
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
    private String contrato;

    
    public Fornecedor(int id) {
        this.id = id;
    }
    
    

    public Fornecedor(String nome, String email,String telefone ,String contrato) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
         this.contrato = contrato;
    }

    public Fornecedor(int id, String nome, String email, String telefone, String contrato) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.contrato = contrato;
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

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

   

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
