
package Models;

public class Product {
    
    private int id;
    private String name;
    private int amount;
    private String category;

    public Product(int id, String nome, int quantidade, String categoria) {
        this.id = id;
        this.name = nome;
        this.amount = quantidade;
        this.category = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
    
    
}
