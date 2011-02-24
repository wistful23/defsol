import java.io.*;
import java.util.*;

public class A {
    public static void main(String args[]) throws IOException {
        new A().solve();
    }

    void solve() throws IOException {
        br = new BufferedReader(new FileReader("form.in"));
        pw = new PrintWriter("form.out");

        int t = Integer.parseInt(br.readLine());
        for(int ct = 1; ct <= t; ++ct) {
            int n = Integer.parseInt(br.readLine());
            RGB[] l = new RGB[n];
            for(int i = 0; i < n; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                l[i] = new RGB();
                l[i].r = Integer.parseInt(st.nextToken());
                l[i].g = Integer.parseInt(st.nextToken());
                l[i].b = Integer.parseInt(st.nextToken());
            }
            int best = 0;
            for(int i = 0; i < n; ++i) {
                for(int j = i + 1; j < n; ++j) {
                    int v = dist(l[i], l[j]);
                    if(v > best) best = v;
                }
            }
            pw.println("Example " + ct + ":");
            for(int i = 0; i < n; ++i) {
                for(int j = i + 1; j < n; ++j) {
                    if(dist(l[i], l[j]) == best) {
                        pw.println((i + 1) + " " + (j + 1));
                    }
                }
            }
        }
        pw.close();
    }

    int dist(RGB x, RGB y) {
        return (x.r - y.r)*(x.r - y.r) + (x.g - y.g)*(x.g - y.g) + (x.b - y.b)*(x.b - y.b); 
    }

    class RGB {
        int r, g, b;
    }

    BufferedReader br;
    PrintWriter pw;
}
