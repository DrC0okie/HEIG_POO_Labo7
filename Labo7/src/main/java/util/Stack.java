package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a LIFO stack of objects where each item has a reference to the next one.
 */
public class Stack {
    /**
     * The item that is currently on top of the stack.
     */
    private Item topItem;

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param object The object to push on top.
     */
    public void push(Object object) {
        topItem = new Item(object, topItem);
    }

    /**
     * Removes the object at the top of this stack and returns it.
     *
     * @return The object at the top of this stack.
     * @throws RuntimeException If the stack is empty.
     */
    public Object pop() {
        if (topItem == null)
            throw new RuntimeException("the stack is empty");

        Object value = topItem.getValue();
        topItem = topItem.getNextItem();
        return value;
    }

    /**
     * Returns an array that represents the current state of this stack starting with the top item.
     *
     * @return The array that represents the state of this stack.
     */
    public Object[] getCurrentState() {
        StackIterator iterator = getIterator();
        List<Object> result = new ArrayList<>();

        while (iterator.hasNext())
            result.add(iterator.next());

        return result.toArray();
    }

    /**
     * Returns an iterator pointing to the top item.
     *
     * @return an iterator pointing to the top item.
     */
    public StackIterator getIterator() {
        return new StackIterator(topItem);
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return The string representation of this stack.
     */
    @Override
    public String toString() {
        StackIterator iterator = getIterator();
        StringBuilder builder = new StringBuilder("[");

        while (iterator.hasNext())
            builder.append(" <").append(iterator.next()).append("> ");

        return builder.append("]").toString();
    }
}
