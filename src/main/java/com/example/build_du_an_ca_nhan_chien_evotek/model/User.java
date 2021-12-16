package com.example.build_du_an_ca_nhan_chien_evotek.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotBlank
        @Size(min = 3, max = 50)
        private String name;
        @NotBlank
        @Size(min = 3, max = 50)
        private String username;
        @NaturalId
        @NotBlank
        @Size(max = 50)
        @Email
        private String email;
        @JsonIgnore
        @NotBlank
        @Size(min = 6, max = 100)
        private String password;
        @Lob
        private String avatar;
        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "user_role",
                joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
        Set<Role> roles = new HashSet<>();
        private String phoneNumber;

        public User() {
        }

        public User(Long id, String name, String username, String email, String password, String avatar, Set<Role> roles, String phoneNumber) {
                this.id = id;
                this.name = name;
                this.username = username;
                this.email = email;
                this.password = password;
                this.avatar = avatar;
                this.roles = roles;
                this.phoneNumber = phoneNumber;
        }

        public User(  @NotBlank @Size(min = 3, max = 50)String name,
                      @NotBlank @Size(min = 3, max = 50)String username,
                      @NotBlank @Size(max = 50) @Email String email,
                      @NotBlank @Size(min = 6, max = 100)String encode) {
                this.name = name;
                this.username = username;
                this.email = email;
                this.password = encode;
        }
}
