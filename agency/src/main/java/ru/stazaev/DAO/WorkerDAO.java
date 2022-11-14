package ru.stazaev.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.stazaev.entity.Worker;
import ru.stazaev.hibernateUtil.HibernateSessionFactoryUtil;

import java.util.List;

public class WorkerDAO {
    private SessionFactory sessionFactory;


    public Worker findById(long id) {
        Worker worker = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Worker.class, id);
//        HibernateSessionFactoryUtil.getSessionFactory().openSession().close();
        return worker;
    }

    public void save(Worker worker) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(worker);
        tx1.commit();
        session.close();
    }

    public void update(Worker worker) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(worker);
        tx1.commit();
        session.close();
    }

    public void delete(Worker worker) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(worker);
        tx1.commit();
        session.close();
    }

    public List<Worker> findAll() {
//        List<Worker> workers = (List<Worker>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Worker").list();
        return  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Worker").list();
    }
}
