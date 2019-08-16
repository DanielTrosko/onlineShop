package it.danieltrosko.shop.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "auction")
public class Auction {
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @NotBlank
    @Column(name = "mark", nullable = false)
    private String mark;
    @NotBlank
    @Column(name = "model", nullable = false)
    private String model;
    @NotNull
    @Column(name = "year", nullable = false)
    private int year;
    @NotNull
    @Column(name = "price", nullable = false)
    private int price;
    @OneToMany
    @JoinColumn(name = "auction_user_id", nullable = false)
    @NotNull
    private User user;

    public Auction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
