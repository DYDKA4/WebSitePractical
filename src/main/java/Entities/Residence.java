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
@Table(name = "residence")
public class Residence {


    @Column(name = "id_residence")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person_person")
    @NonNull
    private Person person;

    @Column(name = "address")
    @NonNull
    private String address;

    @Column(name = "check_in_date")
    @NonNull
    private Date check_in;

    @Column(name = "check_out_date")
    private Date check_out;

    public Residence(@NonNull Person person, @NonNull String address, @NonNull Date check_in, Date check_out){

        this.person = person;
        this.address = address;
        this.check_in = check_in;
        this.check_out = check_out;
    }

    public Residence(@NonNull Person person, @NonNull String address, @NonNull Date check_in){

        this.person = person;
        this.address = address;
        this.check_in = check_in;
    }

    public Residence() {

    }
}