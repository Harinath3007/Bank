package com.omrbranch.pojoclass;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StateList_Output_Pojo {
	private int status;
	    private String message;
	    private ArrayList<Datum> data;

}
