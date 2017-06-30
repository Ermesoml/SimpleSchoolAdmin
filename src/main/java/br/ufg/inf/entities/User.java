package br.ufg.inf.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Class User.
 */
@Entity
@Table(name = "Users")
public class User implements Serializable {

    /** The user id. */
    private Long userId;
    
    /** The user name. */
    private String userName = "";
    
    /** The password. */
    private String password = "";
    
    /** The active. */
    private Boolean active = false;
    
    /** The user. */
    private Person user;
    
    /** The role. */
    private Role role;

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId the new user id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the role.
     *
     * @return the role
     */
    @OneToOne(cascade=CascadeType.ALL)
    @JoinTable(name="User_Roles",
            joinColumns = {@JoinColumn(name="USER_ID")},
            inverseJoinColumns = {@JoinColumn(name="ROLE_ID")}
    )
    public Role getRole() {
        return role;
    }

    /**
     * Sets the role.
     *
     * @param role the new role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Gets the user.
     *
     * @return the user
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    public Person getUser() {
        return user;
    }

    /**
     * Sets the user.
     *
     * @param user the new user
     */
    public void setUser(Person user) {
        this.user = user;
    }

    /**
     * Gets the user name.
     *
     * @return the user name
     */
    @Column(nullable = false)
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user name.
     *
     * @param userName the new user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the active.
     *
     * @return the active
     */
    @Column(nullable = false)
    public Boolean getActive() {
        return active;
    }

    /**
     * Sets the active.
     *
     * @param active the new active
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
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

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, password, active, user);
    }
}
