package tanzimfx;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Mohammed Al-jabalai
 */
public class Students extends Person{
    
    private LocalDate birthDate; 
    private ArrayList<Double> grades = new ArrayList<Double>(); 
    private double  finalGrades;
    private Documents require;
    private Group inGroup;

    public Students(LocalDate birthDate, Documents require, Group inGroup, String id, String name) {
        super(id, name);
        this.birthDate = birthDate;
        this.require = require;
        this.inGroup = inGroup;
    }

    
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Double> grades) {
        this.grades = grades;
    }

    public double getFinalGrades() {
        return finalGrades;
    }

    public Documents getRequire() {
        return require;
    }

    public void setRequire(Documents require) {
        this.require = require;
    }

    public Group getInGroup() {
        return inGroup;
    }

    public void setInGroup(Group inGroup) {
        this.inGroup = inGroup;
    }
    
    @Override
    public String generateId(){
        incCounter();
        return "1"+getLastUpdataDate() + getCounter();
    }
    
    
    public double finalGrade(){
        double sum=0;
        for (int i = 0; i < grades.size(); i++) {
            sum += grades.get(i);
        }
        return sum/(grades.size());
    }
    
}
