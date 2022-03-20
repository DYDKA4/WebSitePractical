package Entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Getter
@Setter
@ToString
@Table(name= "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "born")
    @NonNull
    private Date born;

    @Column(name = "death")
    private Date death;

//    @OneToMany(targetEntity = Residence.class)
//    @JoinColumn(name = "id_person_person")
//    private Set<Residence> residences;

    public Person(@NonNull String name, @NonNull Date born, Date death) {
        this.name = name;
        this.born = born;
        this.death = death;
    }

    public Person(@NonNull String name, @NonNull Date born) {
        this.name = name;
        this.born = born;
    }


    public Person() {

    }
//    public Set<Residence> getResidences() {
//        return residences;
//    }

//    public void setResidences(Set<Residence> residences) {
//        this.residences = residences;
//    }
}
