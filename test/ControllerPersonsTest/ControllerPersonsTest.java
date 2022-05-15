package ControllerPersonsTest;

import controller.ControllerOrders;
import controller.ControllerPersons;
import model.Client;
import model.Orders;
import model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerPersonsTest {
    @Test
    public void findById(){
        ControllerPersons controllerPersons=new ControllerPersons();
        Person x= controllerPersons.findById(13);
        assertEquals(13,x.getId());
    }
   @Test
    public void addPersonTest() {
        ControllerPersons controllerperson = new ControllerPersons();
        Person x = new Client(20,"Nicoleta",49,"nicoleta@yahoo.com","javacurs7",4);
        controllerperson.addPerson(x);
        assertEquals(49, controllerperson.findById(20).getAge());
    }
    @Test
    public void deletePersonTest(){
        ControllerPersons controllerPersons=new ControllerPersons();
        controllerPersons.deletePerson(13);
        assertEquals(null,controllerPersons.findById(13));
    }

    @Test
    public void updatePasswordTest(){
        ControllerPersons controllerPersons=new ControllerPersons();
        controllerPersons.updatePassword(7,"java");
        assertEquals("java",controllerPersons.findById(7).getPassword());
    }

    @Test
    public void nextIdTest() {
        ControllerPersons controllerPersons=new ControllerPersons();
        assertEquals(16, controllerPersons.nextId());
    }

    @Test
    public void verifyAccTest(){
        ControllerPersons controllerPersons=new ControllerPersons();
        Person x = controllerPersons.verifyAcc("javacurs1","floredenis@yahoo.com");
        assertEquals(20,x.getAge());
    }
    @Test
    public void findByNameTest(){
        ControllerPersons controllerPersons=new ControllerPersons();
        Person x = controllerPersons.findByName("Ionela");
        assertEquals(9,x.getId());
    }
}