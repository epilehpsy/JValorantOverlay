package felpud0.valorantAPI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;

public class PartidaNormal extends Partida {

	private final List<Equipo>equipos;
	
	
		public PartidaNormal(DatosPartida metadatos, List<Equipo> equipos) {
		super(metadatos);
		this.equipos=equipos;
	}
	

	public List<Equipo> getEquipos() {
		return equipos;
	}
	
	public String getResultado() {
		return equipos.get(0).getRondasGanadas()+" - "+equipos.get(0).getRondasGanadas();
	}
	
	public Jugador buscarJugador(String puuid) {
		for (Equipo e: equipos) {
			for(Jugador j : e.getJugadores()) {
				if (j.getPuuid().equals(puuid)) 
					return j;
				
			}
		}
		
		return null;
	}
	
	
	public Equipo getEquipoGanador() {
		for (Equipo e : equipos) {
			if (e.hasWon()) return e;
		}
		
		return null;
	}
	
	//Devuelve si el parametro esta en el equipo ganador
	public boolean haGanado(String puuid) {
		
		return haGanado(buscarJugador(puuid));
	}
	
	public boolean haGanado(Jugador jugador) {
		return getEquipoGanador().getJugadores().contains(jugador);
	}
	
	public static PartidaNormal parsearJson(DatosPartida dp, JsonNode partida) {
		
		JsonNode nEq = partida.get("teams");
		JsonNode nJug = partida.get("players");
		ArrayList<Equipo> equipos = new ArrayList<>();
		Iterator<Entry<String,JsonNode>> it = nJug.fields();
		while (it.hasNext()){
			
			Entry<String,JsonNode> entry = ((Entry<String,JsonNode>)it.next());
			JsonNode e = entry.getValue();
			String equipoAct = entry.getKey();
			
			if (!equipoAct.equals("all_players")) 
				equipos.add(Equipo.parsearJson(equipoAct,e,nEq.get(equipoAct)));
			}
		
		return new PartidaNormal(dp, equipos);
	}


	@Override
	String datosJugador(String puuid) {
		
		StringBuffer sb = new StringBuffer();
		for (Equipo e : getEquipos()) {
			for (Jugador j : e.getJugadores()) {
				if (j.getPuuid().equals(puuid)) {
					
					if (e.hasWon()) sb.append(":white_check_mark: WON ");
					else sb.append(":x: LOST ");
					sb.append(e.getRondasGanadas()).append(" - ").append(e.getRondasPerdidas()).append(" ");
					sb.append(j.getCharacter()).append(" ");
					sb.append("| KDA: ").append(j.getEstadisticas().kdaYScore()).append(" |");
					return sb.toString();
				}
			}
		}
		
		return "";
	}
	

}
