package view;

import controller.ControllerOrderDetails;
import controller.ControllerOrders;
import controller.ControllerPersons;
import controller.ControllerProducts;
import model.Admin;

import java.util.Scanner;

public class ViewModerator {
    private ControllerOrderDetails controllerOrderDetails;
    private ControllerOrders controllerOrders;
    private ControllerPersons controllerPersons;
    private ControllerProducts controllerProducts;
    private Admin admin;
    private Scanner scanner;

    public ViewModerator() {
        this.controllerOrderDetails = new ControllerOrderDetails();
        admin = new Admin(5, "Ana", 40, "razvan@yahoo.com", "javacurs5", "Moderator");
        scanner = new Scanner(System.in);
        controllerProducts = new ControllerProducts();
        controllerOrders = new ControllerOrders();
        controllerOrderDetails = new ControllerOrderDetails();
        controllerPersons = new ControllerPersons();
    }


    public void meniu() {
        System.out.println("---------------------Meniu------------------");
        System.out.println("1.Adauga stock in functie de produs selectat cantitatea dorita");
        System.out.println("2.Editeaza descrierea produsului ");
        System.out.println("3.Modifica pretul produsului selectat");
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
                    addStock();
                    break;
                case 2:
                    editDescription();
                    break;
                case 3:
                    modifyPrice();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    meniu();
            }
        }
        controllerProducts.toSaveProducts();
    }

    public void addStock() {
        System.out.println("Selecteaza produsul : ");
        String nameProduct = scanner.nextLine();
        System.out.println("Cantitatea noua adaugata : ");
        int cantitate = Integer.parseInt(scanner.nextLine());
        controllerProducts.addStock(nameProduct, cantitate);
        controllerProducts.save();
    }

    public void editDescription() {
        System.out.println("Selecteaza produsul : ");
        String nameProduct = scanner.nextLine();
        System.out.println("Noua Descriere a produsului este : ");
        String description = scanner.nextLine();
        controllerProducts.editDescription(nameProduct, description);
        controllerProducts.save();
    }

    public void modifyPrice() {
        System.out.println("Selecteaza produsul : ");
        String nameProduct = scanner.nextLine();
        System.out.println("Noul Pret al produsului : ");
        float price = Float.parseFloat(scanner.nextLine());
        controllerProducts.updatePrice(nameProduct, price);
        controllerProducts.save();

    }
}
