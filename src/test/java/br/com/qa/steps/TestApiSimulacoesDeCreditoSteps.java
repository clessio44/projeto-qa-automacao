package br.com.qa.steps;

import java.io.IOException;

import br.com.qa.pages.TestApiSimulacoesDeCreditoPage;
import io.cucumber.java.pt.Dado;

public class TestApiSimulacoesDeCreditoSteps {
		
	@Dado("que envio uma request para consultar uma restricao via CPF")
	public void que_envio_uma_request_para_consultar_uma_restricao_via_CPF() throws IOException {
	    TestApiSimulacoesDeCreditoPage cred = new TestApiSimulacoesDeCreditoPage();
	    cred.deveConsultarUmaRestricaoViaCpf();
	}

	@Dado("que envio uma request para criar uma simulacao")
	public void que_envio_uma_request_para_criar_uma_simulacao() {
		TestApiSimulacoesDeCreditoPage cred = new TestApiSimulacoesDeCreditoPage();
		cred.deveCriarUmaSimulacao();
	}

	@Dado("que envio uma request para alterar uma simulacao")
	public void que_envio_uma_request_para_alterar_uma_simulacao() {
		TestApiSimulacoesDeCreditoPage cred = new TestApiSimulacoesDeCreditoPage();
		cred.deveAlterarUmaSimulacao();
	}

	@Dado("que envio uma request para consultar todas as simulacoes cadastradas")
	public void que_envio_uma_request_para_consultar_todas_as_simulacoes_cadastradas() {
		TestApiSimulacoesDeCreditoPage cred = new TestApiSimulacoesDeCreditoPage();
		cred.deveConsultarTodasAsSimulacoesCadastradas();
	}

	@Dado("que envio uma request para consultar uma simulacao cadastrada pelo cpf")
	public void que_envio_uma_request_para_consultar_uma_simulacao_cadastrada_pelo_cpf() {
		TestApiSimulacoesDeCreditoPage cred = new TestApiSimulacoesDeCreditoPage();
		cred.deveConsultarUmaSimulacaoViaCpf();
	}

	@Dado("que envio uma request para remover uma simulacao cadastrada via id")
	public void que_envio_uma_request_para_remover_uma_simulacao_cadastrada_via_id() {
		TestApiSimulacoesDeCreditoPage cred = new TestApiSimulacoesDeCreditoPage();
		cred.deveRemoverUmaSimulacaoCadastradaViaId();
	}


}
