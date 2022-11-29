package ch.heigvd.poo.labo7.stack;

import java.util.Iterator;

public class Stack{
    private int top;
    final private int size;
    private int[] array;

    /**
     * Construit un stack avec déjà des valeurs dedans. (pour la première tour)
     * @param value
     */
    public Stack(int value){
        array = new int[value];
        this.size = value;
        top = size - 1;

        for (int i = 0; i < value; ++i){
            array[i] = i + 1;
        }
    }

    public void push(int value) {
        if (isFull()){
            throw new RuntimeException("Stack Overflow");
        }

        array[++top] = value;
    }

    public int pop() {
        if (isEmpty())
            throw new RuntimeException("The stack is empty");

        return array[top--];
    }

    private boolean isFull(){
        return top == size -1;
    }

    private boolean isEmpty(){
        return top == -1;
    }

    public void clear(){
        top = -1;
    }

    public int[] getState(){
        int[] returnArray = new int[size];
        for (int i = 0; i <= top; ++i){
            returnArray[0] = array[top - i];
        }
        return returnArray;
    }



    //public T[] getState() {
    //    T[] array = (T[]) new Object[size];
//
    //    Iterator<T> i = iterator();
    //    int index = 0;
    //    while (i.hasNext()) {
    //        array[index++] = i.next();
    //    }
    //    return array;
    //}
    //@Override
    //public Iterator<T> iterator() {
    //    return new StackIterator<T>(top);
    //}

    //@Override
    //public String toString() {
    //    Iterator<T> i = iterator();
    //    StringBuilder sb = new StringBuilder("[");
    //    while (i.hasNext()) {
    //        sb.append(" <");
    //        sb.append(i.next());
    //        sb.append("> ");
    //    }
    //    sb.append("]");
    //    return sb.toString();
    //}

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
