import java.io.*;
import java.util.*;

public class F {

    public static void main(String[] args) throws IOException {
        new F().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(in.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());

        out.println((x1 + x2 - x3) + ".000000 " + (y1 + y2 - y3) + ".000000");
        out.println((x1 + x3 - x2) + ".000000 " + (y1 + y3 - y2) + ".000000");
        out.println((x3 + x2 - x1) + ".000000 " + (y3 + y2 - y1) + ".000000");

        out.close();
    }

    BufferedReader in;
    PrintWriter out;
}
