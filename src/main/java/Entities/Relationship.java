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
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person_person_1")
    @NonNull
    private Person person_1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person_person_2")
    @NonNull
    private Person person_2;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role_role_1")
    @NonNull
    private RoleType role_1;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role_role_2")
    @NonNull
    private RoleType role_2;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_relationship_type_1")
    @NonNull
    private RoleType type_relationship_1;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_relationship_type_2")
    @NonNull
    private RoleType type_relationship_2;
}
