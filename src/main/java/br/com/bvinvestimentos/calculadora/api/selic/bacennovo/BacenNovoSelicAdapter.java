package br.com.bvinvestimentos.calculadora.api.selic.bacennovo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bvinvestimentos.calculadora.api.selic.SelicAdapter;


@Service
public class BacenNovoSelicAdapter implements SelicAdapter {
	
	@Autowired
	BacenNovoClient bacenNovoClient;

	@Override
	public BigDecimal getSelic() {
		return bacenNovoClient.getResultados(new Periodo("25/04/2023", "25/04/2023")).registros().stream()
			.max(Comparator.comparing(Registro::dataCotacao))
			.get().taxaAnual().setScale(2, RoundingMode.HALF_DOWN);
	}

}
