package ru.stazaev.entity;

import javax.persistence.*;
import java.util.HashSet;
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

    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Flat> flats;


    public Worker() {
    }

    public Worker(String workerName, String telephoneNumber) {
        this.workerName = workerName;
        this.telephoneNumber = telephoneNumber;
        flats = new HashSet<>();
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

    public Set<Flat> getFlats() {
        return flats;
    }

    public void setFlats(Set<Flat> flats) {
        this.flats = flats;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", workerName='" + workerName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", flats=" + flats +
                '}';
    }
}
