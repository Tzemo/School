package generatestudents;

/**
 * Student consists in this example only of an ldap and the amount of ects
 * earned.
 *
 * @author breud
 */
public class Student {

    private final String ldap;
    private final int ects;
    private int hash;

    public Student(String ldap, int ects) {
        this.ldap = ldap;
        this.ects = ects;
    }

    public String getLdap() {
        return ldap;
    }

    public int getEcts() {
        return ects;
    }

    @Override
    public int hashCode() {

        hash = 13;
   
        for (int i = 0; i < ldap.length(); i++) {
            hash = (hash * 37 + ldap.charAt(i)) * hash ;
        }
        
        return hash;
       
    }

    /**
     * Converts the student to a string.
     *
     * @return the converted student
     */
    @Override
    public String toString() {
        return "Student{" + "ldap=" + ldap + ", ects=" + ects + '}';
    }
}
