public enum Option {
    RESET('O', "Reset planszy", null),
    LEFT('a', "Przesun w lewo", Direction.LEFT),
    RIGHT('d', "Przesun w prawo", Direction.RIGHT),
    UP( 'w', "Przesun w gore", Direction.UP),
    DOWN( 's', "Przesun w dol", Direction.DOWN),
    EXIT('q', "Zakonczenie gry", null);

    private final char znak;
    private final String opis;
    private final Direction kierunek;

    Option(char znak, String opis, Direction kierunek){
        this.znak = znak;
        this.opis = opis;
        this.kierunek = kierunek;
    }

    public char getZnak() { return znak; }
    public Direction getKierunek() { return kierunek; }
    public String getOpis() { return opis; }

    @Override
    public String toString() {
        if( kierunek != null)
            return "'" + znak + "' ==> opcja " + this.name() +
                ", opis: " + opis +
                ", wektor przesuniecia: "+ kierunek +
                " dla " + kierunek.name();
        else {
            return "'" + znak + "' ==> opcja " + this.name() +
                    ", opis: " + opis;
        }
    }
}
