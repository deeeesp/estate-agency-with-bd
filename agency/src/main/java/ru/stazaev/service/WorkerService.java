package ru.stazaev.service;

import org.hibernate.SessionFactory;
import ru.stazaev.DAO.WorkerDAO;
import ru.stazaev.entity.Worker;

import java.util.List;

public class WorkerService {

    private WorkerDAO workerDAO;

    public WorkerService(SessionFactory sessionFactory) {
        this.workerDAO = new WorkerDAO(sessionFactory);
    }

    public void saveWorker(String name, String telephone) {
        Worker worker = new Worker(name,telephone);
//        worker.setWorkerName(name);
//        worker.setTelephoneNumber(telephone);
        workerDAO.save(worker);

    }

    public void update(Worker worker){
        workerDAO.update(worker);
    }

    public Worker getWorker(long id){
        return workerDAO.findById(id);
    }
    public void deleteWorker(Worker worker){
        workerDAO.delete(worker);
    }

    public List<Worker> getWorkersList(){
        return workerDAO.findAll();
    }
}
