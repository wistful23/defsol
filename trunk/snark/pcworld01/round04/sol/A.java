import java.io.*;
import java.util.*;

public class A {
    public static void main(String args[]) throws IOException {
        new A().solve();
    }

    void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in)/*new FileReader("a.in")*/);
        pw = new PrintWriter(System.out/*"a.out"*/);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        k = 0;
        while(m-- > 0) {
            String[] tokens = br.readLine().split(" ");
            int i = getId(tokens[0]);
            int j = getId(tokens[1]);
            g[i][j] = true;
        }

        boolean r[][] = new boolean[k][k];
        for(int i = 0; i < k; ++i) {
            r[i][i] = true;
        }

        boolean p[][] = new boolean[k][k];
        for(int i = 0; i < k; ++i) {
            for(int j = 0; j < k; ++j) {
                p[i][j] = g[i][j];
            }
        }

        while(n > 0) {
            if((n & 1) != 0) {
                r = mul(r, p);
            }
            n >>>= 1;
            if(n > 0) {
                p = mul(p, p);
            }
        }

        List<Record> ans = new ArrayList<Record>();
        for(int i = 0; i < k; ++i) {
            Record rec = new Record(names.get(i));
            for(int j = 0; j < k; ++j) {
                if(r[i][j]) {
                    rec.list.add(names.get(j));
                }
            }
            ans.add(rec);
        }

        Collections.sort(ans);
        for(Record rec : ans) {
            rec.print();
        }

        pw.close();
    }

    int getId(String name) {
        if(!rooms.containsKey(name)) {
            rooms.put(name, k++);
            names.add(name);
        }
        return rooms.get(name);
    }

    boolean[][] mul(boolean[][] a, boolean b[][]) {
        boolean[][] c = new boolean[k][k];
        for(int i = 0; i < k; ++i) {
            for(int j = 0; j < k; ++j) {
                for(int t = 0; t < k; ++t) {
                    c[i][j] = c[i][j] || (a[i][t] && b[t][j]);
                }
            }
        }
        return c;
    }

    int k;
    boolean g[][] = new boolean[100][100];

    Map<String, Integer> rooms = new HashMap<String, Integer>();
    List<String> names = new ArrayList<String>();

    class Record implements Comparable<Record> {
        public Record(String name) {
            this.name = name;
        }

        public int compareTo(Record o) {
            return cmp.compare(name, o.name);
        }

        public void print() {
            Collections.sort(list, cmp);
            pw.print(name + ":");
            for(String s : list) pw.print(" " + s);
            pw.println();
        }

        String name;
        List<String> list = new ArrayList<String>();
    }

    Comparator<String> cmp = new Comparator<String>() {
        public int compare(String o1, String o2) {
            int d = o1.length() - o2.length();
            if(d != 0) return d;
            int i = 0;
            while(i < o1.length() && o1.charAt(i) == o2.charAt(i)) ++i;
            if(i < o1.length()) return o1.charAt(i) - o2.charAt(i);
            return 0;
        }
    };

    BufferedReader br;
    PrintWriter pw;
}
