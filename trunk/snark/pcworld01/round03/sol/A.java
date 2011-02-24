import java.io.*;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("bintrans.dat"));
        PrintWriter pw = new PrintWriter("bintrans.sol");
        String a = br.readLine();
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            String aa = "";
            for(int i = 0; i < a.length(); ++i)
                if(a.charAt(i) == '1') {
                    aa += Integer.toBinaryString(i + 1);
                }
            a = aa;
        }
        pw.println(a);
        br.close();
        pw.close();
    }
}
