package felpud0.valorantAPI;

public abstract class Cuenta {
	
	private final String name;
	private final String tag;
	

	public Cuenta(String name, String tag) {
		this.name=name;
		this.tag=tag;
	}




	public String getName() {
		return name;
	}

	public String getTag() {
		return tag;
	}
	
	@Override
	public String toString() {
		return name+"#"+tag;
	}


}
