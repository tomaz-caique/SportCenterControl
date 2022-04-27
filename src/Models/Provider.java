
package Models;

import java.util.Date;


public class Provider {
    
    private int id;
    private String nome;
    private String email;
    private Date contrato;

    public Provider(int id, String nome, String email, Date contrato) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.contrato = contrato;
    }

    public Provider(int id, String nome, Date contrato) {
        this.id = id;
        this.nome = nome;
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

    public Date getContrato() {
        return contrato;
    }

    public void setContrato(Date contrato) {
        this.contrato = contrato;
    }
    
    
}
