package org.com;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class pages {
	   private int page;
	    private int per_page;
	    private int total;
	    private int total_pages;
	    private ArrayList<Dataclass> data;
	    private Support support;
	}

