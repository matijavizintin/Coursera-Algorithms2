package week5.datacompression;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

import java.util.Objects;

/**
 * Created by matijav on 11/02/2017.
 */
public class RunLength {
    private final static int R = 256;   // max run-length count
    private final static int lgR = 8;   // number of bits per count

    public static void compress() {
        char run = 0;
        boolean previous = false;
        while (!BinaryStdIn.isEmpty()) {
            boolean b = BinaryStdIn.readBoolean();
            if (previous != b) {
                BinaryStdOut.write(run, lgR);
                run = 1;
                previous = b;
            } else {
                run++;
            }

            // flush
            if (run == R - 1) {
                BinaryStdOut.write(run, lgR);
                run = 0;
                BinaryStdOut.write(run, lgR);   // write 0 since we alternate between 0 and 1
            }
        }

        // flush
        BinaryStdOut.write(run, lgR);
        BinaryStdOut.close();
    }

    public static void expand() {
        boolean bit = false;
        while (!BinaryStdIn.isEmpty()) {
            int run = BinaryStdIn.readInt(lgR);     // read 8 bits
            for (int i = 0; i < run; i++) {
                BinaryStdOut.write(bit);            // write bits to out
            }
            bit = !bit;
        }
        BinaryStdOut.close();       // pad 0s for byte alignment
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("No parameters specified. Use compress or expand.");
            System.exit(-1);
        }

        if (Objects.equals(args[0], "compress")) {
            compress();
        } else if (Objects.equals(args[0], "expand")) {
            expand();
        } else {
            System.err.printf("Invalid argument: %s\n", args[0]);
        }
    }
}
