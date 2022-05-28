package controller;

import model.Admin;
import model.Client;
import model.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerPersons {
    private ArrayList<Person> arrayList;

    public ControllerPersons() {
        arrayList = new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File f = new File("src/res/persons.txt");
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {

                String lime = scanner.nextLine();

                switch (lime.split(",")[5]) {
                    case "admin":
                        this.arrayList.add(new Admin(lime));
                        break;
                    case "client":
                        this.arrayList.add(new Client(lime));
                        break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisare() {
        for (Person x : arrayList) {
            System.out.println(x.toString());
        }
    }


    public Person findById(int id) {
        for (Person x : arrayList) {
            if (x.getId() == id) {
                return x;
            }
        }
        return null;
    }

    public void addPerson(Person persoanaNou) {
        Person x = findById(persoanaNou.getId());
        if (x == null) {
            this.arrayList.add(persoanaNou);
        } else {
            System.out.println("Exista o persoana cu ID respectiv ");
        }
    }


    public void deletePerson(int id) {
        Person c = findById(id);
        if (c != null) {
            this.arrayList.remove(c);
        } else {
            System.out.println("Nu exista persoana");
        }

    }

    public void updatePassword(int id, String passwordNoua) {
        Person x = findById(id);
        if (x != null) {
            x.setPassword(passwordNoua);
        } else {
            System.out.println("Persoana respectiva nu exista");
        }
    }

    public int nextId() {
        if (this.arrayList.size() >= 0) {
            return this.arrayList.get(this.arrayList.size() - 1).getId() + 1;
        }
        return 1;
    }

    public Person verifyAcc(String password, String email) {
        for (Person x : arrayList) {
            if (x.getEmail().equals(email) && x.getPassword().equals(password)) {
                return x;
            }
        }
        return null;
    }

    public Person findByName(String name){
        for (Person x:arrayList){
            if(x.getName().equals(name)){
                return x;
            }
        }
        return null;
    }

    public String toSavePerson() {
        String text = "";
        for (Person x : arrayList) {
            text += x.toSave() + "\n";
        }
        return text;
    }

    public void save() {
        try {
            File file = new File("C:\\Users\\flore\\Desktop\\mycode\\shop-online\\src\\res\\persons.txt" );
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(toSavePerson());
            printWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
