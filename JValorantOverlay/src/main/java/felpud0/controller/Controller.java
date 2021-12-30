package felpud0.controller;

import felpud0.valorantAPI.CuentaMMR;
import felpud0.valorantAPI.CuentaStandard;
import felpud0.valorantAPI.HistorialPartidas;
import felpud0.valorantAPI.ValorantGetter;

public class Controller {
	
	static private Controller unicaInstancia=null;
	
	private ValorantGetter player;
	
	private Controller() {
	}
	
	public static Controller getController() {
		
		if (unicaInstancia==null)
			unicaInstancia=new Controller();
		
		return unicaInstancia;
	}
	
	public ValorantGetter stablishPlayer(String nametag) {
		
		player = ValorantGetter.buildValorantGetter(nametag);
		return player;
	}
	
	public ValorantGetter stablishPlayer(String name, String tag) {
		
		player = ValorantGetter.buildValorantGetter(name+'#'+tag);
		return player;
	}
	
	public boolean isStablish() {
		if (player==null)
			return false;
		return true;
	}
	
	public CuentaStandard accountInfo() {
		return player.getAccountData();
	}
	
	public CuentaMMR mmrInfo() {
		return player.getMMR();
	}
	
	public HistorialPartidas gameHistory() {
		
		return player.getHistorialPartidas();
	}
	
	public HistorialPartidas rankedGameHistory() {
		
		return player.getHistorialPartidas("competitive");
	}
	
	public ValorantGetter getVG() {
		return player;
	}
	
}
