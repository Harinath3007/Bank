package com.omrbranch.pojoclass;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CityList_Output_Pojo {

	private int status;
    private String message;
    private ArrayList<CityList> data;
}
