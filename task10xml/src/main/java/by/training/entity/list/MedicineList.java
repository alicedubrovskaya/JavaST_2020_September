package by.training.entity.list;

import by.training.entity.Medicine;

import java.util.ArrayList;
import java.util.List;

public class MedicineList {
    List<Medicine> medicines;

    public MedicineList() {
        this.medicines = new ArrayList<>();
    }

    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }
}
