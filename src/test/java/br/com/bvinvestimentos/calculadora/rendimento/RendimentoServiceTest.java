package br.com.bvinvestimentos.calculadora.rendimento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
		var rendimentos = rendimentoService.getRendimentoTaxavel(new BigDecimal(72000), 721, 110, new BigDecimal(13.65));
		var rendimentoCDI = rendimentos.stream().filter(e -> TipoRendimento.CDI.equals(e.tipoRendimento())).findFirst();
		assertTrue(rendimentoCDI.isPresent());
		assertEquals(new BigDecimal(81189.18).setScale(2, RoundingMode.HALF_DOWN), rendimentoCDI.get().valorRendido());
	}

}
