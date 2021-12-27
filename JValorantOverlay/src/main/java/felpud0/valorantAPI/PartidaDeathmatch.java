package felpud0.valorantAPI;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class PartidaDeathmatch extends Partida{
	
	List<Jugador> jugadores;

	public PartidaDeathmatch(DatosPartida metadatos, List<Jugador> jugadores) {
		super(metadatos);
		this.jugadores = jugadores;
		this.jugadores.sort(new OrdenKills());
	}
	
	public static PartidaDeathmatch parsearJson(DatosPartida dp, JsonNode partida) {
		
		JsonNode allp = partida.get("players").get("all_players");
		
		LinkedList<Jugador> l = new LinkedList<>();
		for(JsonNode j : allp) {
			l.add(Jugador.parsearJson(j));
		}
		
		return new PartidaDeathmatch(dp, l);
	}
	
	public List<Jugador> getLeaderboard(){
		
		return Collections.unmodifiableList(jugadores);
	}

	@Override
	String datosJugador(String puuid) {
		int puesto=1;
		for (Jugador j : jugadores) {
			if (j.getPuuid().equals(puuid)) {
				return ":medal: Rank: "+puesto+ "| KDA: "+ j.getEstadisticas().kdaYScore()+" |";
			}
			puesto++;
		}
		return "";
	}
	

}
