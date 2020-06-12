package br.com.heredia.examples.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.stereotype.Component;

import br.com.heredia.examples.dto.rockandroll.Band;
import br.com.heredia.examples.repository.RockAndRollRepository;

@Component(value = "bandService")
@WebService(serviceName = "bandService", endpointInterface = "br.com.heredia.examples.webservice.BandService", targetNamespace = "br.com.heredia.examples.rockandroll")
public class BandService implements WebServerFactory {

	private RockAndRollRepository rockAndRollRepository;

	@Autowired
	public BandService(RockAndRollRepository rockAndRollRepository) {
		this.rockAndRollRepository = rockAndRollRepository;
	}

	@WebMethod(operationName = "bands")
	public List<Band> getBands() {
		return rockAndRollRepository.getBands();
	}

	@WebMethod(operationName = "findBand")
	public Band findBandByName(@WebParam(name = "name") String name) {
		return rockAndRollRepository.findBandByName(name);
	}
}
