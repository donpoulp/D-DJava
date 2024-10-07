package fr.campus.donjon.personnage.inventory;

import java.util.ArrayList;

public class Inventory {
    ArrayList<Items> inventory;
    int maxSize;

    public Inventory(int size) {
        this.inventory = new ArrayList<>(size);
        this.maxSize = 10;
    }

    public ArrayList<Items> getInventory() {return inventory;}
    public int getMaxSize() {return maxSize;}

    public void setInventory(ArrayList<Items> inventory) {this.inventory = inventory;}
    public void setMaxSize(int maxSize) {this.maxSize = maxSize;}

    @Override
    public String toString() {
        StringBuilder inventoryString = new StringBuilder();
        if(inventory.isEmpty()){
            return "Inventaire : [] [] [] [] [] [] [] [] [] []";
        }else{
            for (Items items : inventory) {
                inventoryString.append(items.toString()).append("\n");
            }
            return "\n*******************  Inventaire *********************\n"
                    + inventoryString +
                    "*****************************************************\n";
        }
    }

    public void addItem(Items item) {this.inventory.add(item);}

    public void removeItem(Items item) {this.inventory.remove(item);}
}
