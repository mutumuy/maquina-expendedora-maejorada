public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    private boolean billeteConPremio;
    private int numeroMaximoBilletes;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean premio, int numeroBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        billeteConPremio = premio;
        numeroMaximoBilletes = numeroBilletes;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if(numeroMaximoBilletes > 0){
            if(cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;                  
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }   
        }
        else{
            System.out.println("N�mero de billetes maximos superado");      
        }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        if(numeroMaximoBilletes > 0){
            if(balanceClienteActual >= precioBillete) {        
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();         
                
                numeroMaximoBilletes -= 1; 
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                if(billeteConPremio){
                    System.out.println("##################");
                    System.out.println("# Billete de tren:");
                    System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                    System.out.println("# " + precioBillete + " euros.");
                    System.out.println("##################");
                    System.out.println();
                    
                    numeroMaximoBilletes -= 1;
                }
            }
            else {
                System.out.println("Necesitas introducir " + (precioBillete - balanceClienteActual) + " euros mas!");
                        
            } 
        }
        else{
            System.out.println("N�mero de billetes maximos superado");
        }
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero()
    {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
    
    public int vaciarDineroMaquina() {
        int dineroADevolver = -1;
        if (balanceClienteActual == 0){
            //No hay operacion en curso
            dineroADevolver = totalDineroAcumulado;
            totalDineroAcumulado = 0;
        }
        else {
            //No hay una operacion en curso
            System.out.println("Hay una operacion en curso");
        }
        return dineroADevolver;
    }
}