import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.FieldNamingPolicy;

public class ConsultaExchange {
    Gson gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .setPrettyPrinting()
        .create();        

    public Exchange buscaExchange(){
        //URL propia
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
                String json = response.body();
                //System.out.println(json);

            //debajo no opera, debe cambiar de gson -> new Gson()
            //Exchange miExchange = gson.fromJson(json, Exchange.class);
            Exchange miExchange = new Gson().fromJson(json, Exchange.class);
                System.out.println("miExhange...:\n"+miExchange.toString());



            //Gson gson1 = new Gson();
            // // ExchangeRate miExchangeRate = new TypeToken<Map<String, conversion_rates>>() {}.getType();
            // // Map<String, conversion_rates> nameExchangeRateMap = gson1.fromJson(json, miExchangeRate);
            // // System.out.println(nameExchangeRateMap);
            
            //ExchangeRate exchangeRate = gson1.fromJson(json, ExchangeRate.class);
            //ExchangeRate exchangeRate =  new Gson().fromJson(json, ExchangeRate.class);
                //System.out.println(exchangeRate.toString());





            return new Gson().fromJson(json, Exchange.class);  //Pelicula.class para que lo transforme

        }catch(Exception e){
            throw new RuntimeException("//ConEx /No encontré el exchange...:\n" + e.getMessage());
            
        }        
    }
}
