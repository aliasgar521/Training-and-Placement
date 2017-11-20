/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test4;
public class Register1 {
    
    private String pid;
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private String gender;
    private String city;
    private String street;
    private String house;
    private Integer pincode;
    
    
    
    public Register1(String PID,String Fname,String Lname,String Email,String Phone,String Gender,String City,String Street)//,String House,Integer Pincode)
    {
        this.pid = PID;
        this.fname = Fname;
        this.lname = Lname;
        this.email = Email;
        
        this.phone = Phone;
        this.gender = Gender;
       // this.pincode=Pincode;
        this.city=City;
        this.street=Street;
       // this.house=House;
    }
    
    public String getpid()
    {
        return pid;
    }

    public String getfname()
    {
        return fname;
    }

    public String getlname()
    {
        return lname;
    }
    public String getemail()
    {
        return email;
    }
    
    public String getphone()
    {
        return phone;
    }
    public String getgender()
    {
        return gender;
    }
    public Integer getpincode()
    {
        return pincode;
    }
    public String getcity()
    {
        return city;
    }
    public String getstreet()
    {
        return street;
    }
    public String gethouse()
    {
        return house;
    }
}