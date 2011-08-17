import java.io.*;
import java.util.*;

public class A {

    char[][] f = new char[8][];
    boolean[][] mask = new boolean[8][8];
    int best;
    List<String> l = new ArrayList<String>();

    void calc(int i1, int j1, int i2, int j2) {
        char t = f[i1][j1]; f[i1][j1] = f[i2][j2]; f[i2][j2] = t;
        int r = 0;
        for (int i = 0; i < 8; ++i) {
            Arrays.fill(mask[i], false);
        }
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (i < 6 && f[i][j] == f[i + 1][j] && f[i][j] == f[i + 2][j]) {
                    mask[i][j] = mask[i + 1][j] = mask[i + 2][j] = true;
                }
                if (j < 6 && f[i][j] == f[i][j + 1] && f[i][j] == f[i][j + 2]) {
                    mask[i][j] = mask[i][j + 1] = mask[i][j + 2] = true;
                }
                if (mask[i][j]) ++r;
            }
        }
        if (r >= best) {
            if (r > best) {
                best = r;
                l.clear();
            }
            l.add(i1 + " " + j1 + " " + (i1 == i2 ? 'R' : 'D'));
        }
        t = f[i1][j1]; f[i1][j1] = f[i2][j2]; f[i2][j2] = t;
    }

    void solve() throws IOException {
        in("game.in"); out("game.out");

        for (int i = 0; i < 8; ++i) {
            f[i] = readLine().toCharArray();
        }

        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (i < 7) {
                    calc(i, j, i + 1, j);
                }
                if (j < 7) {
                    calc(i, j, i, j + 1);
                }
            }
        }

        println(best);
        for (String s : l) {
            println(s);
        }

        exit();
    }

    void in(String name) throws IOException {
        if (name.equals("__std")) {
            in = new BufferedReader(new InputStreamReader(System.in));
        } else {
            in = new BufferedReader(new FileReader(name));
        }
    }

    void out(String name) throws IOException {
        if (name.equals("__std")) {
            out = new PrintWriter(System.out);
        } else {
            out = new PrintWriter(name);
        }
    }

    void exit() {
        out.close();
        System.exit(0);
    }

    String readLine() throws IOException {
        return in.readLine();
    }

    void println(Object value) {
        out.println(value);
    }

    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new A().solve();
    }
}
