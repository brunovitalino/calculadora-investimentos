package br.com.bvinvestimentos.calculadora.api.selic.bacennovo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.bvinvestimentos.calculadora.api.FeignConfig;

// MAIS INFORMACOES: https://www.bcb.gov.br/htms/SELIC/SELICdiarios.asp?frame=1
@FeignClient(name = "bacen", url = "https://www3.bcb.gov.br/novoselic/rest/taxaSelicApurada/pub/search?parametrosOrdenacao=[]&page=1&pageSize=20", configuration = FeignConfig.class)
public interface BacenNovoClient {

	@PostMapping()
	public Conteudo getResultados(@RequestBody Periodo periodo);
}
