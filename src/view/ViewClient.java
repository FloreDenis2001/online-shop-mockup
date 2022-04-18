package view;

import controller.ControllerPersons;
import controller.ControllerProducts;
import model.Client;

import java.util.Scanner;

public class ViewClient {


    private Client client;
    private Scanner scanner;
    private ControllerProducts controllerProducts;
    public ViewClient() {
        client=new Client(1,"Denis",20,"floredenis907@yahoo.com","javacurs1",4);
        scanner = new Scanner(System.in);
        controllerProducts=new ControllerProducts();
    }

    public void meniu(){
        System.out.println("---------------------Meniu------------------");
        System.out.println("1. Pentru a vedea toate produsele ");
        System.out.println("2. Pentru a adauga in cos");
        System.out.println("--------------------------------------------");
    }

    public void play(){
        boolean running=true;
        int choose;

        while(running){
            meniu();
            choose=Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1 : controllerProducts.afisare();
                    break;
                case 2 :
                    break;
            }
        }
    }

    public void adaugaCos(){
        System.out.println("Introduceti produsul dorit ");
        String productName= scanner.nextLine();
    }

}
