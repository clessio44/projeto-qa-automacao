package br.com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void localizarEPreencherElementoViaId(String id, String text) {
		WebElement element = (new WebDriverWait(driver, 4))
				.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
		element.sendKeys(text);
	}

	public void localizarEPreencherElementoViaXpath(String xpath, String text) {
		WebElement element = (new WebDriverWait(driver, 15))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		element.click();
		element.sendKeys(text);
	}

	public void localizarElementoViaIdEClicar(String id) {
		WebElement element = (new WebDriverWait(driver, 5))
				.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
		element.click();
	}

	public void timer(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public void localizarElementoViaXpathEClicar(String xpath) {
		WebElement element = (new WebDriverWait(driver, 7))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		element.click();

	}

	public void validarComAssertEqualsXpath(String xpath, String msgEsperada) {
		WebElement element = (new WebDriverWait(driver, 6))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		System.out.println(element.getText() + " Iniciando Validação via Xpath");
		Assert.assertEquals(msgEsperada, element.getText());
	}

	@SuppressWarnings("resource")
	public String lerDadosNoExcel(int row, int column, String sheet) throws IOException {
		// open excel
		FileInputStream file = new FileInputStream("src/main/resources/massa.xlsx");
		XSSFWorkbook wkb = new XSSFWorkbook(file);
		// The first sheet of excel
		XSSFSheet sheet1 = wkb.getSheet(sheet);
		// get the row and cell
		XSSFRow row1 = sheet1.getRow(row);
		XSSFCell column1 = row1.getCell(column);
		// get the string value
		String text = column1.getStringCellValue();
		// close file
		file.close();
		return text;
	}
	public void takeScreenShot(String titulo) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
		String format = formatter.format(LocalDateTime.now());
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("Evidences/"+  titulo + format + ".png"));
	}

}
