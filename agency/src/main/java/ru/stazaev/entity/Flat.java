package ru.stazaev.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "flats")
public class Flat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_flat")
    private long id;

    @Column(name = "address")
    private String address;

    @Column(name = "floor")
    private int floor;

    @Column(name = "meters")
    private int meters;

    @Column(name = "rooms_number")
    private int roomsNumber;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_worker")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Worker worker;

    public Flat() {
    }

    public Flat(String address, int floor, int meters, int roomsNumber) {
        this.address = address;
        this.floor = floor;
        this.meters = meters;
        this.roomsNumber = roomsNumber;
    }

    public long getId() {
        return id;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getMeters() {
        return meters;
    }

    public void setMeters(int meters) {
        this.meters = meters;
    }

    public int getRoomsNumber() {
        return roomsNumber;
    }

    public void setRoomsNumber(int roomsNumber) {
        this.roomsNumber = roomsNumber;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
