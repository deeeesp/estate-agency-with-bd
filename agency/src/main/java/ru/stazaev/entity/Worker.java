package ru.stazaev.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_worker")
    private long id;

    @Column(name = "worker_name")
    private String workerName;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Flat> flats;


    public Worker() {
        this.flats = new ArrayList<>();
    }

    public Worker(String workerName, String telephoneNumber) {
        this.workerName = workerName;
        this.telephoneNumber = telephoneNumber;
        flats = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public List<Flat> getFlats() {
        return flats;
    }

    public void setFlats(List<Flat> flats) {
        this.flats = flats;
    }

    public void addFlat(Flat flat){
        flat.setWorker(this);
        flats.add(flat);
    }


}
