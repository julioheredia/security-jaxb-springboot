package br.com.heredia.examples.dto.rockandroll;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "instrument")
@XmlEnum
public enum Instrument {

	VOCALS, GUITAR, DRUMS, BASS;

	public String value() {
		return name();
	}

	public static Instrument fromValue(String v) {
		return valueOf(v);
	}
}
