
public class Main {
    public static void main(String[] args) {

       Stack<String> onp = new Stack(15);

        String input= args[0];
        System.out.println(input);
        try {
            for (int i = 0; i < input.length(); i++) {
                int x = (int)input.charAt(i);
                if ( x >= 97 && x <= 122) {
                    onp.push(Character.toString(input.charAt(i)));
                }
                else if(x=='+' || x =='-' || x=='*'|| x=='/'){
                    String a2 = onp.pop();
                    String a1 = onp.pop();
                    String s="("+ a1 + Character.toString(input.charAt(i)) + a2 + ")";

                    onp.push(s);
                }

            }
            String wynik = onp.pop();
            if(onp.isEmpty()){
                System.out.println("Wynik: "+wynik);
            }else{
                System.out.println("BLAD DANYCH WEJSCIOWYCH! Koniec algorytmu, a stos nie jest pusty: "+ onp+", "+wynik);
            }
        }
        catch (StackOverflowException e){
            System.err.println(e.getMessage());
        }
        catch (StackUnderflowException e){
            System.err.println("BLAD DANYCH WEJSCIOWYCH! Na stosie jest za malo elementow, zeby wykonac operacje!");
        }


    }
}
