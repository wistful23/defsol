import java.io.*;
import java.util.Scanner;

public class E {
    public static void main(String args[]) throws IOException {
        Scanner s = new Scanner(new File("math.in"));
        PrintWriter pw = new PrintWriter("math.out");
        int n = s.nextInt();
        if(n == 0) {
            pw.println("0 1");
        } else {
            for(int b = 1; b <= n; ++b) {
                int v = n*b*b*b;
                int a = (int)Math.sqrt(v);
                if(a*a == v) {
                    pw.println(a + " " + b);
                    break;
                }
            }
        }
        s.close();
        pw.close();
    }
}
