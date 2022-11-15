package ru.stazaev.service;

import org.hibernate.SessionFactory;
import ru.stazaev.DAO.WishDAO;
import ru.stazaev.entity.Wish;

import java.util.List;

public class WishService {
    private WishDAO wishDAO;

    public WishService(SessionFactory sessionFactory) {
        this.wishDAO = new WishDAO(sessionFactory);
    }

    public void save(Wish wish){
        wishDAO.save(wish);
    }

    public void delete(Wish wish){
        wishDAO.delete(wish);
    }

    public void update(Wish wish){
        wishDAO.update(wish);
    }

    public Wish getById(long id){
        return wishDAO.findById(id);
    }

    public List<Wish> getAllWishes(){
        return wishDAO.findAll();
    }
}
