/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test4;

/**
 *
 * @author ali
 */

public class alumni_java {
    private Integer cand_id;
    private Integer stID;
    private String company;
    private String designation;
    private String pack;
    private Integer sch_id;
    private String name;
    
public alumni_java(Integer c_id,String fname,String comp,String des,String packa,Integer sc_id,Integer stuID){
    this.cand_id=c_id;
    this.company=comp;
    this.stID=stuID;
    this.designation=des;
    this.pack=packa;
    this.sch_id=sc_id;
    this.name=fname;
    
}
public Integer getID(){
    return cand_id;
}
public String getname(){
    return name;
}
public Integer getstid(){
    return stID;
}
public String getcomp(){
    return company;
}
public String getdes(){
    return designation;
}
public String getpack(){
    return pack;
}
public Integer getscID(){
    return sch_id;
}
}
