package br.com.heredia.examples.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.heredia.examples.dto.rockandroll.Musician;
import br.com.heredia.examples.repository.RockAndRollRepository;

@Component(value = "musicianService")
@WebService(endpointInterface = "br.com.heredia.examples.webservice.MusicianService", targetNamespace = "br.com.heredia.examples.rockandroll")
public class MusicianService {

	private RockAndRollRepository rockAndRollRepository;

	@Autowired
	public MusicianService(RockAndRollRepository rockAndRollRepository) {
		this.rockAndRollRepository = rockAndRollRepository;
	}

	@WebMethod(operationName = "musicians")
	public List<Musician> getMusicians() {
		return rockAndRollRepository.getMusicians();
	}

	@WebMethod(operationName = "findMusician")
	public Musician findMusicianByName(@WebParam(name = "name") String name) {
		return rockAndRollRepository.findMusicianByName(name);
	}

}
