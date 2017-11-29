package dadsa;

import java.util.Comparator;

/**
 *
 * @author dawid
 */


public class ItemComparator implements Comparator<Item> {

    @Override
    public int compare(Item i1, Item i2) { // Compares item i1 and i2 in order to aid the ordered list
        return (int) (i2.getValue() - i2.getValue());
    }


   
}
