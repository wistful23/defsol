import java.io.*;
import java.util.*;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("unsort.dat"));
        PrintWriter pw = new PrintWriter("unsort.sol");
        String[] tok = br.readLine().split(" ");
        int n = Integer.parseInt(tok[0]);
        int m = Integer.parseInt(tok[1]);
        int[] a = new int[n];
        int[] p = new int[m];
        int[] q = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < m; ++i) {
            tok = br.readLine().split(" ");
            p[i] = Integer.parseInt(tok[0]) - 1;
            q[i] = Integer.parseInt(tok[1]) - 1;
        }
        for(int i = m - 1; i >= 0; --i) {
            int t = a[p[i]];
            a[p[i]] = a[q[i]];
            a[q[i]] = t;
        }
        for(int i = 0; i < n; ++i) {
            pw.print(a[i] + " ");
        }
        pw.println();
        br.close();
        pw.close();
    }
}
