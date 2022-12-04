package util;

/**
 * Iterator which can be used to iterate on the Stack class int this package
 *
 * @author Kevin Farine, Timothee Van Hove
 */
public class StackIterator {

    /**
     * The item on which the iterator is currently pointing on
     */
    private Item item;

    /**
     * Iterator constructor with a reference on the first item
     *
     * @param item First element
     */
    public StackIterator(Item item) {
        this.item = item;
    }

    /**
     * Checks if the next item exists
     *
     * @return true if the next item exists, else returns false
     */
    public boolean hasNext() {
        return item != null;
    }

    /**
     * Makes the item referencing the next element
     *
     * @return the current element's value
     * @throws RuntimeException it the next element doesn't exists
     */
    public Object next() {
        if (!hasNext())
            throw new RuntimeException("The next element doesn't exists");

        Item current = item;
        item = item.getNextItem();
        return current.getValue();
    }
}

