package com.grsu.pharmacy.model.dao.implementations;

import com.grsu.pharmacy.dataAccess.dao.PrescriptionDao;
import com.grsu.pharmacy.model.entities.Medicine;
import com.grsu.pharmacy.model.entities.Prescription;
import com.grsu.pharmacy.model.entities.User;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class PrescriptionDaoTest {

    private static PrescriptionDao prescriptionDao;
    private static Prescription prescription;
    private static Prescription newPrescription;

    @BeforeClass
    public static void setUp() throws ParseException {
        prescriptionDao = new PrescriptionDao();

        Medicine medicine = new Medicine(2, "No-spa", false);
        Medicine newMedicine = new Medicine(1, "Aspirin", false);
        User user = new User(1, "Ivan", "Ivanov");

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        prescription = new Prescription(1, medicine, dateFormat.parse("20.12.2020"), user);
        newPrescription = new Prescription(2, newMedicine, dateFormat.parse("26.12.2020"), user);
    }

    @Test
    public void findById() {
        assertEquals(prescription, prescriptionDao.findById(1));
    }

    @Test
    public void save() {
        prescriptionDao.save(newPrescription);
        assertEquals(newPrescription, prescriptionDao.findById(newPrescription.getId()));

        prescriptionDao.delete(newPrescription);
    }

    @Test
    public void update() {
        Date initialDate = prescription.getExpirationDate();
        prescription.setExpirationDate(new Date(2020-12-12));
        prescriptionDao.update(prescription);
        assertEquals(prescription, prescriptionDao.findById(prescription.getId()));

        prescription.setExpirationDate(initialDate);
        prescriptionDao.update(prescription);
    }

    @Test
    public void delete() {
        prescriptionDao.save(newPrescription);
        prescriptionDao.delete(newPrescription);
        assertEquals(null, prescriptionDao.findById(newPrescription.getId()));
    }
}