package com.grsu.pharmacy.dataAccess.dao;

import com.grsu.pharmacy.dataAccess.genericDao.GenericDaoImpl;
import com.grsu.pharmacy.model.entities.Order;

public class OrderDao extends GenericDaoImpl<Order>{

    @Override
    public Class<Order> getType() {
        return Order.class;
    }
}
