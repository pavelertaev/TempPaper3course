package com.example.temppaper3course.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SockStore {
    private Sock sock;
    @Min(1) private int quantity;

    private void setQuantity(){
        if(quantity>0){
            this.quantity = quantity;
        }else {
            throw new IllegalArgumentException("Колличество носков не может быть меньше нуля");
        }
    }
}
