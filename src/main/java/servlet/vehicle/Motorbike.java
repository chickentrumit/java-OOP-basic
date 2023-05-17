/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet.vehicle;

/**
 *
 * @author ACER
 */
public class Motorbike extends Vehicle {
    private String license;
    private int speed;

    public Motorbike() {
    }

    public Motorbike(String license, int speed) {
        this.license = license;
        this.speed = speed;
    }

    public Motorbike(String license, int speed, String name, String color, String vehicleId, String brand, int price) {
        super(name, color, vehicleId, brand, price);
        this.license = license;
        this.speed = speed;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "+)  MOTORBIKE: \n" + super.toString() + " ; Required license - " + this.license 
                + " ; Speed - " + this.speed + "\n";
    }

    @Override
    protected void updateVehicle() {
        super.updateVehicle();
        this.license = MethodUtils.updateYesNo(this.license, "Update Required license (Yes/No): ");
        this.speed = MethodUtils.updateGreaterThan0(this.speed, "Update Speed: ");
    }

    @Override
    protected void createVehicle() {
        super.createVehicle();
        this.license = MethodUtils.getYesNo("Required license (Yes/No): ");
        this.speed = MethodUtils.getGreaterThan0("Speed: ");
    }   
    
}
