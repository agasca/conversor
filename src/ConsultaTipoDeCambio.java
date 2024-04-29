import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConsultaTipoDeCambio {
    
    
    public Rcd_RespEstructGral buscaTipoCambio(){
        //URL propia
        String clave = "d987371e09f1c8a8f2581542";
        String monedaBase = "USD";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+clave+"/latest/"+monedaBase+"/");
        
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
            HttpResponse<String> response = client 
                .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                //System.out.println(json);

            Gson gson = new GsonBuilder().create();
            Rcd_RespEstructGral responseDTO = gson.fromJson(json, Rcd_RespEstructGral.class);
                //System.out.println(responseDTO.conversion_rates().MXN);


            //return new Gson().fromJson(json, Exchange.class);  //Pelicula.class para que lo transforme
            return responseDTO;

        }catch(Exception e){
            throw new RuntimeException("//ConEx /No encontré el exchange...:\n" + e.getMessage());
            
        }        
    }
}

