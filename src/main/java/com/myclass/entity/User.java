package com.myclass.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    @Column(length = 10)
    private String mobile;
    @Column(length = 50, unique = true)
    private String email;
    @Column(length = 250)
    private String password;
    private Date registeredAt;

    private Date lastLogin;
    private String intro;
    private String profile;
    @Transient
    @JsonIgnore
    private String confirmPassword;
    private String roleId;
//user may have one or many role and vice versa
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    @PrePersist
    protected void OnRegister(){
        this.registeredAt= new Date();
    }
    @PreUpdate
    protected void OnLastLogin(){
        this.lastLogin = new Date();
    }

}
