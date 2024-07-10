package org.com;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Writejson {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		File file = new File("C:\\Users\\HARINATH\\eclipse-workspace\\APIProject\\src\\test\\resources\\Index.json");
        ObjectMapper mapper= new ObjectMapper();
        ArrayList<Dataclass>data= new ArrayList<>();
        Dataclass d1 = new Dataclass(3, "AirIndia", "India", "28", "https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
        Dataclass d2 = new Dataclass(33, "AirIndia", "India", "20", "https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
        Dataclass d3 = new Dataclass(36, "Srilankan AriLines", "SriLanka", "56", "https:\\/\\/en.wikipedia.org\\/wiki\\/Sri_Lanka");
        Dataclass d4 = new Dataclass(42, "AirIndia.Raj", "India", "98", "https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
        Dataclass d5 = new Dataclass(49, "AirIndia", "India", "88", "https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
        Dataclass d6 = new Dataclass(59, "AirIndia", "India", "87", "https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
        data.add(d1);
        data.add(d2);
        data.add(d3);
        data.add(d4);
        data.add(d5);
        data.add(d6);
        Support s = new Support("https:\\/\\/omrbranch.com", "For Joining Automation Course, Please Contact-Velmurugan 9944152058");
        
        pages page = new pages(1,6,7544,1288,data,s);
        mapper.writeValue(file, page);
		
		
	}
}

