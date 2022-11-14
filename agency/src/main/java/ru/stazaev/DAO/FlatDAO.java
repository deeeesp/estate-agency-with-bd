package ru.stazaev.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.stazaev.entity.Flat;
import ru.stazaev.entity.Worker;

import java.util.List;

public class FlatDAO {
    private SessionFactory sessionFactory;

    public FlatDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Flat findById(long id) {
        Session session = sessionFactory.openSession();
        Flat flat = session.get(Flat.class, id);
        session.close();
        return flat;
    }

    public void save(Flat flat) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(flat);
        tx1.commit();
        session.close();
    }

    public void update(Flat flat) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(flat);
        tx1.commit();
        session.close();
    }

    public void delete(Flat flat) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(flat);
        tx1.commit();
        session.close();
    }

    public List<Flat> findAll() {
//        List<Worker> workers = (List<Worker>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Worker").list();
        return  sessionFactory.openSession().createQuery("From Flat").list();
    }
}
