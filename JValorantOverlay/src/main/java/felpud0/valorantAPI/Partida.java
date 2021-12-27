package felpud0.valorantAPI;



import com.fasterxml.jackson.databind.JsonNode;

public abstract class Partida {
	
	private final DatosPartida metadatos;
	//private final List<Equipo> equipos;
	
	
	public Partida(DatosPartida metadatos) {
		super();
		this.metadatos = metadatos;
	}


	public DatosPartida getMetadatos() {
		return metadatos;
	}


	
	public static Partida parsearJson(JsonNode partida) {
		
		JsonNode nMet = partida.get("metadata");

		
		DatosPartida metadata = DatosPartida.parsearJson(nMet);
		
		switch (metadata.getModo()) {
		case "Deathmatch":
			return PartidaDeathmatch.parsearJson(metadata, partida);			
		
		case "Competitive":
			return PartidaNormal.parsearJson(metadata, partida);

		default:
			return PartidaNormal.parsearJson(metadata, partida);
		}
		
	}
	
	abstract String datosJugador(String puuid);
	
	public String resumen(String puuid) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("[").append(metadatos.getModo()).append("] ");
		sb.append(metadatos.getMap());
		sb.append(datosJugador(puuid));
		sb.append(" Dur: ").append((int) metadatos.getDuracion()).append("min.");

		return sb.toString();
	}
	
	
	
}
