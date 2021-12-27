package felpud0.valorantAPI;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.databind.JsonNode;

public class DatosPartida {
	
	private final String map;
	private final double duracion;
	private final String gameStartPatched;
	private final int rondas;
	private final String modo;
	private final String matchid;
	
	
	public DatosPartida(String map, double duracion, String gameStartPatched, int rondas, String modo, String matchid) {
		this.map = map;
		this.duracion = duracion;
		this.gameStartPatched = gameStartPatched;
		this.rondas = rondas;
		this.modo = modo;
		this.matchid = matchid;
	}

	public String getMap() {
		return map;
	}

	public double getDuracion() {
		return duracion;
	}

	public String getGameStartPatched() {
		return gameStartPatched;
	}

	public int getRondas() {
		return rondas;
	}

	public String getModo() {
		return modo;
	}

	public String getMatchid() {
		return matchid;
	}
	
	public static DatosPartida parsearJson(JsonNode metadatos) {
		
		String map = metadatos.get("map").asText();
		long rawLength =  metadatos.get("game_length").asLong();
		long epo = metadatos.get("game_start").asLong();
		LocalDateTime time =  LocalDateTime.ofInstant(Instant.ofEpochMilli(epo),ZoneId.systemDefault());
		
		//Transformamos la duracion de milisegundos a minutos
		long min = TimeUnit.MILLISECONDS.toMinutes(rawLength);
		
		//Formateamos nuestra fecha.
		String fecha = time.format(DateTimeFormatter.ISO_DATE_TIME);

		//Parseamos los datos de la partida
		return new DatosPartida(map,
				min, 
				fecha, 
				metadatos.get("rounds_played").asInt(), 
				metadatos.get("mode").asText(), 
				metadatos.get("matchid").asText());
	}
}
