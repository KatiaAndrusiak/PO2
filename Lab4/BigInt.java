import java.util.Arrays;

public class BigInt {
    private final byte[] bytes;

    public BigInt(String number) {
        bytes = new byte[number.length()];
        for (int i = 0; i < number.length(); i++) {
            bytes[i] = Byte.parseByte(number.split("")[i]);
        }
    }

    public BigInt(byte[] b) {
        bytes = new byte[b.length];
        System.arraycopy(b, 0, bytes, 0, b.length);
    }

    public BigInt(BigInt bi) {

        bytes = new byte[bi.bytes.length];
        System.arraycopy(bi.bytes, 0, bytes, 0, bi.bytes.length);
    }


    public boolean equals(Object obj) {
        BigInt a = new BigInt("");
        if(obj.getClass().equals(BigInt.class)) {
             a = (BigInt) obj;
        }
        return Arrays.equals(bytes, a.bytes);
    }

    public final byte[] getNum() {
        return bytes;
    }

    public static BigInt add(BigInt a, BigInt b) {
        byte[] xmax = max(a, b);
        byte[] xmin = min(b, a);
        int[] res = new int[xmax.length + 1];
        byte[] tmp = new byte[xmax.length];
        for (int i = 0; i < xmin.length; i++) {
            tmp[xmax.length - i - 1] = xmin[xmin.length - i - 1];
        }

        int r = 0;
        for (int i = xmax.length - 1; i >= 0; i--) {
            if (xmax[i] + tmp[i] + r < 10) {
                res[i + 1] = xmax[i] + tmp[i] + r;
                r = 0;
            } else {
                res[i + 1] = (xmax[i] + tmp[i] + r) % 10;
                r = (xmax[i] + tmp[i] + r) / 10;

            }
        }
        res[0] = r;

        StringBuilder s = new StringBuilder();
        if(res[0]!=0) s.append(res[0]);
        for (int i = 1; i < xmax.length + 1; i++) {
            s.append(res[i]);
        }
        return new BigInt(s.toString());
    }

    private static byte[] max(BigInt a, BigInt b) {
        if (a.getNum().length > b.getNum().length) return a.bytes;
        else return b.bytes;
    }

    private static byte[] min(BigInt a, BigInt b) {
        if (a.getNum().length < b.getNum().length) return a.bytes;
        else return b.bytes;
    }

    public String toString() {
        String[] str = Arrays.toString(bytes).split(", ");
        return String.join("", str).replace("[", "").replace("]", "");
    }

}
