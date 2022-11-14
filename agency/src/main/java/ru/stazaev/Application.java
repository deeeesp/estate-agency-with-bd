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

                case "3" -> System.out.println(3);
                case "4" -> System.out.println(4);
                case "5" -> System.out.println(5);
                case "6" -> System.out.println(6);
                case "7" -> System.out.println(7);
                case "99" -> {
                    return;
                }
                default -> System.out.println("def");
            }
        }
    }
}
