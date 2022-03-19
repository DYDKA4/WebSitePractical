package entities;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "Relationship_type")
public class Relationship_type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_relationship_type")
    private int id;

    @Column(name = "name_of_relationship")
    private String name;

    @Column(name = "start_of_relationship")
    private Time start;

    @Column(name = "end_of_relationship")
    private Time end;

    public Relationship_type(int id, String name, Time start, Time end){
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public  Relationship_type(){

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

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }
}
