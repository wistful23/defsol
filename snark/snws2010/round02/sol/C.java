import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        new C().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("chess.in"));
        out = new PrintWriter("chess.out");

        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            String s = in.readLine();
            int i1 = s.charAt(0) - 'A';
            int j1 = s.charAt(1) - '1';
            int i2 = s.charAt(3) - 'A';
            int j2 = s.charAt(4) - '1';
            d = new int[9][9];
            for (int i = 0; i < 9; ++i) {
                Arrays.fill(d[i], Integer.MAX_VALUE);
            }
            qi = new LinkedList<Integer>();
            qj = new LinkedList<Integer>();
            qi.add(i1);
            qj.add(j1);
            d[i1][j1] = 0;
            while (!qi.isEmpty()) {
                int i = qi.poll();
                int j = qj.poll();
                int v = d[i][j] + 1;
                if ((i + j) % 2 == 0) {
                    for (int dd = 1; dd < 9; ++dd) {
                        check(i + dd, j + dd, v);
                        check(i - dd, j - dd, v);
                        check(i + dd, j - dd, v);
                        check(i - dd, j + dd, v);
                    }
                } else {
                    for (int k = 0; k < 8; ++k) {
                        check(i + di[k], j + dj[k], v);
                    }
                }
            }
            if (d[i2][j2] == Integer.MAX_VALUE) {
                out.println("-1");
            } else {
                out.println(d[i2][j2]);
            }
        }

        out.close();
    }

    int[][] d;
    Queue<Integer> qi, qj;

    void check(int i, int j, int v) {
        if (i >= 0 && j >= 0 && i < 9 && j < 9 && d[i][j] > v) {
            d[i][j] = v;
            qi.add(i);
            qj.add(j);
        }
    }

    final static int[] di = {-2, -1, 1, 2, -2, -1, 1, 2};
    final static int[] dj = {1, 2, 2, 1, -1, -2, -2, -1};

    BufferedReader in;
    PrintWriter out;
}
