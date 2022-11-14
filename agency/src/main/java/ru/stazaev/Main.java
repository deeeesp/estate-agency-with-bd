package ru.stazaev;


import org.hibernate.SessionFactory;
import ru.stazaev.entity.Worker;
import ru.stazaev.hibernateUtil.HibernateSessionFactoryUtil;
import ru.stazaev.service.FlatService;
import ru.stazaev.service.WorkerService;

public class Main {
    public static void main(String[] args) {
        Application.run();
    }
}
