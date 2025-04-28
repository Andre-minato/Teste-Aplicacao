package tests;

import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjetos.CreateTaskPage;
import pageObjetos.TaskListPage;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;

public class AndroidTesting extends DriverFactory {

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

    @Test(dataProvider = "data")
    public void test_add_task(String TaskName, String TaskDesc) throws MalformedURLException {
        DriverFactory.Android_setUp();
        taskListPage = new TaskListPage(DriverFactory.driver);
        createTaskPage = new CreateTaskPage(DriverFactory.driver);

        taskListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName(TaskName);
        createTaskPage.enterTaskDesc(TaskDesc);
        createTaskPage.clickSaveBtn();
        DriverFactory.driver.hideKeyboard();
    }
}
