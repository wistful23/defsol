import java.io.*;
import java.util.Scanner;

public class F {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("picture.dat"));
        PrintWriter pw = new PrintWriter("picture.sol");
        int m = s.nextInt();
        int n = s.nextInt();
        int[] cnt = new int[4];
        int p = -1;
        for(int i = 0; i < m; ++i) {
            int c = s.nextInt();
            if(c == p) {
                ++cnt[c];
            }
            p = c;
        }
        int ans = 0;
        p = -1;
        for(int i = 0; i < n; ++i) {
            int c = s.nextInt();
            if(c == p) {
                ans += cnt[c];
            }
            p = c;
        }
        pw.println(ans);
        s.close();
        pw.close();
    }
}
