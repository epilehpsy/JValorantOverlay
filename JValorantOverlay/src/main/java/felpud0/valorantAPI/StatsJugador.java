package felpud0.valorantAPI;

import com.fasterxml.jackson.databind.JsonNode;

public class StatsJugador implements Comparable<StatsJugador> {
	
	private final int score;
	private final int kills;
	private final int deaths;
	private final int assists;
	
	public StatsJugador(int score, int kills, int deaths, int assists) {
		this.score = score;
		this.kills = kills;
		this.deaths = deaths;
		this.assists = assists;
	}

	public int getScore() {
		return score;
	}

	public int getKills() {
		return kills;
	}

	public int getDeaths() {
		return deaths;
	}

	public int getAssists() {
		return assists;
	}
	
	public String kdaBonito() {
		
		return String.join("/", String.valueOf(kills),String.valueOf(deaths),String.valueOf(assists));
	}
	
	public String kdaYScore() {
		return kdaBonito()+" "+score;
	}
	
	public static StatsJugador parsearJson(JsonNode stats) {
		
		return new StatsJugador(stats.get("score").asInt(),
				stats.get("kills").asInt(),
				stats.get("deaths").asInt(),
				stats.get("assists").asInt());
	}

	@Override
	public int compareTo(StatsJugador o) {
		return ((Integer) score).compareTo(o.getScore());
	}
	
	
	
	
}
