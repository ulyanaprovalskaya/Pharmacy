package com.grsu.pharmacy.model.dao.implementations;

import com.grsu.pharmacy.dataAccess.dao.OrderDao;
import com.grsu.pharmacy.model.entities.Medicine;
import com.grsu.pharmacy.model.entities.Order;
import com.grsu.pharmacy.model.entities.User;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OrderDaoTest {

    private static OrderDao orderDao = new OrderDao();
    private static Order order;
    private static Order newOrder;

    @BeforeClass
    public static void setUp(){
        Medicine medicine = new Medicine(2, "No-spa", false);
        List<Medicine> ordersMedicines = new ArrayList<>();
        ordersMedicines.add(medicine);

        User user = new User(1, "Ivan", "Ivanov");

        order = new Order(1, ordersMedicines, user);
        newOrder = new Order(2, ordersMedicines, user);
    }

    @Test
    public void findById() {
        Order actualOrder = orderDao.findById(1);
        assertEquals(actualOrder, order);
    }

    @Test
    public void save() {
        orderDao.save(newOrder);
        assertEquals(newOrder, orderDao.findById(newOrder.getId()));

        orderDao.delete(newOrder);
    }

    @Test
    public void update() {
        List<Medicine> initialMedicines = new ArrayList<>();
        initialMedicines.addAll(order.getMedicines());

        order.getMedicines().add(new Medicine(1,"Aspirin", false));
        orderDao.update(order);
        assertEquals(order, orderDao.findById(order.getId()));

        order.setMedicines(initialMedicines);
        orderDao.update(order);
    }

    @Test
    public void delete() {
        orderDao.save(newOrder);
        orderDao.delete(newOrder);

        assertEquals(null, orderDao.findById(newOrder.getId()));
    }
}