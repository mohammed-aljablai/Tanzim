/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tanzimfx;

import java.time.LocalDate;

/**
 *
 * @author Mohammed Al-jabalai
 */
abstract public class Person implements PersonInterface{

    private String id ;
    private String name;
    private LocalDate lastUpdataDate = LocalDate.now();
    private static int counter=0;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // getter methods
    public String getId() { return id;}
    public String getName() { return name;}

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
