package com.grsu.pharmacy.dataAccess.dao;

import com.grsu.pharmacy.dataAccess.genericDao.GenericDaoImpl;
import com.grsu.pharmacy.model.entities.Prescription;

public class PrescriptionDao extends GenericDaoImpl<Prescription> {

    @Override
    public Class<Prescription> getType() {
        return Prescription.class;
    }
}
