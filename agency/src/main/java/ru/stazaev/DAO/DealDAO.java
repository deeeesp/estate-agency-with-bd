package ru.stazaev.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.stazaev.entity.Deal;
import ru.stazaev.entity.Wish;

import java.util.List;

public class DealDAO {
    private SessionFactory sessionFactory;

    public DealDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Deal findById(long id) {
        Session session =  sessionFactory.openSession();
        Deal deal = session.get(Deal.class, id);
        session.close();
        return deal;
    }

    public void save(Deal deal) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(deal);
        tx1.commit();
        session.close();
    }

    public void update(Deal deal) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(deal);
        tx1.commit();
        session.close();
    }

    public void delete(Deal deal) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(deal);
        tx1.commit();
        session.close();
    }

    public List<Deal> findAll() {
//        List<Worker> workers = (List<Worker>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Worker").list();
        return  sessionFactory.openSession().createQuery("From Deal").list();
    }
}
