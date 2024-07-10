package com.omrbranch.pojoclass;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Search_Product_Output {
	private int status;
    private String message;
    private ArrayList<Search_Productin> data;
    private String currency;

}
