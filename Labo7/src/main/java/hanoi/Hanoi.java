package hanoi;

import util.Stack;

/**
 * Contains all the methods to solve, and display the Hannoi tower problem
 *
 * @author Kevin Farine, Timothee Van Hove
 */
public class Hanoi {
    private static final int NB_NEEDLES = 3;
    private static final String[] TOWER_NAMES = {"One", "Two", "Three"};
    HanoiDisplayer displayer;
    private final Stack[] needles;
    private int nb_moves;
    private final int nbDisks;

    public Hanoi(int nbDisks, HanoiDisplayer displayer) {
        if (nbDisks < 0)
            throw new RuntimeException("The disks count cannot be negative");

        this.nbDisks = nbDisks;
        this.displayer = displayer;

        // Stacks initialization
        needles = new Stack[NB_NEEDLES];
        for (int i = 0; i < NB_NEEDLES; i++) {
            needles[i] = new Stack();
        }

        // Puts all the disks onto the first needle beginning by the last one
        for (int i = nbDisks; i > 0; i--) {
            needles[0].push(i);
        }
    }

    public Hanoi(int disks) {
        this(disks, new HanoiDisplayer());
    }

    /**
     * Solves the Hanoi towers problem using a recursive algorithm
     */
    public void solve() {
        displayer.display(this);
        hanoiAlgorithm(needles[0], needles[1], needles[2], nbDisks);
    }

    /**
     * Hanoi recursive algorithm used to solve the Hanoi towers problem with 3 needles.
     * Complexity in O(n^2 - 1)
     * @param from The first needle. At the beginning all disks are placed onto this needle.
     * @param via The intermediate needle
     * @param to The final needle. At the end all disks are placed onto that needle
     * @param nbDisks The number of disks to place on the first needle.
     */
    private void hanoiAlgorithm(Stack from, Stack via, Stack to, int nbDisks) {
        if (nbDisks > 0) {
            nb_moves++;
            hanoiAlgorithm(from, to, via, nbDisks - 1);

            // Transfers the top disk between 2 stacks
            to.push(from.pop());
            displayer.display(this);
            hanoiAlgorithm(via, from, to, nbDisks - 1);
        }
    }

    /**
     * Returns a 2d array representation of the needles current status
     *
     * @return a 2d int array representing the status of the 3 needles
     */
    public int[][] status() {
        int[][] result = new int[NB_NEEDLES][];

        for (int i = 0; i < NB_NEEDLES; i++) {
            Object[] currentState = needles[i].getCurrentState();
            result[i] = new int[currentState.length];

            for (int j = 0; j < currentState.length; j++) {
                result[i][j] = (int) currentState[j];
            }
        }
        return result;
    }

    /**
     * Indicates if the run is finished (when 2^n - 1 moves have been done)
     *
     * @return True if the run is finished, false if not.
     */
    public boolean finished() {
        return nb_moves == Math.pow(2, nbDisks) - 1;
    }

    /**
     * Indicates the number of moves that were required to solve the problem with n disks.
     *
     * @return The number of moves to solve the problem.
     */
    public int turn() {
        return nb_moves;
    }

    /**
     * String representation of the current state of the 3 needles
     *
     * @return The string representation
     */
    @Override
    public String toString() {
        StringBuilder state = new StringBuilder("-- Turn: " + turn() + "\n");
        for (int i = 0; i < NB_NEEDLES; i++) {
            state.append(String.format("%-5s%c %s \n", TOWER_NAMES[i], ':', needles[i]));
        }
        return state.toString();
    }
}