import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.FieldNamingPolicy;

//jSon
// import java.io.InputStream;
// import java.io.InputStreamReader;
// import java.net.HttpURLConnection;
// import com.google.gson.JsonElement;
// import com.google.gson.JsonObject;
// import com.google.gson.JsonParser;
// import java.net.URL;

public class ConsultaExchange {
    Gson gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .setPrettyPrinting()
        .create();        

    public Exchange buscaExchange(){
        //propia url
        String clave = "d987371e09f1c8a8f2581542";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+clave+"/latest/USD");
        //System.out.println(direccion);
        
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
            HttpResponse<String> response = client 
                .send(request, HttpResponse.BodyHandlers.ofString());
                //System.out.println("ini.Valida en pantalla solicitud/request");
                //captura a variable
                String json = response.body();
                //    System.out.println("jSon...:\n" + json);
            
                //Exchange miExchange = gson.fromJson(json, Exchange.class);
                //Exchange miExchange = gson.fromJson(jsonObject, Exchange.class);
                Exchange miExchange = new Gson().fromJson(json, Exchange.class);
                    System.out.println("miExhange...:\n"+miExchange.toString());
                    
            // // De esta forma si Acceso al object pero sin utilizar clase record Exchange.class
            // // Convert to JSON
            // JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            // //JsonObject jsonObject = JsonParser.parseString(jsonObject).getAsJsonObject();
            // //System.out.println("jsonObject"+jsonObject);
            // String req_result = jsonObject.get("result").getAsString();     
            //     System.out.println("result...:" + req_result);
            // req_result = jsonObject.get("time_last_update_unix").getAsString();     
            //     System.out.println("time...:" + req_result);            

            

                        
            //return new Gson().fromJson(response.body(), Exchange.class);  //Pelicula.class para que lo transforme
            return new Gson().fromJson(json, Exchange.class);  //Pelicula.class para que lo transforme
            //}catch(IOException | InterruptedException e){
        }catch(Exception e){
            throw new RuntimeException("//ConEx /No encontré el exchange...:\n" + e.getMessage());
        }        
    }
}
