package controller;

import model.Admin;
import model.Client;
import model.Person;

import java.io.File;
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
        }
            catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisare(){
        for (Person x : arrayList){
            System.out.println(x.toString());
        }
    }

    public int nextId(){
        if(this.arrayList.size()>=0){
            return this.arrayList.get(this.arrayList.size()-1).getId()+1;
        }
        return 1;
    }


}
