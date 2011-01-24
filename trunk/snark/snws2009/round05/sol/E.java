import java.io.*;

public class E {

    public static void main(String[] args) throws IOException {
        new E().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("old.in"));
        out = new PrintWriter("old.out");

        char[][] l = new char[2][];
        l[0] = in.readLine().toCharArray();
        l[1] = in.readLine().toCharArray();
        while (in.ready()) {
            String msg = in.readLine();
            int i = 0;
            int k = 0;
            while (k < msg.length()) {
                int j = Integer.valueOf(msg.substring(k, k + 5), 2);
                if (j == 27) {
                    i = 0;
                } else if (j == 31) {
                    i = 1;
                } else {
                    out.print(l[i][j]);
                }
                k += 5;
            }
            out.println();
        }

        out.close();
    }

    BufferedReader in;
    PrintWriter out;
}
