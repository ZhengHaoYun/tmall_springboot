package com.zhy.controller;


import com.zhy.pojo.Property;
import com.zhy.service.PropertyService;
import com.zhy.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
  
@RestController

public class PropertyController {
    @Autowired
    PropertyService propertyService;
 
    @GetMapping("/categories/{cid}/properties")
    public Page4Navigator<Property> list(@PathVariable("cid") int cid, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) {
        start = start<0?0:start;
        return propertyService.list(cid, start, size,5);
    }
     
    @GetMapping("/properties/{id}")
    public Property get(@PathVariable("id") int id) {
        return propertyService.get(id);
    }
     
    @PostMapping("/properties")
    public Object add(@RequestBody Property bean) {
        propertyService.add(bean);
        return bean;
    }
     
    @DeleteMapping("/properties/{id}")
    public String delete(@PathVariable("id") int id)   {
        propertyService.delete(id);
        return null;
    }
     
    @PutMapping("/properties")
    public Property update(@RequestBody Property bean) {
        propertyService.update(bean);
        return bean;
    }
 
}