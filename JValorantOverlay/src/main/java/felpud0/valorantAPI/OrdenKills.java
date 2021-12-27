package felpud0.valorantAPI;

import java.util.Comparator;

public class OrdenKills implements Comparator<Jugador> {

	@Override
	public int compare(Jugador o1, Jugador o2) {
		return ((Integer)o2.getEstadisticas().getKills()).compareTo(o1.getEstadisticas().getKills());
	}
}
