package it.danieltrosko.shop.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "authorities")
public class Authorities {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @NotEmpty
    @Column(name = "username")
    private String usernamev;
    @Column(name = "authority")
    private String authority;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsernamev() {
        return usernamev;
    }

    public void setUsernamev(String usernamev) {
        this.usernamev = usernamev;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
