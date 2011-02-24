import java.io.*;
import java.util.*;

public class C {
    public static void main(String args[]) throws IOException {
        new C().solve();
    }

    void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in)/*new FileReader("c.in")*/);
        pw = new PrintWriter(System.out/*"c.out"*/);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] f = new char[n][m];
        for(int y = 0; y < n; ++y) {
            for(int x = 0; x < m; ++x) f[y][x] = '.';
        }
        st = new StringTokenizer(br.readLine(), " ");
        int y0 = Integer.parseInt(st.nextToken());
        int x0 = Integer.parseInt(st.nextToken());
        int[] l = new int[9];
        for(int i = 0; i < 3; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 3; ++j) {
                l[i*3 + j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < 9; ++i) {
            int x = x0;
            int y = y0;
            for(int k = 0; k < l[i]; ++k) {
                x += vx[i];
                y += vy[i];
                if(x < 0 || y < 0 || x == m || y == n) invalid();
                f[y][x] = '#';
            }
        }
        f[y0][x0] = '#';
        for(int y = 0; y < n; ++y) {
            for(int x = 0; x < m; ++x) pw.print(f[y][x]);
            pw.println();
        }

        pw.close();
    }

    void invalid() {
        pw.println("Invalid parameters");
        pw.close();
        System.exit(0);
    }

    BufferedReader br;
    PrintWriter pw;

    final static int[] vx = {-1,  0,  1, -1, 0, 1, -1, 0, 1};
    final static int[] vy = {-1, -1, -1,  0, 0, 0,  1, 1, 1};
}
