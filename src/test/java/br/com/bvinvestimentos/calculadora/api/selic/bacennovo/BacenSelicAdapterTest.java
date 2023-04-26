package br.com.bvinvestimentos.calculadora.api.selic.bacennovo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BacenSelicAdapterTest {
	
	@Mock
	BacenNovoClient bacenNovoClient;

	@InjectMocks
	BacenNovoSelicAdapter bacenSelicAdapter;

	@Test
	void shouldReturnSelic() {
		var payload = new Periodo("25/04/2023", "25/04/2023");
		var registros = new ArrayList<Registro>();
		registros.add(new Registro("25/04/2023", 13.65, new BigDecimal("13.649989315282562")));
		var conteudo = new Conteudo(1, registros, "26/04/2023 às 01:05:40");
		when(bacenNovoClient.getResultados(payload)).thenReturn(conteudo);
		assertEquals(new BigDecimal(13.65).setScale(2, RoundingMode.HALF_DOWN), bacenSelicAdapter.getSelic());
	}

}
