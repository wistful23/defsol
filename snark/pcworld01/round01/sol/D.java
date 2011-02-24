import java.io.*;
import java.util.StringTokenizer;

public class D {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)/*new FileReader("d.in")*/);
        PrintWriter pw = new PrintWriter(System.out/*"d.out"*/);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int size = 1;
        while(size < n) size <<= 1;
        int shift = size - 1;
        int[] c = new int[size << 1];
        int[] ans = new int[maxr + 1];
        long p = 1;
        for(int r = 1; r <= maxr; ++r) {
            p = p * a % n;
            int k = (int)p + 1;
            int i = shift + k;
            if(c[i] == 0) {
                while(i > 0) {
                    ++c[i];
                    i >>>= 1;
                }
            }
            if(k == 1) continue;
            if(k == 2) {
                ans[r] = c[shift + 1];
                continue;
            }
            i = shift + 1;
            int j = shift + k - 1;
            int v = c[i] + c[j];
            while((i >>> 1) != (j >>> 1)) {
                if((i & 1) == 0) v += c[i + 1];
                if((j & 1) == 1) v += c[j - 1];
                i >>>= 1;
                j >>>= 1;
            }
            ans[r] = v;
        }
        while(q-- > 0) {
            int r = Integer.parseInt(br.readLine());
            pw.println(ans[r]);
        }
        br.close();
        pw.close();
    }

    final static int maxr = 100000;
}
