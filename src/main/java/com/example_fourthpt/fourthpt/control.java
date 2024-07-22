package com.example_fourthpt.fourthpt;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/mm")
public class control {
@Autowired 
service s;
@PostMapping("/no")
public Map getting(@RequestBody pojo p){
   Map data= s.details(p) ; 
   return data;

}
}
