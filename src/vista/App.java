package vista;

import modelo.Deportivo;
import modelo.Hombre;
import modelo.Mujer;
import modelo.Producto;

public class App {
    public static void main(String[] args) {
        Producto prod = new Producto("abc123", 0, 10000);
        Deportivo deportivo = new Deportivo(prod, "Semana", 44, "Futbol", "Cuero");
        Mujer mujer = new Mujer(prod, "Semana", 44, "Rojo", 12);
        Hombre hombre = new Hombre(prod, "Semana", 44, "Rojo");

        System.out.println("El valor venta del calzado deportivo es: $" + deportivo.valorVenta());

        System.out.println("El IVA del calzado deportivo es: $" + deportivo.impuestoIva());

        System.out.println("Impuesto especifico Calzado Mujer: $" + mujer.impuestoEspecifico());

        System.out.println("El Impuesto Material del calzado deportivo es: $" + deportivo.impuestoMaterial());

        System.out.println("El descuento calzado mujer es: $"+mujer.descuento());

        System.out.println("El descuento calzado hombre es: $"+hombre.descuento());

        System.out.println("Valor a pagar Calzado Mujer: "+mujer.valorACancelar());

        System.out.println("Valor a pagar Calzado Hombre: "+hombre.valorACancelar());

        System.out.println("Valor a pagar Calzado deportivo: "+deportivo.valorACancelar());

    }
}
