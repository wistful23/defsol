import java.io.*;

public class D {
    public static void main(String args[]) throws IOException {
        new D().solve();
    }

    void solve() throws IOException {
        br = new BufferedReader(new FileReader("stat.in"));
        pw = new PrintWriter("stat.out");

        int t = Integer.parseInt(br.readLine());
        for(int ct = 1; ct <= t; ++ct) {
            int n = Integer.parseInt(br.readLine());
            String[] name = new String[n];
            String[] big = new String[n];
            for(int i = 0; i < n; ++i) {
                name[i] = br.readLine();
                big[i] = name[i].toUpperCase();
            }
            String a = br.readLine().toUpperCase();
            pw.println("Example " + ct + ":");
            for(int k = 0; k < n; ++k) {
                int j = 0;
                for(int i = 0; i < name[k].length(); ++i) {
                    if(big[k].charAt(i) == a.charAt(j)) ++j;
                    if(j == a.length()) break;
                }
                if(j == a.length()) {
                    pw.println(name[k]);
                }
            }
        }

        pw.close();
    }

    BufferedReader br;
    PrintWriter pw;
}
