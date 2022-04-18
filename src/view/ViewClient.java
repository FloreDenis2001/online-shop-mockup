package view;

import controller.ControllerOrderDetails;
import controller.ControllerOrders;
import controller.ControllerPersons;
import controller.ControllerProducts;
import jdk.swing.interop.SwingInterOpUtils;
import model.Client;
import model.OrderDetails;
import model.Orders;
import model.Products;

import java.util.Scanner;

public class ViewClient {


    private Client client;
    private Scanner scanner;
    private ControllerProducts controllerProducts;
    private ControllerOrders controllerOrders;
    private ControllerOrderDetails controllerOrderDetails;
    private Orders orders;

    public ViewClient() {
        client = new Client(1, "Denis", 20, "floredenis907@yahoo.com", "javacurs1", 4);
        scanner = new Scanner(System.in);
        controllerProducts = new ControllerProducts();
        orders = new Orders(controllerOrders.nextId(), this.client.getId(), 0);
    }

    public void meniu() {
        System.out.println("---------------------Meniu------------------");
        System.out.println("1. Pentru a vedea toate produsele ");
        System.out.println("2. Pentru a adauga in cos");
        System.out.println("3. Pentru a vedea cosul ");
        System.out.println("--------------------------------------------");

    }

    public void play() {
        boolean running = true;
        int choose;

        while (running) {
            meniu();
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    controllerProducts.afisare();
                    break;
                case 2:adaugaCos();
                    break;
                case 3 :afisareCos();
                break;
            }
        }
    }

    public void adaugaCos() {
        System.out.println("Introduceti produsul dorit ");
        String productName = scanner.nextLine();

        ///etapa 1 luam produsul din controler
        Products p = controllerProducts.findByName(productName);

        if (p != null) {
            //ETAPA2 :CEREM CANTIATEA
            System.out.println("Cantitatea dorita : ");
            int cantitate = Integer.parseInt(scanner.nextLine());
            //ce
            if (p.getStock() >= cantitate) {

                OrderDetails orderDetails = new OrderDetails(controllerOrderDetails.nextId(), orders.getId(), p.getId(), p.getPrice() * cantitate, cantitate);

                controllerOrderDetails.addOrderdetails(orderDetails);

                p.setStock(p.getStock()-cantitate);

            } else {
                System.out.println("Stock epuizat");
            }


        }


    }
    public void afisareCos(){



    }
}
