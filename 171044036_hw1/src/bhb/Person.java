package bhb;


/**
 *
 * Person class keeps the name and surname of employees
 * @author  Baran Hasan BOZDUMAN
 * @version 1.0
 * @since   2020-02-23
 */
public class Person {

    /**
     *
     */
    protected String name;
    protected String surname;
    protected String id;
    /**
     * It constructor of person every person must hava a name and surname
     * @param n takes name for the person
     * @param s takes surname for the person
     */
    public Person(String n, String s) {
        name=n;
        surname=s;
    }
    /**
     * overrided to string method it returns name+whitespace+surname of person
     */
    @Override
    public String toString() {
       // return name+" "+surname;
    	return id;
    }
    public void setName(String n) {
        name=n;
    }
    public void setSurname(String s) {
        surname=s;
    }
}

