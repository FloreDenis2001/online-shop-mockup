package controller;

import model.Orders;
import model.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
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
            File f = new File("src/res/orders.txt");
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                String lime = scanner.nextLine();
                this.orders.add(new Orders(lime));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //todo crud
    public void afisare() {
        for (Orders x : orders) {
            System.out.println(x.toString());
        }
    }

    public Orders findById(int id) {
        for (Orders x : orders) {
            if (x.getId() == id) {
                return x;
            }
        }
        return null;
    }


    public void addOrder(Orders orderNou) {
        Orders x = findById(orderNou.getId());
        if (x == null) {
            this.orders.add(orderNou);
        } else {
            System.out.println("Exista o comanda cu ID respectiv");
        }
    }


    public void deleteOrders(int id) {
        Orders c = findById(id);
        if (c != null) {
            this.orders.remove(c);
        } else {
            System.out.println("Nu exista comanda respectiv");
        }

    }



    public void updatePret(int id, float pretNou) {
        Orders x = findById(id);
        if (x != null) {
            x.setPrice(pretNou);
        } else {
            System.out.println("Comanda respectiv nu exista");
        }
    }


    public int nextId() {

        if (this.orders.size() > 0) {

            return this.orders.get(this.orders.size() - 1).getId() + 1;
        }
        return 1;
    }


     public ArrayList<Orders> findByCustomerId(Person person){
       ArrayList<Orders> personOrders=new ArrayList<>();
        for (Orders o : orders){
            if(o.getCustomerId()== person.getId()){
               personOrders.add(o);
            }
        }
       return personOrders;
     }
    public String toSaveOrders() {
        String text = "";
        for (Orders x : orders) {
            text += x.toSave() + "\n";
        }
        return text;
    }

    public void save() {
        try {
            File file = new File("C:\\Users\\flore\\Desktop\\mycode\\shop-online\\src\\res\\orders.txt" );
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(toSaveOrders());
            printWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
