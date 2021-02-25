/**
 * This is a model class to hold student information and inherit the Man class
 *
 * @author Katia
 */
abstract class Man {
    /**MAn name*/
    private final String name;
    /**Man surname*/
    private final String surname;

    // DOPISAC: Konstruktor
    /** Man constructor
     * @param name Man name
     * @param surname Man surname
     * */
    public Man(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
    // DOPISAC: Metody typu get
    /**
     * Gets the Man name
     * @return a <code> string </code>
     * specifying the name
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the Man surname
     * @return a <code> string </code>
     * specifying the surname
     */
    public String getSurname() {
        return surname;
    }

    // DOPISAC: toString zwracajacy lancuch z imieniem i nazwiskiem
    /** Convert to string
     * @return <code> string </code> representing
     * information about man
     * */
    public String toString(){
        return name + " " + surname;
    }
    /**Abstract method compares Man obj in inherit classes*/
    abstract public Man compare(Man ob);

    /**
     * @return <code>double</code> 0.0
     * */
    public double average() {
        return 0.0;
    }
}



