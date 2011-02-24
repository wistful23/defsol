import java.io.*;
import java.util.StringTokenizer;

public class B {
    public static void main(String args[]) throws IOException {
        new B().solve();
    }

    void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in)/*new FileReader("b.in")*/);
        pw = new PrintWriter(System.out/*"b.out"*/);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] a = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int i = 1;
        int j = 2;
        while(l-- > 0) {
            int t = Integer.parseInt(st.nextToken());
            if(s == 0) {
                while(t-- > 0) {
                    if(a[i] != 0) {
                        no(a[i], i, j);
                    } else a[i] = j;
                    if(a[j] != 0) {
                        no(a[j], i, j);
                    } else a[j] = i;
                    if(j == n) {
                        ++i;
                        j = i + 1;
                    } else ++j;
                }
            } else {
                while(j + t > n) {
                    t -= n - j + 1;
                    ++i;
                    j = i + 1;
                }
                j += t;
            }
            s = 1 - s;
        }
        pw.println("YES");
        pw.close();
    }

    void no(int i, int j, int k) throws IOException {
        pw.println("NO");
        pw.println(i + " " + j + " " + k);
        pw.close();
        System.exit(0);
    }

    BufferedReader br;
    PrintWriter pw;
}
