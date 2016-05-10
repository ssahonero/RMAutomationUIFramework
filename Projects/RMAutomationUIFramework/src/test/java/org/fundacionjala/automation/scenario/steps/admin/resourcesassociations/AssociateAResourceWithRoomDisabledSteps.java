package org.fundacionjala.automation.scenario.steps.admin.resourcesassociations;

import org.fundacionjala.automation.framework.pages.admin.conferencerooms.ConferenceRoomsPage;
import org.fundacionjala.automation.framework.pages.admin.conferencerooms.RoomsResourceAssociationsPage;
import org.fundacionjala.automation.framework.utils.api.managers.ResourceAPIManager;
import org.fundacionjala.automation.framework.utils.api.objects.admin.Resource;
import org.testng.Assert;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AssociateAResourceWithRoomDisabledSteps {
	private ConferenceRoomsPage conferenceRoom;
	private RoomsResourceAssociationsPage resourceAssociations;
	private String roomToModify;
	private Resource resourceToAssociate;
	private String resourceName;

	
	@Before("@num#5")
	public void beforeScenario() throws Throwable {

		conferenceRoom = new ConferenceRoomsPage();
		resourceToAssociate = ResourceAPIManager.postRequest("http://172.20.208.84:4040/resources"
                , new Resource("keyf", "keyf", "fa fa-key", "", "Key"));

        resourceName = resourceToAssociate.customName;
        roomToModify = "Room003";
	}

	@Given("^I have a resource associated$")
	public void i_have_a_resource_associated() throws Throwable {
		conferenceRoom
					.openConfigurationPage(roomToModify)
					.clickOnResourceAssociations()
					.addResource(resourceName)
					.clickOnSave();
	}
	
	@When("^I disable the room$")
	public void i_disable_the_room() throws Throwable {
	    conferenceRoom.disableRoom(roomToModify);
	}

	@When("^when I open the pop-up configuration of the room disabled$")
	public void when_I_open_the_pop_up_configuration_of_the_room_disabled() throws Throwable {
		resourceAssociations = 
				            conferenceRoom
							.openConfigurationPage(roomToModify)
							.clickOnResourceAssociations();
	}

	@Then("^I see the resource associated in Associated column$")
	public void i_see_the_resource_associated_in_Associated_column() throws Throwable {
		
	   Assert.assertTrue(resourceAssociations.isInAssociatedColumn(resourceName),
			                                  "the resource should be in resource column");
	   
	}
	@After("@num#5")
	public void afterScenario() throws Throwable {
		ResourceAPIManager.deleteRequest("http://172.20.208.84:4040/resources", resourceToAssociate._id);
	}
	
}
