package org.com;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		File file = new File("C:\\Users\\HARINATH\\eclipse-workspace\\APIProject\\src\\test\\resources\\Employee.json");
		ObjectMapper mapper = new ObjectMapper();
		pages value = mapper.readValue(file, pages.class);
		
        int page = value.getPage();
        System.out.println(page);
        int per_page = value.getPer_page();
        System.out.println(per_page);
        int total = value.getTotal();
        System.out.println(total);
        int total_pages = value.getTotal_pages();
        System.out.println(total_pages);
        ArrayList<Dataclass> data = value.getData();
        for (Dataclass d : data) {
			System.out.println(d.getId());
			System.out.println(d.getFlightName());
			System.out.println(d.getCountry());
			System.out.println(d.getDestinations());
			System.out.println(d.getURL());
		}
       
     Support support = value.getSupport();
     String url = support.getUrl();
        System.out.println(url);
        String text = support.getText();
        System.out.println(text);
	}
}
