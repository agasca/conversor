import java.util.Scanner;
import java.util.InputMismatchException;

public class Principal {
    //public static void main(String[] args) throws IOException {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        var  busqueda = 1;
        while(busqueda !=7){ 
            System.out.println("******************************MENU*****************************");
            System.out.println("Sea bienvenido/ al Convrsor de moneda...:\n");
            System.out.println("1) Dólar a Peso Argentino");
            System.out.println("2) Peso Argentino a Dolar");
            System.out.println("3) Dolar a Real brasileño");
            System.out.println("4) Real brasileño a Dólar");
            System.out.println("5) Dólar a Peso colombiano");
            System.out.println("6) Peso colombiano a Dólar");
            System.out.println("7) Salir\n");
            System.out.print("Elija una opción válida...: ");
            try {
                busqueda = Integer.parseInt(lectura.nextLine());            
                System.out.println("****************************************************************"+busqueda);
                if(busqueda > 0){
                    if (busqueda < 7){
                        System.out.println("******************************0000*****************************");
                        ConsultaExchange consulta = new ConsultaExchange();
                        ConsultaTipoDeCambio tipoCambio = new ConsultaTipoDeCambio();
                            switch (busqueda) {
                                case 1: 
                                    Exchange datos = consulta.buscaExchange("USD");
                                    Rcd_RespEstructGral monedaTC = tipoCambio.buscaTipoCambio("USD");
                                    System.out.println("Estado de la conexión...:" + datos.result()+"\n");
                                    System.out.println("Tipo de cambio Dólar a Peso Argentino (USD-ARS)...:"+monedaTC.conversion_rates().USD / monedaTC.conversion_rates().ARS);
                                break;
                                case 2: 
                                    datos = consulta.buscaExchange("ARS");
                                    monedaTC = tipoCambio.buscaTipoCambio("ARS");
                                    System.out.println("Estado de la conexión...:" + datos.result()+"\n");                            
                                    System.out.println("Tipo de cambio de Peso Argentino a Dólas (ARS-USD)...:"+monedaTC.conversion_rates().ARS * monedaTC.conversion_rates().USD);
                                    break;

                                case 3: 
                                    datos = consulta.buscaExchange("USD");
                                    monedaTC = tipoCambio.buscaTipoCambio("USD");
                                    System.out.println("Estado de la conexión...:" + datos.result()+"\n");
                                    System.out.println("Tipo de cambio de Dólar a Real Brasileño (USD-BRL)...:"+monedaTC.conversion_rates().USD / monedaTC.conversion_rates().BRL);
                                    break;
                                case 4: 
                                    datos = consulta.buscaExchange("BRL");
                                    monedaTC = tipoCambio.buscaTipoCambio("BRL");
                                    System.out.println("Estado de la conexión...:" + datos.result()+"\n");                            
                                    System.out.println("Tipo de cambio de Real Brasileño a Dólar (BRL-USD)...:"+monedaTC.conversion_rates().BRL * monedaTC.conversion_rates().USD);
                                    break;
                                case 5: 
                                    datos = consulta.buscaExchange("USD");
                                    monedaTC = tipoCambio.buscaTipoCambio("USD");
                                    System.out.println("Estado de la conexión...:" + datos.result()+"\n");                                                        
                                    System.out.println("Tipo de cambio de Dólar a Peso Colombiano (USD-COP)...:"+monedaTC.conversion_rates().USD / monedaTC.conversion_rates().COP);
                                    break;
                                case 6: 
                                    datos = consulta.buscaExchange("COP");
                                    monedaTC = tipoCambio.buscaTipoCambio("COP");
                                    System.out.println("Estado de la conexión...:" + datos.result()+"\n");                                                        
                                    System.out.println("Tipo de cambio PEso Colombiano a Dólar (COP-USD)...:"+monedaTC.conversion_rates().COP * monedaTC.conversion_rates().USD);
                                    break;
                                default:
                                    break;
                            }
                            System.out.println("\n Tipos de cambio de varaias monedas******************************");
                            Exchange datos = consulta.buscaExchange("USD");
                            Rcd_RespEstructGral monedaTC = tipoCambio.buscaTipoCambio("USD");
                            System.out.println("ARS...:"+monedaTC.conversion_rates().ARS);
                            System.out.println("BOB...:"+monedaTC.conversion_rates().BOB);                
                            System.out.println("BRL...:"+monedaTC.conversion_rates().BRL);
                            System.out.println("CPL...:"+monedaTC.conversion_rates().CPL);
                            System.out.println("COP...:"+monedaTC.conversion_rates().COP);
                            System.out.println("USD...:"+monedaTC.conversion_rates().USD);
                            System.out.println("MXN...:"+monedaTC.conversion_rates().MXN);
                            System.out.println("******************************0000*****************************\n");
                        // //System.out.println(monedaTC.conversion_rates());
                        // //System.out.println(monedaTC.conversion_rates().MXN);
                    }
                    System.out.print("...");
                }
                System.out.println("Ready...");
            }            
            catch (Exception e) {
                System.out.println("Error: Solo es posible la captura de un número...:\n" );
                //+ e.getMessage());
            }
        }
        lectura.close();
        System.out.println("Gracias Alura & Orcale One");
        System.out.println("Fin");
    }
}