package ru.stazaev.service;

import org.hibernate.SessionFactory;
import ru.stazaev.DAO.ClientDAO;
import ru.stazaev.entity.Client;

import java.util.List;

public class ClientService {

    private ClientDAO clientDAO;

    public ClientService(SessionFactory sessionFactory) {
        this.clientDAO = new ClientDAO(sessionFactory);
    }

    public void save(Client client){
        clientDAO.save(client);
    }

    public void delete(Client client){
        clientDAO.delete(client);
    }

    public void update(Client client){
        clientDAO.update(client);
    }

    public Client getById(long id){
        return clientDAO.findById(id);
    }

    public List<Client> getAll(){
        return clientDAO.findAll();
    }
}
