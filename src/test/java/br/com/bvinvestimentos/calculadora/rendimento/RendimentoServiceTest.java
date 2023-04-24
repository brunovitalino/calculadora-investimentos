package br.com.bvinvestimentos.calculadora.rendimento;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RendimentoServiceTest {
	
	@InjectMocks
	RendimentoService rendimentoService;

	@Test
	void shouldReturnRendimentoTaxavel() {
		assertEquals(Double.valueOf(81.18918000000001), rendimentoService.getRendimentoTaxavel(72.000));
	}

}
