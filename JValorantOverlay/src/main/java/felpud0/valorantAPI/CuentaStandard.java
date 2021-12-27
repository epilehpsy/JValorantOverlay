package felpud0.valorantAPI;

public class CuentaStandard extends Cuenta {

	private final String puuid;
	private final int level;
	private final String region;
	private final String tarjeta;
	public CuentaStandard(String puuid, String region, int level, String name, String tag, String tarjeta) {
		super(name, tag);
		this.puuid=puuid;
		this.level=level;
		this.region=region;
		this.tarjeta=tarjeta;
	}
	
	public String getPuuid() {
		return puuid;
	}
	
	public int getLevel() {
		return level;
	}

	public String getRegion() {
		return region;
	}

	public String getTarjeta() {
		return tarjeta;
	}

}
