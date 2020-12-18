package com.grsu.pharmacy.dataAccess.dao;

import com.grsu.pharmacy.dataAccess.genericDao.GenericDaoImpl;
import com.grsu.pharmacy.model.entities.Medicine;

public class MedicineDao extends GenericDaoImpl<Medicine> {
    @Override
    public Class<Medicine> getType() {
        return Medicine.class;
    }
}
