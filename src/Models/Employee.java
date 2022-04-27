
package Models;


public class Employee {
    
    private int id;
    private String name;
    private String email;
    private String password;

    public Employee(int id, String nome, String email, String senha) {
        this.id = id;
        this.name = nome;
        this.email = email;
        this.password = senha;
    }

    public Employee(int id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.password = senha;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
