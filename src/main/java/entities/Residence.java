package entities;


import javax.persistence.*;

@Entity
@Table(name = "Residence")
public class Residence {

    @Id
    @ManyToOne(targetEntity = Person.class)
    @Column(name = "id_person_person")
    private int id_person;

    @Column(name = "address")
    private String address;

    public Residence(int id_person, String address){
        this.id_person = id_person;
        this.address = address;
    }
    public Residence() {
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public int getId_person() {
        return id_person;
    }
}
