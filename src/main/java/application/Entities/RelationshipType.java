package application.Entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "relationship_type")
public class RelationshipType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_relationship_type")
    private Long id;

    @Column(name = "name_of_relationship")
    @NonNull
    private String name;

    public RelationshipType(@NonNull String name){

        this.name = name;
    }
    public RelationshipType() {

    }

}
