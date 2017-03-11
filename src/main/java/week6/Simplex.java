package week6;

/**
 * Created by matijav on 26/02/2017.
 */
public class Simplex {
    private double[][] tableaux;       // simplex tableaux
    private int m, n;           // M constraints, N variables

    public Simplex(double[][] a, double[] b, double[] c) {
        m = b.length;
        n = c.length;
        this.tableaux = new double[m + 1][m + n + 1];

        // copy to tableaux
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tableaux[i][j] = a[i][j];
            }
        }

        // put l into tableaux
        for (int i = n; i < m + n; i++) {
            tableaux[i - n][i] = 1.0;
        }

        // put c into tableaux
        for (int i = 0; i < n; i++) {
            tableaux[m][i] = c[i];
        }

        // put b into tableaux
        for (int i = 0; i < m; i++) {
            tableaux[i][m + n] = b[i];
        }

        solve();
    }

    public double value() {
        return -tableaux[m][m + n];
    }

    private void pivot(int p, int q) {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= m + n; j++) {
                if (i != p && j != q) {
                    tableaux[i][j] -= tableaux[p][j] * tableaux[i][q] / tableaux[p][q];  // scale all entries except tableaux[p][q]
                }
            }
        }

        // zero column q
        for (int i = 0; i <= m; i++) {
            if (i != p) tableaux[i][q] = 0.;
        }

        // scale row p
        for (int i = 0; i <= m + n; i++) {
            if (i != q) tableaux[p][i] /= tableaux[p][q];
        }
        tableaux[p][q] = 1.;

    }

    private void solve() {
        while (true) {
            int q = bland();        // entering column q
            if (q == -1) break;     // if -1 then is optimal

            int p = minRatioRule(q);    // leaving row p
            if (p == -1) {              // unbounded if -1
                throw new ArithmeticException("Linear program is unbounded");
            }

            pivot(p, q);
        }
    }

    private int bland() {
        for (int i = 0; i < m + n; i++) {
            if (tableaux[m][i] > 0) return i;       // entering column
        }
        return -1;
    }

    private int minRatioRule(int q) {
        int p = -1;     // leaving row
        for (int i = 0; i < m; i++) {
            if (tableaux[i][q] > 0 && (p == -1 || tableaux[i][m + n] / tableaux[i][q] < tableaux[p][m + n] / tableaux[p][q])) {
                p = i;
            }
        }

        return p;
    }

}
