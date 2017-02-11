package week5.regex;

import edu.princeton.cs.algs4.StdOut;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by matijav on 11/02/2017.
 */
public class Harvester {

    public static void main(String[] args) {
        String regex = args[0];
//        In in = new In(args[1]);
//        String input = in.readAll();
        String input = args[1];
        input = input.replaceAll("_", " ");

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            StdOut.println(matcher.group());
        }
    }
}
