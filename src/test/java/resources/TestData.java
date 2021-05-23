package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddAPI;
import pojo.Location;

public class TestData {
	
	public AddAPI addPlacePayload(String name, String language, String address) {
		List<String> list = new ArrayList();
		list.add("shoe park");
		list.add("shop");
		
		Location location = new Location();
		location.setLat(-38.383494);
		location.setLng(33.447362);
		
		AddAPI p = new AddAPI();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("987654321");
		p.setWebsite("https://rahushettyacademy.com");
		p.setName(name);
		p.setTypes(list);
		p.setLocation(location);
		
		return p;
	}
	
	public String deletePayload(String place_id) {
		return "{\r\n    \"place_id\":\""+place_id+"\"\r\n}";
	}
	
	

}
