package view;

import controller.ControllerPersons;
import model.Admin;
import model.Client;
import model.Person;

import java.util.Scanner;

public class ViewLogin {
    private ControllerPersons controllerPersons;
    private Scanner scanner;

    public ViewLogin() {
        this.controllerPersons = new ControllerPersons();
        this.scanner = new Scanner(System.in);
    }

    public void meniu() {
        System.out.println("-------------------LOGIN-----------------");
        System.out.println("Apasa 1 pentru a te loga");
        System.out.println("Apasa 2 pentru a te inregistra");
        System.out.println("Apasa 3 pentru a iesi");
    }


    public void play() {
        int choose;
        boolean run = true;
        while (run) {
            meniu();
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    login();
                    break;
                case 2:
                    registration();
                    break;
                case 3:
                    logout();
                    run = false;
                    break;
                default:
                    meniu();
            }
        }

    }


    public void login() {
        System.out.println("Introduceti numele utilizatorului : ");
        String email = scanner.nextLine();
        System.out.println("Introduceti parola : ");
        String password = scanner.nextLine();
        Person x = controllerPersons.verifyAcc(password, email);

        if (x instanceof Client) {
            ViewClient client = new ViewClient((Client) x);
            client.play();
        } else if (x instanceof Admin) {

            Admin admin = (Admin) x;

            if (admin.getRoles().equals("Moderator")) {
                ViewModerator viewModerator = new ViewModerator();
                viewModerator.play();
            }else if (admin.getRoles().equals("Fondator")){
                ViewFondator viewFondator=new ViewFondator();
                viewFondator.play();

            }
        } else {
            System.out.println("Datele au introduse gresit !");
        }

    }

    public void registration() {
        System.out.println("Name : ");
        String name = scanner.nextLine();
        System.out.println("Age : ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Email : ");
        String email = scanner.nextLine();
        System.out.println("Password : ");
        String password = scanner.nextLine();
        Client c = new Client(controllerPersons.nextId(), name, age, email, password, 0);
        controllerPersons.addPerson((Person) c);
    }

    public void logout() {
        System.out.println("LOGIN OUT");
    }
}
