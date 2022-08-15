package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario fulano;

	@BeforeEach
	public void inicializar() {
		System.out.println("inicializar");
		this.service = new ReajusteService();
		this.fulano = new Funcionario("Fulano", LocalDate.now(), new BigDecimal("2000.00"));
	}

	@AfterEach
	public void finalizar() {
		System.out.println("FIM");
	}
	
	@BeforeAll
	public static void antesDeTodos() {
		System.out.println("ANTES DE TODOS");
	}
	
	@AfterAll
	public static void depoisDeTodos() {
		System.out.println("DEPOIS DE TODOS");
	}
	
	@Test
	void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {

		service.concederReajuste(fulano, Desempenho.A_DESEJAR);

		assertEquals(new BigDecimal("2060.00"), fulano.getSalario());
	}

	@Test
	void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {

		service.concederReajuste(fulano, Desempenho.BOM);

		assertEquals(new BigDecimal("2300.00"), fulano.getSalario());
	}

	@Test
	void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {

		service.concederReajuste(fulano, Desempenho.OTIMO);

		assertEquals(new BigDecimal("2400.00"), fulano.getSalario());
	}

}
