/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package servlet.vehicle;

/**
 *
 * @author ACER
 */
public abstract class Vehicle {
    protected String name, color, vehicleId, brand;
    protected int price;

    public Vehicle() {
    }

    public Vehicle(String name, String color, String vehicleId, String brand, int price) {
        this.name = name;
        this.color = color;
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
     protected void createVehicle() {
        this.vehicleId = MethodUtils.getString("Vehicle ID: ");
        this.name = MethodUtils.getString("Name: ");
        this.brand = MethodUtils.getString("Brand: ");
        this.color = MethodUtils.getColor("Color (Blue/Green/Red): ");
        this.price = MethodUtils.getGreaterThan0("Price: ");
    }

    protected void updateVehicle() {
        String newId, currentId;
        currentId = this.vehicleId;
        do {
            newId = MethodUtils.updateString(this.vehicleId, "Update Vehicle ID: ");
            if (currentId.equals(newId)) {
                System.out.println("Duplicated vehicle ID, input again!");
            } else {
                this.vehicleId = newId;
            }
        } while (currentId.equalsIgnoreCase(newId));
        this.name = MethodUtils.updateString(this.name, "Update Name: ");
        this.brand = MethodUtils.updateString(this.brand, "Update Brand: ");
        this.color = MethodUtils.updateColor(this.color, "Update Color (Blue/Green/Red): ");
        this.price = MethodUtils.updateGreaterThan0(this.price, "Update Price: ");
    }

    @Override
    public String toString() {
        return "Vehicle ID - " + this.vehicleId + " ; Name - " + this.name
                + " ; Brand - " + this.brand + " ; Color - " + this.color
                + " ; Price - " + this.price;
    }

    @Override
    public boolean equals(Object obj) {
        return this.vehicleId.equals(((Vehicle) obj).getVehicleId());
    }
    
}
