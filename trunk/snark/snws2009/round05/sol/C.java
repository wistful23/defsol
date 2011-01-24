import java.io.*;
import java.util.*;

public class C {

    public static void main(String[] args) throws IOException {
        new C().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("exchange.in"));
        out = new PrintWriter("exchange.out");

        String s = in.readLine();
        while (!s.equals("0 END")) {

            StringTokenizer st = new StringTokenizer(s);
            int n = Integer.parseInt(st.nextToken());
            String code = st.nextToken();

            out.println(code);

            Bid[] bids = new Bid[n];

            for (int i = 0; i < n; ++i) {
                st = new StringTokenizer(in.readLine());
                bids[i] = new Bid(st.nextToken(), st.nextToken().equals("buy") ? BUY : SELL,
                                  Double.parseDouble(st.nextToken()));
            }

            for (int i = 0; i < n; ++i) {
                out.print(bids[i].name + ":");

                boolean noone = true;
                for (int j = 0; j < n; ++j) {
                    if (i != j) {
                        if ((bids[i].type == BUY && bids[j].type == SELL && bids[i].price >= bids[j].price) ||
                                (bids[i].type == SELL && bids[j].type == BUY && bids[i].price <= bids[j].price)) {
                            noone = false;
                            out.print(" " + bids[j].name);
                        }
                    }
                }

                if (noone) {
                    out.print(" NO-ONE");
                }

                out.println();
            }

            s = in.readLine();
        }

        out.close();
    }

    class Bid {
        String name;
        int type;
        double price;

        public Bid(String name, int type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }
    }

    final static int BUY = 0;
    final static int SELL = 1;

    BufferedReader in;
    PrintWriter out;
}
