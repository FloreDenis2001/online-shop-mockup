package ControllerOrdersDetailsTest;

import controller.ControllerOrderDetails;
import model.OrderDetails;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerOrderDetailsTest {
    @Test
    public void nextIdTest() {
        ControllerOrderDetails controllerOrderDetails = new ControllerOrderDetails();
        assertEquals(8, controllerOrderDetails.nextId());
    }

    @Test
    public void addOrderDetailsTest() {
        ControllerOrderDetails controllerOrderDetails = new ControllerOrderDetails();
        controllerOrderDetails.addOrderDetails(new OrderDetails(8, 6, 3, 20000, 2));
        assertEquals(20000, controllerOrderDetails.findById(8).getPrice());
    }

    @Test
    public void removeOrderDetailsTest() {
        ControllerOrderDetails controllerOrderDetails = new ControllerOrderDetails();
        controllerOrderDetails.removedetails(7, 4);
        assertEquals(null, controllerOrderDetails.findById(7));
    }

    @Test
    public void findByIdTest() {
        ControllerOrderDetails controllerOrderDetails = new ControllerOrderDetails();
        OrderDetails x = controllerOrderDetails.findById(3);
        assertEquals(1, x.getCantitate());
    }

    @Test
    public void getOrderDetailsById() {
        ControllerOrderDetails controllerOrderDetails = new ControllerOrderDetails();
        OrderDetails x = controllerOrderDetails.getOrderDetailsById(2, 3);
        assertEquals(1000, x.getPrice());
    }

    @Test
    public void deleteOrderDetailsByIdTest() {
        ControllerOrderDetails controllerOrderDetails = new ControllerOrderDetails();
        controllerOrderDetails.deleteOrderDetails(5);
        assertEquals(null, controllerOrderDetails.findById(5));
    }

    @Test
    public void updateOrderDetailsTest() {
        ControllerOrderDetails controllerOrderDetails = new ControllerOrderDetails();
        controllerOrderDetails.updateOrderDetails(2, 3, 4, 1500);
        assertEquals(1500, controllerOrderDetails.getOrderDetailsById(2, 3).getPrice());
    }

    @Test
    public void getOrderDetailsByOrdersIdTest() {
        ControllerOrderDetails controllerOrderDetails = new ControllerOrderDetails();
        OrderDetails x = controllerOrderDetails.getOrderDetailsByOrderId(4);
        assertEquals(2, x.getCantitate());
    }

    @Test
    public void bestSellProductTest() {
        ControllerOrderDetails controllerOrderDetails = new ControllerOrderDetails();
        int[] frecventa = controllerOrderDetails.bestSellProduct();
        assertEquals(2, frecventa[3]);
    }

   @Test
    public void updatePrice(){
        ControllerOrderDetails controllerOrderDetails=new ControllerOrderDetails();
        controllerOrderDetails.updatePretbyName(1,1,4);
        assertEquals(4000,controllerOrderDetails.findById(1).getPrice());
   }
}