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
// this class for Universty group
// هذا الكلاس من أجل التخصصات والمجموعات
// e.g: Computer since -> group1
// كلية العلوم والهندسة علوم حاسوب  المجموعة الاولى مستوى أول
package tanzimfx;


public class Group {
    
    // properties
    private int levelNumber ;
    private String section ;
    private String specialization ;
    private int group ;

    // Methods
    // counstructor method
    public Group(int group, int levelNumber, String section, String specialization) {
        this.group = group;
        this.levelNumber = levelNumber;
        this.section = section;
        this.specialization = specialization;
    }

    // Setter and getter Methods
    // group
    public int getGroup() {
        return group;
    }
    public void setGroup(int group) {
        this.group = group;
    }
    // levelNumber
    public int getLevelNumber() {
        return levelNumber;
    }
    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }
    // section
    public String getSection() {
        return section;
    }
    public void setSection(String section) {
        this.section = section;
    }
    // specialization
    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
