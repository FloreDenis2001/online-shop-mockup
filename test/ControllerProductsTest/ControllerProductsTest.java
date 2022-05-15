package ControllerProductsTest;

import controller.ControllerProducts;
import model.Products;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerProductsTest {

    @Test
    public void findByNameTest(){
        ControllerProducts controllerProducts=new ControllerProducts();
        Products x = controllerProducts.findByName("monitor");
        assertEquals(800,x.getPrice());
    }

    @Test
    public void findByIdTest(){
        ControllerProducts controllerProducts=new ControllerProducts();
        Products x= controllerProducts.findById(5);
        assertEquals("boxe audio",x.getName());
    }

    @Test
    public void addStockTest(){
        ControllerProducts controllerProducts=new ControllerProducts();
        controllerProducts.addStock("monitor",14);
        assertEquals(24,controllerProducts.findByName("monitor").getStock());
    }

    @Test
    public void editDescriptionTest(){
        ControllerProducts controllerProducts=new ControllerProducts();
        controllerProducts.editDescription("boxe audio","descriereaperfecta");
        assertEquals("descriereaperfecta",controllerProducts.findByName("boxe audio").getDescriptions());
    }

    @Test
    public void updatePriceTest(){
        ControllerProducts controllerProducts=new ControllerProducts();
        controllerProducts.updatePrice("telefon",5000);
        assertEquals(5000,controllerProducts.findByName("telefon").getPrice());
    }

}