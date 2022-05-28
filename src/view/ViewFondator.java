package view;

import controller.ControllerOrderDetails;
import controller.ControllerOrders;
import controller.ControllerPersons;
import controller.ControllerProducts;
import model.Admin;
import model.Orders;
import model.Person;
import model.Products;

import java.util.Scanner;

public class ViewFondator {  private ControllerOrderDetails controllerOrderDetails;
    private ControllerOrders controllerOrders;
    private ControllerPersons controllerPersons;
    private ControllerProducts controllerProducts;
    private Admin admin;
    private Scanner scanner;

    public ViewFondator() {
        this.controllerOrderDetails = new ControllerOrderDetails();
        admin = new Admin(10, "Cristian", 31, "cristian@yahoo.com", "javacurs10", "Fondator");
        scanner = new Scanner(System.in);
        controllerProducts = new ControllerProducts();
        controllerOrders = new ControllerOrders();
        controllerOrderDetails = new ControllerOrderDetails();
        controllerPersons = new ControllerPersons();
    }


    public void meniu() {
        System.out.println("---------------------Meniu------------------");
        System.out.println("1.Anuleaza o comanda la cererea clientului");
        System.out.println("2.Modifica cantitatea implicit pretul comenzi la cerere");
        System.out.println("3.Exit");
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
                    deleteOrder();
                    break;
                case 2:

                    updateOrder();

                    break;
                case 3:
                    running = false;
                    break;
                default:
                    meniu();
            }
        }
        controllerProducts.toSaveProducts();
        controllerPersons.toSavePerson();
        controllerOrders.toSaveOrders();
    }


    public void deleteOrder(){
        System.out.println("Introduceti numele clientului : ");
        String numeclient= scanner.nextLine();
        controllerOrders.deleteOrders(controllerPersons.findByName(numeclient).getId());

    }

    public void updateOrder(){
        System.out.println("Introduceti numele clientului : ");
        String numeClient= scanner.nextLine();
        Person client = controllerPersons.findByName(numeClient);
        int idOrder=controllerOrders.findByCustomerId(client.getId()).getId();


        System.out.println("Introduceti numele produsului : ");
        String numeprodus=scanner.nextLine();
        int productId=controllerProducts.findByName(numeprodus).getId();

        System.out.println("Introduceti noua cantitate : ");
        int cantitate=Integer.parseInt(scanner.nextLine());

        controllerOrderDetails.updatePretbyName(idOrder,productId,cantitate);

        float lastSum=controllerOrderDetails.moneyDetails(idOrder);

        controllerOrders.updatePriceByCustomerId(idOrder,client.getId(),lastSum);


    }
}
