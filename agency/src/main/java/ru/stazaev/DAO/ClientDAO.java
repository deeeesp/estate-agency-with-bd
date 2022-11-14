package ru.stazaev.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.stazaev.entity.Client;

import java.util.List;

public class ClientDAO {
    private SessionFactory sessionFactory;

    public ClientDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Client findById(long id) {
        Session session = sessionFactory.openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }

    public void save(Client client) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(client);
        tx1.commit();
        session.close();
    }

    public void update(Client client) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(client);
        tx1.commit();
        session.close();
    }

    public void delete(Client client) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(client);
        tx1.commit();
        session.close();
    }

    public List<Client> findAll() {
//        List<Worker> workers = (List<Worker>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Worker").list();
        return sessionFactory.openSession().createQuery("From Client").list();
    }
}
