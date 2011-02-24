import java.io.*;

public class C {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("jury.in"));
        PrintWriter pw = new PrintWriter("jury.out");
        String tokens[] = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);
        int[] b = new int[32];
        for(int i = 0; i < n; ++i) {
            int a = 0;
            int ch = br.read();
            while(ch >= '0' && ch <= '9') {
                a = a*10 + ch - '0';
                ch = br.read();
            }
            int p = 0;
            while(a > 0) {
                if((a & 1) != 0) ++b[p];
                a >>>= 1;
                ++p;
            }
        }
        int v = 0;
        for(int p = 0; p < 32; ++p) {
            if(b[p]%k != 0) v += 1 << p;
        }
        pw.println(v);
        br.close();
        pw.close();
    }
}
