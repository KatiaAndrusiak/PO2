public class Board {

    private final int nx;
    private final int ny;
    private final double p;
    private int curX;
    private int curY;
    private final int finishX;
    private final int finishY;
    CheckStep check = (char[][] board, int i0, int j0, Direction dir)
            -> (board[i0 + dir.getX()][j0 + dir.getY()] == 'x');

    public char[][] board;

     Board(int nx, int ny, double p){
         this.nx = nx;
         this.ny = ny;
         this.p = p;
         board = new char [nx][ny];
         this.curX = nx-2;
         this.curY = 1;
         this.finishY = ny/2;
         this.finishX = 0;
     }

     public void fillBoard(){
         for( int i =0; i < nx; i ++){
             for( int j = 0; j < ny; j++){
                 board[i][j] = 'x';
             }
         }

         board[finishX][finishY] = '*';

         int counter = 0;
         while(counter != ((int)(nx*ny*p) + 1)) {
             int rx = (int)(Math.random() * ((nx - 1) + 1) + 0);
             int ry = (int)(Math.random() * ((ny - 1) + 1) + 0);
             board[rx][ry] = '_';
             counter++;
         }
         board[curX][curY] = 'o';
     }

    public void printBoard(){
         for (int i = 0; i < nx; i++) {
             for (int j = 0; j < ny; j++) {
                 System.out.print(board[i][j] + " ");
             }
             System.out.println();
         }

    }

    public void makeStep(Direction dir) throws WallException {
             if(!check.test(board, curX, curY, dir) ) {
                 board[curX][curY] = ' ';
                 curX += dir.getX();
                 curY += dir.getY();
                 board[curX][curY] = 'o';
             }
             else {
                 throw new WallException("NIE UDALO SIE WYKONAC TAKIEGO RUCHU.");
             }
    }

    public void resetBoard(){
        curX = nx-2;
        curY = 1;
        this.fillBoard();
    }
    public boolean checkWin() {
        return board[curX][curY] == board[finishX][finishY];
    }

    public boolean firstStepCheck(){
        return (board[curX][curY+1] == 'x'
                && board[curX-1][curY] == 'x'
                && board[curX][curY-1] == 'x'
                && board[curX+1][curY] == 'x');
    }

}
