package view;

import controller.ControllerOrderDetails;
import controller.ControllerOrders;
import controller.ControllerPersons;
import controller.ControllerProducts;
import model.*;
import util.Utile;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewClient {


    private Client client;
    private Scanner scanner;
    private ControllerProducts controllerProducts;
    private ControllerOrders controllerOrders;
    private ControllerOrderDetails controllerOrderDetails;
    private ControllerPersons controllerPersons;
    private Orders orders;

    public ViewClient(Client client) {
        this.client = client;
        scanner = new Scanner(System.in);
        controllerProducts = new ControllerProducts();
        controllerOrders = new ControllerOrders();
        controllerOrderDetails = new ControllerOrderDetails();
        controllerPersons = new ControllerPersons();
        orders = new Orders(controllerOrders.nextId(), this.client.getId(), 0);
    }

    public void meniu() {
        System.out.println("---------------------Meniu------------------");
        System.out.println("1. Pentru a vedea toate produsele ");
        System.out.println("2. Pentru a adauga in cos");
        System.out.println("3. Pentru a vedea cosul ");
        System.out.println("4. Pentru a sterge cosul");
        System.out.println("5. Pentru update cos");
        System.out.println("6. Pentru istoricul comenzilor");
        System.out.println("7. Pentru detalii comanda selectata");
        System.out.println("8. Pentru a vedea cel mai cumparat produs");
        System.out.println("9. Pentru delogare");
        //istoric comenzi
        //cel mai cumparat produs


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
                case 2:
                    adaugaCos();
                    break;
                case 3:
                    afisareCos();
                    break;
                case 4:
                    removeCos();
                    break;
                case 5:
                    updateCos();
                    break;
                case 6:
                    istoricComenzi();
                    break;
                case 7:
                    detaliiComanda();
                    break;
                case 8:
                    bestSellProduct();
                    break;
                case 9:
                    running = false;
                    break;
                default:
                    meniu();
            }
        }
    }

    public void adaugaCos() {
        System.out.println("Introduceti produsul dorit ");
        String productName = scanner.nextLine();

        ///Etapa 1 luam produsul din controller
        Products p = controllerProducts.findByName(productName);

        if (p != null) {
            //Etapa 2 cerem cantitatea
            System.out.println("Cantitatea dorita : ");
            int cantitate = Integer.parseInt(scanner.nextLine());

            if (p.getStock() >= cantitate) {

                OrderDetails orderDetails = new OrderDetails(controllerOrderDetails.nextId(), orders.getId(), p.getId(), p.getPrice() * cantitate, cantitate);

                controllerOrderDetails.addOrderDetails(orderDetails);

                orders.setPrice(orders.getPrice() + cantitate * p.getPrice());

                p.setStock(p.getStock() - cantitate);

            } else {
                System.out.println("Stock epuizat");
            }
        }


    }

    public void afisareCos() {
        System.out.println("Elementele din cos sunt : ");
        ArrayList<OrderDetails> orderDetails = controllerOrderDetails.details(this.orders.getId());
        for (OrderDetails detail : orderDetails) {
            Products product = controllerProducts.findById(detail.getProductId());
            System.out.println(String.format("Produsl :%s  nr buc %d costa %.2f",
                    product.getName(), detail.getCantitate(), detail.getPrice()));
        }
    }

    public void removeCos() {
        afisareCos();
        System.out.println("\n Produsul sters : ");
        String productName = scanner.nextLine();
        Products products = controllerProducts.findByName(productName);
        controllerOrderDetails.removedetails(this.orders.getId(), products.getId());
    }

    public void updateCos() {
        afisareCos();
        System.out.println("\n Produsul updatat : ");
        String productName = scanner.nextLine();
        System.out.println("\n Noua cantitate dorita : ");
        int cantitate = Integer.parseInt(scanner.nextLine());
        Products products = controllerProducts.findByName(productName);
        controllerOrderDetails.updateOrderDetails(this.orders.getId(), products.getId(), cantitate, cantitate * products.getPrice());
    }

    public void istoricComenzi() {
        Person person = controllerPersons.findById(this.client.getId());
        ArrayList<Orders> personOrders = controllerOrders.findByCustomerId(person);
        for (Orders o : personOrders) {
            System.out.println(o.toString());
        }
    }

    public void detaliiComanda() {
        System.out.println("Introduceti ID-ul comenzi: ");
        int comandaId = Integer.parseInt(scanner.nextLine());
        OrderDetails o = controllerOrderDetails.getOrderDetailsByOrderId(comandaId);
        int productId = o.getProductId();
        Products products = controllerProducts.findById(productId);
        System.out.println(o.toString());
        System.out.println("Detalii : ");
        System.out.println(products.toString());
    }

    public void bestSellProduct() {
        Products products = controllerProducts.findById(Utile.pozMaxVec(controllerOrderDetails.bestSellProduct()));
        System.out.println(products.toString());

    }

}
