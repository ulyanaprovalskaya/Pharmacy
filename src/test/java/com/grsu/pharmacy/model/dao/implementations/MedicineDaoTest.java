package com.grsu.pharmacy.model.dao.implementations;

import com.grsu.pharmacy.dataAccess.dao.MedicineDao;
import com.grsu.pharmacy.model.entities.Medicine;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

public class MedicineDaoTest {

    private static MedicineDao medicineDao;
    private static Medicine medicine;
    private static Medicine newMedicine;

    @BeforeClass
    public static void setUp() throws ParseException {
        medicineDao = new MedicineDao();

        medicine = new Medicine(2, "No-spa", false);
        newMedicine = new Medicine(1, "Aspirin", false);
    }

    @Test
    public void findById() {
        assertEquals(medicine, medicineDao.findById(medicine.getId()));
    }

    @Test
    public void save() {
        medicineDao.save(newMedicine);
        assertEquals(newMedicine, medicineDao.findById(newMedicine.getId()));

        medicineDao.delete(newMedicine);
    }

    @Test
    public void update() {
        String initialTitle = medicine.getTitle();
        medicine.setTitle("New title");
        medicineDao.update(medicine);
        assertEquals(medicine, medicineDao.findById(medicine.getId()));

        medicine.setTitle(initialTitle);
        medicineDao.update(medicine);
    }

    @Test
    public void delete() {
        medicineDao.save(newMedicine);
        medicineDao.delete(newMedicine);
        assertEquals(null, medicineDao.findById(newMedicine.getId()));
    }
}