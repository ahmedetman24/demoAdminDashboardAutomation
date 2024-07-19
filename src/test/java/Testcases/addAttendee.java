package Testcases;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class addAttendee extends testBase{
    static loginPage loginPage;
    static myEventsPage myEventsPage;
    static newEventPage newEventPage;
    static packagesPage packagesPage;
    static addPackagePage addPackagePage;
    static insideEventPage insideEventPage;
    static usersPage usersPage;
    static addUserPage addUserPage;
    static tripInfoPage tripInfoPage;
    static tripDetailsPage tripDetailsPage;
    static userTripPage userTripPage;
    static createdTripPage createdTripPage;

    @Test(dataProvider = "addAttendeeData", dataProviderClass = dataProviderClass.class)
    public static void addValidAttendee(String url, String username, String password, String futureHours) throws InterruptedException {
        //Login
        loginPage = new loginPage();
        loginPage.login(url, username, password, driver, actions, wait);

        //Create a new event
        myEventsPage = new myEventsPage();
        myEventsPage.startEventFromScratch(driver, wait, actions);

        newEventPage = new newEventPage();
        String createdEventName = newEventPage.createNewEvent(wait, driver, Integer.parseInt(futureHours), actions);

        //Open the created Event
        myEventsPage = new myEventsPage();
        myEventsPage.openCreatedEvent(createdEventName, driver, wait);

        //Add Package
        packagesPage = new packagesPage();
        packagesPage.openNewPackagePage(driver, actions);

        addPackagePage = new addPackagePage();
        String packageName = addPackagePage.addPackage(driver, wait, actions);

        insideEventPage = new insideEventPage();
        insideEventPage.openAttendeePage(driver, actions);

        usersPage = new usersPage();
        usersPage.addUser(driver, actions);

        //Add User
        addUserPage = new addUserPage();
        String createdUsername = addUserPage.registerNewUser(driver, wait);

        //Add a trip for the user
        tripInfoPage = new tripInfoPage();
        tripInfoPage.addTrip(driver, wait, actions);

        tripDetailsPage = new tripDetailsPage();
        tripDetailsPage.addTripDetails(driver, wait, actions);

        //User Trip Page
        userTripPage = new userTripPage();
        userTripPage.completeTrip(packageName, driver, wait);

        createdTripPage = new createdTripPage();
        createdTripPage.saveTrip(driver, wait, actions);

        //Check that trip is created
        insideEventPage = new insideEventPage();
        Assert.assertEquals(insideEventPage.checkAttendeeExistence(wait, driver, actions, createdUsername), createdUsername);
    }
}
