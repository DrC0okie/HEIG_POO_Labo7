package ch.heigvd.poo.labo7.stack;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{
    private StackElement<T> top;
    private int size;

    /**
     * Construit un stack vide. (Pour la tour 2 & 3)
     */
    public Stack(){
        top = null;
        size = 0;
    }

    /**
     * Construit un stack avec déjà des valeurs dedans. (pour la première tour)
     * @param value
     */
    public Stack(T value){
        //top = value;
        //this.size = value;
    }

    public void push(T value) {
        top = new StackElement<>(top, value);
        size++;
    }

    public T pop() {
        if (top == null)
            throw new RuntimeException("The stack is empty");

        T value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public T[] getState() {
        T[] array = (T[]) new Object[size];

        Iterator<T> i = iterator();
        int index = 0;
        while (i.hasNext()) {
            array[index++] = i.next();
        }
        return array;
    }
    @Override
    public Iterator<T> iterator() {
        return new StackIterator<T>(top);
    }

    @Override
    public String toString() {
        Iterator<T> i = iterator();
        StringBuilder sb = new StringBuilder("[");
        while (i.hasNext()) {
            sb.append(" <");
            sb.append(i.next());
            sb.append("> ");
        }
        sb.append("]");
        return sb.toString();
    }

    //Classes supplémentaires
    //Classe StackElement<E>
    private static class StackElement<E> {
        StackElement<E> next;

        E value;

        StackElement(StackElement<E> next, E value) {
            this.next = next;
            this.value = value;
        }
    }

    //Classe StackIterator
    private static class StackIterator<T> implements Iterator<T> {
        private StackElement<T> stackElement;

        private StackIterator(StackElement<T> stackElement) {
            this.stackElement = stackElement;
        }

        public boolean hasNext() {
            return stackElement != null;
        }

        public T next() {
            if (!hasNext())
                throw new RuntimeException("No following element");

            StackElement<T> current = stackElement;
            stackElement = stackElement.next;
            return current.value;
        }
    }
}
