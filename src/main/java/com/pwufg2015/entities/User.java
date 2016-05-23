package com.pwufg2015.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class User implements Serializable {

    private Long userId;
    private String userName = "";
    private String password = "";
    private Boolean active = false;
    private Person user;
    private Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @OneToOne(cascade=CascadeType.ALL)
    @JoinTable(name="User_Roles",
            joinColumns = {@JoinColumn(name="USER_ID")},
            inverseJoinColumns = {@JoinColumn(name="ROLE_ID")}
    )
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }

    @Column(nullable = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable = false)
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user1 = (User) o;
        return Objects.equals(userId, user1.userId) &&
                Objects.equals(userName, user1.userName) &&
                Objects.equals(password, user1.password) &&
                Objects.equals(active, user1.active) &&
                Objects.equals(user, user1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, password, active, user);
    }
}
