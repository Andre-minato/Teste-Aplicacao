package tests;

import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjetos.CreateTaskPage;
import pageObjetos.TaskListPage;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;

public class iOSTesting extends DriverFactory{
    CreateTaskPage createTaskPage;
    TaskListPage taskListPage;

    @DataProvider(name = "data")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJsonData
                (
                        System.getProperty("user.dir")+"/data/InputData.json",
                        "Task Data",
                        2
                );

    }

    //iPhone 14 (238BF268-6D76-49A6-9DD4-8978F15BD68C) (Shutdown)
    //iPhone 14 Plus (60C332E0-2264-4859-9B91-C5C20C328EA4) (Shutdown)

    @Test(dataProvider = "data")
    public void test_add_task(String TaskName, String TaskDesc) throws MalformedURLException {
        iOS_setUp();
        taskListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);

        taskListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName(TaskName);
        createTaskPage.enterTaskDesc(TaskDesc);
        createTaskPage.clickSaveBtn();
    }

}

