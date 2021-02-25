import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int nx;
        int ny;
        double p;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Podaj ilość wierszy: ");
            try {
                int x = scanner.nextInt();
                if (x > 1) {
                    nx = x;
                    break;
                } else {
                    throw new ArithmeticException("Zbyt mala wartosc nx!");
                }
            }
            catch (InputMismatchException e){
                System.err.println("Podaj liczbe calkowita!");
                scanner.nextLine();
            }
            catch(Exception e){
                System.err.println( e.getMessage() );
            }
        }

        while(true) {
            System.out.println("Podaj ilość column: ");
            try {
                int y = scanner.nextInt();
                if (y > 1) {
                    ny = y;
                    break;
                } else {
                    throw new ArithmeticException("Zbyt mala wartosc ny!");
                }
            }
            catch (InputMismatchException e){
                System.err.println("Podaj liczbe calkowita!");
                scanner.nextLine();
            }
            catch(Exception e){
                System.err.println( e.getMessage() );
            }
        }

        while(true) {
            System.out.println("Podaj prawdopodobienstwo z zakresu [0.15,0.95]");
            try {
                double pr = scanner.nextDouble();
                if (pr <= 0.95 && pr >= 0.15) {
                    p = pr;
                    break;
                } else {
                    throw new ArithmeticException("Podaj liczbe z zakresu  [0.15,0.95]!");
                }
            }
            catch (InputMismatchException e){
                System.err.println("Podaj liczbe double!");
                scanner.nextLine();
            }
            catch(Exception e){
                System.err.println( e.getMessage() );
            }
        }


        Board gameBoard = new Board(nx, ny, p);
        gameBoard.fillBoard();

        while (true){
            if(gameBoard.firstStepCheck()) {
                gameBoard.fillBoard();
            }
            else{
                break;
            }
        }
        boolean game = true;

        System.out.println(
                "Dostepne opcje:\n" +
                        Option.RESET + "\n" +
                        Option.LEFT + "\n" +
                        Option.RIGHT+ "\n" +
                        Option.UP + "\n" +
                        Option.DOWN + "\n" +
                        Option.EXIT + "\n");

        boolean play = true;
        while(game){
            System.out.println("Start!!!");

            while (play) {
                gameBoard.printBoard();
                System.out.println("Wybierz opcje:");
                try {
                    char tz = scanner.next().charAt(0);
                    switch (tz) {
                        case 'O':
                            System.out.println(Option.RESET.getOpis());
                            gameBoard.resetBoard();
                            break;
                        case 'a':
                            System.out.println(Option.LEFT.getOpis());
                            gameBoard.makeStep(Direction.LEFT);
                            break;
                        case 'd':
                            System.out.println(Option.RIGHT.getOpis());
                            gameBoard.makeStep(Direction.RIGHT);

                            break;
                        case 'w':
                            System.out.println(Option.UP.getOpis());
                            gameBoard.makeStep(Direction.UP);

                            break;
                        case 's':
                            System.out.println(Option.DOWN.getOpis());
                            gameBoard.makeStep(Direction.DOWN);
                            break;
                        case 'q':
                            System.out.println(Option.EXIT.getOpis());
                            game = false;
                            play = false;
                            break;
                        default:
                            throw new OptionNotRecognizedException("Nie ma takiej opcji!");
                    }
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.err.println("To nie jest wyjscie, szukaj '*'!");
                }
                catch (Exception e){
                    System.err.println( e.getMessage() );
                }

                if(gameBoard.checkWin()){
                    System.out.println("GRATULACJE, WYGRALES!");
                    gameBoard.printBoard();
                    play = false;
                }
            }

            while(true) {
                System.out.println("Chcesz skonczyc? ('t' - tak or 'n' - nie)");
                char q = scanner.next().charAt(0);
                try {
                    if (q == 'n') {
                        play = true;
                        break;
                    } else if (q == 't') {
                        game = false;
                        break;
                    } else
                        throw new OptionNotRecognizedException("Nie ma takiej opcji!");
                }
                catch (Exception e){
                    System.err.println( e.getMessage() );
                }

            }
        }
        scanner.close();
    }
}
