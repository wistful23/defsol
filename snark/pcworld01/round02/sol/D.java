import java.io.*;
import java.util.Scanner;

public class D {
    public static void main(String args[]) throws IOException {
        Scanner s = new Scanner(new File("kingdom.in"));
        PrintWriter pw = new PrintWriter("kingdom.out");
        int n = s.nextInt();
        int k = s.nextInt();
        int x0 = s.nextInt();
        int y0 = s.nextInt();
        int x1 = x0;
        int y1 = y0;
        int x2, y2;
        int area = 0;
        for(int i = 1; i < k; ++i) {
            x2 = s.nextInt();
            y2 = s.nextInt();
            area += x1*y2 - x2*y1;
            x1 = x2;
            y1 = y2;
        }
        area += x1*y0 - x0*y1;
        pw.println(1 - Math.abs(area)%2);
        s.close();
        pw.close();
    }
}
