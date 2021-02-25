public class StudentWFiIS2 implements StudentUSOS {
    private String[] przedmioty;
    private int rok;
    private Student stud;

    StudentWFiIS2(String name, String surname, int id, int year, String l1, double m1, String l2, double m2, String l3, double m3){
        stud = new Student(name, surname, id, m1, m2, m3);
        przedmioty = new String[3];
        przedmioty[0]=l1;
        przedmioty[1]=l2;
        przedmioty[2]=l3;
        rok = year;
    }
    @Override
    public double srednia() {
        return stud.average();
    }

    @Override
    public void listaPrzedmiotow(){
        for(int i = 0; i<przedmioty.length; i++){
            System.out.println("\t"+ (i+1) + ". " + przedmioty[i] + ": " + stud.getGrade(i) );
        }
    }

    @Override
    public String toString() {
        return "[" + rok + "] " + stud.toString() ;
    }
}
