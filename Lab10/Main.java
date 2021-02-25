import java.util.*;

public class Main {
    public static String getAlphaNumericString(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());

            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }


    public static String[] generateRandomWords(int numberOfWords) {
        String[] randomStrings = new String[numberOfWords];
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[(int) (Math.random() * (20 - 5 + 1) + 5)];
            randomStrings[i] = getAlphaNumericString(word.length);
        }
        return randomStrings;
    }

    public static String[] generateRandomWordsM(int numberOfWords, String[] arr) {
        String[] randomStrings = new String[numberOfWords];
        for (int i = 0; i < numberOfWords; i++) {
            int index = (int) (arr.length * Math.random());
            randomStrings[i] = arr[index];
        }
        return randomStrings;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        System.out.println("Losowanie " + n + " lancuchow.");
        String[] t1 = generateRandomWords(n);
        String[] t2 = generateRandomWordsM(m, t1);
        String[] t3 = generateRandomWords(m);

        ArrayList<String> arrli = new ArrayList<>(n);
        LinkedList<String> ll = new LinkedList<>();
        TreeMap<String, Integer> tree_map = new TreeMap<>();
        HashMap<String, Integer> map = new HashMap<>();

        //wypelnienie
        System.out.println("\nFILL");
        /////ArrayList
        long start = System.nanoTime();
        for (String s : t1) {
            arrli.add(s);
        }
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println("ArrayList(" + (double) (elapsedTime) / 1__000__000 + " ms)");
        /////LinkedList
        long startll = System.nanoTime();
        for (String s : t1) {
            ll.add(s);
        }
        long endll = System.nanoTime();
        long elapsedTimell = endll - startll;
        System.out.println("LinkedList(" + (double) (elapsedTimell) / 1__000__000 + " ms)");

        ///tree_map
        long starttm = System.nanoTime();
        for (int i = 0; i < n; i++) {
            tree_map.put(t1[i], i);
        }
        long endtm = System.nanoTime();
        long elapsedTimetm = endtm - starttm;
        System.out.println("TreeMap(" + (double) (elapsedTimetm) / 1__000__000 + " ms)");

        //HashMap
        long starthm = System.nanoTime();
        for (int i = 0; i < n; i++) {
            map.put(t1[i], i);
        }
        long endhm = System.nanoTime();
        long elapsedTimehm = endhm - starthm;
        System.out.println("HashMap(" + (double) (elapsedTimehm) / 1__000__000 + " ms)");

        System.out.println("Poczatek, rozmiary:"+arrli.size()+", "+ll.size()+", "+tree_map.size()+", "+map.size());
        ///////SEARCH
        System.out.println("\nSEARCH");
        /////ArrayList
        start = System.nanoTime();
        for (String s : arrli) {
            for (String r : t2) {
                s.equals(r);


            }
        }
        end = System.nanoTime();
        elapsedTime = end - start;
        System.out.println("ArrayList(" + (double) (elapsedTime) / 1__000__000 + " ms)");
        /////LinkedList
        startll = System.nanoTime();
        for (String s : ll) {
            for (String r : t2) {
                s.equals(r);
            }
        }
        endll = System.nanoTime();
        elapsedTimell = endll - startll;
        System.out.println("LinkedList(" + (double) (elapsedTimell) / 1__000__000 + " ms)");

        ///tree_map
        starttm = System.nanoTime();
        for (String r : t2) {
            tree_map.containsKey(r);
        }
        endtm = System.nanoTime();
        elapsedTimetm = endtm - starttm;
        System.out.println("TreeMap(" + (double) (elapsedTimetm) / 1__000__000 + " ms)");

        //HashMap
        starthm = System.nanoTime();
        for (String r : t2) {
            map.containsKey(r);
        }
        endhm = System.nanoTime();
        elapsedTimehm = endhm - starthm;
        System.out.println("HashMap(" + (double) (elapsedTimehm) / 1__000__000 + " ms)");


        System.out.println("\nSearchNOT");
        /////ArrayList
        start = System.nanoTime();
        for (String s : arrli) {
            for (String r : t3) {
                s.equals(r);

            }
        }
        end = System.nanoTime();
        elapsedTime = end - start;
        System.out.println("ArrayList(" + (double) (elapsedTime) / 1__000__000 + " ms)");

        /////LinkedList
        startll = System.nanoTime();
        for (String s : ll) {
            for (String r : t3) {
                s.equals(r);
            }
        }
        endll = System.nanoTime();
        elapsedTimell = endll - startll;
        System.out.println("LinkedList(" + (double) (elapsedTimell) / 1__000__000 + " ms)");

        ///tree_map
        starttm = System.nanoTime();
        for (String r : t3) {
            tree_map.containsKey(r);
        }
        endtm = System.nanoTime();
        elapsedTimetm = endtm - starttm;
        System.out.println("TreeMap(" + (double) (elapsedTimetm) / 1__000__000 + " ms)");

        //HashMap
        starthm = System.nanoTime();
        for (String r : t3) {
            map.containsKey(r);
        }
        endhm = System.nanoTime();
        elapsedTimehm = endhm - starthm;
        System.out.println("HashMap(" + (double) (elapsedTimehm) / 1__000__000 + " ms)");

        ////
        /////ArrayList for
        start = System.nanoTime();
        for (int i=0; i<n; i++) {
            arrli.get(i);
        }
        end = System.nanoTime();
        elapsedTime = end - start;
        System.out.println("ArrayList for(" + (double) (elapsedTime) / 1__000__000 + " ms), ");

        /////ArrayList foreach
        start = System.nanoTime();
        for (String s:arrli) {
        }
        end = System.nanoTime();
        elapsedTime = end - start;
        System.out.println("ArrayList for-each(" + (double) (elapsedTime) / 1__000__000 + " ms), ");


        /////ArrayList iter
        start = System.nanoTime();
        Iterator<String> it = arrli.iterator();
        while(it.hasNext()) {
            it.next();
        }
        end = System.nanoTime();
        elapsedTime = end - start;
        System.out.println("ArrayList iterator(" + (double) (elapsedTime) / 1__000__000 + " ms)\n");


       // LinkedList
        /////LinkedList for
        start = System.nanoTime();
        for (int i=0; i<n; i++) {
            ll.get(i);
        }
        end = System.nanoTime();
        elapsedTime = end - start;
        System.out.println("LinkedList for(" + (double) (elapsedTime) / 1__000__000 + " ms), ");

        /////LinkedList foreach
        start = System.nanoTime();
        for (String s:ll) {
        }
        end = System.nanoTime();
        elapsedTime = end - start;
        System.out.println("LinkedList for-each(" + (double) (elapsedTime) / 1__000__000 + " ms), ");


        /////LinkedList iter
        start = System.nanoTime();
        Iterator<String> itll = ll.iterator();
        while(itll.hasNext()) {
            itll.next();
        }
        end = System.nanoTime();
        elapsedTime = end - start;
        System.out.println("LinkedList iterator(" + (double) (elapsedTime) / 1__000__000 + " ms) ");

        System.out.println("\nRemove");
        /////ArrayList
        start = System.nanoTime();
        arrli.clear();
        end = System.nanoTime();
        elapsedTime = end - start;
        System.out.println("ArrayList(" + (double) (elapsedTime) / 1__000__000 + " ms)");

        /////LinkedList
        startll = System.nanoTime();
        ll.clear();
        endll = System.nanoTime();
        elapsedTimell = endll - startll;
        System.out.println("LinkedList(" + (double) (elapsedTimell) / 1__000__000 + " ms)");

        ///tree_map
        starttm = System.nanoTime();
        tree_map.clear();
        endtm = System.nanoTime();
        elapsedTimetm = endtm - starttm;
        System.out.println("TreeMap(" + (double) (elapsedTimetm) / 1__000__000 + " ms)");

        //HashMap
        starthm = System.nanoTime();
        map.clear();
        endhm = System.nanoTime();
        elapsedTimehm = endhm - starthm;
        System.out.println("HashMap(" + (double) (elapsedTimehm) / 1__000__000 + " ms)");


        System.out.println("Koniec, rozmiary:"+arrli.size()+", "+ll.size()+", "+tree_map.size()+", "+map.size());
    }



}
