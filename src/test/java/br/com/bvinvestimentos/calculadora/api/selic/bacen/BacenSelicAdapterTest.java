package br.com.bvinvestimentos.calculadora.api.selic.bacen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.bvinvestimentos.calculadora.api.selic.bacennovo.BacenNovoClient;

@ExtendWith(MockitoExtension.class)
class BacenSelicAdapterTest {
	
	@Mock
	BacenClient bacenClient;
	
	@Mock
	BacenNovoClient bacenNovoClient;

	@InjectMocks
	BacenSelicAdapter bacenSelicAdapter;

	@Test
	void shouldReturnMetaSelic() {
		var conteudos = new ArrayList<Conteudo>();
		conteudos.add(new Conteudo(1, LocalDate.now(), 13.0, 1.0, 2.0));
		conteudos.add(new Conteudo(3, LocalDate.now(), 11.0, 3.0, 4.0));
		conteudos.add(new Conteudo(2, LocalDate.now(), 14.0, 5.0, 6.0));
		var historicoTaxasJuros = new HistoricoTaxasJuros(conteudos);
		when(bacenClient.getHistoricoTaxasJuros()).thenReturn(historicoTaxasJuros);
		assertEquals(11.0, bacenSelicAdapter.getSelic());
	}

}
