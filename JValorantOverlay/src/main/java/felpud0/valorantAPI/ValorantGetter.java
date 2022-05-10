package felpud0.valorantAPI;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;


public class ValorantGetter {
	
	private String nick;
	private String tag;
	private String region;
	public final static String REGION_DEFAULT = "eu";
	public final static String URL_BASE = "https://api.henrikdev.xyz";
	
	public ValorantGetter(String nick, String tag, String region)  {
		
		this.nick=nick;
		this.tag=tag;
		this.region=region;
	}
	
	public ValorantGetter(String nick, String tag)  {
		
		this(nick, tag, REGION_DEFAULT);
	}
	
	public static ValorantGetter buildValorantGetter(String name, String tag, String region) {
		return new ValorantGetter(name,tag,region);
	}
	
	public static ValorantGetter buildValorantGetter(String nametag, String region) {
		
		Pattern p = Pattern.compile("(?<name>.+)#(?<tag>.{3,5})$");
		Matcher ma = p.matcher(nametag);
		
		if (!ma.find()) {
			//m.reply("Name:"+nametag+" haven't a correct format").queue();
			return null;
		}
		String name=ma.group("name");
		String tag=ma.group("tag");
		return buildValorantGetter(name, tag, region);
	}
	
	public static ValorantGetter buildValorantGetter(String nametag) {	
		return buildValorantGetter(nametag, REGION_DEFAULT);
	}
	public String getNameTag() {
		return nick+"#"+tag;
	}
	
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public static String stripAccents(String s) 
	{
	    s = Normalizer.normalize(s, Normalizer.Form.NFD);
	    s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
	    return s;
	}
	

	private static JsonNode getJSON(String endpoint) {
		
		String s = URL_BASE+endpoint;
		s = stripAccents(s);
		s= s.replace(' ', '_');
		
		URL url;
		try {
			url = new URL (s);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.addRequestProperty("User-Agent", 
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
			InputStream is =conn.getInputStream();
			String encoding = conn.getContentEncoding();
			encoding = encoding == null ? "UTF-8" : encoding;
			String body = IOUtils.toString(is, encoding);
			ObjectMapper m = new ObjectMapper();
			JsonNode tree = m.readTree(body);
			return tree;
			
		} catch (IOException e) {
			return null;
		}		
	}
	
	public CuentaStandard getAccountData() {
		
		JsonNode arbol = getJSON("/valorant/v1/account/"+nick+"/"+tag+"?force=true");
		if (arbol==null) return null; //E
		
		if (arbol.get("status").asInt()!=200) return null;
		
		JsonNode datos = arbol.get("data");
		return new CuentaStandard(datos.get("puuid").asText(), 
				datos.get("region").asText(),
				datos.get("account_level").asInt(), 
				datos.get("name").asText(),
				datos.get("tag").asText(),
				datos.get("card").get("small").asText());
		
	}
	
	public CuentaMMR getMMR() {
		JsonNode arbol = getJSON("/valorant/v2/mmr/"+region+"/"+nick+"/"+tag+"?force=true");
		if (arbol==null || arbol.isMissingNode()) return null;
		
		if (arbol.get("status").asInt()!=200) return null;
		
		JsonNode datos = arbol.get("data").get("current_data");
		int currenttier=datos.get("currenttier").asInt();
		return new CuentaMMR(currenttier, 
				datos.get("currenttierpatched").asText(), 
				datos.get("ranking_in_tier").asInt(), 
				datos.get("mmr_change_to_last_game").asInt(), 
				datos.get("elo").asInt(),region,nick,tag);
		
	}

	
	public HistorialPartidas getHistorialPartidas(String...filtro) {
		
		String opt;
		if (filtro.length>0) {
			opt="?filter="+filtro[0];
		}else opt="";
		JsonNode arbol = getJSON("/valorant/v3/matches/"+region+"/"+nick+"/"+tag+opt);
		if (arbol==null) return null;	
		
		if (arbol.get("status").asInt()!=200) return null;
		
		ArrayNode partidas = (ArrayNode) arbol.get("data");
		
		ArrayList<Partida> historial = new ArrayList<>();
		for (JsonNode partida : partidas) 
			historial.add(Partida.parsearJson(partida));
		
		return new HistorialPartidas(arbol.get("puuid").asText(), historial);
	}
	
	public int[] getHistorialMMR() {
		
		JsonNode arbol = getJSON("/valorant/v1/mmr-history/"+region+"/"+nick+"/"+tag);
		
		if (arbol==null) return null;	
		if (arbol.get("status").asInt()!=200) return null;
		ArrayNode a = (ArrayNode) arbol.get("data");
		int[] ret = new int[10];
		int i=0;
		for(JsonNode n : a) {
			ret[i]=n.get("mmr_change_to_last_game").asInt();
			i++;
		}
		
		return ret;
	}
	
	
	

	
	public static String storeOffers() {
		return null;
	}

}
