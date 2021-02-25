import java.util.Arrays;

/**
 * This is a model class to hold student information and inherit the Man class
 *
 * @author Katia
  */
public class Student  extends Man{
    /** Student id number */
    private final int id;
    /** Array of marks of student */
    private final double[] marks;

    /** Student constructor
     * @param name Student name
     * @param surname Student surname
     * @param id Student id number
     * @param m1 first mark
     * @param m2 second mark
     * @param m3 third mark
     * */
    public Student(String name, String surname, int id, double m1, double m2, double m3) {
        super(name, surname);
        this.id = id;
        marks = new double[]{m1, m2, m3};
    }
    /** Convert to string
     * @return <code> string </code> representing
     * information about student
     * */
    public String toString(){
        return super.toString() + ", id number: " + id + ", grades: " + Arrays.toString(marks);
    }

    /** Counts average value of marks
     * @return <code> double </code>
     * representing average value
     * */
    public double average() {
        return Arrays.stream(marks).average().orElse(Double.NaN);
    }

    /** Compares an average value of student grades
     * @param ob Man
     * @return <code> Man </code> representing
     * Man(could be Student) with higher average
     * */
     public Man compare(Man ob){
        if(ob instanceof Student){
            if(this.average() > ob.average()){
                return this;
            }
            else return ob;
        }
        else return null;

     }

}
