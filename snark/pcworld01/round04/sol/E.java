import java.io.*;
import java.util.*;

public class E {
    public static void main(String args[]) throws IOException {
        new E().solve();
    }

    void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in)/*new FileReader("e.in")*/);
        pw = new PrintWriter(System.out/*"e.out"*/);
        n = Integer.parseInt(br.readLine());
        f = new int[2][n];
        for(int p = 0; p < 2; ++p) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < n; ++i) {
                f[p][i] = Integer.parseInt(st.nextToken());
            }
        }
        s = new Stack[n];
        for(int i = 0; i < n; ++i) {
            s[i] = new Stack<Integer>();
            s[i].push(f[0][i]);
        }
        go(0);
        if(best != null) {
            if(best.isEmpty()) {
                pw.println("Empty sequence");
            } else {
                pw.print(cn[best.get(0)]);
                for(int i = 1; i < best.size(); ++i) {
                    pw.print(" " + cn[best.get(i)]);
                }
                pw.println();
            }
        } else {
            pw.println("Impossible");
        }
        pw.close();
    }

    void go(int k) {
        if(best != null && k == best.size()) return;
        boolean flag = true;
        for(int i = 0; i < n && flag; ++i) {
            flag = s[i].size() == 1 && s[i].peek() == f[1][i];
        }
        if(flag) {
            best = new ArrayList<Integer>();
            for(int i = 0; i < k; ++i) {
                best.add(pc[i]);
            }
            return;
        }
        if(k == 10) return;
        for(int c = 0; c < 5; ++c) {
            if(c != 2 && s[0].size() < 2) continue;
            flag = true;
            int[] a = new int[n];
            int[] b = new int[n];
            int[] v = new int[n];
            for(int i = 0; c != 2 && i < n && flag; ++i) {
                a[i] = s[i].peek();
                b[i] = s[i].get(s[i].size() - 2);
                v[i] = 0;
                switch(c) {
                    case 0: v[i] = a[i] + b[i]; break;
                    case 1: if(a[i] != 0) v[i] = b[i] / a[i]; else flag = false; break;
                    case 3: v[i] = a[i] * b[i]; break;
                    case 4: v[i] = b[i] - a[i]; break;
                }
                if(v[i] < -30000 || v[i] > 30000) flag = false;
            }
            if(flag) {
                for(int i = 0; i < n; ++i) {
                    if(c == 2) {
                        s[i].push(s[i].peek());
                    } else {
                        s[i].pop();
                        s[i].pop();
                        s[i].push(v[i]);
                    }
                }
                pc[k] = c;
                go(k + 1);
                for(int i = 0; i < n; ++i) {
                    if(c == 2) {
                        s[i].pop();
                    } else {
                        s[i].pop();
                        s[i].push(b[i]);
                        s[i].push(a[i]);
                    }
                }
            }
        }
    }

    int n;
    int[][] f;
    Stack<Integer>[] s;
    int[] pc = new int[10];
    List<Integer> best;

    String cn[] = {"ADD", "DIV", "DUP", "MUL", "SUB"};

    BufferedReader br;
    PrintWriter pw;
}
