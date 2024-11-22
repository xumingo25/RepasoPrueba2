package vista;

import controlador.TiendaCalzado;
import modelo.Deportivo;
import modelo.Hombre;
import modelo.Mujer;
import modelo.Producto;

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
                    codigoCalzado = pideCodigo(); //codigo
                    if(tiendaCalzado.buscarCalzado(codigoCalzado)==-1){
                        //no existe, solicito la info del calzado
                        System.out.println("¿Valor base?"); int valorBase = Leer.datoInt();
                        System.out.println("¿Stock?"); int stock = Leer.datoInt();
                        System.out.println("¿Nro Calzado?"); int numero = Leer.datoInt();

                        String diaVenta;
                        do{
                            System.out.println("¿Dia venta (Semana o Fin de semana)?");
                            diaVenta = Leer.dato(); //semana (7)
                        }while(diaVenta.compareToIgnoreCase("Semana")!=0 && //false
                        diaVenta.compareToIgnoreCase("Fin de semana") !=0); //

                        int respuesta;
                        do{
                            System.out.println("Favor indicare calzado: 1)Deportivo    2)Formal Hombre    3)Formal Mujer");
                            System.out.println("Favor ingrese una opción para continuar (1,2 o 3)");
                            respuesta = Leer.datoInt(); //2
                        }while(respuesta < 1 || respuesta >3);
                            // false         || false
                         if(respuesta==1){
                             //Deportivo
                             System.out.println("¿Tipo Deporte?"); String tipoDeporte = Leer.dato();

                             String tipoMaterial;
                             do{
                                 System.out.println("¿Tipo Material (Cuero o Lona)?");
                                 tipoMaterial = Leer.dato(); //semana (7)
                             }while(tipoMaterial.compareToIgnoreCase("Cuero")!=0 && //false
                                     tipoMaterial.compareToIgnoreCase("Lona") !=0);

                             Producto producto = new Producto(codigoCalzado,stock,valorBase);
                             Deportivo deportivo = new Deportivo(producto,diaVenta,numero,tipoDeporte,tipoMaterial);

                             tiendaCalzado.ingresarCalzadoDeportivo(deportivo);
                             System.out.println("Se registra calzado deportivo correctamente...");

                         }else{
                             //Formal
                             System.out.println("¿Color del calzado?"); String color = Leer.dato();

                             if(respuesta==2){
                                 tiendaCalzado.ingresarCalzadoHombre(new Hombre(new Producto(codigoCalzado,stock,valorBase),diaVenta,numero,color));
                                 System.out.println("Se registra calzado formal de hombre correctamente...");
                             }else{
                                 System.out.println("¿Altura taco?"); int alturaTaco = Leer.datoInt();
                                 tiendaCalzado.ingresarCalzadoMujer(new Mujer(new Producto(codigoCalzado,stock,valorBase),diaVenta,numero,color,alturaTaco));
                                 System.out.println("Se registra calzado formal de mujer correctamente...");
                             }
                         }

                    }else{
                        System.out.println("El codigo "+codigoCalzado + "pertenece a un calzado de la tienda..favor revisar..");
                    }
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
