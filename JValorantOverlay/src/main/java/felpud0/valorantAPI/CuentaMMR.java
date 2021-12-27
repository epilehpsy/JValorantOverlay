package felpud0.valorantAPI;

public class CuentaMMR extends Cuenta implements Comparable<CuentaMMR> {
	
	private final int currentTier;
	private final String currentTierPatch;
	private final int rankInTier;
	private final int mmrChangeLastGame;
	private final int elo;


	public CuentaMMR(int currentTier, String currentTierPatch,
			int rankInTier, int mmrChangeLastGame,
			int elo, String region, String name, String tag) {
		super(name, tag);
		this.currentTier = currentTier;
		this.currentTierPatch = currentTierPatch;
		this.rankInTier = rankInTier;
		this.mmrChangeLastGame = mmrChangeLastGame;
		this.elo = elo;
	}

	public int getCurrentTier() {
		return currentTier;
	}

	public String getCurrentTierPatch() {
		return currentTierPatch;
	}

	public int getRankInTier() {
		return rankInTier;
	}

	public int getMmrChangeLastGame() {
		return mmrChangeLastGame;
	}

	public int getElo() {
		return elo;
	}

	@Override
	public int compareTo(CuentaMMR o) {
		return ((Integer)elo).compareTo(o.getElo());
	}
	
	@Override
	public String toString() {
		return super.toString()+"("+ currentTierPatch+")";
	}
}
