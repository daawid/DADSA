package dadsa;

/**
 *
 * @author dawid
 */

public class Item {

    private final int reference;
    private long value;
    private final String name;


    public Item(int reference, String name, long value) { // Assigns Item values
        this.reference = reference;
        this.name = name;
        this.value = value;
    }

    public int getReference() {
        return reference;
    }

    public String getName() {
        return name;
    }

    public long getValue() {
        return value;
    }

    @Override
    public String toString() { // toString method for displaying Item details in GUI
        return "Item " + reference + ", " + name + ", value = £" + value;
    }
    
    

}
