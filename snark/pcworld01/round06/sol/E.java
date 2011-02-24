import java.io.*;

public class E {
    public static void main(String args[]) throws IOException {
        new E().solve();
    }

    void solve() throws IOException {
        br = new BufferedReader(new FileReader("psy.in"));
        pw = new PrintWriter("psy.out");
        int n = Integer.parseInt(br.readLine());
        c = new long[n + 1][n + 1];
        c[0][0] = 1;
        for(int i = 1; i <= n; ++i) {
            c[i][0] = 1;
            c[i][i] = 1;
            for(int j = 1; j < i; ++j) {
                c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
            }
        }
        long r = 0;
        for(int i = 1; i <= n; ++i) {
            for(int j = i; j <= n; ++j) {
                if(i == j) {
                    r += c[n - j][i] * (c[n - j][i] + 1) / 2;
                } else {
                    r += c[n - j][i] * c[n - i][j];
                }
            }
        }
        pw.println(r);
        pw.close();
    }

    long c[][];

    BufferedReader br;
    PrintWriter pw;
}
