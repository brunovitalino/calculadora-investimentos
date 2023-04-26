package br.com.bvinvestimentos.calculadora.api.selic.bacennovo;

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
	BacenNovoClient bacenNovoClient;

	@Test
	void shouldReturnConteudoComSelic() {
		var periodo = new Periodo("25/04/2023", "25/04/2023");
		var conteudo = new Conteudo(1, new ArrayList<>(), "26/04/2023 às 01:05:40");
		when(bacenNovoClient.getResultados(periodo)).thenReturn(conteudo);
		assertEquals(conteudo, bacenNovoClient.getResultados(periodo));
	}

}
