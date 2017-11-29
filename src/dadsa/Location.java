package dadsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author dawid
 */
public class Location {

    private ArrayList<Item> items = new ArrayList<>(); // Items container
    private int value;
    private int maxValue = 2000000000; // Maximum value of £2bn
    private String name;

    public Location(String name) {
        this.name = name; // Assigns location names
        populate(name); // Calls populate method with the aid of name
    }

    public boolean addItem(Item item) { 
        /** If current value and item value less than maximum add item to Array **/
        if ((value + item.getValue()) < maxValue) { 
            items.add(item);
            value += item.getValue(); // Adds item value to current value
            return true;
        }
        return false;
    }

    public ArrayList<Item> orderedList() { // Returns ordered list based on ItemComparator
        ArrayList<Item> orderedList = new ArrayList(items);
        Collections.sort(orderedList, new ItemComparator());
        return orderedList;
    }

    public boolean removeItem(Item item) { 
        for (Item i : items) { // Loops through items Array
            // If intended reference matches a refence on file remove that item
            if (i.getReference() == item.getReference()) { 
                items.remove(i);
                value -= item.getValue(); // Remove the removed item's value from current value
                return true;
            }
        }
        return false;
    }

    public Item getItem(int ref) {
        /** Loops through items array and displays contents if intended reference matches reference on file **/
        for (Item item : items) { 
            if (item.getReference() == ref) {
                return item;
            }
        }
        return null;
    }

    private void populate(String name) { // Adds current locations
        Scanner scan = new Scanner(Location.class.getResourceAsStream("/Location" + name + ".csv"));
        scan.nextLine(); // Skips first line which contains a header
        while (scan.hasNextLine()) {
            String[] line = scan.nextLine().split(","); // Comma used as a splitter 
            Item i = new Item(Integer.parseInt(line[0]), line[1], Integer.parseInt(line[2]));
            value += Integer.parseInt(line[2]); // Current value is updated using values in file
            items.add(i); // Base items are added to populate the system
        }
        scan.close();
    }

    public String getItems() { // Gets the list of items from items Array
        String s = ""; // Creates a String in order to be able to display in GUI
        s += "\nLocation: " + name + "\n"; // Valuea are added to the tring
        s += System.lineSeparator();
        for (Item item : items) {
            s += item.toString();
            s += System.lineSeparator();
        }
        s += System.lineSeparator();
        s += "Location value: £" + value + "\nAdditional value allowed: £" + getFreeSpace();
        s += System.lineSeparator();
        return s; // Values are now able to be displayed in GUI as a string

    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getFreeSpace() {
        return maxValue - value;
    }

}
