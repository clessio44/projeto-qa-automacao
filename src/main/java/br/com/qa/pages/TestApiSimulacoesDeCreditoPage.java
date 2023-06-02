package br.com.qa.pages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

import org.hamcrest.Matchers;

import com.github.javafaker.Faker;

import br.com.qa.utils.BasePage;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TestApiSimulacoesDeCreditoPage {

	String restricoes = "restricoes/";
	String simulacoes = "simulacoes/";
	String url = "http://localhost:8080/api/v1/";
	
	public void deveConsultarUmaRestricaoViaCpf() throws IOException {
		BasePage base = new BasePage(null);
		for (int i = 1; i <= 10; i++) {
			validandoCpfComRestricao(base.lerDadosNoExcel(i, 12, "ProjetoUm"));
			System.out.println("Cont: " + i);
		}
	}

	public void validandoCpfComRestricao(String cpf) {
		RestAssured.given()
				.log().all()
				.contentType(ContentType.JSON)
			.when()
				.get(url + restricoes + cpf)
			.then()
				.log().status()
				.log().body()
				.statusCode(200)
				.assertThat().body("mensagem", Matchers.is("O CPF " + cpf + " tem problema"));
	}

	public String deveCriarUmaSimulacao() {
		Faker fake = new Faker(new Locale("pt-BR"));

		String name = fake.address().firstName();
		String cpf = fake.number().digits(11);
		String email = fake.internet().emailAddress();
		int valor = fake.number().numberBetween(1000, 40000);
		int parcelas = fake.number().numberBetween(2, 48);
		Boolean seguro = fake.random().nextBoolean();
		
		HashMap<String, Object> simu = new HashMap<>();
		simu.put("nome", name);
		simu.put("cpf", cpf);
		simu.put("email", email);
		simu.put("valor", valor);
		simu.put("parcelas", parcelas);
		simu.put("seguro", seguro);
		
		RestAssured.given()
				.log().all()
				.contentType(ContentType.JSON)
				.body(simu)
			.when()
				.post(url + simulacoes)
			.then()
				.log().status()
				.log().body()
				.statusCode(201)
				.assertThat().body("nome", Matchers.is(name))
				.assertThat().body("cpf", Matchers.is(cpf))
				.assertThat().body("email", Matchers.is(email))
				.assertThat().body("valor", Matchers.is(valor))
				.assertThat().body("parcelas", Matchers.is(parcelas))
				.assertThat().body("seguro", Matchers.is(seguro))
			;
		return cpf;
	}

	public void deveAlterarUmaSimulacao() {
		String cpfPost = deveCriarUmaSimulacao();
		System.out.println();
		Faker fake = new Faker(new Locale("pt-BR"));

		String name = fake.address().firstName();
		String email = fake.internet().emailAddress();
		int valor = fake.number().numberBetween(1000, 40000);
		int parcelas = fake.number().numberBetween(2, 48);
		Boolean seguro = fake.random().nextBoolean();
		
		HashMap<String, Object> simu = new HashMap<>();
		simu.put("nome", name);
		simu.put("email", email);
		simu.put("valor", valor);
		simu.put("parcelas", parcelas);
		simu.put("seguro", seguro);
		
		System.out.println("Valor: " + valor );
		
		RestAssured.given()
				.log().all()
				.contentType(ContentType.JSON)
				.body(simu)
			.when()
				.put(url + simulacoes + cpfPost)
			.then()
				.log().status()
				.log().body()
				.statusCode(200)
				.assertThat().body("nome", Matchers.is(name))
				.assertThat().body("cpf", Matchers.is(cpfPost))
				.assertThat().body("email", Matchers.is(email))
				.assertThat().body("parcelas", Matchers.is(parcelas))
				.assertThat().body("seguro", Matchers.is(seguro))
			;
		}

	public void deveConsultarTodasAsSimulacoesCadastradas() {
			RestAssured.given()
				.log().all()
				.contentType(ContentType.JSON)
			.when()
				.get(url + simulacoes)
			.then()
				.log().all()
				.log().body()
				.statusCode(200)
				.assertThat()
				;
	}

	public void deveConsultarUmaSimulacaoViaCpf() {
			Object path = RestAssured.given()
				.log().all()
				.contentType(ContentType.JSON)
			.when()
				.get(url + simulacoes)
			.then()
				.log().all()
				.log().body()
				.extract().path("cpf")
				;
			
			System.out.println("path: " + path);
			String cpf = path.toString().substring(1, 12);
			
			RestAssured.given()
			.log().all()
			.contentType(ContentType.JSON)
		.when()
			.get(url + simulacoes + cpf)
		.then()
			.log().all()
			.log().body()
			.statusCode(200)
			.assertThat().body("cpf", Matchers.is(cpf))
			;
	}

	public void deveRemoverUmaSimulacaoCadastradaViaId() {
		Object path = RestAssured.given()
				.log().all()
				.contentType(ContentType.JSON)
			.when()
				.get(url + simulacoes)
			.then()
				.log().all()
				.log().body()
				.extract().path("id")
				;
			
			System.out.println("id: " + path);
			String id = path.toString().substring(1, 3);
			
			RestAssured.given()
					.log().all()
					.contentType(ContentType.JSON)
				.when()
					.delete(url + simulacoes + id)
				.then()
					.log().status()
					.log().body()
					.statusCode(200)
					.assertThat()
				;
	}
}
