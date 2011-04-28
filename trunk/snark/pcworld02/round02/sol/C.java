import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        new C().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("shield.in"));
        out = new PrintWriter("shield.out");

        int r = Integer.parseInt(in.readLine());

        StringTokenizer st = new StringTokenizer(in.readLine());
        int ax1 = Integer.parseInt(st.nextToken());
        int ay1 = Integer.parseInt(st.nextToken());

        int ax2 = Integer.parseInt(st.nextToken());
        int ay2 = Integer.parseInt(st.nextToken());

        int ax3 = Integer.parseInt(st.nextToken());
        int ay3 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int bx1 = Integer.parseInt(st.nextToken());
        int by1 = Integer.parseInt(st.nextToken());

        int bx2 = Integer.parseInt(st.nextToken());
        int by2 = Integer.parseInt(st.nextToken());

        int bx3 = Integer.parseInt(st.nextToken());
        int by3 = Integer.parseInt(st.nextToken());

        int bx4 = Integer.parseInt(st.nextToken());
        int by4 = Integer.parseInt(st.nextToken());

        double s[] = new double[3];
        s[0] = 2.0 * Math.PI * r * r;
        s[1] = area(ax1, ay1, ax2, ay2, ax3, ay3);
        //s[2] = area(bx1, by1, bx2, by2, bx3, by3) + area(bx3, by3, bx4, by4, bx1, by1);
        //s[2] = area(bx1, by1, bx2, by2, bx3, by3) + area(bx1, by1, bx3, by3, bx4, by4);
        s[2] = area(bx1, by1, bx2, by2, bx4, by4) + area(bx3, by3, bx2, by2, bx4, by4);

        String[] name = new String[3];
        name[0] = "Fred";
        name[1] = "Garret";
        name[2] = "Arthur";

        for(int i = 0; i < 3; ++i) {
            for(int j = i + 1; j < 3; ++j) {
                if(s[i] < s[j]) {
                    double t = s[i];
                    s[i] = s[j];
                    s[j] = t;
                    
                    String ts = name[i];
                    name[i] = name[j];
                    name[j] = ts;
                }
            }
        }

        for(int i = 0; i < 3; ++i) {
            out.println(name[i]);
        }

        out.close();
    }

    int area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)); 
    }

    BufferedReader in;
    PrintWriter out;
}
