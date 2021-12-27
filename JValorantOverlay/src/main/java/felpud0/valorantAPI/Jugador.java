package felpud0.valorantAPI;

import java.util.Objects;

import com.fasterxml.jackson.databind.JsonNode;

public class Jugador extends Cuenta implements Comparable<Jugador> {
	
	private final String puuid;
	private final String character;
	private final StatsJugador estadisticas;
	
	public Jugador(String name, String tag, String puuid, String character, StatsJugador estadisticas) {
		super(name, tag);
		this.puuid = puuid;
		this.character = character;
		this.estadisticas = estadisticas;
	}
	

	public String getPuuid() {
		return puuid;
	}

	public String getCharacter() {
		return character;
	}

	public StatsJugador getEstadisticas() {
		return estadisticas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(puuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(puuid, other.puuid);
	}
	
	public static Jugador parsearJson(JsonNode jugador) {
		
		return new Jugador(jugador.get("name").asText(), 
				jugador.get("tag").asText(), 
				jugador.get("puuid").asText(),
				jugador.get("character").asText(), 
				StatsJugador.parsearJson(jugador.get("stats")));
	}


	@Override
	public int compareTo(Jugador o) {
		return this.compareTo(o);
	}



	
	
}
