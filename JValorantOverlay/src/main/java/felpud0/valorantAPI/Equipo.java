package felpud0.valorantAPI;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;

public class Equipo  {
	
	private final String color;
	private final boolean won;
	private final int rondasGanadas;
	private final int rondasPerdidas;
	private final Set<Jugador> jugadores;
	
	public Equipo(String color, boolean won, int rondasGanadas, int rondasPerdidas, Set<Jugador> jugadores) {
		this.rondasGanadas = rondasGanadas;
		this.rondasPerdidas = rondasPerdidas;
		this.jugadores = jugadores;
		this.won=won;
		this.color=color;
	}

	public int getRondasGanadas() {
		return rondasGanadas;
	}

	public int getRondasPerdidas() {
		return rondasPerdidas;
	}
	
	
	public boolean hasWon() {
		return won;
	}

	public String getColor() {
		return color;
	}

	public Set<Jugador> getJugadores() {
		return Collections.unmodifiableSet(jugadores);
	}
	
	public static Equipo parsearJson(String nombre, JsonNode nJugadores, JsonNode nEquipo) {
		
		//Hacemos una lista con uss jugadores
		HashSet<Jugador> plantilla = new HashSet<>();
		for (JsonNode j : nJugadores) {
			plantilla.add(Jugador.parsearJson(j));

		}
		
		return new Equipo(nombre, 
				nEquipo.get("has_won").asBoolean(), 
				nEquipo.get("rounds_won").asInt(), 
				nEquipo.get("rounds_lost").asInt(), 
				plantilla);
	}
	

	

}
