import java.io.*;
import java.util.*;

public class E {

    public static void main(String[] args) throws IOException {
        new E().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("kangaroo.in"));
        out = new PrintWriter("kangaroo.out");

        int k = Integer.parseInt(in.readLine());
        for (int x = 1; x <= k; ++x) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            char[][] swamp = new char[h][];
            int[][][] t = new int[h][w][4];

            Queue<Elem> q = new LinkedList<Elem>();

            for (int i = 0; i < h; ++i) {
                swamp[i] = in.readLine().toCharArray();
                for (int j = 0; j < w; ++j) {

                    for (int dir = 0; dir < 4; ++dir) {
                        t[i][j][dir] = INF;
                    }

                    if (swamp[i][j] == 'K') {
                        for (int dir = 0; dir < 4; ++dir) {
                            q.add(new Elem(i, j, dir));
                            t[i][j][dir] = 0;
                        }
                    }
                }
            }

            int best = INF;

            while (!q.isEmpty()) {
                Elem e = q.poll();

                for (int d = 1; d <= 5; ++d) {

                    for (int dir = 0; dir < 4; ++dir) {
                        int ni = e.i + di[dir] * d;
                        int nj = e.j + dj[dir] * d;

                        if (ni >= 0 && nj >= 0 && ni < h && nj < w && swamp[ni][nj] != '.') {
                            int time = t[e.i][e.j][e.dir] + 1 + (e.dir == dir ? 0 : 1);

                            if (swamp[ni][nj] == 'G' && time < best) {
                                best = time;
                            }

                            time += (d - 1) * (d - 1);
                            if (time < t[ni][nj][dir]) {
                                t[ni][nj][dir] = time;
                                q.add(new Elem(ni, nj, dir));
                            }
                        }
                    }

                }

            }

            out.println("Data Set " + x + ":");
            out.println(best == INF ? "Impossible" : best);
            out.println();
        }

        out.close();
    }

    class Elem {
        int i, j;
        int dir;

        public Elem(int i, int j, int dir) {
            this.i = i;
            this.j = j;
            this.dir = dir;
        }
    }

    final static int INF = 1000000000;

    final static int[] di = {0, 1, 0, -1};
    final static int[] dj = {1, 0, -1, 0};

    BufferedReader in;
    PrintWriter out;
}
