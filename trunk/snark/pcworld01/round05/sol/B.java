import java.io.*;
import java.util.*;

public class B {
    public static void main(String args[]) throws IOException {
        new B().solve();
    }

    void solve() throws IOException {
        br = new BufferedReader(new FileReader("level.in"));
        pw = new PrintWriter("level.out");

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            p = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            v = new int[k][w];
            for(int i = 0; i < k; ++i) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < w; ++j) {
                    v[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int best = 0;
            mask = new boolean[k][w];
            filled = new boolean[k][w];
            for(int i = 0; i < k; ++i) {
                for(int j = 0; j < w; ++j) {
                    if(!mask[i][j]) {
                        cnt = 0;
                        s = v[i][j];
                        fill(i, j);
                        while(!q.isEmpty()) {
                            Point p = q.poll();
                            fill(p.i + 1, p.j);
                            fill(p.i - 1, p.j);
                            fill(p.i, p.j + 1);
                            fill(p.i, p.j - 1);
                        }
                        if(cnt > best) best = cnt;
                        clear(i, j);
                        while(!q.isEmpty()) {
                            Point p = q.poll();
                            clear(p.i + 1, p.j);
                            clear(p.i - 1, p.j);
                            clear(p.i, p.j + 1);
                            clear(p.i, p.j - 1);
                        }
                    }
                }
            }
            pw.println(best);
        }

        pw.close();
    }

    int p;
    int k, w;
    int[][] v;
    boolean[][] mask, filled;
    int cnt, s;

    Queue<Point> q = new LinkedList<Point>();

    class Point {
        int i, j;
        Point(int i0, int j0) {
            i = i0;
            j = j0;
        }
    }

    void fill(int i, int j) {
        if(i < 0 || j < 0 || i >= k || j >= w || filled[i][j]) return;
        if(v[i][j] >= s && v[i][j] - s <= p) {
            ++cnt;
            filled[i][j] = true;
            if(v[i][j] == s) mask[i][j] = true;
            q.add(new Point(i, j));
        }
    }

    void clear(int i, int j) {
        if(i < 0 || j < 0 || i >= k || j >= w || !filled[i][j]) return;
        filled[i][j] = false;
        q.add(new Point(i, j));
    }

    BufferedReader br;
    PrintWriter pw;
}
