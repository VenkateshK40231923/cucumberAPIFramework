package resources;

import java.util.ArrayList;
import java.util.List;
import pojo.Location;
import pojo.mainSystemTwo;

public class TestDataBuild {

	public mainSystemTwo addPlacePayload(String name, String language, String address) {
		
		mainSystemTwo obj1 = new mainSystemTwo();
		
		obj1.setAccuracy(50);
		obj1.setAddress(address);
		obj1.setLanguage(language);
		obj1.setName(name);
		obj1.setPhone_number("5146383528");
		List<String> mylist = new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");
		obj1.setTypes(mylist);
		obj1.setWebsite("www.google.com");
		
		Location l = new Location();
		l.setLng(-54.55465);
		l.setLat(45.21532);
		
		obj1.setLocation(l);
		
		return obj1;
	}
	
	public String deletePlacePayload(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}
}
