import java.io.*;
import java.util.*;

public class C {
    public static void main(String args[]) throws IOException {
        new C().solve();
    }

    public void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in)/*new FileReader("c.in")*/);
        pw = new PrintWriter(System.out/*"c.out"*/);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean isSwap = false;
        if(n > m) {
            int t = n; n = m; m = t;
            isSwap = true;
        }
        d = gcd(n, m);
        l = n * m / d;
        n = n / d;
        m = m / d;
        char[] s = new char[n];
        char[] t = new char[m];
        Arrays.fill(s, 'a');
        Arrays.fill(t, 'a');
        t[m - 1] = 'b';
        int best = m - 1;
        char[] bs = Arrays.copyOf(s, s.length);
        char[] bt = Arrays.copyOf(t, t.length);
        int p = m - 1;
        while(true) {
            int i = p % n;
            int j = p % m;
            if(s[i] != 'b') {
                s[i] = 'b';
            } else {
                t[j] = 'b';
            }
            p = calc(s, t);
            if(p == -1) break;
            if(p > best) {
                best = p;
                bs = Arrays.copyOf(s, s.length);
                bt = Arrays.copyOf(t, t.length);
            }
        }
        //pw.println(best);
        if(isSwap) {
            print(bt);
            print(bs);
        } else {
            print(bs);
            print(bt);
        }
        pw.close();
    }

    int d, l;

    void print(char[] s) {
        for(char ch : s) {
            for(int j = 0; j < d - 1; ++j) {
                pw.print('c');
            }
            pw.print(ch);
        }
        pw.println();
    }

    int calc(char[] s, char[] t) {
        int p = 0;
        while(p < l && s[p % s.length] == t[p % t.length]) ++p;
        if(p == l) return -1;
        return p;
    }
    
    int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    BufferedReader br;
    PrintWriter pw;
}
