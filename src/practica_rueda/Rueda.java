
package practica_rueda;

/**
 * Clase que representa una rueda de un vehículo 
 */

public class Rueda {

    private int combustible_queda;// Indica la cantidad de combustible disponible 
    private double centimos_litro;// precio por litro de combustible
    private int capacidad;//capacidad depósito .Se supone que es litros.
    private int consumoTorresRuizDavid = 6;//litros a los cien
    /**
     * Obtiene la cantidad de combustible que queda.
     * @return combustible_queda La cantidad de combustible restante en litros.
     */
    public int getCombustible_queda() {
        return combustible_queda;
    }

    /**
     * Establece la cantidad de combustible que queda.
     * @param combustible_queda La nueva cantidad de combustible en litros.
     */
    public void setCombustible_queda(int combustible_queda) {
        this.combustible_queda = combustible_queda;
    }

    /**
     * Obtiene el precio por litro de combustible.
     * @return the centimos_litro El precio por litro de combustible en centimos.
     */
    public double getCentimos_litro() {
        return centimos_litro;
    }

    /**
     * Establece el precio por litro de combustible.
     * @param centimos_litro El nuevo precio por litro de combustible en centimos.
     */
    public void setCentimos_litro(double centimos_litro) {
        this.centimos_litro = centimos_litro;
    }

    /**
     * Obtiene la capacidad máxima del depósito
     * @return the capacidad La capacidad máxima del depósito en litros.
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Establece la capacidad máxima del depósito
     * @param capacidad La nueva capacidad máxima del depósito en litros.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Obtiene el consumo de combustible cada 100 km.
     * @return the consumoTorresRuizDavid El consumo de combustible por cada 100 km en litros.
     */
    public int getConsumoTorresRuizDavid() {
        return consumoTorresRuizDavid;
    }

    /**
     * Establece el consumo de combustible por cada 100 km.
     * @param consumoTorresRuizDavid El nuevo consumo de combustible por cada 100 km en litros.
     */
    public void setConsumoTorresRuizDavid(int consumoTorresRuizDavid) {
        this.consumoTorresRuizDavid = consumoTorresRuizDavid;
    }
    
  
    /**
     * Constructor por defecto de la clase Rueda.
     */
    public Rueda() {
    }

    /**
     * Constructor de la clase Rueda que permite inicializar los atributos.
     * @param combustible_queda La cantidad de combustible que queda en litros.
     * @param centimos_litro El precio por litro de combustible en centimos.
     * @param capacidad La capacidad máxima del depósito en litros.
     */   
    public Rueda(int combustible_queda, int centimos_litro, int capacidad) {
        this.combustible_queda = combustible_queda;
        this.centimos_litro = centimos_litro;
        this.capacidad = capacidad;
        
    }
    /**
     * Obtiene la cantidad de combustible que queda en la rueda.
     * @return La cantidad de combustible restante en litros.
     */
    public int getcombustible()
    {
        return(getCombustible_queda());
    }
    /**
     * Realiza un viaje reduciendo la cantidad de combustible según la distancia recorrida y el consumo.
     * @param km La distancia del viaje en kilómetros.
     * @throws Exception Si no hay suficiente combustible para la distancia especificada o la distancia no es positiva.
     */
    public void viaje(int km) throws Exception {
        
        if (km * this.getConsumoTorresRuizDavid()/100 > this.getCombustible_queda()) {
                throw new Exception("No hay suficiente combustible para esa distancia");
        }
        if (km <= 0) {
            throw new Exception("No tiene sentido recorrer una distancia que no sea positiva");
        }
        this.setCombustible_queda(this.getCombustible_queda() - (km * this.getConsumoTorresRuizDavid() / 100)); 
        
    }
     

        /**
     * Rellena el depósito de combustible de la rueda con una cantidad específica de litros y dinero.
     * @param litros La cantidad de litros de combustible a añadir al depósito.
     * @param dinero La cantidad de dinero disponible para comprar el combustible.
     * @throws Exception Si el dinero o la cantidad de litros no son suficientes, o si se supera la capacidad del depósito.
     */
      public void rellenar(int litros, double dinero) throws Exception {
            
        if ((dinero <= 0)  || (litros <= 0)){
            throw new Exception("No se puede rellenar el depósito.");
        }
       
        if (this.getCombustible_queda() + litros > getCapacidad()) {
            throw new Exception("No se puede rellenar, porque se supera la capacidad del depósito");
        }
        if (dinero < litros * getCentimos_litro()) {
            throw new Exception("No tiene dinero suficiente para rellenar el depósito.");
        }
        this.setCombustible_queda(this.getCombustible_queda() + litros);
        
    }

}


    
    
    

