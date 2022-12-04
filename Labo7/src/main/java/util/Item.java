package util;

/**
 * represents an item in a stack with a value and a reference to the next one.
 *
 * @author Kevin Farine, Timothee Van Hove
 */
class Item {
    /**
     * The value of this item.
     */
    private final Object value;

    /**
     * The next item linked to this one.
     */
    private final Item next;

    /**
     * Item constructor
     *
     * @param value The value of the item.
     * @param next the next item in the stack.
     */
    Item(Object value, Item next) {
        this.value = value;
        this.next = next;
    }

    /**
     * Getter of the value. Used with package visibility to be used by StackIterator class.
     * @return The object value.
     */
    Object getValue(){
        return value;
    }

    /**
     * Getter of the nex item. Used with package visibility to be used by StackIterator class.
     * @return the next referenced item.
     */
    Item getNextItem(){
        return next;
    }
}
