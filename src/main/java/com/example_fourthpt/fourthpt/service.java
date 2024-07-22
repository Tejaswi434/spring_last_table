package com.example_fourthpt.fourthpt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class service {
 @Autowired
 JdbcTemplate jd; 


 public Map details(pojo p){ 
    Map <String,Object> n = new HashMap<> ();
          String str= "select * from project where pid=?" ;
 
    List<Map <String,Object>> data= (jd.queryForList(str,p.getProjid()));

    for(Map mp : data) {
        n.put("pid",mp.get("pid"));
        n.put(  "pname",mp.get(  "pname"));
        n.put(  "client",mp.get(  "client"));
        n.put("projmanager",mp.get("projmanager"));
        n.put("startdate" ,mp.get("startdate"));
        n.put("enddate",mp.get("enddate"));
        n.put("employeeCount",mp.get("employecount"));
  //System.out.print(n); 
    }
    
    String str_2= "select emp_id from project_2 where pid=?" ;
    ///empty list to store emploeedetails
    List<Map <String,Object>> employeedata= new ArrayList <>();
    List<Map <String,Object>> data_2= (jd.queryForList(str_2,p.getProjid()));
    for(Map mp_2 : data_2){
        System.out.print(mp_2);
    String str_3= "select * from Employee_table where EmployeeID=?" ;
    List<Map <String,Object>> dat_3 =jd.queryForList(str_3,mp_2.get("emp_id")) ;
    for(Map ma :dat_3){
        employeedata.add(ma);
    }
    } 
    System.out.print(employeedata);
    n.put("Employees_details" ,employeedata);
    System.out.print(n);
    return n;
}  
}
