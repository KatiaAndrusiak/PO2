public class StudentWFiIS3 extends Student {
    private StudentUSOS stud;
    StudentWFiIS3(String name, String surname, int id, int year, String l1, double m1, String l2, double m2, String l3, double m3) {
        super(name, surname, id, m1, m2, m3);
        String[]  przedmioty = new String[3];
        przedmioty[0]=l1;
        przedmioty[1]=l2;
        przedmioty[2]=l3;

        stud = new StudentUSOS() {
            @Override
            public double srednia(){
                return average();
            }

            @Override
            public void listaPrzedmiotow() {
                for(int i = 0; i<przedmioty.length; i++) {
                    System.out.println("\t" + (i + 1) + ". " + przedmioty[i] + ": " + getGrade(i) );
                }
            }
            @Override
            public String toString(){
                 return "[" + year + "] ";
            }
        };

    }
    public double srednia() {
        return stud.srednia();
    }

    public void listaPrzedmiotow(){
        stud.listaPrzedmiotow();
    }

    public String toString() {
        return stud.toString() + super.toString();
    }

}

