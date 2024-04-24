public class Monedas {
    private String result;
    private int time_last_update_unix;
    private String time_last_update_utc;
    private int time_next_update_unix;
    private String time_next_update_utc;
    private String base_code;
    // private String conversion_rates;

    //constructor
    public Monedas(String result
                , int time_last_update_unix
                , String time_last_update_utc
                , int time_next_update_unix
                , String time_next_update_utc
                , String base_code
                // , String conversion_rates
                ) {
        this.result = result;
        this.time_last_update_unix = time_last_update_unix;
        this.time_last_update_utc = time_last_update_utc;
        this.time_next_update_unix = time_next_update_unix;
        this.time_next_update_utc = time_next_update_utc;
        this.base_code = base_code;
        // this.conversion_rates = conversion_rates;
    }

    public Monedas(String result) {
        this.result = result;
    }

    public Monedas(Exchange miExchange){
        this.result = miExchange.result();
        this.time_last_update_unix = Integer.valueOf(miExchange.time_last_update_unix());
        this.time_last_update_utc = miExchange.time_last_update_utc();
        this.time_next_update_unix = Integer.valueOf(miExchange.time_next_update_unix());
        this.time_next_update_utc = miExchange.time_next_update_utc();
        this.base_code = miExchange.base_code();
        // this.conversion_rates = miExchange.conversion_rates();
    }
    
    public Monedas(){ }

    //getter
    public String getResult() {
        return result;
    }
    public String getTime_last_update_unix() {
        return Integer.valueOf(time_last_update_unix);
    }
    public String getTime_last_update_utc() {
        return time_last_update_utc;
    }
    public String getTime_next_update_unix() {
        return time_next_update_unix;
    }
    public String getTime_next_update_utc() {
        return time_next_update_utc;
    }
    public String getBase_code() {
        return base_code;
    }
    // public String getConversion_rates() {
    //     return conversion_rates;
    // }
    
    //metodos
    @Override
    public String toString() {
        return "{result=" + result +
            "time_last_update_unix=" + time_last_update_unix +
            "time_last_update_utc=" + time_last_update_utc +
            "time_next_update_unix=" + time_next_update_unix +
            "time_next_update_utc=" + time_next_update_utc +
            "base_code=" + base_code +
            // "conversion_rates=" + conversion_rates +
        "}";
    }    
}