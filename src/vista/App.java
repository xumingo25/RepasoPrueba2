package vista;

import controlador.TiendaCalzado;
import modelo.*;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Producto prod = new Producto("ABC123",10,10000);
        Producto prod2 = new Producto("ABC1234",10,10000);

        Producto prod3 = new Producto("ABCD123",10,10000);

        Deportivo deportivo = new Deportivo(prod,"Semana",44,"Rugby","otra cosa");

        Hombre hombre = new Hombre(prod3,"Fin de semana",40,"verde");

        Mujer mujer = new Mujer(prod2,"Fin de semana",36,"rosa",15);




        TiendaCalzado tiendaCalzado = new TiendaCalzado(new ArrayList<>());

        System.out.println("La colección tiene "+ tiendaCalzado.getTiendaCalzado().size() + " elementos");

        //System.out.println("valor a pagar calzado deportivo $"+deportivo.valorAPagar());
        //System.out.println("valor a pagar calzado formal mujer $"+mujer.valorAPagar());
        //System.out.println("valor a pagar calzado formal hombre $"+hombre.valorAPagar());

        tiendaCalzado.ingresarCalzadoDeportivo(deportivo);
        System.out.println("La colección tiene "+ tiendaCalzado.getTiendaCalzado().size() + " elementos");

        tiendaCalzado.ingresarCalzadoMujer(mujer);
        System.out.println("La colección tiene "+ tiendaCalzado.getTiendaCalzado().size() + " elementos");

        tiendaCalzado.ingresarCalzadoHombre(hombre);
        System.out.println("La colección tiene "+ tiendaCalzado.getTiendaCalzado().size() + " elementos");
    }
}
