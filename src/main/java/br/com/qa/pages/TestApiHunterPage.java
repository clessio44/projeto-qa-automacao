package br.com.qa.pages;

import java.util.HashMap;
import java.util.Random;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class TestApiHunterPage {
	
	public static RequestSpecification Request;
	
	public TestApiHunterPage(){
	}
	String baseURI = "https://api.hunter.io/v2";
	String key = "6e62e4139ba00669b103536a51ff447797901209";
	String head = "x-api-key";
	String  lead = "/leads";
	String leadList = "/leads_lists";
	String leadCustom = "/leads_custom_attributes";
	String dominio = "/domain-search?domain=";
	String intercom = "intercom.io";
	String github = "github.com";
	String blog = "blog.intercom.io";
 	String stripe = "stripe.com";
	private Integer ID;
	
	//ct001
	public void realizandoComandoGet(){
		RestAssured.given()
				.log().all()
				.header(head, key)
				.contentType(ContentType.JSON)
				.when()
					.get(baseURI + lead)
				.then()
					.log().body()
					.statusCode(200)
					;
	}
	//ct002
	public void recuperarTodosOsLeadsComGet() {
		RestAssured.given()
				.log().all()
				.header(head, key)
				.contentType(ContentType.JSON)
			.when()
				.get(baseURI + dominio + github)
			.then()
				.log().body()
				.statusCode(200);
	}
	//ct003
	public void recuperarLeadEspecifico() {
		//Sem o id
		RestAssured.given()
			.log().all()
			.header(head, key)
			.contentType(ContentType.JSON)
		.when()
			.get(baseURI + leadCustom + "/label")
		.then()
			.log().body()
			.statusCode(404)
			.body(Matchers.containsString("not_found"))
			.body(Matchers.containsString("This leads custom attribute does not exist."))
			;
		//Com ID
		deveCriarNovoLead();//envia o post, e captura o ID e armazena em variavel 
		RestAssured.given()
			.log().all()
			.header(head, key)
			.contentType(ContentType.JSON)
		.when()
			.get(baseURI + lead +"/"+ID)
		.then()
			.log().body()
			.statusCode(200)
			.body("data.id", Matchers.is(ID))
			;
	}
	
	//ct004
	public void deveCriarNovoLead() {
		System.out.println("Criar novo lead");
		Random ger = new Random();
		HashMap<String, Object> user = new HashMap<>();
		user.put("email", ger.nextInt(999)*11 +"@"+ ger.nextInt(999)* 11+".com");
		user.put("first_name", ger.nextInt(99)*11);
		user.put("last_name", ger.nextInt(99)*11);
		user.put("position", "Analista");
		user.put("company", "Amazon");
		user.put("company_industry", "Internet and Telecom");
	
		 ID = RestAssured.given()
			.log().all()
			.header(head, key)
			.contentType(ContentType.JSON)
			.body(user)
		.when()
			.post(baseURI + lead)
		.then()
			.log().body()
			.statusCode(201)
			.extract().path("data.id");
		 System.out.println("ID: >>> " + ID);
	}
	//ct005
	public void deveEditarRequisicaoDoLeadEspecifico() {
		deveCriarNovoLead();
		System.out.println("Iniciando PUT...");
		Random ger = new Random();
		HashMap<String, Object> user = new HashMap<>();
		user.put("email", ger.nextInt(999)*11 +"@"+ ger.nextInt(999)* 11+".com");
		user.put("first_name", ger.nextInt(99)*11);
		user.put("last_name", ger.nextInt(99)*11);
		user.put("position", "Gerente");
		user.put("company", "Google");
		user.put("company_industry", "Internet and Telecom");
		RestAssured.given()
			.log().all()
			.header(head, key)
			.contentType(ContentType.JSON)
			.body(user)
		.when()
			.put(baseURI + lead + "/"+ ID)
		.then()
			.log().status()
			.log().body()
			.statusCode(Matchers.anyOf(Matchers.is(200), Matchers.is(204)))
			;
		
	}
	//ct006
	public void deveDeletarOLeadEspecifico() {
		deveCriarNovoLead();
		RestAssured.given()
			.log().all()
			.header(head, key)
			.contentType(ContentType.JSON)
		.when()
			.delete(baseURI + lead + "/" + ID)
		.then()
			.log().status()
			.statusCode(204)
		;
	}
	//ct007
	public void deveEnviarRequestGetParaReceberLista() {
		RestAssured.given()
			.log().all()
			.headers(head, key)
			.contentType(ContentType.JSON)
		.when()
			.get(baseURI + leadList)
		.then()
			.log().status()
			.log().body()
			.statusCode(200)
			.body("data.leads_lists.id", Matchers.hasItem(4337228))
			.body("data.leads_lists.name", Matchers.hasItem("Clessio's leads"))
			.body("data.leads_lists.leads_count", Matchers.hasItem(43))
			.body("data.leads_lists.created_at", Matchers.hasItem("2023-05-29 22:06:20 UTC"))
		;
	}
	//ct008
	public void deveEnviarRequestGetParaReceberUmaListaEspecifica() {
		Object path = RestAssured.given()
		.log().all()
		.headers(head, key)
		.contentType(ContentType.JSON)
	.when()
		.get(baseURI + leadList)
	.then()
		.log().status()
		.log().body()
		.statusCode(200)
		.extract().path("data.leads_lists.id")
		;
		
		System.out.println("Path: " + path.toString().substring(1,8));
		String subs = path.toString().substring(1,8);
		
		RestAssured.given()
		.log().all()
		.headers(head, key)
		.contentType(ContentType.JSON)
	.when()
		.get(baseURI + leadList +"/"+ subs)
	.then()
		.log().status()
		.log().body()
		.statusCode(200)
		.body("data.leads.id", Matchers.hasItem(127315783))
		.body("data.leads.id", Matchers.hasItem(127315782))
		.body("data.leads.id", Matchers.hasItem(127315780))
		.body("data.leads.id", Matchers.hasItem(127315779))
		.body("data.leads.id", Matchers.hasItem(127315778))
		.body("data.leads.id", Matchers.hasItem(127306182))
		;	
	}
	//ct009
	public void deveEnviarRequestPostParaCriarNovaLista() {
		HashMap<String, Object> list = new HashMap<>();
		list.put("name", "Clessio's New leads list");
		RestAssured.given()
			.log().all()
			.header(head, key)
			.contentType(ContentType.JSON)
			.body(list)
		.when()
			.post(baseURI + leadList)
		.then()
			.log().status()
			.log().body()
			.statusCode(201)
			.body("data.name", Matchers.hasItem("Clessio's New leads list"))
		;
	}
	//ct010
	public void deveAlterarRequestComPutParaEditarListaDeLead() {
			Object path = RestAssured.given()
			.log().all()
			.headers(head, key)
			.contentType(ContentType.JSON)
		.when()
			.get(baseURI + leadList)
		.then()
			.log().status()
			.log().body()
			.statusCode(200)
			.extract().path("data.leads_lists.id")
			;
			
		System.out.println("Path: " + path.toString().substring(1,8));
		String subs = path.toString().substring(1,8);
		
		HashMap<String, Object> list = new HashMap<>();
		list.put("name", "Clessio's New leads list Edit");
		RestAssured.given()
			.log().all()
			.header(head, key)
			.contentType(ContentType.JSON)
			.body(list)
		.when()
			.put(baseURI + leadList + "/" + subs)
		.then()
			.log().status()
			.log().body()
			.statusCode(204)
			;
	}
	//ct011
	public void deveDeletarUmaListaDeLeadEspecifica() {
		Object path = RestAssured.given()
				.log().all()
				.headers(head, key)
				.contentType(ContentType.JSON)
			.when()
				.get(baseURI + leadList)
			.then()
				.log().status()
				.log().body()
				.statusCode(200)
				.extract().path("data.leads_lists.id")
				;
				
			System.out.println("Path: " + path.toString().substring(1,8));
			String subs = path.toString().substring(1,8);
			
		RestAssured.given()
			.log().all()
			.header(head, key)
			.contentType(ContentType.JSON)
		.when()
			.delete(baseURI + leadList + "/"+subs)
		.then()
			.log().status()
			.log().body()
			.statusCode(204)
		;
		
	}
	
	
	
	

}
