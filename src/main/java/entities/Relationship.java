package entities;

import javax.persistence.*;

@Entity
@Table(name = "Relationship")
public class Relationship {

    @Id
    @OneToOne(targetEntity = Relationship_type.class)
    @Column(name = "id_relationship_type")
    private int id_relationship_type;

    @ManyToOne(targetEntity = Person.class)
    @Column(name = "id_person_person_1")
    private int id_person_person_1;

    @ManyToOne(targetEntity = Person.class)
    @Column(name = "id_person_person_2")
    private int id_person_person_2;

    @OneToOne(targetEntity = Role_type.class)
    @Column(name = "id_role_type_1")
    private int role_type_1;

    @OneToOne(targetEntity = Role_type.class)
    @Column(name = "id_role_type_2")
    private int role_type_2;

    public Relationship(int id_relationship_type, int id_person_person_1, int id_person_person_2, int role_type_1,
                        int role_type_2) {
        this.id_relationship_type = id_relationship_type;
        this.id_person_person_1 = id_person_person_1;
        this.id_person_person_2 = id_person_person_2;
        this.role_type_1 = role_type_1;
        this.role_type_2 = role_type_2;
    }

    public Relationship() {

    }

    public int getId_relationship_type() {
        return id_relationship_type;
    }

    public int getId_person_person_1() {
        return id_person_person_1;
    }

    public int getId_person_person_2() {
        return id_person_person_2;
    }

    public int getRole_type_1() {
        return role_type_1;
    }

    public int getRole_type_2() {
        return role_type_2;
    }
}
