/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test4;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 *
 * @author ali
 */
public class company1 {
     private Integer comp_id;
    private String co_name;
    private String type;
    
    public company1(Integer Comp_id,String Co_name,String Type){
            this.comp_id=Comp_id;
            this.co_name=Co_name;
            this.type=Type;
    }
    
     public Integer getcompid()
    {
        return comp_id;
    }

    public String getcompname()
    {
        return co_name;
    }

    public String gettype()
    {
        return type;
    }
}
