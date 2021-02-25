/**
 * This is a model class to hold dean information and inherit the Man class
 *
 * @author Katia
 */
public class Dean extends Man{
    /**Dean scientific degree */
    private final String degree;
    /**first year as a dean*/
    private final int fromYear;
    /**last year as a dean*/
    private final int toYear;

    /** Dean constructor
     * @param degree Dean scientific degree
     * @param name Dean name
     * @param surname Dean surname
     * @param fromYear first year as a dean
     * @param toYear last year as a dean
     * */
    public Dean(String degree, String name, String surname, int fromYear, int toYear){
        super(name, surname);
        this.degree = degree;
        this.fromYear = fromYear;
        this.toYear = toYear;
    }

    /** Convert to string
     * @return <code> string </code> representing
     * information about dean
     * */
    public String toString(){
        return degree + " " + super.toString() + ", Dean of the Faculty from "+ fromYear + " to " + toYear + ".";
    }

    /**Overrides method in Man
     * Informs that average not applicable for Dean class
     * @return <code>double</code> 0.0
     * */
    public double average() {
        System.out.print("  [Average not applicable]");
        return 0.0;
    }
    /** Compares the last year of dean post
     * @param ob Man
     * @return <code> Man </code> representing
     * Man(could be Dean) whose last year is closer
     * */
    public Man compare(Man ob){
        if(ob instanceof Student){
            return  ob.compare(this);
        }
        else if(ob instanceof Dean){
            if(this.toYear > ((Dean) ob).toYear){
                return this;
            }
            else return ob;
        }
        else
            return null;
    }
}
