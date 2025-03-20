package com.example.familyplanner.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;
@Setter
@Getter
@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private UUID id;

@   Setter
    @Column (nullable = false)
    private String userName;

    @Column (nullable = false, unique = true)

    private String email;
@Setter
@Getter
    @Column (nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn (name = "role")
    private Role role;


    public void setName(@NotBlank String name) {
        this.userName = name;
    }

    public String getUsername() {
        return this.userName;
    }

    public String setUsername(String nameTest) {
       return userName=nameTest;
    }
}