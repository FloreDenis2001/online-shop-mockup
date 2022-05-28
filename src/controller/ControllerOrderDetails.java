package controller;

import model.OrderDetails;

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


    public int nextId() {
        if (this.orderDetails.size() > 0) {
            return this.orderDetails.get(this.orderDetails.size() - 1).getOrderId() + 1;
        }
        return 1;
    }


    public ArrayList<OrderDetails> details(int ordersId) {
        ArrayList<OrderDetails> orderDetails1 = new ArrayList<>();
        for (OrderDetails orders : orderDetails) {

            if (orders.getOrderId() == ordersId) {

                orderDetails1.add(orders);

            }
        }
        return orderDetails1;
    }


    public OrderDetails getOrderDetailsById(int orderId, int productId) {
        for (OrderDetails orders : orderDetails) {
            if (orders.getProductId() == productId && orders.getOrderId() == orderId) {
                return orders;
            }
        }
        return null;
    }


    public void removedetails(int orderId, int productId) {
        this.orderDetails.remove(getOrderDetailsById(orderId, productId));
    }

    //todo CRUD

    public void afisare() {
        for (OrderDetails x : orderDetails) {
            System.out.println(x.toString());
        }
    }

    public OrderDetails findById(int id) {
        for (OrderDetails x : orderDetails) {
            if (x.getId() == id) {
                return x;
            }
        }
        return null;
    }

    public void addOrderDetails(OrderDetails orderDetailsNou) {
        OrderDetails x = findById(orderDetailsNou.getId());
        if (x == null) {
            this.orderDetails.add(orderDetailsNou);
        } else {
            System.out.println("Exista deja detalii despre comanda cu ID respectiv");
        }
    }


    public void deleteOrderDetails(int id) {
        OrderDetails c = findById(id);
        if (c != null) {
            this.orderDetails.remove(c);
        } else {
            System.out.println("Nu exista detalii despre comanda respectiv");
        }

    }

    public void updateOrderDetails(int orderId, int productId, int cantitate, float priceNou) {
        OrderDetails orderDetails = getOrderDetailsById(orderId, productId);
        orderDetails.setCantitate(cantitate);
        orderDetails.setPrice(priceNou);
    }

    public OrderDetails getOrderDetailsByOrderId(int orderId) {
        for (OrderDetails orders : orderDetails) {
            if (orders.getOrderId() == orderId) {
                return orders;
            }
        }
        return null;
    }


    public int[] bestSellProduct() {

        int[] frecventa = new int[1000];
        for (int i = 0; i < orderDetails.size(); i++) {
            frecventa[orderDetails.get(i).getProductId()]++;
        }

        return frecventa;


    }

    public void updatePretbyName(int idOrder, int idProdus, int cantitateNoua) {

        for (OrderDetails x : orderDetails) {
            if (x.getProductId() == idProdus && x.getOrderId() == idOrder) {
                double pretProdus = x.getPrice() / x.getCantitate();
                x.setCantitate(cantitateNoua);
                x.setPrice((float) pretProdus * cantitateNoua);
            }
        }


    }

    public float moneyDetails(int idOrder){
        float sum=0;
        for (OrderDetails x:orderDetails){
            if(x.getOrderId()==idOrder){
                sum=sum+x.getPrice();
            }
        }
        return sum;
    }

}










