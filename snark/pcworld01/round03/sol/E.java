import java.io.*;
import java.util.Scanner;

public class E {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("circum.dat"));
        PrintWriter pw = new PrintWriter("circum.sol");
        int t = s.nextInt();
        while(t-- > 0) {
            double r = Double.parseDouble(s.next());
            int n = s.nextInt();
            double a[] = new double[n];
            double s1 = 0, s2 = 0;
            for(int i = 0; i < n; ++i) {
                a[i] = Double.parseDouble(s.next());
                if(i % 2 == 0) s1 += a[i]; else s2 += a[i];
            }
            if(r == 0) {
                pw.println("0");
                continue;
            }
            double tg = 0.5*(s1 - s2)/r;
            double alpha = Math.atan(tg);
            if(alpha < 0) alpha += Math.PI;
            for(int i = n - 1; i >= 1; --i) {
                tg = a[i]/r - tg;
                double beta = Math.atan(tg);
                if(beta < 0) beta += Math.PI;
                alpha += beta;
            }
            pw.println(Math.abs(alpha - Math.PI) < 0.05 ? "1" : "0");
        }
        s.close();
        pw.close();
    }
}
