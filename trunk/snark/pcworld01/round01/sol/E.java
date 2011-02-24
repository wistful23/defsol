import java.io.*;
import java.util.*;

public class E {
    public static void main(String args[]) throws IOException {
        new E().solve();
    }

    void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in)/*new FileReader("e.in")*/);
        pw = new PrintWriter(System.out/*"e.out"*/);
        int n = Integer.parseInt(br.readLine());
        List<Rect> l = new ArrayList<Rect>();
        x = new int[n];
        y = new int[n];
        for(int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
            for(int j = 0; j < i; ++j) {
                l.add(new Rect(i, j));
            }
        }
        Collections.sort(l);
        int best = 1;
        Rect r = l.get(0);
        int k = 1;
        for(int i = 1; i < l.size(); ++i) {
            Rect p = l.get(i - 1);
            Rect c = l.get(i);
            if(c.compareTo(p) == 0) ++k; else k = 1;
            if(k > best) {
                best = k;
                r = c;
            }
        }
        if(6*best >= n*(n - 1)) {
            pw.println(best);
            pw.println(++r.j + " " + ++r.i);
        } else {
            pw.println("-1");
        }
        br.close();
        pw.close();
    }

    class Rect implements Comparable<Rect> {
        public Rect(int i, int j) {
            this.i = i;
            this.j = j;
            a = Math.abs(x[i] - x[j]);
            b = Math.abs(y[i] - y[j]);
            if(a > b) {
                int t = a; a = b; b = t;
            }
        }

        public int compareTo(Rect o) {
            int u = a*o.b;
            int v = b*o.a;
            return u < v ? -1 : u == v ? 0 : 1;
        }

        int i, j;
        int a, b;
    }

    int[] x;
    int[] y;

    BufferedReader br;
    PrintWriter pw;
}
