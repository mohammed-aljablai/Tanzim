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
    - this doctor class
*/
package tanzimfx;
import java.util.ArrayList;

public class Doctor extends Person{
    
    // properties
    private int experienceYears;
    private ArrayList<Generalization> myMsg = new ArrayList<>();
    private ArrayList<Education> myEdcate = new ArrayList<>();

    // Methods
    // counstructor method
    public Doctor(int experienceYears, String id, String name) {
        super(id, name);
        this.experienceYears = experienceYears;
    }

    // Setter and getter Methods
    // experienceYears
    public int getExperienceYears() {
        return experienceYears;
    }
    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }
    // my masseges (Latest news)
    public ArrayList<Generalization> getMyMsg() {
        return myMsg;
    }
    public void setMyMsg(ArrayList<Generalization> myMsg) {
        this.myMsg = myMsg;
    }
    // my edcuation
    public ArrayList<Education> getMyEdcate() {
        return myEdcate;
    }
    public void setMyEdcate(ArrayList<Education> myEdcate) {
        this.myEdcate = myEdcate;
    }

    @Override
    // الدلة تقوم بصنع ايدي للمادة بشكل تلقائي
    // غيرمستخدمة حتى الان
    public String generateId() {
        incCounter(); // this fun do increment for counter
        return "2"+getLastUpdataDate() + getExperienceYears() + getCounter();
    }
    
}
