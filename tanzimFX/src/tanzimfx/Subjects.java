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
    - this class for the subject 
    - student study more tha one subject and one sub studied by more 
    than one student
    - doctor teach more than one sub and one sub teached by more 
    than one teacher
    - هذا كلاس المادة المواد تدرس وتدرس من قبل عدة طلاب وعدة معلمين
    وعدة معلمين وعدة طلاب يدرسو ويدرسو عدة مواد.
*/
package tanzimfx;


public class Subjects extends Person{
    
    // Methods
    // counstructor method
    public Subjects(String id, String name) {
        super(id, name);
    }

    @Override
    // الدلة تقوم بصنع ايدي للمادة بشكل تلقائي
    // غيرمستخدمة حتى الان
    public String generateId() {
        incCounter(); // this fun do increment for counter
        return "3"+getLastUpdataDate() + getCounter();
    }
}
