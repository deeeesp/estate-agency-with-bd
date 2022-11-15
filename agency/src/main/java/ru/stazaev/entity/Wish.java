package ru.stazaev.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "wishes")
public class Wish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_wish")
    private long id;

    @Column(name = "wish_cost")
    private int cost;

    @Column(name = "meters")
    private int meters;

    @Column(name = "rooms_number")
    private int roomsNumber;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_client")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;

    public Wish() {
    }

    public Wish(int cost, int meters, int roomsNumber) {
        this.cost = cost;
        this.meters = meters;
        this.roomsNumber = roomsNumber;
//        this.client = client;
    }

    public long getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public int getMeters() {
        return meters;
    }

    public int getRoomsNumber() {
        return roomsNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setMeters(int meters) {
        this.meters = meters;
    }

    public void setRoomsNumber(int roomsNumber) {
        this.roomsNumber = roomsNumber;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
