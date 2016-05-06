package org.fundacionjala.automation.framework.maps.tablet.settings;

public class NavigationMap {

	public static final String DEFAULT_ROOM_TOGGLE_BUTTON = "//button[@class='btn btn-default'][@type='button'][@ng-click='toggleRoomSelectionPanel()']";
	public static final String SAVE_BUTTON = "//span[text()='Save']/parent::button[@class='clean item item-btn'][@ng-click='saveNavigationSettings()']";
	public static final String ROOMS_LIST = "//div[2]/div/div/div[3]/div[2]/form/div/div/div/div[1]/div[3]/div[2]/ul";
	public static final String ROOMS_LIST_ELEMENT = "li";
	public static final String ROOM_NAME = "strong";
}
