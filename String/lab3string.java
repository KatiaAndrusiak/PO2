public class lab3string {

    public static int dlugosc(String s){
        return s.length();
    }

    public static int ile_razy_literka_wystepuje(String s, char literka){
        int count = 0;
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == literka)
                count++;
        }
        return count;
    }

    public static boolean czy_takie_same(String s1, String s2){
        return s1.contentEquals(s2);
    }

    public static String wspak(String s){
        String ss = "";
        for( int i = s.length()-1; i>=0; i--){
            ss += s.charAt(i);
        }
        return ss;
    }

    public static boolean czy_plaindrom(String s){
        return czy_takie_same(s, wspak(s));
    }

    public static boolean czy_abecadlowe(String s){
        char firstLetter = s.charAt(0);
        for( int i = 1; i < s.length(); i++){
            if(firstLetter > s.charAt(i)) {
                return false;
            }
        }
        return  true;
    }

    public static String rot13(String a){
        String result = "";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) >= 'a' && a.charAt(i) <= 'z') {
                int c = ((a.charAt(i) + 13) % 'z');
                if (c < 'a') {
                    c += 'a' - 1;
                }
                result += (char)(c);
            } else if (a.charAt(i) >= 'A' && a.charAt(i) <= 'Z') {
                int c = ((a.charAt(i) + 13) % 'Z');
                if (c < 'A') {
                    c += 'A' - 1;
                }
                result += (char)(c);
            } else {
                result += a.charAt(i);
            }
        }
        return result;
}

}
