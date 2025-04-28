package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pageObjetos.CreateTaskPage;
import pageObjetos.TaskListPage;
import tests.DriverFactory;

import java.net.MalformedURLException;

public class CreateNewTask extends DriverFactory {
    CreateTaskPage createTaskPage;
    TaskListPage taskListPage;
    @Dado("estou na tela inicial da aplicacao e clico no botao adicionar")
    public void estouNaTelaInicialDaAplicacaoEClicoNoBotaoAdicionar() throws MalformedURLException {
        Android_setUp();
        createTaskPage = new CreateTaskPage(driver);
        taskListPage = new TaskListPage(driver);
        taskListPage.clickAddTaskBtn();
    }

    @E("preencho o nome da Task")
    public void preenchoONomeDaTask() {
        createTaskPage.enterTaskName("1º Task");
    }

    @E("preencho uma descricao")
    public void preenchoUmaDescricao() {
        createTaskPage.enterTaskDesc("Primerira taska adicionada");
    }

    @Quando("clico no botao salvar")
    public void clicoNoBotaoSalvar() {
        createTaskPage.clickSaveBtn();
    }

    @Entao("a Task deve ser adicioada com sucesso")
    public void aTaskDeveSerAdicioadaComSucesso() {
        driver.hideKeyboard();
        tearDown();
    }
}
