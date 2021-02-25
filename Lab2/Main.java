import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static int Euclid(int a, int b) {
        int tmp = 0;
        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static int extendedEuclid(int a, int b) {
        int x0 = 1;
        int x = 0;
        int b0 = b;
        int q;
        int tmp;
        while (b != 0) {
            q = a / b;
            tmp = x;
            x = x0 - q * x;
            x0 = tmp;
            tmp = a % b;
            a = b;
            b = tmp;
        }
        if (x0 < 0) {
            x0 += b0;
        }
        return x0;
    }

    public static void main(String[] args) {
        int p = 397;
        int q = 103;
        int n = p * q;
        int fn = (p - 1) * (q - 1);
        int e = 3;
        while (e < fn) {
            if (e % 2 == 1) {
                if (Euclid(e, fn) == 1)
                    break;
            }
            e += 2;
        }
        System.out.println("e = " + e);

        int d = extendedEuclid(e, fn);
        System.out.println("d = " + d);


        System.out.println("Please enter your message:");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        System.out.println("Your message is: "+message);
        int size = message.length();


        BigInteger[] arr = new BigInteger[size];
        BigInteger[] encryption = new BigInteger[size];
        BigInteger exp = BigInteger.valueOf(e);
        BigInteger m = BigInteger.valueOf(n);
        String encStr = "";
        for (int i = 0; i < size; i++) {
            arr[i] = BigInteger.valueOf((int) message.charAt(i));
            encryption[i] = arr[i].modPow(exp, m);
            encStr += encryption[i];
        }
        System.out.println("There is encryption:"  + encStr);

        BigInteger d1 = BigInteger.valueOf(d);
        char[] decryption = new char[size];
        String decStr = "";
        for (int i = 0; i < size; i++) {
            decryption[i] =(char) encryption[i].modPow(d1, m).intValue();
            decStr += decryption[i];
        }
        System.out.println("After decryption:" + decStr);
    }
}
