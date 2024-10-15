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
// This is a class (Education) link between Students, Doctors, and Subjects
// هذا الكلاس للربط بين الطالب والدكتور والمواد
package tanzimfx;
import java.sql.Date;
import java.time.LocalDate;

public class Education {
    
    //properties
    private String subjectID;
    private String StudentID;
    private String doctorID;
    private double degree;
    private Date theTeachingYear;

    // Methods
    // counstructor method
    public Education(String subjectID, String StudentID, String doctorID, double degree, Date theTeachingYear) {
        this.subjectID = subjectID;
        this.StudentID = StudentID;
        this.doctorID = doctorID;
        this.degree = degree;
        this.theTeachingYear = theTeachingYear;
    }
    
    // Setter and getter Methods
    // subjectID
    public String getSubjectID() {
        return subjectID;
    }
    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }
    // StudentID
    public String getStudentID() {
        return StudentID;
    }
    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }
    // doctorID
    public String getDoctorID() {
        return doctorID;
    }
    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }
    // degree
    public double getDegree() {
        return degree;
    }
    public void setDegree(double degree) {
        this.degree = degree;
    }
    // theTeachingYear
    public Date getTheTeachingYear() {
        return theTeachingYear;
    }
    public void setTheTeachingYear(Date theTeachingYear) {
        this.theTeachingYear = theTeachingYear;
    }
    
}
