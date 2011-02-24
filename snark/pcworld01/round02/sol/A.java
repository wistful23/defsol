import java.io.*;
import java.util.Scanner;

public class A {
    public static void main(String args[]) throws IOException {
        Scanner s = new Scanner(new File("seq.in"));
        PrintWriter pw = new PrintWriter("seq.out");
        int n = s.nextInt();
        int m = 1;
        while(m < n) m <<= 1;
        a = new int[m];
        go(0, m - 1);
        for(int i = 0; i < n; ++i) {
            pw.print(a[i] + " ");
        }
        pw.println();
        s.close();
        pw.close();
    }

    static void go(int i, int j) {
        if(i == j) return;
        int k = (i + j) >>> 1;
        a[k] = 1 - a[j];
        go(i, k);
        go(k + 1, j);
    }

    static int[] a;
}
