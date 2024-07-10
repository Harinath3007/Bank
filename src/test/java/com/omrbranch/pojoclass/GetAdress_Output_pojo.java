package com.omrbranch.pojoclass;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAdress_Output_pojo {
	public int status;
    public String message;
    public ArrayList<Getclass> data;

}
