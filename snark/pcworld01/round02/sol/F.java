import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;

public class F {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("flowers.in"));
        PrintWriter pw = new PrintWriter("flowers.out");
        int n = s.nextInt();
        int k = s.nextInt();
        boolean[][] g = new boolean[k][k];
        for(int j = 0; j < k; ++j) {
            int c = s.nextInt();
            while(c > 0) {
                g[j][s.nextInt() - 1] = true;
                --c;
            }
        }
        int c = 0;
        for(int j = 0; j < k; ++j) {
           if(g[j][j]) ++c;
        }
        BigInteger bc = BigInteger.valueOf(c);
        BigInteger[][][] d = new BigInteger[n][k][k];
        for(int j = 0; j < k; ++j) {
            for(int first = 0; first < k; ++first) {
                if(j == first) {
                    d[0][j][first] = BigInteger.ONE;
                } else {
                    d[0][j][first] = BigInteger.ZERO;
                }
            }
        }
        for(int i = 1; i < n; ++i) {
            for(int j = 0; j < k; ++j) {
                for(int first = 0; first < k; ++first) {
                    d[i][j][first] = BigInteger.ZERO;
                    for(int prev = 0; prev < k; ++prev) {
                        if(g[j][prev] && g[prev][j]) {
                            if((i < n - 1) || (g[j][first] && g[first][j])) {
                                d[i][j][first] = d[i][j][first].add(d[i - 1][prev][first]);
                            }
                        }
                    }
                }
            }
        }
        BigInteger ans = BigInteger.ZERO;
        for(int j = 0; j < k; ++j) {
            for(int first = 0; first < k; ++first) {
                ans = ans.add(d[n - 1][j][first]);
            }
        }
        pw.println(ans.subtract(bc).divide(BigInteger.valueOf(n)).add(bc));
        s.close();
        pw.close();
    }
}
