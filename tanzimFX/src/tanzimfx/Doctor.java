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


public class Doctor extends Person{
    
    // properties
    private int experienceYears;

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

    @Override
    // الدلة تقوم بصنع ايدي للمادة بشكل تلقائي
    // غيرمستخدمة حتى الان
    public String generateId() {
        incCounter(); // this fun do increment for counter
        return "2"+getLastUpdataDate() + getExperienceYears() + getCounter();
    }
    
}
