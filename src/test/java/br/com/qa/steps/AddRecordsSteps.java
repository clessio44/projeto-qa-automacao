package br.com.qa.steps;

import org.openqa.selenium.WebDriver;

import br.com.qa.pages.AddRecordsPage;
import br.com.qa.utils.DriverClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AddRecordsSteps {

	private WebDriver driver;
	
	AddRecordsPage add;
	DriverClass dr = new DriverClass();
	
	@Before()
    public void beforeScenario() throws InterruptedException{
		System.out.println("Iniciando...");
		System.out.println();
		
    }	
	
	@After
    public void afterScenario(){
        System.out.println("Finalizando...");
        dr.closeDriver();
    }

	@Dado("que acesso o sistema")
	public void que_acesso_o_sistema() throws Exception {
		driver = dr.initDriver("https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap");
		add = new AddRecordsPage(driver);
		add.acionandoSelectV4Theme();
		add.addRecord();
	}

	@Quando("realizo o cadastro")
	public void realizo_o_cadastro() throws Exception {
		add = new AddRecordsPage(driver);
		add.customerName();
		add.contactLastName();
		add.contacFirstName();
		add.phone();
		add.addressLineOne();
		add.addressLineTwo();
		add.city();
		add.state();
		add.postalCode();
		add.country();
		add.salesRepEmployeeNumber();
		add.creditLimit();
		add.botaoSave();
	}

	@Então("valido a finalizacao do teste")
	public void valido_a_finalizacao_do_teste() throws Exception {
		add.msgReportSuccess();
	}

	// tag2

	@E("que realizei a primeira etapa de cadastro")
	public void que_realizei_a_primeira_etapa_de_cadastro() throws Exception {
		add = new AddRecordsPage(driver);
		add.customerName();
		add.contactLastName();
		add.contacFirstName();
		add.phone();
		add.addressLineOne();
		add.addressLineTwo();
		add.city();
		add.state();
		add.postalCode();
		add.country();
		add.salesRepEmployeeNumber();
		add.creditLimit();
		add.botaoSave();
		add.msgReportSuccess();
	}

	@Quando("realizo o retorno com botao")
	public void realizo_o_retorno_com_botao() throws Exception {
		add.botaoSaveAndGoBack();
		add.cmpSearchCustomerName();
		add.clickCheckBox();
		add.delete();
		add.validarPopUp();
		add.deletePopUp();

	}

	@Então("valido a mensagem final")
	public void valido_a_mensagem_final() throws Exception {
		add.validarMsgFinalDeleted();	
	}

}
