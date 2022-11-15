package ru.stazaev.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.stazaev.DAO.DealDAO;
import ru.stazaev.entity.Deal;

import java.util.List;

public class DealService {

    private DealDAO dealDAO;

    public DealService(SessionFactory sessionFactory) {
        this.dealDAO = new DealDAO(sessionFactory);
    }

    public void save(Deal deal){
        dealDAO.save(deal);
    }

    public void delete(Deal deal){
        dealDAO.delete(deal);
    }

    public Deal findById(long id){
        return dealDAO.findById(id);
    }

    public void update(Deal deal){
        dealDAO.update(deal);
    }

    public List<Deal> getDeals(){
        return dealDAO.findAll();
    }
}
