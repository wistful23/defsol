import java.io.*;
import java.util.*;

public class A {

    public static void main(String[] args) throws IOException {
        new A().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("banking.in"));
        out = new PrintWriter("banking.out");

        int a = Integer.parseInt(in.readLine());
        while (a > 0) {

            Map<String, Account> accounts = new HashMap<String, Account>();

            for (int i = 0; i < a; ++i) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                String id = st.nextToken();
                double balance = Double.parseDouble(st.nextToken());
                accounts.put(id, new Account(id, balance));
            }

            String cmd = in.readLine();
            while (!cmd.equals("end")) {

                StringTokenizer st = new StringTokenizer(cmd);
                String name = st.nextToken();
                String id = st.nextToken();

                if (name.equals("create")) {

                    if (accounts.containsKey(id)) {
                        out.println(name + ": already exists");
                    } else {
                        accounts.put(id, new Account(id, 0));
                        out.println(name + ": ok");
                    }

                } else if (name.equals("deposit")) {

                    Account account = accounts.get(id);

                    double amount = Double.parseDouble(st.nextToken());

                    if (account == null) {
                        out.println(name + " " + new Formatter().format(
                                Locale.US, "%.2f", amount) + ": no such account");
                    } else {
                        account.balance += amount;
                        out.println(name + " " + new Formatter().format(
                                Locale.US, "%.2f", amount) + ": ok");
                    }

                } else if (name.equals("withdraw")) {

                    Account account = accounts.get(id);

                    double amount = Double.parseDouble(st.nextToken());

                    if (account == null) {
                        out.println(name + " " + new Formatter().format(
                                Locale.US, "%.2f", amount) + ": no such account");
                    } else {
                        if (account.balance < amount) {
                            out.println(name + " " + new Formatter().format(
                                    Locale.US, "%.2f", amount) + ": insufficient funds");
                        } else {
                            account.balance -= amount;
                            out.println(name + " " + new Formatter().format(
                                    Locale.US, "%.2f", amount) + ": ok");
                        }
                    }

                } else if (name.equals("transfer")) {

                    Account account1 = accounts.get(id);
                    Account account2 = accounts.get(st.nextToken());

                    double amount = Double.parseDouble(st.nextToken());

                    if (account1 == null || account2 == null) {
                        out.println(name + " " + new Formatter().format(
                                Locale.US, "%.2f", amount) + ": no such account");
                    } else {
                        if (account1.id.equals(account2.id)) {
                            out.println(name + " " + new Formatter().format(
                                    Locale.US, "%.2f", amount) + ": same account");
                        } else {
                            if (account1.balance < amount) {
                                out.println(name + " " + new Formatter().format(
                                        Locale.US, "%.2f", amount) + ": insufficient funds");
                            } else {
                                account1.balance -= amount;
                                account2.balance += amount;
                                if (account1.bank == account2.bank) {
                                    out.println(name + " " + new Formatter().format(
                                            Locale.US, "%.2f", amount) + ": ok");
                                } else {
                                    out.println(name + " " + new Formatter().format(
                                            Locale.US, "%.2f", amount) + ": interbank");
                                }
                            }
                        }
                    }

                }

                cmd = in.readLine();
            }

            out.println("end");
            out.println();

            in.readLine();
            a = Integer.parseInt(in.readLine());

            if (a == 0) {
                out.println("goodbye");
            }
        }

        out.close();
    }

    class Account {
        String id;
        double balance;

        int bank;

        public Account(String id, double balance) {
            this.id = id;
            this.balance = balance;

            bank = Integer.parseInt(id.substring(id.lastIndexOf('/') + 1));
        }
    }

    BufferedReader in;
    PrintWriter out;
}
