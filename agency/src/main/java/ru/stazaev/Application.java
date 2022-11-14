package ru.stazaev;

import ru.stazaev.hibernateUtil.HibernateSessionFactoryUtil;
import ru.stazaev.service.Service;

import java.util.Scanner;

public class Application {
    public static void run() {
        Service service = new Service(HibernateSessionFactoryUtil.getSessionFactory());
        System.out.println("hello");
        System.out.println("1 -  показать всех работников  \n" +
                "2 - новый работник");
        while (true){
            Scanner scanner = new Scanner(System.in);
            switch (scanner.next()){
                case "1" -> System.out.println(service.getAllWorkers().toString().toString());
                case "2" -> {
                    System.out.println("Введите значения в след порядке: имя, номер телефона\n" + "имя: ");
                    String name = scanner.next();
                    System.out.println("номер телефона");
                    String telephone = scanner.next();
                    service.addWorker(name,telephone);
                    System.out.println("added");
                }
                case "3" -> {
                    System.out.println("добавить квартиру");
                    System.out.println("id работника");
                    long id = scanner.nextInt();
                    service.addNewFlat(id,"adr",4,80,3);
                    System.out.println("suc");
                }
                case "4" -> System.out.println("все квартиры");
                case "5" -> System.out.println("провести сделку");
                case "6" -> System.out.println("все сделки");
                case "7" -> System.out.println("все клиенты");
                case "8" -> System.out.println("клиент + хотелка");
                case "99" -> {
                    return;
                }
                default -> System.out.println("def");
            }
        }
    }
}
