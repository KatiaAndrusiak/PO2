import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static String[] splitArgs(String arg){
        return Arrays.stream(arg.split("[\\s+(),]")).filter(w -> w.isEmpty() == false).toArray(String[]::new);
    }
    public static void main(String[] args) {
        try {
            String[] splitted;
            splitted = splitArgs(args[0]);
            try {
                if (splitted.length > 3 || splitted.length < 2)
                    throw new Exception("Zla liczba argumentow funkcji! Podaj jedna lub dwie liczby.");
                Class m = Math.class;
                Object obj = null;
                if (splitted.length == 3) {
                    Method mt = m.getMethod(splitted[0], Double.TYPE, Double.TYPE);
                    System.out.println(args[0] + "\nWynik:" + mt.invoke(obj, Double.parseDouble(splitted[1]), Double.parseDouble(splitted[2])).toString());
                } else if (splitted.length == 2) {
                    Method mt = m.getMethod(splitted[0], Double.TYPE);
                    System.out.println(args[0] + "\nWynik:" + mt.invoke(obj, Double.parseDouble(splitted[1])).toString());
                }
            } catch (NoSuchMethodException e) {
                System.err.println("Nie ma takiej metody!");
            } catch (NumberFormatException e) {
                System.err.println("Argumenty funkcji musza byc liczbami!");
            } catch (Exception e) {
                    System.err.println(e.getMessage());
            }
        }
        catch (Exception e){
            System.err.println("Nie podano nic do obliczenia.");
        }
    }
}
