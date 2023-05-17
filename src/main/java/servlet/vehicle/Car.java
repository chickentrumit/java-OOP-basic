/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet.vehicle;

/**
 *
 * @author ACER
 */
public class Car extends Vehicle {
    private String type;
    private int yearOfManufacture;

    public Car() {
    }

    public Car(String type, int yearOfManufacture) {
        this.type = type;
        this.yearOfManufacture = yearOfManufacture;
    }
    
    public Car(String type, int yearOfManufacture, String name, String color, String vehicleId, String brand, int price) {
        super(name, color, vehicleId, brand, price);
        this.type = type;
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
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
 @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "+)  CAR: \n" + super.toString() + " ; Type - " + this.type + " ; Year of manufacture - " + this.yearOfManufacture + "\n";
    }

    @Override
    protected void updateVehicle() {
        super.updateVehicle();
        this.type = MethodUtils.updateType(this.type, "Update Type (Sport/Travel/Common): ");
        this.yearOfManufacture = MethodUtils.updateYear(this.yearOfManufacture, "Update Year of manufacture: ");
    }

    @Override
    protected void createVehicle() {
        super.createVehicle();
        this.type = MethodUtils.getType("Type (Sport/Travel/Common): ");
        this.yearOfManufacture = MethodUtils.getYear("Year of manufacture: ");
    }    
}
