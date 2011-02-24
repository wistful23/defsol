import java.io.*;
import java.util.*;

public class F {
    public static void main(String args[]) throws IOException {
        new F().solve();
    }

    void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in)/*new FileReader("f.in")*/);
        pw = new PrintWriter(System.out/*"f.out"*/);
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        if(n < 7) {
            long r = m + n;
            while(!checkBottom(r)) r += n;
        } else {
            long r = c[n - 2];
            for(int i = 1; i < m; ++i) r -= n - 1;
            pw.println(r);
        }
        pw.close();
    }

    boolean checkBottom(long r) {
        for(int i = 0; i < n; ++i) {
            if(r * n % (n - 1) != 0) return false;
            r = r * n / (n - 1) + m;
        }
        pw.println(r);
        return true;
    }

    boolean checkUp(long r) {
        for(int i = 0; i <= n; ++i) {
            if(r - m <= 0 || (r - m) % n != 0) return false;
            r = r - m - (r - m) / n;
        }
        return true;
    }

    long[] c = {15L, 79L, 1021L, 15621L, 279931L, 5764795L, 134217721L, 3486784393L, 99999999991L};

    int n, m;

    BufferedReader br;
    PrintWriter pw;
}
