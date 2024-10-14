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
// this is the Students class
// هذا كلاس الطالب
package tanzimfx;
import java.time.LocalDate;
import java.util.ArrayList;

public class Students extends Person{
    
    // properties
    private LocalDate birthDate; 
    private ArrayList<Double> grades = new ArrayList<>(); 
    private ArrayList<Generalization> myMsg = new ArrayList<>();
    private ArrayList<Education> myEdcate = new ArrayList<>();
    private double  finalGrades;
    private Documents require;
    private Group inGroup;

    // Methods
    // counstructor method
    public Students(LocalDate birthDate, Documents require, Group inGroup, String id, String name) {
        super(id, name);
        this.birthDate = birthDate;
        this.require = require;
        this.inGroup = inGroup;
    }

    // Setter and getter Methods
    // birthDate
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    // grades
    public ArrayList<Double> getGrades() {
        return grades;
    }
    public void setGrades(ArrayList<Double> grades) {
        this.grades = grades;
    }
    // finalGrades
    public double getFinalGrades() {
        return finalGrades;
    }
    // require
    public Documents getRequire() {
        return require;
    }
    public void setRequire(Documents require) {
        this.require = require;
    }
    // inGroup
    public Group getInGroup() {
        return inGroup;
    }
    public void setInGroup(Group inGroup) {
        this.inGroup = inGroup;
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
    // الدلة تقوم بصنع ايدي للطالب بشكل تلقائي
    // غيرمستخدمة حتى الان
    public String generateId(){
        incCounter(); // this fun do increment for counter
        return "1"+getLastUpdataDate() + getCounter();
    }
    
    // الدالة تقوم بحساب معدل الطالب النهائي
    // this culec the finalGrades for the students
    public double finalGrade(){
        double sum=0;
        for (int i = 0; i < grades.size(); i++) {
            sum += grades.get(i);
        }
        return sum/(grades.size());
    }
    
}
