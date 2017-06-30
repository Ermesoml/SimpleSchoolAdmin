package br.ufg.inf.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * The Class Role.
 */
@Entity
@Table(name="Roles")
public class Role implements Serializable {

    /** The id. */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Long id;

    /** The role. */
    private String role;

    /** The user roles. */
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="User_Roles",
            joinColumns = {@JoinColumn(name="ROLE_ID")},
            inverseJoinColumns = {@JoinColumn(name="USER_ID")}
    )
    private Set<User> userRoles;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role.
     *
     * @param role the new role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets the user roles.
     *
     * @return the user roles
     */
    public Set<User> getUserRoles() {
        return userRoles;
    }

    /**
     * Sets the user roles.
     *
     * @param userRoles the new user roles
     */
    public void setUserRoles(Set<User> userRoles) {
        this.userRoles = userRoles;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return Objects.equals(id, role1.id) &&
                Objects.equals(role, role1.role);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, role);
    }
}
