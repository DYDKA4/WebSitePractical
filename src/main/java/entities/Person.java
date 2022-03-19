package entities;


import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Set;


@Entity
@Table(name= "Person")
public class Person{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_person")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "born_date")
    private Date born;

    @Column(name = "death_date")
    private Date death;

    @OneToMany(targetEntity = Residence.class)
    @JoinColumn(name = "id_person_person")
    private Set<Residence> residences;

    public Person(int id, String name, Date born, Date death){
        this.id = id;
        this.name = name;
        this.born = born;
        this.death = death;
    }
    public Person(String name, Date born){
        this.name = name;
        this.born = born;
    }
    public Person(){

    }
    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Date getBorn() {
        return born;
    }
    public void setBorn(Date born){
        this.born = born;
    }
    public Date getDeath() {
        return death;
    }
    public void setDeath(Date death){
        this.death = death;
    }

    public Set<Residence> getResidences() {
        return residences;
    }

    public void setResidences(Set<Residence> residences) {
        this.residences = residences;
    }
}
