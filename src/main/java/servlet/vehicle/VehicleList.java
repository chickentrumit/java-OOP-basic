/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet.vehicle;

import java.util.*;

/**
 *
 * @author ACER
 */
public class VehicleList extends ArrayList<Vehicle> implements function_List {

    ArrayList<Vehicle> list = new ArrayList<>();
    Vehicle vhc;
    private int index;

    public VehicleList() {
    }

    public VehicleList(Vehicle vhc, int index) {
        this.vhc = vhc;
        this.index = index;
    }

    public VehicleList(Vehicle vhc, int index, Collection<? extends Vehicle> c) {
        super(c);
        this.vhc = vhc;
        this.index = index;
    }

    public ArrayList<Vehicle> getList() {
        return list;
    }

    public void setList(ArrayList<Vehicle> list) {
        this.list = list;
    }

    public Vehicle getVhc() {
        return vhc;
    }

    public void setVhc(Vehicle vhc) {
        this.vhc = vhc;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int findid(String code) {
        return list.indexOf(new Car());
    }

    @Override
    public void add() {
        int c;
        try {
            do {
                System.out.println("\n     ADD VEHICLE MENU");
                System.out.println("    1 - Add Car");
                System.out.println("    2 - Add Motorbike");
                System.out.println("    Other - Back to menu \n");
                c = MethodUtils.getInt("Enter your choice Add: ");
                switch (c) {
                    case 1:
                        vhc = new Car();
                        vhc.createVehicle();
                        index = list.indexOf(vhc);
                        if (index == -1) {
                            list.add(vhc);
                            System.out.println("Added!");
                        } else {
                            System.out.println("Dupplicated!");
                        }
                        System.out.println("");
                        break;

                    case 2:
                        vhc = new Motorbike();
                        vhc.createVehicle();
                        index = list.indexOf(vhc);
                        if (index == -1) {
                            list.add(vhc);
                            System.out.println("Added!");
                        } else {
                            System.out.println("Dupplicated!");
                        }
                        System.out.println("");
                        break;
                }
            } while (!(c < 1 || c > 2));
        } catch (Exception e) {
        }
    }

    @Override
    public void delete() {
        this.index = findid(MethodUtils.getString("Enter Vehicle ID that you want to delete, required to enter correct Vehicle ID including uppercase and lowercase: "));
         System.out.println(this.index);
        String check;
        if (index != -1) {
            check = MethodUtils.getYesNo("Are you sure you want to delete (Yes/No)? ");
            if (check.equalsIgnoreCase("Yes")) {
                list.remove(index);
                System.out.println("Successfully!");
            } else {
                System.out.println("Fail!");
            }
        } else {
            System.out.println("Not Found!");
        }
    }

    @Override
    public void update() {
        this.index = findid(MethodUtils.getString("Enter the Vehicle ID that you want to update, required to enter correct Vehicle ID including uppercase and lowercase: "));
       
        if (index != -1) {
            vhc = list.get(index);
            vhc.updateVehicle();
            list.set(index, vhc);
            System.out.println("Updated!");
            System.out.println("The result of the update: \n" + vhc.toString());
        } else {
            System.out.println("Vehicle does not exist!");
        }
    }

    @Override
    public void search() {
        int c;
        String text1, text2;
        int count1 = 0;
        int count2 = 0;

        try {
            do {
                System.out.println("\n        SEARCH VEHICLE MENU");
                System.out.println("    1 - Search by vehicle name");
                System.out.println("    2 - Search by vehicle id");
                System.out.println("    Other - Back to menu \n");
                c = MethodUtils.getInt("Enter your choice: ");
                switch (c) {
                    case 1: // Search by vehicle Name (descending).
                        text1 = MethodUtils.getString("Enter the vehicle name you want to find: ");
                        ArrayList<Vehicle> clonelist = (ArrayList<Vehicle>) list.clone();
                        Collections.sort(clonelist, new Comparator<Vehicle>() {
                            @Override
                            public int compare(Vehicle c1, Vehicle c2) {
                                return (c2.vehicleId.compareTo(c1.vehicleId));
                            }
                        });
                        for (Vehicle oo : clonelist) {
                            if (oo.getName() != null && (oo.getName().contains(text1))) {
                                System.out.println(oo.toString());
                                count1++;
                            }
                        }
                        if (count1 == 0) {
                            System.out.println("Not found!");
                        }
                        System.out.println("");
                        break;

                    case 2: // Search by Vehicle ID.
                        text2 = MethodUtils.getString("Enter the Vehicle ID you want to find, required to enter correct ID including uppercase and lowercase: ");
                        for (Vehicle vhc : list) {
                            if (vhc.getVehicleId() != null && vhc.getVehicleId().equals(text2)) {
                                System.out.println(vhc.toString());
                                count2 = 1;
                                break;
                            }
                        }
                        if (count2 != 1) {
                            System.out.println("Not found!");
                        }
                }
            } while (!(c < 1 || c > 2));

        } catch (Exception e) {
        }
    }

    @Override
    public void output() {
        int c;
        try {
            do {
                System.out.println("\n     SHOW VEHICLE MENU");
                System.out.println("    1 - Show all");
                System.out.println("    2 - Show descending by price");
                System.out.println("    Other - Back to menu \n");
                c = MethodUtils.getInt("Enter your choice: ");
                switch (c) {
                    case 1: // Show all.
                        for (Vehicle zo : list) {
                            System.out.println(zo.toString());
                        }
                        System.out.println("");
                        break;

                    case 2: // Show descending by Price.
                        ArrayList<Vehicle> clonelist = (ArrayList<Vehicle>) list.clone();
                        Collections.sort(clonelist, new Comparator<Vehicle>() {
                            @Override
                            public int compare(Vehicle c1, Vehicle c2) {
                                if (c1.price < c2.price) {
                                    return 1;
                                } else {
                                    if (c1.price == c2.price) {
                                        return 0;
                                    } else {
                                        return -1;
                                    }
                                }
                            }
                        });
                        for (Vehicle vhc : clonelist) {
                            System.out.println(vhc.toString());
                        }
                        System.out.println("");
                        break;
                }
            } while (!(c < 1 || c > 2));
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

}
