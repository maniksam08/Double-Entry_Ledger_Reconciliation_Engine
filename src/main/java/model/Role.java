package model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "roles")
public class Role {

    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated( EnumType.STRING )
    @Column(length = 20, name = "role_name", nullable = false)
    private  AppRoles RoleName;

    public Role(AppRoles appRoles){
        this.RoleName= appRoles;
    }
}
