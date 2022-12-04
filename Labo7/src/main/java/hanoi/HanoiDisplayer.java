package hanoi;

import hanoi.gui.JHanoi;

/**
 * Displays the execution of the Hanoi towers problem. If no argument is given, the gui will be
 * displayed, if the number of disks is given as argument the turns will be print in the console.
 * If more than 1 argument is given, the program will terminate.
 *
 * @author Kevin Farine, Timothee Van Hove
 */
public class HanoiDisplayer {

    public static void main(String[] args){
        if (args.length == 0) {
            new JHanoi();
        } else {
            Hanoi hanoi = new Hanoi(checkArguments(args));
            hanoi.solve();
        }
    }

    public void display(Hanoi h){
        System.out.println(h);
    }

    private static int checkArguments(String[] args){
        int nbDisks;
        if (args == null || args.length > 1){
            throw new RuntimeException(
                    "1 argument expected, " + (args == null ? "0" : args.length) + " are given");
        }
        try {
            nbDisks = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Error: cannot parse " + "\"" + args[0] + "\"" + " to int");
        }
        if (nbDisks < 1){
            throw new RuntimeException("The argument cannot be < 1");
        }
        return nbDisks;
    }
}