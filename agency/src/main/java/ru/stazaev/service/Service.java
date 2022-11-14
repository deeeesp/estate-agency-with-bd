package ru.stazaev.service;

import org.hibernate.SessionFactory;
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
}
