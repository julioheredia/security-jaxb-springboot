package br.com.heredia.examples.dto.rockandroll;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "band", propOrder = { "name", "musicians" })
public class Band {

	@XmlElement(required = true)
	private String name;
	@XmlElement(name = "musicians")
	private List<Musician> musicians;

	public Band() {
	}

	public Band(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Musician> getMusicians() {
		return musicians;
	}

	public void addMusicians(Musician musician) {
		if (this.musicians == null) {
			this.musicians = new ArrayList<Musician>();
			this.musicians.add(musician);
		} else {
			this.musicians.add(musician);
		}

	}

}
