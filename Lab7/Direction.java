public enum Direction {
    LEFT (-1,0),
    RIGHT(1, 0),
    UP   (0, 1),
    DOWN (0,-1);

    private final int x;
    private final int y;

    Direction(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){  return -y; }
    public int getY(){  return x; }

    @Override
    public String toString() {
        return "[" + x + ", " + y + ']';
    }
}
