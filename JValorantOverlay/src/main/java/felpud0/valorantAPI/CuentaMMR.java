package felpud0.valorantAPI;

public class CuentaMMR extends Cuenta implements Comparable<CuentaMMR> {
	
	public static String[] fotosRango = {
			"none",
			"https://static.wikia.nocookie.net/valorant/images/7/7f/TX_CompetitiveTier_Large_3.png/",
			"https://static.wikia.nocookie.net/valorant/images/2/28/TX_CompetitiveTier_Large_4.png",
			"https://static.wikia.nocookie.net/valorant/images/b/b8/TX_CompetitiveTier_Large_5.png/",
			"https://static.wikia.nocookie.net/valorant/images/a/a2/TX_CompetitiveTier_Large_6.png/",
			"https://static.wikia.nocookie.net/valorant/images/e/e7/TX_CompetitiveTier_Large_7.png",
			"https://static.wikia.nocookie.net/valorant/images/a/a8/TX_CompetitiveTier_Large_8.png",
			"https://static.wikia.nocookie.net/valorant/images/0/09/TX_CompetitiveTier_Large_9.png/",
			"https://static.wikia.nocookie.net/valorant/images/c/ca/TX_CompetitiveTier_Large_10.png/",
			"https://static.wikia.nocookie.net/valorant/images/1/1e/TX_CompetitiveTier_Large_11.png/",
			"https://static.wikia.nocookie.net/valorant/images/9/91/TX_CompetitiveTier_Large_12.png/",
			"https://static.wikia.nocookie.net/valorant/images/4/45/TX_CompetitiveTier_Large_13.png/",
			"https://static.wikia.nocookie.net/valorant/images/c/c0/TX_CompetitiveTier_Large_14.png/",
			"https://static.wikia.nocookie.net/valorant/images/d/d3/TX_CompetitiveTier_Large_15.png/",
			"https://static.wikia.nocookie.net/valorant/images/a/a5/TX_CompetitiveTier_Large_16.png/",
			"https://static.wikia.nocookie.net/valorant/images/f/f2/TX_CompetitiveTier_Large_17.png/",
			"https://static.wikia.nocookie.net/valorant/images/b/b7/TX_CompetitiveTier_Large_18.png/",
			"https://static.wikia.nocookie.net/valorant/images/3/32/TX_CompetitiveTier_Large_19.png/",
			"https://static.wikia.nocookie.net/valorant/images/1/11/TX_CompetitiveTier_Large_20.png/",
			"https://static.wikia.nocookie.net/valorant/images/f/f9/TX_CompetitiveTier_Large_21.png/",
			"https://static.wikia.nocookie.net/valorant/images/2/24/TX_CompetitiveTier_Large_24.png/",
	};
	
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
	
	public String getRankImg() {
		return fotosRango[currentTier-3];
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
