package Personnage.Inventory;

import GameRule.Board.Case;

import java.util.ArrayList;

public class Inventory {
    ArrayList<Items> inventory;
    int maxSize;

    public Inventory(int size) {
        this.inventory = new ArrayList<>(size);
        this.maxSize = size;
    }

    public ArrayList<Items> getInventory() {return inventory;}

    public int getMaxSize() {return maxSize;}

    public void setInventory(ArrayList<Items> inventory) {this.inventory = inventory;}

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
