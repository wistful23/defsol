import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("binrvrs.dat"));
        PrintWriter pw = new PrintWriter("binrvrs.sol");
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String s = br.readLine();
            if(s.length() == 0) {
                pw.println();
                continue;
            }
            if(s.charAt(0) == '0') {
                pw.println("NO SOLUTION");
                continue;
            }
            int[] d = new int[s.length()];
            int[] p = new int[s.length()];
            d[0] = 1;
            p[0] = -1;
            for(int i = 1; i < s.length(); ++i) {
                for(int j = 0; j <= i; ++j) {
                    if(s.charAt(j) == '1') {
                        int v = j > 0 ? d[j - 1] : 0;
                        int w = 0;
                        for(int k = j; k <= i; ++k) {
                            w = w*2 + s.charAt(k) - '0';
                            if(w >= inf) {
                                w = inf;
                                break;
                            }
                        }
                        if(w > v || w == inf) {
                            if(d[i] == 0 || w < d[i]) {
                                d[i] = w;
                                p[i] = j - 1;
                            }
                        }
                    }
                }
            }
            int len = d[s.length() - 1];
            if(len == inf) {
                pw.println("LINE TOO LONG");
            } else {
                int[] ans = new int[len];
                int i = s.length() - 1;
                while(i != -1) {
                    ans[d[i] - 1] = 1;
                    i = p[i];
                }
                for(int j = 0; j < len; ++j) {
                    pw.print(ans[j]);
                }
                pw.println();
            }
        }
        br.close();
        pw.close();
    }

    static final int inf = 30001;
}
