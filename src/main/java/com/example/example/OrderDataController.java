package com.example.example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/orderform")


public class OrderDataController {

    @Autowired
    private OrderRepository example;

    @PostMapping
    public OrderDataModel SubmitOrderDataModel(@RequestBody OrderDataModel Data  ) {
        return example.save(Data);
    }

    @GetMapping
    public List<OrderDataModel> getAllOrderForms(){
        return example.findAll();
    }
    @GetMapping("/{id}")
    public Optional<OrderDataModel> getOrderDataByID(@PathVariable String id){
        return example.findById(id);
    }
    
    @PutMapping("/{id}")
    public OrderDataModel updateSingleField(@PathVariable String id, @RequestBody OrderDataModel updatedData){
        return example.findById(id).map(existingData -> {
            if(updatedData.getCity() !=null){
                existingData.setCity(updatedData.getCity()) ;
            }
            if(updatedData.getState() !=null){
                existingData.setState(updatedData.getState());
            }
            return example.save(existingData);
        })
        .orElseThrow(() -> new RuntimeException("Data not found with id"+id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrderDataId(@PathVariable String id){
        example.deleteById(id);
        return ResponseEntity.ok("Form data deleted successfully with id:"+id);

    }
    @DeleteMapping
    public String deleteORderData(){
        example.deleteAll();
        return "successfully deleted";
        

    }    


}
    
    
    

