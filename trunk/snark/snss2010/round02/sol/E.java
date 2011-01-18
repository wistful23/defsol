import java.io.*;

public class E {

    public static void main(String[] args) throws IOException {
        new E().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        int[] v = new int[n];
        for (int i = 1; i < n; ++i) {
            v[i] = Integer.parseInt(in.readLine());
        }
        String[] s = new String[n];
        for (int i = 0; i < n; ++i) {
            s[i] = in.readLine();
        }
        String a = in.readLine();
        String b = in.readLine();
        int pa = -1;
        int pb = -1;
        for (int i = 0; i < n; ++i) {
            if (s[i].equals(a)) pa = i;
            if (s[i].equals(b)) pb = i;
        }

        out.println(v[Math.abs(pa - pb)]);

        out.close();
    }

    BufferedReader in;
    PrintWriter out;
}
