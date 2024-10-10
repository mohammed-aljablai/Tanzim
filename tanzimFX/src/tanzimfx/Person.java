/*
 - This project call tanzim.
 - tanzim: is a project where orgnize the stuednt and the doctor, in addtion
   the emplyee life> from sending msg update degree and more...
 - this project have been worked by:
   - Mohammed Abdullh Al-jablai
   - Gamal Aldeen Al-hakl
   - Youseef Al-asadi
   - abdAlmalik
*/
/*
    - this class is the father for doctor, student, in addtion subjects
    هذا كلاس الاب لكل من الطالب والدكتور والمواد
*/
package tanzimfx;
import java.time.LocalDate;

abstract public class Person implements PersonInterface{
    
    //properties
    private String id ;
    private String name;
    private LocalDate lastUpdataDate = LocalDate.now();
    private static int counter=0;

    // Methods
    // counstructor method
    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // getter methods
    public String getId() { 
        return id;
    }
    public String getName() { 
        return name;
    }
    public LocalDate getLastUpdataDate() {
        return lastUpdataDate;
    }
    public static int getCounter() {
        return counter;
    }
    
    // setter methods
        // set name
    public void setName(String name) {
        this.name = name;
    }
    public static void incCounter() {
        Person.counter++;
    }
    
}
