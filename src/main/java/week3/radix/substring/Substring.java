package week3.radix.substring;

/**
 * Created by matijav on 28/01/2017.
 */
public class Substring implements Comparable<Substring> {
    private final String source;
    private final int beginning;
    private final int end;

    public Substring(String source, int beginning, int end) {
        this.source = source;
        this.beginning = beginning;
        this.end = end;
    }

    public int length() {
        return end - beginning;
    }

    public char charAt(int i) {
        return source.charAt(beginning + i);
    }

    public Substring substring(int beginning, int end) {
        return new Substring(source, this.beginning + beginning, this.beginning + end);
    }

    public String asString() {
        return source.substring(beginning, end);
    }

    @Override
    public int compareTo(Substring that) {
        int lim = Math.min(this.length(), that.length());

        int k = 0;
        while (k < lim) {
            char c1 = this.charAt(k);
            char c2 = that.charAt(k);
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return this.length() - that.length();
    }
}
