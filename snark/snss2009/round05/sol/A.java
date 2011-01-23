import java.io.*;

public class A {

    final static int M = 2946859;
    final static int K = 216816;
    final static int N = 3000000;

    public static void main(String[] args) throws IOException {
        new A().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("airport.in"));
        out = new PrintWriter("airport.out");
        int k = 0;
        for (int i = 2; i < N; ++i) {
            if (!p[i]) {
                l[k++] = i;
                int j = i << 1;
                while (j < N) {
                    p[j] = true;
                    j += i;
                }
            }
        }
        int n = Integer.parseInt(in.readLine());
        int n3 = n * 3;
        long r = 1;
        for (int i = 0; i < K; ++i) {
            k = calc(n3, l[i]) - calc(n, l[i]) * 3;
            if (k > 0) {
                r = (r * pow(l[i], k)) % M;
            }
        }
        out.println(r);
        out.close();
    }

    int calc(int n, int p) {
        int r = 0;
        long k = p;
        while (k <= n) {
            r += n / k;
            k *= p;
        }
        return r;
    }

    long pow(int b, int p) {
        if (p == 1) {
            return b;
        }
        long r = pow(b, p / 2);
        r = (r * r) % M;
        if ((p & 1) == 1) {
            r = (r * b) % M;
        }
        return r;
    }

    boolean[] p = new boolean[N];
    int l[] = new int[K];

    BufferedReader in;
    PrintWriter out;
}
