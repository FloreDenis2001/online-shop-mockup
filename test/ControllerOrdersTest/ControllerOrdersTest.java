package ControllerOrdersTest;

import controller.ControllerOrders;
import model.Client;
import model.Orders;
import model.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerOrdersTest {

    @Test
    public void findByIdTest() {
        ControllerOrders controllerOrders = new ControllerOrders();
        Orders x = controllerOrders.findById(3);
        assertEquals(3, x.getId());
    }

    @Test
    public void addOrderTest() {
        ControllerOrders controllerOrders = new ControllerOrders();
        Orders x = new Orders(10, 4, 1000);
        controllerOrders.addOrder(x);
        assertEquals(1000, controllerOrders.findById(10).getPrice());
    }

    @Test
    public void deleteOrdersTest() {
        ControllerOrders controllerOrders = new ControllerOrders();
        controllerOrders.deleteOrders(1);
        assertEquals(null, controllerOrders.findById(1));
    }

    @Test
    public void updatePriceTest() {
        ControllerOrders controllerOrders = new ControllerOrders();
        controllerOrders.updatePret(2, 7000);
        assertEquals(7000, controllerOrders.findById(2).getPrice());

    }

    @Test
    public void nextIdTest() {
        ControllerOrders controllerOrders = new ControllerOrders();
        assertEquals(8, controllerOrders.nextId());
    }

    @Test
    public void findByCustomerId(){
        ControllerOrders controllerOrders=new ControllerOrders();
        //Adauga cateva comenzi in array inainte ... !!!
        ArrayList<Orders> personOrders=new ArrayList<>();
    }

    @Test
    public void updatePrice(){
        ControllerOrders controllerOrders=new ControllerOrders();
        controllerOrders.updatePriceByCustomerId(2,4,7000);
        assertEquals(7000,controllerOrders.findById(2).getPrice());
    }

}