package ru.stazaev.service;

import org.hibernate.SessionFactory;
import ru.stazaev.DAO.FlatDAO;
import ru.stazaev.entity.Flat;
import ru.stazaev.entity.Worker;

public class FlatService {
    private FlatDAO flatDAO;

    public FlatService(SessionFactory sessionFactory) {
        this.flatDAO = new FlatDAO(sessionFactory);
    }

    public void saveFlat(Flat flat) {
        flatDAO.save(flat);

    }

    public Flat getFlat(long id){
        return flatDAO.findById(id);
    }


    public void deleteFlat(Flat flat){
        flatDAO.delete(flat);
    }
}
