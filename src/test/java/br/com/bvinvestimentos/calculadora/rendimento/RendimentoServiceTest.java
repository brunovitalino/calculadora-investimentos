package br.com.bvinvestimentos.calculadora.rendimento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.bvinvestimentos.calculadora.api.selic.SelicAdapter;

@ExtendWith(MockitoExtension.class)
class RendimentoServiceTest {
	
	@Mock
	SelicAdapter selicAdapter;
	
	@InjectMocks
	RendimentoService rendimentoService;

	@Test
	void shouldReturnRendimentoTaxavel() {
		BigDecimal valorInvestido = new BigDecimal(72000);
		Integer numeroDiasInvestido = 350;
		BigDecimal taxaSELIC = new BigDecimal(13.75);
		Integer porcentagemCDI = 110;
		BigDecimal aliquotaCDI = new BigDecimal(13.65);
		
		when(selicAdapter.getSelic()).thenReturn(taxaSELIC);
		
		var rendimentos = rendimentoService.getAllRendimentoTaxavel(valorInvestido, numeroDiasInvestido, porcentagemCDI, aliquotaCDI);
		
		var rendimentoSELIC = rendimentos.stream().filter(e -> TipoRendimento.SELIC.equals(e.tipoRendimento())).findFirst();
		assertTrue(rendimentoSELIC.isPresent());
		assertEquals(new BigDecimal(80415.00).setScale(2, RoundingMode.HALF_DOWN), rendimentoSELIC.get().valorRendido());
		
		var rendimentoCDI = rendimentos.stream().filter(e -> TipoRendimento.CDI.equals(e.tipoRendimento())).findFirst();
		assertTrue(rendimentoCDI.isPresent());
		assertEquals(new BigDecimal(81189.18).setScale(2, RoundingMode.HALF_DOWN), rendimentoCDI.get().valorRendido());
	}

}
