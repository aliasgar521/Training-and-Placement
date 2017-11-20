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
public class schedule1 {
     private Integer sch_id;
    private String sch_date;
    private Integer criteria;
    private String coname;
    private Integer min_salary;
    private Integer comp_id;
    
    public schedule1(Integer Sch_id,String Sch_date,Integer Comp_id,String company,Integer Criteria,Integer Min_salary){
        this.criteria=Criteria;
        this.min_salary=Min_salary;
        this.sch_date=Sch_date;
        this.sch_id=Sch_id;
        this.comp_id=Comp_id;
        this.coname=company;
    }
    
    public Integer getschid()
    {
        return sch_id;
    }
    public String getschdate()
    {
        return sch_date;
    }
    public String getconame()
    {
        return coname;
    }
    public Integer getminsalary(){
        return min_salary;
    }
    public Integer getcriteria()
    {
        return criteria;
    }
     public Integer getcompid()
    {
        return comp_id;
    }
}
