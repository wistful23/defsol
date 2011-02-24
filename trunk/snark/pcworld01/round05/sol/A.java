import java.io.*;
import java.util.*;

public class A {
    public static void main(String args[]) throws IOException {
        new A().solve();
    }

    void solve() throws IOException {
        br = new BufferedReader(new FileReader("patrol.in"));
        pw = new PrintWriter("patrol.out");

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Interval> l = new ArrayList<Interval>();
            for(int i = 0; i < n; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                l.add(new Interval(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(l);
            int left = l.get(0).a;
            int right = l.get(0).b;
            for(int i = 1; i < l.size(); ++i) {
                Interval interval = l.get(i);
                if(interval.a > right + 1) {
                    pw.println(left + " " + right);
                    left = interval.a; 
                }
                if(interval.b > right) {
                    right = interval.b;
                }
            }
            pw.println(left + " " + right);
        }

        pw.close();
    }

    class Interval implements Comparable<Interval> {
        public Interval(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int compareTo(Interval o) {
            return a < o.a ? -1 : 1;
        }

        int a, b;
    }

    BufferedReader br;
    PrintWriter pw;
}
