/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tanzimfx;

/**
 *
 * @author Mohammed Al-jabalai
 */
public class Group {
    
    
    
    private int levelNumber ;
    private String section ;
    private String specialization ;
    private int group ;

    public Group(int group, int levelNumber, String section, String specialization) {
        this.group = group;
        this.levelNumber = levelNumber;
        this.section = section;
        this.specialization = specialization;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
