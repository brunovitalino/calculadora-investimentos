package br.com.bvinvestimentos.calculadora.api.selic.bacen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BacenClientTest {
	
	@Mock
	BacenClient bacenClient;

	@Test
	void shouldReturnHistoricoTaxasJuros() {
		var historicoTaxasJuros = new HistoricoTaxasJuros(new ArrayList<>());
		when(bacenClient.getHistoricoTaxasJuros()).thenReturn(historicoTaxasJuros);
		assertEquals(historicoTaxasJuros, bacenClient.getHistoricoTaxasJuros());
	}

}
