
package Models;

public class Produto {
    
    private int id;
    private String nome;
    private int quantidade;
    private String categoria;

    public Produto(String nome, int quantidade, String categoria) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public Produto(int id, String nome, int quantidade, String categoria) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.categoria = categoria;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
    
    
}
