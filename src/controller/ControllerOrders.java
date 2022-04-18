package controller;

import model.Orders;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerOrders {
    private ArrayList<Orders> orders;

    public ControllerOrders() {
        orders = new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File f = new File("C:\\Users\\flore\\Desktop\\ApplicationPolimorfism\\src\\res\\orders.txt");
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                String lime = scanner.nextLine();
                this.orders.add(new Orders(lime));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void afisare(){
        for (Orders x:orders){
            System.out.println(x.toString());
        }
    }


}
