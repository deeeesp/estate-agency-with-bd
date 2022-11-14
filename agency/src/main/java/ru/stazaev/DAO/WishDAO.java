package ru.stazaev.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.stazaev.entity.Wish;

import java.util.List;

public class WishDAO {
    private SessionFactory sessionFactory;

    public WishDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Wish findById(long id) {
        Session session =  sessionFactory.openSession();
        Wish wish = session.get(Wish.class, id);
        session.close();
        return wish;
    }

    public void save(Wish wish) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(wish);
        tx1.commit();
        session.close();
    }

    public void update(Wish wish) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(wish);
        tx1.commit();
        session.close();
    }

    public void delete(Wish wish) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(wish);
        tx1.commit();
        session.close();
    }

    public List<Wish> findAll() {
//        List<Worker> workers = (List<Worker>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Worker").list();
        return  sessionFactory.openSession().createQuery("From Wish").list();
    }
}
