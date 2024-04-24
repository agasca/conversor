public record Exchange(
    String result
    , String time_last_update_unix
    , String time_last_update_utc
    , String time_next_update_unix
    , String time_next_update_utc
    , String base_code
    // , String conversion_rates
    )
    { }
//DTO
//recibimos jSon en String