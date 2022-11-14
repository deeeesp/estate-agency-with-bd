package ru.stazaev.service;

import org.hibernate.SessionFactory;
import ru.stazaev.DAO.WorkerDAO;
import ru.stazaev.entity.Worker;

public class WorkerService {

    private WorkerDAO workerDAO;

    public WorkerService(SessionFactory sessionFactory) {
        this.workerDAO = new WorkerDAO();
    }

    public void saveWorker(Worker worker) {
        workerDAO.save(worker);

    }

    public Worker getWorker(long id){
        return workerDAO.findById(id);
    }
    public void deleteWorker(Worker worker){
        workerDAO.delete(worker);
    }
}
