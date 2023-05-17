/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet.vehicle;

/**
 *
 * @author ACER
 */
public class Main {

    public static void main(String[] args) {
        
        int c; //Init
        VehicleList vhc = new VehicleList();

        try {
            do {
                MethodUtils.printMenu();
                c = MethodUtils.getInt("Enter your choice Menu: ");
                switch (c) {
                    case 1:
                        System.out.println("readfilenotsuccessfully");
                        break;

                    case 2:
                        vhc.add();
                        System.out.println("");
                        break;

                    case 3:
                        vhc.update();
                        System.out.println("");
                        break;

                    case 4:
                        vhc.delete();
                        System.out.println("");
                        break;

                    case 5:
                        vhc.search();
                        System.out.println("");
                        break;

                    case 6:
                        vhc.output();
                        System.out.println("");
                        break;

                    case 7:
                        System.out.println("writefilenotsuccessfully");
                        break;
                        
                        
                }
            } while (!(c<1||c>7));
            
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
}
