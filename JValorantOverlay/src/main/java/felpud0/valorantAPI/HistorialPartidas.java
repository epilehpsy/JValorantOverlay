package felpud0.valorantAPI;

import java.util.List;


public class HistorialPartidas {
	
	private final String puuid;
	private final List<Partida> partidas;
	
	public HistorialPartidas(String puuid, List<Partida> partidas) {
		super();
		this.puuid = puuid;
		this.partidas = partidas;
	}

	public String getPuuid() {
		return puuid;
	}

	public List<Partida> getPartidas() {
		return partidas;
	}
	

}
