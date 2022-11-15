package ru.stazaev.service;

import org.hibernate.SessionFactory;
import ru.stazaev.entity.*;

import java.util.List;

public class Service {
    private SessionFactory sessionFactory;
    private FlatService flatService;
    private WorkerService workerService;
    private DealService dealService;
    private ClientService clientService;

    public Service(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
        this.workerService = new WorkerService(sessionFactory);
        this.flatService = new FlatService(sessionFactory);
        this.dealService = new DealService(sessionFactory);
        this.clientService = new ClientService(sessionFactory);
    }


    public List<Worker> getAllWorkers() {
        return workerService.getWorkersList();
    }

    public void addWorker(String name, String telephone) {
        workerService.saveWorker(name,telephone);
    }

    public void addNewFlat(long id, String address, int floor, int meters, int rooms) {
        Worker worker = workerService.getWorker(id);
        Flat flat = new Flat(address,floor,meters,rooms);
        flat.setWorker(worker);
//        System.out.println(workerService.getFlats(id));
        worker.addFlat(flat);
        workerService.update(worker);
//        flatService.saveFlat(flat);

    }

    public List<Flat> getAllFlats() {
        return flatService.getAllFlats();
    }

    public void addDeal(long workerId, long flatId,long clientId, String dealType, int cost) {
        Deal deal = new Deal(workerId,flatId,clientId,dealType,cost);
        dealService.save(deal);
    }

    public List<Deal> getAllDeals() {
        return dealService.getDeals();
    }

    public void addClient(String name, String telephone) {
        Client client = new Client(name,telephone);
        clientService.save(client);
    }

    public List<Client> getAllClients() {
        return clientService.getAll();
    }

    public List<Wish> getClientWishes(long id) {
        Client client = clientService.getById(id);
        return client.getWishes();
    }

    public void addWish(long id, int cost, int meters, int rooms) {
        Client client = clientService.getById(id);
        Wish wish = new Wish(cost, meters, rooms);
        wish.setClient(client);
        client.addWishes(wish);
        clientService.update(client);
    }
}
