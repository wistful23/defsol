import java.io.*;
import java.util.*;

public class E {
    public static void main(String args[]) throws IOException {
        new E().solve();
    }

    void solve() throws IOException {
        br = new BufferedReader(new FileReader("scheme.in"));
        pw = new PrintWriter("scheme.out");

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int W = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            b = new int[W + 1];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1; i <= W; ++i) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            cmd = new int[B + 1];
            in = new int[B + 1][];
            for(int i = 1; i <= B; ++i) {
                st = new StringTokenizer(br.readLine(), " ");
                int w = Integer.parseInt(st.nextToken());
                in[i] = new int[w];
                for(int j = 0; j < w; ++j) {
                    in[i][j] = Integer.parseInt(st.nextToken());
                }
                String s = st.nextToken();
                int j = 0;
                while(!names[j].equals(s)) {
                    ++j;
                }
                cmd[i] = j;
            }
            int r = Integer.parseInt(br.readLine());
            d = new int[B + 1];
            Arrays.fill(d, -1);
            pw.println(calc(r));
        }

        pw.close();
    }

    int b[];
    int d[];

    int cmd[];
    int[][] in;

    int calc(int i) {
        if(i < 0) {
            return b[-i];
        }
        if(d[i] == -1) {
            if(cmd[i] == 6) {
                d[i] = calc(in[i][0]) ^ 1;
            } else {
                int v = calc(in[i][0]);
                for(int j = 1; j < in[i].length; ++j) {
                    switch(cmd[i]) {
                        case 0:
                        case 1:
                            v |= calc(in[i][j]);
                            break;
                        case 2:
                        case 3:
                            v &= calc(in[i][j]);
                            break;
                        case 4:
                        case 5:
                            v ^= calc(in[i][j]);                            
                    }
                }
                if(cmd[i] == 1 || cmd[i] == 3 || cmd[i] == 5) {
                    v ^= 1;
                }
                d[i] = v;
            }
        }
        return d[i];
    }

    final String names[] = new String[] {"OR", "NOR", "AND", "NAND", "XOR", "XNOR", "NOT"};

    BufferedReader br;
    PrintWriter pw;
}
