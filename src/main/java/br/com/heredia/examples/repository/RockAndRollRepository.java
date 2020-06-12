package br.com.heredia.examples.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import br.com.heredia.examples.dto.rockandroll.Band;
import br.com.heredia.examples.dto.rockandroll.Instrument;
import br.com.heredia.examples.dto.rockandroll.Musician;

@Component
public class RockAndRollRepository {

	private static final Map<String, Musician> musicians = new HashMap<>();
	private static final Map<String, Band> bands = new HashMap<>();

	@PostConstruct
	public void initData() {
		addBlackSabbath();
		addLedZeppelin();
		addMetallica();
	}

	public Musician findMusicianByName(String name) {
		Assert.notNull(name, "The musician's name must not be null");
		return musicians.get(name);
	}

	public Band findBandByName(String name) {
		Assert.notNull(name, "The band's name must not be null");
		return bands.get(name);
	}

	public List<Band> getBands() {
		return bands.values().stream().collect(Collectors.toList());
	}

	public List<Musician> getMusicians() {
		return musicians.values().stream().collect(Collectors.toList());
	}

	private void addBlackSabbath() {
		Band blackSabbath = new Band("Black Sabbath");

		Musician ozzy = new Musician();
		ozzy.setName("Ozzy Osborne");
		ozzy.setBand(blackSabbath.getName());
		ozzy.setInstrument(Instrument.VOCALS);

		blackSabbath.addMusicians(ozzy);
		musicians.put(ozzy.getName(), ozzy);

		Musician iommi = new Musician();
		iommi.setName("Tony Iommi");
		iommi.setBand(blackSabbath.getName());
		iommi.setInstrument(Instrument.GUITAR);

		blackSabbath.addMusicians(iommi);
		musicians.put(iommi.getName(), iommi);

		Musician geezer = new Musician();
		geezer.setName("Geezer Butler");
		geezer.setBand(blackSabbath.getName());
		geezer.setInstrument(Instrument.BASS);

		blackSabbath.addMusicians(geezer);
		musicians.put(geezer.getName(), geezer);

		Musician ward = new Musician();
		ward.setName("Bill Ward");
		ward.setBand(blackSabbath.getName());
		ward.setInstrument(Instrument.DRUMS);

		blackSabbath.addMusicians(ward);
		musicians.put(ward.getName(), ward);

		bands.put(blackSabbath.getName(), blackSabbath);
	}

	private void addLedZeppelin() {
		Band ledZeppelin = new Band("Led Zeppelin");

		Musician plant = new Musician();
		plant.setName("James Hetfield");
		plant.setBand(ledZeppelin.getName());
		plant.setInstrument(Instrument.VOCALS);

		ledZeppelin.addMusicians(plant);
		musicians.put(plant.getName(), plant);

		Musician page = new Musician();
		page.setName("Jimmy Page");
		page.setBand(ledZeppelin.getName());
		page.setInstrument(Instrument.GUITAR);

		ledZeppelin.addMusicians(page);
		musicians.put(page.getName(), page);

		Musician jones = new Musician();
		jones.setName("John Paul Jones");
		jones.setBand(ledZeppelin.getName());
		jones.setInstrument(Instrument.BASS);

		ledZeppelin.addMusicians(jones);
		musicians.put(jones.getName(), jones);

		Musician bonham = new Musician();
		bonham.setName("John Bonham");
		bonham.setBand(ledZeppelin.getName());
		bonham.setInstrument(Instrument.DRUMS);

		ledZeppelin.addMusicians(bonham);
		musicians.put(bonham.getName(), bonham);

		bands.put(ledZeppelin.getName(), ledZeppelin);
	}

	private void addMetallica() {
		Band metallica = new Band("Metallica");

		Musician hetfield = new Musician();
		hetfield.setName("James Hetfield");
		hetfield.setBand(metallica.getName());
		hetfield.setInstrument(Instrument.VOCALS);

		metallica.addMusicians(hetfield);
		musicians.put(hetfield.getName(), hetfield);

		Musician hammett = new Musician();
		hammett.setName("Kirk Hammett");
		hammett.setBand(metallica.getName());
		hammett.setInstrument(Instrument.GUITAR);

		metallica.addMusicians(hammett);
		musicians.put(hammett.getName(), hammett);

		Musician burton = new Musician();
		burton.setName("Cliff Burton");
		burton.setBand(metallica.getName());
		burton.setInstrument(Instrument.BASS);

		metallica.addMusicians(burton);
		musicians.put(burton.getName(), burton);

		Musician ulrich = new Musician();
		ulrich.setName("Lars Ulrich");
		ulrich.setBand(metallica.getName());
		ulrich.setInstrument(Instrument.DRUMS);

		metallica.addMusicians(ulrich);
		musicians.put(ulrich.getName(), ulrich);

		bands.put(metallica.getName(), metallica);
	}

}
