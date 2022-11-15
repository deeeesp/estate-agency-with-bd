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
                    service.addNewFlat(id,"adr",4,88,3);
                    System.out.println("suc");
                }
                case "4" -> {
                    System.out.println("все квартиры");
                    System.out.println(service.getAllFlats());
                }
                case "5" -> {
                    System.out.println("провести сделку");
                    service.addDeal(6,7,1,"buy",5000000);
                    System.out.println("added");
                }
                case "6" -> {
                    System.out.println("все сделки");
                    System.out.println(service.getAllDeals());
                }
                case "7" -> {
                    System.out.println("добавить клиента");
                    service.addClient("name","423");
                }
                case "8" -> {
                    System.out.println("все клиенты");
                    System.out.println(service.getAllClients());
                }
                case "9" -> {
                    System.out.println("клиент + хотелка");
                    System.out.println("id клиента");
                    long id = scanner.nextInt();
                    System.out.println(service.getClientWishes(id));
                }
                case "10" -> {
                    System.out.println("добавить хотелку");
                    System.out.println("клиент + хотелка");
                    System.out.println("id клиента");
                    long id = scanner.nextInt();
                    service.addWish(id,100000000,45,1);
                }
                case "99" -> {
                    return;
                }
                default -> System.out.println("def");
            }
            System.out.println("успешно");
        }
    }
}
