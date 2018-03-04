package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;

public final class SuppliersDirectory {
    private final List<Supplier> theSupplierList = new ArrayList<>();

    public SuppliersDirectory() {
        theSupplierList.add(new ExtraFoodShop());
        theSupplierList.add(new HealthyShop());
        theSupplierList.add(new GlutenFreeShop());
    }

    public List<Supplier> getList() {
        return new ArrayList<>(theSupplierList);
    }

}
