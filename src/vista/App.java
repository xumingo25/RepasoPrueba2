package vista;

import modelo.*;

public class App {
    public static void main(String[] args) {
        Producto prod = new Producto("ABC123",10,10000);

        Deportivo deportivo = new Deportivo(prod,"Semana",44,"Rugby","otra cosa");

        Hombre hombre = new Hombre(prod,"Fin de semana",40,"verde");

        Mujer mujer = new Mujer(prod,"Fin de semana",36,"rosa",15);


        System.out.println("valor a pagar calzado deportivo $"+deportivo.valorAPagar());
        System.out.println("valor a pagar calzado formal mujer $"+mujer.valorAPagar());
        System.out.println("valor a pagar calzado formal hombre $"+hombre.valorAPagar());



    }
}
