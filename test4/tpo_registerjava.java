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
public class tpo_registerjava {
    private String tpo_id;
    private String designation;
    private String salary;
    
    public tpo_registerjava(String TPOID,String Desig,String Sal)
    {
        this.designation = Desig;
        this.salary = Sal;
        this.tpo_id = TPOID;
    }
    
    public String getId()
    {
        return tpo_id;
    }
    public String getSal()
    {
        return salary;
    }
    public String getDesig()
    {
        return designation;
    }
    
}
