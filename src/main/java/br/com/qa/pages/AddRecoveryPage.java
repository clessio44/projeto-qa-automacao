package br.com.qa.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.qa.utils.BasePage;

public class AddRecoveryPage {

	public AddRecoveryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	private WebDriver driver;

	BasePage base = new BasePage(driver);

	public void acionandoSelectV4Theme() throws Exception {
		// v4Theme
		WebElement select = driver.findElement(By.id("switch-version-select"));
		Select sel = new Select(select);
		sel.selectByVisibleText("Bootstrap V4 Theme");
		BasePage base = new BasePage(driver);
		base.takeScreenShot("V4 Theme");
	}

	public void addRecord() {
		// addRecord
		WebElement btnRecord = (new WebDriverWait(driver, 3))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='floatL t5']")));
		if (btnRecord.isDisplayed()) {
			btnRecord.click();
			System.out.println("btn Add Record acionado...");
		}
	}

	public void customerName() throws Exception {
		// customerName
		BasePage base = new BasePage(driver);
		base.localizarEPreencherElementoViaId("field-customerName", base.lerDadosNoExcel(1, 0, "ProjetoUm"));
		base.takeScreenShot("CustomerName");
	}

	public void contactLastName() throws Exception {
		// contactLastName
		BasePage base = new BasePage(driver);
		base.localizarEPreencherElementoViaId("field-contactLastName", base.lerDadosNoExcel(1, 1, "ProjetoUm"));
		base.takeScreenShot("contactLastName");
	}

	public void contacFirstName() throws Exception {
		// contactFirstName
		BasePage base = new BasePage(driver);
		base.localizarEPreencherElementoViaId("field-contactFirstName", base.lerDadosNoExcel(1, 2, "ProjetoUm"));
		base.takeScreenShot("contactFirstName");
	}

	public void phone() throws Exception {
		// phone
		BasePage base = new BasePage(driver);
		base.localizarEPreencherElementoViaId("field-phone", base.lerDadosNoExcel(1, 3, "ProjetoUm"));
		base.takeScreenShot("Phone");
	}

	public void addressLineOne() throws Exception {
		// addressLineOne
		BasePage base = new BasePage(driver);
		base.localizarEPreencherElementoViaId("field-addressLine1", base.lerDadosNoExcel(1, 4, "ProjetoUm"));
		base.takeScreenShot("addressLineOne");
	}

	public void addressLineTwo() throws Exception {
		// addressLineTwo
		BasePage base = new BasePage(driver);
		base.localizarEPreencherElementoViaId("field-addressLine2", base.lerDadosNoExcel(1, 5, "ProjetoUm"));
		base.takeScreenShot("addressLineTwo");
	}

	public void city() throws Exception {
		// city
		BasePage base = new BasePage(driver);
		base.localizarEPreencherElementoViaId("field-city", base.lerDadosNoExcel(1, 6, "ProjetoUm"));
		base.takeScreenShot("City");
	}

	public void state() throws Exception {
		// state
		BasePage base = new BasePage(driver);
		base.localizarEPreencherElementoViaId("field-state", base.lerDadosNoExcel(1, 7, "ProjetoUm"));
		base.takeScreenShot("state");
	}

	public void postalCode() throws Exception {
		// postalCode
		BasePage base = new BasePage(driver);
		base.localizarEPreencherElementoViaId("field-postalCode", base.lerDadosNoExcel(1, 8, "ProjetoUm"));
		base.takeScreenShot("postalCode");
	}

	public void country() throws Exception {
		// country
		BasePage base = new BasePage(driver);
		base.localizarEPreencherElementoViaId("field-country", base.lerDadosNoExcel(1, 9, "ProjetoUm"));
		base.takeScreenShot("country");
	}

	public void salesRepEmployeeNumber() throws Exception {
		// salesRepEmployeeNun
		BasePage base = new BasePage(driver);
		base.localizarEPreencherElementoViaId("field-salesRepEmployeeNumber", base.lerDadosNoExcel(1, 10, "ProjetoUm"));
		base.takeScreenShot("Employee");
	}

	public void creditLimit() throws Exception {
		// creditLimit
		BasePage base = new BasePage(driver);
		base.localizarEPreencherElementoViaId("field-creditLimit", base.lerDadosNoExcel(1, 11, "ProjetoUm"));
		base.takeScreenShot("creditLimit");
	}

	public void botaoSave() {
		// botão save
		BasePage base = new BasePage(driver);
		base.localizarElementoViaIdEClicar("form-button-save");
	}

	public void msgReportSuccess() throws Exception {
		// msg Report Success
		BasePage base = new BasePage(driver);
		WebElement report = (new WebDriverWait(driver, 6))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='report-success']/p")));
		String subs = report.getText().toString().substring(0, 57);

		Assert.assertEquals("Your data has been successfully stored into the database.", subs);
		base.takeScreenShot("Your data has been successfully stored into the database.");
		System.out.println(subs + " Validação Ok");
	}

	public void botaoSaveAndGoBack() {
		// botão saveAndGoBack
		BasePage base = new BasePage(driver);
		base.localizarElementoViaIdEClicar("save-and-go-back-button");
	}

	public void cmpSearchCustomerName() throws Exception {
		// cmp searchCustomerName
		BasePage base = new BasePage(driver);
		base.localizarEPreencherElementoViaXpath("//thead/tr[2]/td[3]/input[1]", "Teste Sicredi");
		base.takeScreenShot("searchCustomerName");
		base.timer(5);
	}

	public void clickCheckBox() throws Exception {
		// checkBox
		BasePage base = new BasePage(driver);
		List<WebElement> list = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (int i = 0; i <= 5; i++) {
			if (i == 5) {
				list.get(i).click();
				base.takeScreenShot("checkBox");
			} else {
				System.out.println(list.get(i).getText());
			}
		}
	}

	public void delete() {
		// delete
		BasePage base = new BasePage(driver);
		base.localizarElementoViaXpathEClicar("//a[@title='Delete']");
	}

	public void validarPopUp() {
		// validarPopUp
		BasePage base = new BasePage(driver);
		base.validarComAssertEqualsXpath("//p[contains(text(),'Are you sure that you want to delete this 1 item?')]",
				"Are you sure that you want to delete this 1 item?");
	}

	public void deletePopUp() {
		// deletePopUp
		BasePage base = new BasePage(driver);
		base.localizarElementoViaXpathEClicar("//button[@class='btn btn-danger delete-multiple-confirmation-button']");
		base.timer(2);
	}

	public void validarMsgFinalDeleted() throws Exception {
		// validarMsgFinal
		BasePage base = new BasePage(driver);
		WebElement element = (new WebDriverWait(driver, 7)).until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//p[contains(text(),'Your data has been successfully deleted from the d')]")));
		for (int i = 0; i < 15; i++) {
			if (element.isDisplayed()) {
				element.click();
				base.validarComAssertEqualsXpath(
						"//p[contains(text(),'Your data has been successfully deleted from the d')]",
						"Your data has been successfully deleted from the database.");
				base.takeScreenShot(element.getText());
			}else{
				System.out.println("Count: " + i);
			}
		}

	}

}
