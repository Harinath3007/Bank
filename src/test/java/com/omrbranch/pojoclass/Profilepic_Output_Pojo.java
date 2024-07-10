package com.omrbranch.pojoclass;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Profilepic_Output_Pojo {
	 private int status;
	    private String message;
	    private Profilepic_Pojo data;
	    private int cart_count;

}
