package Entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "relationship")
public class Relationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relationship_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_person_person_1")
    @NonNull
    private Person person_1;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_person_person_2")
    @NonNull
    private Person person_2;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role_role_1")
    @NonNull
    private RoleType role_1;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role_role_2")
    @NonNull
    private RoleType role_2;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_relationship_type_1")
    @NonNull
    private RelationshipType type_relationship_1;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_relationship_type_2")
    @NonNull
    private RelationshipType type_relationship_2;

    public Relationship(@NonNull Person person_1, @NonNull Person person_2, @NonNull RoleType role_1, @NonNull RoleType role_2,
                        @NonNull RelationshipType type_relationship_1, @NonNull RelationshipType type_relationship_2){

        this.person_1 = person_1;
        this.person_2 = person_2;
        this.role_1 = role_1;
        this.role_2 = role_2;
        this.type_relationship_1 = type_relationship_1;
        this.type_relationship_2 = type_relationship_2;
    }
    public Relationship(){

    }
}
