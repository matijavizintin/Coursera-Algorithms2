package week4.substringsearch;

/**
 * Created by matijav on 05/02/2017.
 */
public class KnuthMorrisPratt {
    private static final int R = 256;
    private final int M;           // final state
    private final int[][] dfa;     // array[next_char][state]
    public char debugChar;

    public KnuthMorrisPratt(String pattern) {
        this.M = pattern.length();

        // compute DFA
        dfa = new int[R][M];
        dfa[pattern.charAt(0)][0] = 1;  // set first transition

        // go through all states of the DFA
        for (int previousState = 0, currentState = 1; currentState < M; currentState++) {
            // copy previous state to current state
            for (int c = 0; c < R; c++) {
                dfa[c][currentState] = dfa[c][previousState];
            }

            dfa[pattern.charAt(currentState)][currentState] = currentState + 1;     // override match, set to next state
            previousState = dfa[pattern.charAt(currentState)][previousState];       // update previous state
        }
    }

    public int search(String text) {
        int i, j, N = text.length();

        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[text.charAt(i)][j];     // compute next DFA state
        }

        if (j == M) return i - M;
        else return N;
    }

    public void debugPrint() {
        for (int i = 0; i < M; i++) {
            System.out.print(dfa[debugChar][i] + " ");
        }
    }
}
