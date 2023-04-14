package br.com.bvinvestimentos.calculadora.api.selic.bacen;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.bvinvestimentos.calculadora.api.FeignConfig;

// MAIS INFORMACOES: https://www.bcb.gov.br/controleinflacao/historicotaxasjuros
@FeignClient(name = "bacen", url = "https://www.bcb.gov.br/api/servico/sitebcb", configuration = FeignConfig.class)
public interface BacenClient {

	@GetMapping("/historicotaxasjuros")
	public HistoricoTaxasJuros getHistoricoTaxasJuros();
}
