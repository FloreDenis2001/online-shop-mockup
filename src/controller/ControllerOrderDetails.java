package controller;

import model.OrderDetails;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerOrderDetails {

    private ArrayList<OrderDetails> orderDetails;

    public ControllerOrderDetails(){
        orderDetails=new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File f = new File("C:\\Users\\flore\\Desktop\\ApplicationPolimorfism\\src\\res\\orderdetails.txt");
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                String lime = scanner.nextLine();
                this.orderDetails.add(new OrderDetails(lime));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisare(){
        for (OrderDetails x: orderDetails){
            System.out.println(x.toString());
        }
    }

}
