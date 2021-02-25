public class StudentWFiIS1 extends Student implements StudentUSOS {
    private String[] przedmioty;
    private int rok;

    StudentWFiIS1(String name, String surname, int id, int year, String l1, double m1, String l2, double m2, String l3, double m3){
        super(name, surname, id, m1, m2, m3);
        przedmioty = new String[3];
        przedmioty[0]=l1;
        przedmioty[1]=l2;
        przedmioty[2]=l3;
        rok = year;
    }

    @Override
    public double srednia() {
        return super.average();
    }

    @Override
    public void listaPrzedmiotow(){
        for(int i = 0; i<przedmioty.length; i++){
            System.out.println("\t"+ (i+1) + ". " + przedmioty[i] + ": " + super.getGrade(i) );
        }
    }

    @Override
    public String toString() {
        return "[" + rok + "] " + super.toString() ;
    }
}
