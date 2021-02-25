public class Main {
    public static void test(){
        long leftLimit = 0L;
        long rightLimit = 9223372036854775807L;
        int c = 0;

        for(int i =0; i<1000; i++) {

            long x1 = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
            long x2 = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
            if (x1 + x2 >= 0) {
                BigInt a =BigInt.add(new BigInt(x1 + ""), new BigInt(x2 + ""));
                String ls = (x1+x2)+"";
                if(a.equals(new BigInt(ls))) {
                    c++;
                    System.out.println("\nx1: " + x1 + "\nx2: " + x2 + "\nsum: " + (x1 + x2));
                    System.out.println("BigInt sum:" + a + "\n");
                }
                else {
                    System.out.println("Sum is wrong!!!!!!!!!!!!!!!!");
                }
            } else {
                c++;
                System.out.println("\nx1: " + x1 + "\nx2: " + x2 );
                System.out.println("The sum of longs is too large");
            }

        }
        long l =999999999999999999L;
        long one = 1L;
        System.out.println("\nx1: " + l + "\nx2: " + one + "\nsum: " + (l + one));
        System.out.println("BigInt sum:" + BigInt.add(new BigInt( l+""), new BigInt( one+"")));

        System.out.println("\nx1: " + one + "\nx2: " + l + "\nsum: " + (one + l ));
        System.out.println("BigInt sum:" + BigInt.add(new BigInt( one+ ""), new BigInt( l+"")));
        if(c == 1000){
            System.out.println("\n\n\t\t\tTest is completed successfully!");
        }
    }



    public static void main(String[] args) {
        byte[] b = {1,2,3,4};
        BigInt bb = new BigInt(b);
        BigInt bs = new BigInt("111");
        BigInt bc = new BigInt(bb);
        System.out.println(bb+"\n" + bs + "\n" + bc);

        test();
    }
}
