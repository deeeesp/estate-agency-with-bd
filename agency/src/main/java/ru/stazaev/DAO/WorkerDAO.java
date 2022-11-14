package ru.stazaev.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.stazaev.entity.Flat;
import ru.stazaev.entity.Worker;

import java.util.List;

public class WorkerDAO {
    private SessionFactory sessionFactory;

    public WorkerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Worker findById(long id) {
        Session session =  sessionFactory.openSession();
        Worker worker = session.get(Worker.class, id);
        session.close();
        return worker;
    }

    public List<Flat> getFlats(long id){
        Session session =  sessionFactory.openSession();
        Worker worker = session.get(Worker.class, id);
        List<Flat> flats = worker.getFlats();
//        System.out.println(flats);
        session.close();
        return flats;
    }

    public void save(Worker worker) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(worker);
        tx1.commit();
        session.close();
    }

    public void update(Worker worker) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(worker);
        tx1.commit();
        session.close();
    }

    public void delete(Worker worker) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(worker);
        tx1.commit();
        session.close();
    }

    public List<Worker> findAll() {
//        List<Worker> workers = (List<Worker>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Worker").list();
        return  sessionFactory.openSession().createQuery("From Worker").list();
    }
}
