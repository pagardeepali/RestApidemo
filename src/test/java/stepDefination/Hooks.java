package stepDefination;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {

        StepDefination m = new StepDefination();
        if (StepDefination.place_id == null) {

            m.add_place_payload_with("Deepali", "English", "France");
            m.user_calls_with_http_request("AddPlaceAPI", "POST");
            m.verify_place_Id_created_maps_to_using("Deepali", "getPlaceAPI");


        }

    }
}
