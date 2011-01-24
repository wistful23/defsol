import java.io.*;
import java.util.*;

public class D {

    public static void main(String[] args) throws IOException {
        new D().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("fence.in"));
        out = new PrintWriter("fence.out");

        int n = Integer.parseInt(in.readLine());
        while (n > 0) {
            Tree[] trees = new Tree[n];
            for (int i = 0; i < n; ++i) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                trees[i] = new Tree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            int bestV = Integer.MAX_VALUE;
            Tree[] keepedTrees = new Tree[n];
            int full = 1 << n;
            for (int mask = 0; mask < full; ++mask) {
                int curV = 0;
                int curL = 0;
                int m = 0;
                for (int i = 0; i < n; ++i) {
                    if ((mask & (1 << i)) != 0) {
                        keepedTrees[m++] = trees[i];
                    } else {
                        curV += trees[i].v;
                        curL += trees[i].l;
                    }
                }
                if (curV < bestV && curL >= len(keepedTrees, m)) {
                    bestV = curV;
                }
            }
            out.println("The lost value is " + bestV + ".");
            n = Integer.parseInt(in.readLine());
        }

        out.close();
    }

    double len(Tree[] t, int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 2.0 * Math.hypot(t[0].x - t[1].x, t[0].y - t[1].y);
        }
        Arrays.sort(t, 0, n);
        Tree t1 = t[0];
        Tree t2 = t[n - 1];
        List<Tree> up = new ArrayList<Tree>();
        List<Tree> down = new ArrayList<Tree>();
        up.add(t1);
        down.add(t1);
        for (int i = 1; i < n; ++i) {
            if (i == n - 1 || cw(t1, t[i], t2)) {
                while (up.size() >= 2 && !cw(up.get(up.size() - 2), up.get(up.size() - 1), t[i])) {
                    up.remove(up.size() - 1);
                }
                up.add(t[i]);
            }
            if (i == n - 1 || !cw(t1, t[i], t2)) {
                while (down.size() >= 2 && cw(down.get(down.size() - 2), down.get(down.size() - 1), t[i])) {
                    down.remove(down.size() - 1);
                }
                down.add(t[i]);
            }
        }
        List<Tree> fence = new ArrayList<Tree>();
        fence.addAll(up);
        for (int i = down.size() - 2; i >= 0; --i) {
            fence.add(down.get(i));
        }
        double l = 0;
        for (int i = 0; i < fence.size() - 1; ++i) {
            Tree a = fence.get(i);
            Tree b = fence.get(i + 1);
            l += Math.hypot(a.x - b.x, a.y - b.y);
        }
        return l;
    }

    boolean cw(Tree a, Tree b, Tree c) {
        return (c.x - a.x) * (b.y - a.y) - (c.y - a.y) * (b.x - a.x) > 0;
    }

    class Tree implements Comparable<Tree> {

        int x, y;
        int v;
        int l;

        public Tree(int x, int y, int v, int l) {
            this.x = x;
            this.y = y;
            this.v = v;
            this.l = l;
        }

        public int compareTo(Tree o) {
            return x > o.x ? 1 : (x == o.x && y > o.y) ? 1 : -1;
        }
    }

    BufferedReader in;
    PrintWriter out;
}
