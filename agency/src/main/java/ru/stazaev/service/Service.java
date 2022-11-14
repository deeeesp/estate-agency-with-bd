package ru.stazaev.service;

import org.hibernate.SessionFactory;
import ru.stazaev.entity.Flat;
import ru.stazaev.entity.Worker;

import java.util.List;

public class Service {
    private SessionFactory sessionFactory;
    private FlatService flatService;
    private WorkerService workerService;

    public Service(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
        this.workerService = new WorkerService(sessionFactory);
        this.flatService = new FlatService(sessionFactory);
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
        flatService.saveFlat(flat);

    }
}
