
public class Principal {
    //public static void main(String[] args) throws IOException {
    public static void main(String[] args) {
        
        try {
            System.out.println("hello...:\n");
            ConsultaExchange consulta = new ConsultaExchange();
            Exchange datos = consulta.buscaExchange();
                System.out.println(datos.result());
        } catch (Exception e) {
            System.out.println("//Prin  /Error...:\n" + e.getMessage());
        }
    }
}
