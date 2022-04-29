package controller;

import model.OrderDetails;
import model.Orders;
import model.Products;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerOrderDetails {

    private ArrayList<OrderDetails> orderDetails;

    public ControllerOrderDetails() {
        orderDetails = new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File f = new File("src/res/orderdetails.txt");
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                String lime = scanner.nextLine();
                this.orderDetails.add(new OrderDetails(lime));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisare() {
        for (OrderDetails x : orderDetails) {
            System.out.println(x.toString());
        }
    }

    public int nextId() {
        if (this.orderDetails.size() > 0) {
            return this.orderDetails.get(this.orderDetails.size() - 1).getOrderId() + 1;
        }
        return 1;
    }


    public void addOrderdetails(OrderDetails o) {
        this.orderDetails.add(o);
    }



    public ArrayList<OrderDetails> details(int ordersId) {
        ArrayList<OrderDetails> orderDetails1 = new ArrayList<>();
        for(OrderDetails orders:orderDetails){

            if(orders.getOrderId()==ordersId){

                orderDetails1.add(orders);

            }
        }
        return orderDetails1;
    }


}



