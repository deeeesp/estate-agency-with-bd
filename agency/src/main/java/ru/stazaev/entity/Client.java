package ru.stazaev.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private long id;

    @Column(name = "name_client")
    private String name;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Wish> wishes;


    public Client(String name, String telephoneNumber) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        wishes = new HashSet<>();
    }

    public Client(){}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public Set<Wish> getWishes() {
        return wishes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setWishes(Set<Wish> wishes) {
        this.wishes = wishes;
    }
}
