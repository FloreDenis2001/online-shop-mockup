package controller;


import model.Person;
import model.Products;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerProducts {
    private ArrayList<Products> products;

    public ControllerProducts() {
        products = new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File f = new File("src/res/products.txt");
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                String lime = scanner.nextLine();
                this.products.add(new Products(lime));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisare() {
        for (Products x : products) {
            System.out.println(x.toString());
        }
    }

    public Products findByName(String name) {
        for (Products x : products) {
            if (x.getName().equals(name)) {
                return x;
            }
        }
        return null;
    }

    public Products findById(int id) {
        for (Products p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void addStock(String name, int cantitate) {
        for (Products x : products) {
            if (x.getName().equals(name)) {
                x.setStock(x.getStock() + cantitate);
            }
        }
    }

    public void editDescription(String name, String description) {
        for (Products x : products) {
            if (x.getName().equals(name)) {
                x.setDescriptions(description);
            }
        }
    }

    public void updatePrice(String name, float price) {
        for (Products x : products) {
            if (x.getName().equals(name)) {
                x.setPrice(price);
            }
        }
    }

    public String toSaveProducts() {
        String text = "";
        for (Products x : products) {
            text += x.toSave() + "\n";
        }
        return text;
    }

    public void save() {
        try {
            File file = new File("src/res/products.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(toSaveProducts());
            printWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
