package vista;

import controlador.TiendaCalzado;
import modelo.Deportivo;
import modelo.Hombre;
import modelo.Mujer;
import modelo.Producto;

import java.util.ArrayList;

public class App {
    public static int menu(){
        System.out.println("Tienda de Calzados");
        System.out.println("-----------------------");
        System.out.println("1.\tIngresar");
        System.out.println("2.\tMostrar sólo los calzado de mujer");
        System.out.println("3.\tValor Venta");
        System.out.println("4.\tCalzados top");
        System.out.println("5.\tTotal Impuesto Especifico");
        System.out.println("6.\tTotal descuento");
        System.out.println("7.\tSalir");

        return Leer.datoInt();
    }

    public static String pideCodigo(){
        System.out.println("Favor ingrese codigo de calzado...");
        return Leer.dato();
    }

    public static void main(String[] args) {
        //armar nuestra interfaz para el proximo martes
        int opcion;
        String codigoCalzado;

        //creación de la colección
        TiendaCalzado tiendaCalzado = new TiendaCalzado(new ArrayList<>());

        do{
            opcion = menu();

            switch (opcion) {
                case 1:
                    //1.	Ingresar
                    //El ingreso puede ser Calzado de mujer, hombre o deportivo y  no puede estar duplicado
                    codigoCalzado = pideCodigo();
                    if (tiendaCalzado.buscarCalzado(codigoCalzado) == -1) {
                        //Codigo no pertenece a ningun calzado...lo puedo ingresar

                    System.out.println("¿Stock");
                    int stock = Leer.datoInt();

                    System.out.println("¿Valor Base?");
                    int valorBase = Leer.datoInt();

                    String diaVenta; //Fin de semana
                    do {
                        System.out.println("¿Dia de venta? (ingrese 'Semana' o 'Fin de Semana')");
                        diaVenta = Leer.dato();
                    } while (diaVenta.compareToIgnoreCase("Semana") != 0 &&
                            diaVenta.compareToIgnoreCase("Fin de semana") != 0); //false

                    System.out.println("¿Numero?");
                    int numero = Leer.datoInt();

                    int respuesta;
                    do{
                        System.out.println("El calzado es: 1) Deportivo   2) Formal Hombre   3)Formal Mujer");
                        respuesta= Leer.datoInt();//3
                    }while(respuesta<1 || respuesta>3);
                            //false    || false
                                    //false

                    if(respuesta==1){
                        //deportivo
                        System.out.println("¿Tipo deporte?"); String tipoDeporte = Leer.dato();

                        String tipoMaterial; //Fin de semana
                        do {
                            System.out.println("¿tipo de material? (ingrese 'Cuero' o 'Lona')");
                            tipoMaterial = Leer.dato();
                        } while (tipoMaterial.compareToIgnoreCase("Cuero") != 0 &&
                                tipoMaterial.compareToIgnoreCase("Lona") != 0); //false

                        //Producto prod = new Producto(codigoCalzado,stock,valorBase);

                        //Deportivo deportivo = new Deportivo(prod,diaVenta,numero,tipoDeporte,tipoMaterial);

                        tiendaCalzado.ingresarCalzadoDeportivo(new Deportivo(new Producto(codigoCalzado,stock,valorBase),diaVenta,numero,tipoDeporte,tipoMaterial));
                        System.out.println("Se agrega calzado deportivo correctamente");
                    }else{ //2 o un 3
                        //puede ser formal de hombre o mujer
                        System.out.println("Favor ingrese color del calzado..."); String color = Leer.dato();

                        if(opcion==2){
                            //formal hombre
                            tiendaCalzado.ingresarCalzadoHombre(new Hombre(new Producto(codigoCalzado,stock,valorBase),diaVenta,numero,color));
                        }else{
                            //formal mujer
                            System.out.println("¿Altura de taco?"); int alturaTaco = Leer.datoInt();
                            tiendaCalzado.ingresarCalzadoMujer(new Mujer(new Producto(codigoCalzado,stock,valorBase),diaVenta,numero,color,alturaTaco));
                        }
                    }
                    }else{
                        System.out.println("el codigo "+codigoCalzado + " esta asociado a uno ya registrado");
                    }

                    break;
                case 2:
                    //2.	Mostrar sólo los calzado de mujer
                    System.out.println(tiendaCalzado.calzadosMujer());
                    break;
                case 3:
                    codigoCalzado = pideCodigo();
                    //3.	Valor Venta
                    System.out.println(tiendaCalzado.valorVenta(codigoCalzado));
                    break;
                case 4:
                    System.out.println(tiendaCalzado.calzadosTop());
                    //haremos la op 4
                    break;
                case 5:
                    //5.	Total Impuesto Especifico
                    System.out.println("El total de impuestos especificos si se vendieran todos los calzados" +
                            "de la tienda es de: $"+ tiendaCalzado.totalImpuestosEspecificos());
                    break;
                case 6:
                    //6.	Total descuento
                    System.out.println("El total de descuentos si se vendieran todos los calzados" +
                            "de la tienda es de: $"+ tiendaCalzado.totalDescuentos());
                    break;
            }
        }while(opcion!=7);
    }


}
