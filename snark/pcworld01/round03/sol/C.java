import java.io.*;
import java.util.Scanner;

public class C {
    public static void main(String args[]) throws IOException {
        Scanner s = new Scanner(new File("roach.dat"));
        PrintWriter pw = new PrintWriter("roach.sol");
        int b = s.nextInt();
        int e = s.nextInt();
        int scores[] = new int[12];
        for(int i = 0; i < 12; ++i) {
            scores[i] = s.nextInt();
        }
        int[][][] d = new int[12][60][2];
        d[b][0][1] = -1000000000;
        for(int h = b; h < e; ++h) {
            for(int m = 0; m < 60; ++m) {
                int hh = h;
                int mm = m + 1;
                if(mm == 60) {
                    ++hh;
                    mm = 0;
                }
                if(hh == 12) {
                    hh = 0;
                }
                d[hh][mm][0] = d[h][m][0] + scores[m / 5];
                d[hh][mm][1] = d[h][m][1] + scores[h]; 
                if(h * 5 == m) {
                    d[hh][mm][0] = Math.max(d[hh][mm][0], d[h][m][1] + scores[m / 5]);
                    d[hh][mm][1] = Math.max(d[hh][mm][1], d[h][m][0] + scores[h]);
                }
            }
        }
        pw.println(d[e % 12][0][0]);
        s.close();
        pw.close();
    }
}
