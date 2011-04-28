import java.io.*;
import java.util.*;

public class B {
    public static void main(String args[]) throws IOException {
        new B().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("brackets.in"));
        out = new PrintWriter("brackets.out");

        String s = in.readLine();

        long cnt = 0;
        long k = 0;

        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(') {
                cnt += k;
                k++;
            } else {
                k--;
            }
        }

        out.println(cnt);
        
        out.close();
    }

    BufferedReader in;
    PrintWriter out;
}
