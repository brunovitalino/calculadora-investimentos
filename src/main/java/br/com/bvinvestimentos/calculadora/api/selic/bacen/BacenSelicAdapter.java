package br.com.bvinvestimentos.calculadora.api.selic.bacen;

import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bvinvestimentos.calculadora.api.selic.SelicAdapter;


@Service
public class BacenSelicAdapter implements SelicAdapter {
	
	@Autowired
	BacenClient bacenClient;

	@Override
	public Double getSelic() {
		return bacenClient.getHistoricoTaxasJuros().conteudos().stream()
	      .max(Comparator.comparing(Conteudo::numeroReuniaoCopom))
	      .get().metaSelic();
	}

}