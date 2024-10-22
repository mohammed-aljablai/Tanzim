/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tanzimfx;

/**
 *
 * @author Administrator
 */
public class SharedData {
  private static SharedData instance;
  private int id;
  private int exYreas;
  private String name;
  
  private SharedData(){}
  
  public static SharedData getInstance(){
    if(instance == null)
      instance = new SharedData();
    return instance;
  }

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getExYreas() {
    return exYreas;
  }
  public void setExYreas(int exYreas) {
    this.exYreas = exYreas;
  }
  
  
}
