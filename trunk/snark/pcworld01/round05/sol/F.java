import java.io.*;

public class F {
    public static void main(String args[]) throws IOException {
        new F().solve();
    }

    void solve() throws IOException {
        br = new BufferedReader(new FileReader("parity.in"));
        pw = new PrintWriter("parity.out");

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String s = br.readLine();
            long m = Long.parseLong(s, 2);
            long n = Long.parseLong(br.readLine(), 2);
            long p = 1L << (s.length() - 1);
            for(int i = 0; i <= s.length(); ++i) {
                if(n == 0) {
                    pw.println("1");
                    break;
                }
                if(s.charAt(i) == '1') {
                    m -= p;
                    if(n >= p) {
                        n -= p;
                    } else {
                        if(n > m) {
                            pw.println("0");
                            break;
                        }
                    }
                }
                p >>>= 1;
            }
        }

        pw.close();
    }

    BufferedReader br;
    PrintWriter pw;
}
