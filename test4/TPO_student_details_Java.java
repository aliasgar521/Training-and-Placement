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
public class TPO_student_details_Java {
    private Integer stu_id;
    private String username;
    private String name;
    private String acad_year;
    private Integer FE;
    private Integer SE;
    private Integer TE;
    
    
    
    public TPO_student_details_Java(String Name,Integer Stu_id,Integer fe,Integer se,Integer te,String Username,String Acad_year){   //
        this.username=Username;
        this.stu_id=Stu_id;
        this.acad_year=Acad_year;
        this.FE=fe;
        this.SE=se;
        this.TE=te;
        this.name=Name;
    }
    public String getusername(){
        return username;
    }
    public Integer getstu_id()
    {
        return stu_id;
    }
    public Integer getfe()
    {
        return FE;
    }
    public Integer getse()
    {
        return SE;
    }
    public Integer gette()
    {
        return TE;
    }
    public String getname(){
        return name;
    }
    public String getacad_year(){
        return acad_year;
    }
   
    

}

    

