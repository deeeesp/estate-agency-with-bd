package ru.stazaev.entity;

import javax.persistence.*;

@Entity
@Table(name = "deals")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_deal")
    private long id;

    @Column(name = "id_worker")
    private long workerId;

    @Column(name = "id_flat")
    private long flatId;

    @Column(name = "id_client")
    private long client_id;

    @Column(name = "deal_type")
    private String type;

    @Column(name = "cost_flat")
    private int cost;

    public Deal() {
    }

    public long getId() {
        return id;
    }

    public long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(long workerId) {
        this.workerId = workerId;
    }

    public long getFlatId() {
        return flatId;
    }

    public void setFlatId(long flatId) {
        this.flatId = flatId;
    }

    public long getClient_id() {
        return client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
