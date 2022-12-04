package util;

/**
 * Iterator which can be used to iterate on the Stack class int this package.
 *
 * @author Kevin Farine, Timothee Van Hove
 */
public class StackIterator {

    /**
     * The item on which the iterator is currently pointing.
     */
    private Item item;

    /**
     * Iterator constructor with a reference on the item to point.
     *
     * @param item The item to point on.
     */
    public StackIterator(Item item) {
        this.item = item;
    }

    /**
     * Checks if the next item exists.
     *
     * @return true if the next item exists, else returns false.
     */
    public boolean hasNext() {
        return item != null;
    }

    /**
     * Makes the item referencing the next one.
     *
     * @return the current item value
     * @throws RuntimeException if the next item does not exist
     */
    public Object next() {
        if (!hasNext())
            throw new RuntimeException("The next item doesn't exists");

        Item current = item;
        item = item.getNextItem();
        return current.getValue();
    }
}

