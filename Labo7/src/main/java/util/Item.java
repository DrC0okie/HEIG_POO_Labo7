package util;

/**
 * represents an item in a stack with a value and reference to the next Item
 *
 * @author Kevin Farine, Timothee Van Hove
 */
class Item {
    private Object value;
    private Item next;

    /**
     * Element constructor
     *
     * @param value The value of the item
     * @param next the preceding item in the stack
     */
    Item(Object value, Item next) {
        this.value = value;
        this.next = next;
    }

    /**
     * Getter of the value. Used with package visibility to be used by StackIterator class
     * @return The object's value
     */
    Object getValue(){
        return value;
    }

    /**
     * Getter of the nex item. Used with package visibility to be used by StackIterator class
     * @return the next referenced item
     */
    Item getNextItem(){
        return next;
    }
}
