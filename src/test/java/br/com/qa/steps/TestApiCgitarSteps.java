package br.com.qa.steps;

import br.com.qa.pages.TestApiCgitarPage;
import io.cucumber.java.pt.Dado;

public class TestApiCgitarSteps {
	
	
	@Dado("que envio uma request para criar um user na api cgitar")
	public void que_envio_uma_request_para_criar_um_user_na_api_cgitar() {
		TestApiCgitarPage cg = new TestApiCgitarPage();
		cg.deveCriarUserNaApiCgitar();
	}

	@Dado("que envio uma request para buscar uma pergunta")
	public void que_envio_uma_request_para_buscar_uma_pergunta() {
		TestApiCgitarPage cg = new TestApiCgitarPage();
		cg.deveBuscarUmaPergunta();
	}

	@Dado("que envio uma request para responder a pergunta escolhida")
	public void que_envio_uma_request_para_responder_a_pergunta_escolhida() {
		TestApiCgitarPage cg = new TestApiCgitarPage();
		cg.deveResponderUmaPergunta();
		
	}

	@Dado("que envio uma request para consultar todas as respostas enviadas")
	public void que_envio_uma_request_para_consultar_todas_as_respostas_enviadas() {
		TestApiCgitarPage cg = new TestApiCgitarPage();
		cg.devebuscarTodasAsRespostasEnviadas();
	}

	@Dado("que envio uma request para alterar resposta")
	public void que_envio_uma_request_para_alterar_resposta() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Dado("que envio uma request para avaliar as respostas")
	public void que_envio_uma_request_para_avaliar_as_respostas() {
		TestApiCgitarPage cg = new TestApiCgitarPage();
		cg.deveEnviarRequestParaVerificarAsRespostas();
	}
}
