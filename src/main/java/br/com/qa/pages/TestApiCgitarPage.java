package br.com.qa.pages;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TestApiCgitarPage {
	
	String url = "http://165.227.93.41/cgitar";
	String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c3VhcmlvaWQiOiIxMDQxIiwidXN1YXJpb25vbWUiOiJDbGVzc2lvIFNpbHZhIiwidXN1YXJpb2VtYWlsIjoiY2xlc3Npb3NpbHZhNDRAZ21haWwuY29tIiwidXN1YXJpb3RlbGVmb25lIjoiMTE5NjE4MDY4OTQifQ.DRoNy1UVxv-hqbuj6mqUIAqvdaQUHJms_JIxmTxXiHY";
	String endpointUser = "/usuarios";
	String endpointAutent = "/autenticacao";
	String endpointPerg = "/perguntas";
	String endpointResp = "/respostas";
	String endpointCert = "/certificados";
	
	public void deveCriarUserNaApiCgitar() {		
		HashMap<String, Object> simu = new HashMap<>();
		simu.put("usuarioNomeCompleto", "Clessio Silva");
		simu.put("usuarioEmail", "");
		simu.put("usuarioSenha", "");
		simu.put("usuarioTelefone", "");
		
		RestAssured.given()
				.log().all()
				.contentType(ContentType.JSON)
				.body(simu)
			.when()
				.post(url + endpointUser)
			.then()
				.log().status()
				.log().body()
				.statusCode(201)
			;
	}
	
	public void  autenticacao(){
		HashMap<Object, String> map = new HashMap<>();
		map.put("usuarioEmail", "clessiosilva44@gmail.com");
		map.put("usuarioSenha", "TestApiStatusCode200");
		
		   RestAssured.given()
			.log().all()
			.contentType(ContentType.JSON)
			.body(map)
		.when()
			.post(url + endpointAutent)
		.then()
			.log().status()
			.log().body()
			.statusCode(200)
			.extract().path("data.token")
		;
	}
	
	public String deveBuscarUmaPergunta() {	
		String pergunta = RestAssured.given()
			.header("token", token)
			.log().all()
			.contentType(ContentType.JSON)
		.when()
			.get(url + endpointPerg)
		.then()
			.log().status()
			.log().body()
			.statusCode(200)
			.extract().path("perguntaId", "perguntaDescricao")
			;	
		return pergunta;
	}
	
	public void deveResponderUmaPergunta(){
		
			HashMap<Object, String> map = new HashMap<>();
			map.put("perguntaId", "17");
			map.put("respostaDada", "true");
				
			RestAssured.given().header("token", token).log().all().contentType(ContentType.JSON).body(map)
					.when()
						.post(url + endpointResp)
					.then().log().status().log().body().statusCode(201);
	
			map.put("perguntaId", "20");
			map.put("respostaDada", "true");
				
			RestAssured.given().header("token", token).log().all().contentType(ContentType.JSON).body(map)
					.when()
						.post(url + endpointResp)
					.then().log().status().log().body().statusCode(201);

			map.put("perguntaId", "31");
			map.put("respostaDada", "true");
				
			RestAssured.given().header("token", token).log().all().contentType(ContentType.JSON).body(map)
					.when()
						.post(url + endpointResp)
					.then().log().status().log().body().statusCode(201);
				map.put("perguntaId", "11");
				map.put("respostaDada", "true");
				
			RestAssured.given().header("token", token).log().all().contentType(ContentType.JSON).body(map)
					.when()
						.post(url + endpointResp)
					.then().log().status().log().body().statusCode(201);
				map.put("perguntaId", "34");
				map.put("respostaDada", "true");
				
			RestAssured.given().header("token", token).log().all().contentType(ContentType.JSON).body(map)
					.when()
						.post(url + endpointResp)
					.then().log().status().log().body().statusCode(201);

			map.put("perguntaId", "27");
			map.put("respostaDada", "true");
				
			RestAssured.given().header("token", token).log().all().contentType(ContentType.JSON).body(map)
					.when()
						.post(url + endpointResp)
					.then().log().status().log().body().statusCode(201);

			map.put("perguntaId", "37");
			map.put("respostaDada", "true");
			
			RestAssured.given().header("token", token).log().all().contentType(ContentType.JSON).body(map)
					.when()
						.post(url + endpointResp)
					.then().log().status().log().body().statusCode(201);

			map.put("perguntaId", "33");
			map.put("respostaDada", "true");
				
			RestAssured.given().header("token", token).log().all().contentType(ContentType.JSON).body(map)
					.when()
						.post(url + endpointResp)
					.then().log().status().log().body().statusCode(201);

			map.put("perguntaId", "29");
			map.put("respostaDada", "true");
				
			RestAssured.given().header("token", token).log().all().contentType(ContentType.JSON).body(map)
					.when()
						.post(url + endpointResp)
					.then().log().status().log().body().statusCode(201);

			map.put("perguntaId", "18");
			map.put("respostaDada", "false");
				
			RestAssured.given().header("token", token).log().all().contentType(ContentType.JSON).body(map)
					.when()
						.post(url + endpointResp)
					.then().log().status().log().body().statusCode(201);
	}

	public void devebuscarTodasAsRespostasEnviadas() {
		RestAssured.given()
			.header("token", token)
			.log().all()
			.contentType(ContentType.JSON)
		.when()
			.get(url + endpointResp)
		.then()
			.log().status()
			.log().body()
			.statusCode(200)
			;
	}

	public void deveEnviarRequestParaVerificarAsRespostas() {
		HashMap<Object, String> map = new HashMap<>();
		map.put("apresentarPercentual", "true");
		RestAssured.given()
			.header("token", token)
			.log().all()
			.contentType(ContentType.JSON)
			.body(map)
		.when()
			.post(url + endpointCert)
		.then()
			.log().status()
			.log().body()
			.statusCode(201)
		;
	}
	

}
