
package Models;

import java.util.Date;


public class Provider {
    
    private int id;
    private String name;
    private String email;
    private Date contract;

    public Provider(int id, String name, String email, Date contract) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contract = contract;
    }

    public Provider(int id, String name, Date contract) {
        this.id = id;
        this.name = name;
        this.contract = contract;
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

    public Date getContract() {
        return contract;
    }

    public void setContract(Date contract) {
        this.contract = contract;
    }
    
    
}
