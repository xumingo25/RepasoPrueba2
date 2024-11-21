package vista;

import controlador.TiendaCalzado;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        int opcion;
        String codigoCalzado;

        TiendaCalzado tiendaCalzado = new TiendaCalzado(new ArrayList<>()); //colección que almacena 0 calzados

        do{
            opcion = menu();

            switch (opcion){
                case 1:
                    System.out.println("Opción 1");
                    break;
                case 2:
                    System.out.println(tiendaCalzado.calzadosMujer());
                    break;
                case 3:
                    String codigoSolicitado = pideCodigo();
                    System.out.println(tiendaCalzado.valorVenta(codigoSolicitado));
                    break;
                case 4:
                    System.out.println(tiendaCalzado.calzadosTop());
                    break;
                case 5:
                    System.out.println("el total de impuestos especificos si se vendieran todos los calzados es: $"+tiendaCalzado.totalImpuestosEspecificos());
                    break;
                case 6:
                    System.out.println("el total de descuentos si se vendieran todos los calzados es: $"+tiendaCalzado.totalDescuentos());
                    break;
            }

        }while(opcion!=7);
    }

    public static String pideCodigo(){
        System.out.println("Favor ingrese codigo de calzado...");
        return Leer.dato();
    }

    public static int menu(){
        System.out.println("---- Sistema tienda de calzados ----");
        System.out.println("------------------------------------");
        System.out.println("1.\tIngresar Calzado (Deportivo, Formal de hombre o Mujer)");
        System.out.println("2.\tMostrar sólo los calzado de mujer");
        System.out.println("3.\tValor Venta calzado ");
        System.out.println("4.\tCalzados top (Valor venta mayor a $80.000)");
        System.out.println("5.\tTotal Impuesto Especificos de la tienda");
        System.out.println("6.\tTotal descuentos de la tienda");
        System.out.println("7.\tSalir.");
        System.out.println("------------------------------------");
        System.out.println("Favor ingrese una opción para continuar...");
        return Leer.datoInt();
    }


}
