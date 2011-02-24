import java.io.*;

public class B {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pow.in"));
        PrintWriter pw = new PrintWriter("pow.out");
        String[] tokens = br.readLine().split(" ");
        String k = tokens[0];
        String n = tokens[1];
        if(!n.equals("0")) {
            int d = k.charAt(k.length() - 1) - '0';
            int l = 0;
            for(int i = 0; i < n.length(); ++i) {
                l = (l*10 + n.charAt(i) - '0')%p[d];
            }
            if(l == 0) l = p[d];
            int v = 1;
            for(int i = 0; i < l; ++i) {
                v = (v*d)%10;
            }
            pw.println(v);
        } else {
            pw.println("1");
        }
        br.close();
        pw.close();
    }

    final static int[] p = {1, 1, 4, 4, 2, 1, 1, 4, 4, 2};
}
