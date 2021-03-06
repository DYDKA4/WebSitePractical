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
@Table(name = "role_type")
public class RoleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_type_id")
    private Long id;

    @Column(name = "role_name")
    @NonNull
    private String name;

    public RoleType(@NonNull String name){
        this.name = name;
    }
    public RoleType(){

    }
}
