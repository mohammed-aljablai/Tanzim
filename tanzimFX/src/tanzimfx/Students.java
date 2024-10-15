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
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Students extends Person{
    
    // properties
    private Date birthDate; 
    private Documents require;
    private Group inGroup;
    private double  finalGrades;
    private ArrayList<Double> grades = new ArrayList<>(); 
    private ArrayList<Generalization> myMsg = new ArrayList<>();
    private ArrayList<Education> myEdcate = new ArrayList<>();

    // Methods
    // counstructor method
    public Students(Date birthDate, Documents require, Group inGroup, String id, String name) {
        super(id, name);
        this.birthDate = birthDate;
        this.require = require;
        this.inGroup = inGroup;
    }

    // Setter and getter Methods
    // birthDate
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    // grades
    public ArrayList<Double> getGrades() {
        return grades;
    }
    public void setGrades(Double grades) {
        this.grades.add(grades);
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
    public void setMyMsg(String groupID, String doctorId, Date sendDate, String content) {
        this.myMsg.add(new Generalization(groupID, doctorId,sendDate, content));
    }
    // my edcuation
    public ArrayList<Education> getMyEdcate() {
        return myEdcate;
    }

    public void setMyEdcate
        (String subjectID, String StudentID, String doctorID, double degree, Date theTeachingYear) {
        this.myEdcate.add(new Education(subjectID, StudentID, doctorID, degree, theTeachingYear));
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
