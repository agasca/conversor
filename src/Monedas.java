public class Monedas {
    private String result;

    //constructor
    public Monedas(String result) {
        this.result = result;
    }

    public Monedas(Exchange miExchange){
        this.result = miExchange.result();
    }
    
    public Monedas(){ }

    //getter
    public String getResult() {
        return result;
    }

    //metodos
    @Override
    public String toString() {
        return "{result=" + result +"}";
    }
}
