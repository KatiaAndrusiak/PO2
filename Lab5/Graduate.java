/**
 * This is a model class to hold graduate information and inherit the Student class
 *
 * @author Katia
 */
public class Graduate extends Student {
    /**Graduate scientific degree */
    private final String degree;
    /**last year of Graduate study*/
    private final int year;
    /** Graduate constructor
     * @param degree Graduate degree
     * @param name Graduate name
     * @param surname Graduate surname
     * @param id Graduate id number
     * @param year last year of study
     * @param m1 first mark
     * @param m2 second mark
     * @param m3 third mark
     * */
    public Graduate(String degree, String name, String surname, int id, int year, double m1, double m2, double m3){
        super(name, surname,id, m1, m2, m3);
        this.degree = degree;
        this.year = year;
    }
    /** Convert to string
     * @return <code> string </code> representing
     * information about graduate
     * */
    public String toString(){
        return degree + " " + super.toString() + ", year of graduation: " + year;
    }
}
