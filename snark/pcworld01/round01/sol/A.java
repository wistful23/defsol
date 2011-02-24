import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class A {
    public static void main(String args[]) throws IOException {
        new A().solve();
    }

    void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in)/*new FileReader("a.in")*/);
        pw = new PrintWriter(System.out/*"a.out"*/);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        BigInteger k = new BigInteger(br.readLine());
        d = new BigInteger[n + 1][m + 1];
        for(int i = 0; i <= n; ++i) {
            for(int j = 0; j <= m; ++j) {
                d[i][j] = BigInteger.ZERO;
                if(i == 0 && j == 0) d[i][j] = BigInteger.ONE;
                if(i > 0) d[i][j] = d[i][j].add(d[i - 1][j]);
                if(j > 0) d[i][j] = d[i][j].add(d[i][j - 1]);
            }
        }
        go(n, m, 0, k);
        pw.println(ans);
        pw.close();
    }

    void go(int i, int j, int v, BigInteger k) {
        if(i == 0 && j == 0) return;
        if(j > 0 && k.compareTo(d[i][j - 1]) != 1) {
            ans += v == 0 ? "AB" : "B";
            go(i, j - 1, 1, k);
        } else {
            ans += v == 0 ? "B" : "CB";
            if(j > 0) k = k.subtract(d[i][j - 1]);
            go(i - 1, j, 0, k);
        }
    }

    String ans = "";
    BigInteger[][] d;

    BufferedReader br;
    PrintWriter pw;
}
