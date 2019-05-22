package net.cakecdn.api.admin.all.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private Long id;

    @Column(nullable = false, length = 32)
    private String name;

    private Role(String name) {
        this.name = name;
    }

    public static List<Role> build(List<String> roleNames) {
        List<Role> roles = new ArrayList<>();
        for (String roleName : roleNames) {
            roles.add(new Role(roleName));
        }
        return roles;
    }
}