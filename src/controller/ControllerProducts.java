package controller;


import model.Products;

import java.io.File;
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


}
