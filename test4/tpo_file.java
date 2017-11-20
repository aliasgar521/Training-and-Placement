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
public class tpo_file {
    private Integer tpo_id;
    private String username;
    
    public tpo_file(String Username,Integer TPO_id){
        this.username=Username;
        this.tpo_id=TPO_id;
    }
    public String getusername(){
        return username;
    }
    public Integer gettpo_id()
    {
        return tpo_id;
    }
}
