package APIs;

import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

public class APImonedas {
	public String miPais = "";
	public String miMoneda = "";
	public double precioConversion;
	
	private String cntJson = "";
	
	public void ConsumoAPI(String enlace) {
		try {
			
			URL url = new URL(enlace);
			HttpsURLConnection cx = (HttpsURLConnection) url.openConnection();
			cx.setRequestMethod("GET");
			
			InputStream strm = cx.getInputStream();
			byte[] arrStream = strm.readAllBytes();
			
			for(byte tmp: arrStream) {
				cntJson += (char)tmp;
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	
	public void MiUbicacionMoneda() {
		try {
			
			JSONObject json = new JSONObject(cntJson);
			miPais = json.getString("iso2");
			miMoneda = json.getString("currency");  
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public String PrecioMonedaConversion(String monedaConversion) {
		String precio = "";
		try {
			
			JSONObject json = new JSONObject(cntJson);
			precio = (new JSONObject(((JSONObject)json).get("rates").toString()).get(monedaConversion).toString()).toString(); 
		
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		return precio;
	}
}
