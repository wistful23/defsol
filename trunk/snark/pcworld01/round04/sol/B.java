import java.io.*;
import java.util.*;

public class B {
    public static void main(String args[]) throws IOException {
        new B().solve();
    }

    void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in)/*new FileReader("b.in")*/);
        pw = new PrintWriter(System.out/*"b.out"*/);
        read(0);
        read(1);
        int ar = 23;
        int ap = 0;
        for(int i = 0; i < 2; ++i) {
            center(1 - i);
            int l[] = new int[8];
            for(int j = 0; j < 8; ++j) l[j] = len(1 - i, j);
            for(int r = 0; r < 4; ++r) {
                center(i);
                int ll = len(i, 0);
                if(l[0] % ll == 0) {
                    int p = l[0] / ll;
                    boolean flag = true;
                    for(int j = 1; flag && j < 8; ++j) {
                        flag = l[j] == p * len(i, j);
                    }
                    int rr = r;
                    if(r == 3) rr = 1;
                    if(flag && rr < ar) {
                        ar = rr;
                        ap = p;
                    }
                }
                rotate(i);
            }
        }
        if(ar == 23) {
            pw.println("Not equal");
        } else {
            pw.println("Equal");
            pw.println(ar * 90 +  " " + ap);
        }
        pw.close();
    }

    void center(int i) {
        for(int y = 1; y < size; ++y) {
            for(int x = 1; x < size; ++x) {
                if(f[i][y][x] == '#' && f[i][y - 1][x - 1] == '#' &&
                   f[i][y][x - 1] == '#' && f[i][y - 1][x] == '#') {
                    y0[i] = y;
                    x0[i] = x;
                    return;
                }
            }
        }
    }

    void read(int i) throws IOException {
        clear(i);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int y = 0; y < n; ++y) {
            String s = br.readLine();
            for(int x = 0; x < m; ++x) f[i][y + 1][x + 1] = s.charAt(x);
        }
    }

    void clear(int i) {
        for(int y = 0; y < size; ++y) {
            Arrays.fill(f[i][y], '.');
        }
    }

    void rotate(int i) {
        clear(2);
        for(int y = 0; y < size; ++y) {
            for(int x = 0; x < size; ++x) {
                f[2][x][size - y - 1] = f[i][y][x];
            }
        }
        for(int y = 0; y < size; ++y) {
            f[i][y] = Arrays.copyOf(f[2][y], size);
        }
    }

    int len(int i, int j) {
        int l = 0;
        while(f[i][y0[i] + l*vy[j]][x0[i] + l*vx[j]] == '#') ++l;
        return --l;
    }

    BufferedReader br;
    PrintWriter pw;

    final int size = 1023;
    int[][][] f = new int[3][size][size];
    int[] x0 = new int[2];
    int[] y0 = new int[2];

    final static int[] vx = {-1,  0,  1, -1, 1, -1, 0, 1};
    final static int[] vy = {-1, -1, -1,  0, 0,  1, 1, 1};
}
