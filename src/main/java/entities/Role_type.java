package entities;

import javax.persistence.*;

@Entity
@Table(name = "Role_type")
public class Role_type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_role_type")
    private int id;

    @Column(name = "role_name")
    private String role_name;

    public Role_type(int id, String role_name){
        this.id = id;
        this.role_name = role_name;
    }
    public Role_type(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
