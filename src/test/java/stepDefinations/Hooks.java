package stepDefinations;

import java.io.IOException;
import io.cucumber.java.Before;

public class Hooks {
	
	StepDefination1 sd = new StepDefination1();
	
     @Before("@DeletePlace")
	 public void beforeScenario() throws IOException {
		if(StepDefination1.place_id == null){
		sd.add_place_payload_with("nayak", "Italian", "Italy");
		sd.user_calls_with_post_http_request("AddPlaceAPI", "POST");
		sd.verify_place_id_created_maps_to_using("nayak", "getPlaceAPI");
	   }
	}
}
