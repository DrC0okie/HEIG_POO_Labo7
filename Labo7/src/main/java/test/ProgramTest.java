package test;

import hanoi.HanoiDisplayer;
import util.Stack;
import java.util.ArrayList;
import java.util.List;

public class ProgramTest {
    static Stack stack = new Stack();
    private final static String FAIL = "|Test failed|", SUCCESS = "|Test succeeded|";

    public static void main(String[] args) {
        System.out.println("----------Test program----------");
        //Stack class tests
        emptyStackMustBePrintable();
        stackCanContainGenericObjects();
        iteratorMustReferenceTopItem();
        itemsMustBeIterableAndPrintable();
        stackMustBePrintable();
        stackMustReturnCorrectStateArray();
        stackMustBeWellEncapsulated();
        stackCanBeEmptied();
        poppingAnItemFromEmptyStackMustGenerateException();
        nextItemOnEmptyStackMustGenerateException();

        // Hanoi class tests
        multipleArgumentsMustThrowException();
        nonIntegerArgumentsMustThrowException();
        negativeValueArgumentsMustThrowException();
    }

    private static void emptyStackMustBePrintable(){
        System.out.print("Printing an empty stack : ");
        try{
            System.out.print(stack);
        }
        catch(Exception e){
            System.err.println(" " + FAIL);
        }
        System.out.println(" " + SUCCESS);
    }

    private static void stackCanContainGenericObjects() {
        System.out.print("Populating stack with generic objects : ");
        List<Dog> dogs = new ArrayList();
        try{
            dogs.add(new Dog("Rex", 7));
            dogs.add(new Dog("Laika", 9));

            stack.push(dogs);
            stack.push(new Dog("Lassie", 4));
            stack.push("Hello world!");
            stack.push(42);
        }
        catch(Exception e){
            System.err.println(FAIL);
        }
        System.out.println(SUCCESS);
    }

    private static void itemsMustBeIterableAndPrintable() {
        System.out.print("Iterating and printing items of the stack : ");
        Stack.StackIterator iterator = stack.getIterator();
        try{
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
        }
        catch(Exception e){
            System.err.println(FAIL);
        }
        System.out.println(SUCCESS);
    }

    private static void stackMustBePrintable() {
        System.out.print("Printing the stack : ");
        try {
            if(stack.toString().startsWith("[ <") && stack.toString().endsWith("> ]")){
                System.out.print(stack);
                System.out.println(" " + SUCCESS);
            }
        }
        catch (Exception e){
            System.err.println(FAIL);
        }
    }

    private static void iteratorMustReferenceTopItem(){
        System.out.print("Verifying the StackIterator reference : ");
        try {
            Stack.StackIterator iterator = stack.getIterator();
            if ((int) iterator.next() != 42) {
                System.err.println(FAIL);
                return;
            }
        }
        catch(Exception e){
            System.err.println(FAIL);
        }
        System.out.println(SUCCESS);
    }

    private static void stackMustReturnCorrectStateArray(){
        System.out.print("Verifying the length of the status array : ");
        if(stack.getCurrentState().length != 4){
            System.err.println(FAIL);
            return;
        }
        System.out.println(SUCCESS);
    }

    private static void stackMustBeWellEncapsulated(){
        System.out.print("Verifying stack encapsulation by trying to modify the state array : ");
        stack.push(42);
        Object[] state = stack.getCurrentState();
        state[0] = 33;
        if((int)(stack.getIterator().next()) == 33){
            System.err.println(FAIL);
            return;
        }
        System.out.println(SUCCESS);
    }

    private static void stackCanBeEmptied(){
        System.out.print("Emptying the stack entirely : ");
        while(stack.getIterator().hasNext()){
            stack.pop();
        }
        if(!stack.toString().equals("[]")){
            System.err.println(FAIL);
            return;
        }
        System.out.println(SUCCESS);
    }

    private static void poppingAnItemFromEmptyStackMustGenerateException(){
        System.out.print("Trying to pop an item from an empty stack : ");
        try {
            Stack stack = new Stack();
            stack.pop();
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage() + " " + SUCCESS);
            return;
        }
        System.err.println(FAIL);
    }

    private static void nextItemOnEmptyStackMustGenerateException(){
        System.out.print("Trying to reach next item with an iterator on an empty stack : ");
        try {
            Stack stack = new Stack();
            stack.getIterator().next();
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage() + " " + SUCCESS);
            return;
        }
        System.err.println(FAIL);
    }

    private static void multipleArgumentsMustThrowException(){
        System.out.print("Trying to launch the hanoi program with multiple arguments : ");
        try {
            HanoiDisplayer.main(new String[]{"1", "2"});
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage() + " " + SUCCESS);
            return;
        }
        System.err.println(FAIL);
    }

    private static void nonIntegerArgumentsMustThrowException(){
        System.out.print("Trying to launch the hanoi program with non integer arguments : ");
        try {
            HanoiDisplayer.main(new String[]{"test"});
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage() + " " + SUCCESS);
            return;
        }
        System.err.println(FAIL);
    }

    private static void negativeValueArgumentsMustThrowException(){
        System.out.print("Trying to launch the hanoi program with negative integer arguments : ");
        try {
            HanoiDisplayer.main(new String[]{"-1"});
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage() + " " + SUCCESS);
            return;
        }
        System.err.println(FAIL);
    }

    abstract static class Pet {
        private final String name;

        Pet(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Name : " + name;
        }
    }

    static class Dog extends Pet {
        private final int age;

        Dog(String name, int age) {
            super(name);
            this.age = age;
        }

        @Override
        public String toString() {
            return super.toString() + ", Age : " + age;
        }
    }
}
