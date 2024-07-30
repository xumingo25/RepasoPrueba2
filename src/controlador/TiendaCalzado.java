package controlador;

import modelo.Calzado;
import modelo.Deportivo;
import modelo.Hombre;
import modelo.Mujer;

import java.util.ArrayList;

public class TiendaCalzado {
    //Atributos
    private ArrayList<Calzado> tiendaCalzado;

    //Métodos
    public TiendaCalzado(ArrayList<Calzado> tiendaCalzado) {
        this.tiendaCalzado = tiendaCalzado;
    }

    public ArrayList<Calzado> getTiendaCalzado() {
        return tiendaCalzado;
    }

    public void setTiendaCalzado(ArrayList<Calzado> tiendaCalzado) {
        this.tiendaCalzado = tiendaCalzado;
    }

    //Logica del negocio

    //El ingreso puede ser Calzado de mujer, hombre o deportivo y  no puede estar duplicado
    public int buscarCalzado(String codigo){     //cod 123sfsadf 123
        for(int i=0;i< tiendaCalzado.size();i++){ //recorrer la colección
            if(tiendaCalzado.get(i).getProducto().getCodigo().compareToIgnoreCase(codigo)==0){//defini una condición
                //encontro el objeto
                return i; //0
            }
        }
        return -1; //
    }

    //{objeto1,objeto2,objeto3,objeto4}
    //{   0   ,   1   ,   2   ,   3   }
    //{   M   ,   H   ,   D   ,   H   }
    //{  123  , asv2  , fsdf3 , re534 }

    //INGRESAR CALZADOS DE MUJER
    public void ingresarCalzadoMujer(Mujer mujer){
        if(this.buscarCalzado(mujer.getProducto().getCodigo())==-1){
            //Calzado no existe
            tiendaCalzado.add(mujer);
        }
    }

    //INGRESAR CALZADOS DE Hombre
    public void ingresarCalzadoHombre(Hombre hombre){
        if(this.buscarCalzado(hombre.getProducto().getCodigo())==-1){
            //Calzado no existe
            tiendaCalzado.add(hombre);
        }
    }

    //INGRESAR CALZADOS Deportivo
    public void ingresarCalzadoDeportivo(Deportivo deportivo){
        if(this.buscarCalzado(deportivo.getProducto().getCodigo())==-1){
            //Calzado no existe
            tiendaCalzado.add(deportivo);
        }
    }

    //{objeto1,objeto2,objeto3,objeto4}
    //{   0   ,   1   ,   2   ,   3   }
    //{   M   ,   H   ,   D   ,   M   }
    //{  123  , asv2  , fsdf3 , re534 }

    public String calzadosMujer(){
        String mensaje ="";
        Mujer mujer = null;

        for(int i=0;i<tiendaCalzado.size();i++){ //Recorrer la colección
            if(tiendaCalzado.get(i) instanceof Mujer) { //definir una condición
                mujer = (Mujer) tiendaCalzado.get(i);

                mensaje = mensaje + "\n Dia venta: "+mujer.getDiaVenta()+ " , altura de taco: "+
                        mujer.getAlturaTaco()+ " y descuento: $"+mujer.descuento();
            }
        }
        if(mensaje.equalsIgnoreCase("")){
            mensaje = "No hay calzados de mujer registrados. favor ingrese calzado";
        }

        return mensaje;
    }

    public String valorVenta(String codigo){
        for(int i=0;i<tiendaCalzado.size();i++) { //Recorrer la colección
            //    lista     .objeto.atributo.subatributo
            if(tiendaCalzado.get(i).getProducto().getCodigo().compareToIgnoreCase(codigo)==0){ //
                //existe el calzado
                return "el valor de venta del calzado es: $"+tiendaCalzado.get(i).valorVenta() +
                        " y el nro de calzado es: "+tiendaCalzado.get(i).getNumero();
            }
        }
        return "el codigo "+codigo + " no se encuentra asociado a ningun calzado. ¿Desea ingresarlo?";
    }

    public String calzadosTop(){
        int suma=0;

        for(int i=0;i<tiendaCalzado.size();i++) { //Recorrer la colección
            if(tiendaCalzado.get(i).valorVenta()>80000){
                //es un calzado top
                suma = suma + tiendaCalzado.get(i).getProducto().getStock();
            }
        }
        return "tienes "+suma + " calzados top (precio mayor a $80.000)";
    }


    //{objeto1,objeto2,objeto3,objeto4}
    //{   0   ,   1   ,   2   ,   3   }
    //{   M   ,   H   ,   D   ,   M   }
    //{  123  , asv2  , fsdf3 , re534 }

    public int totalImpuestosEspecificos(){
        int totalImpuestos = 0;
        Mujer mujer = null;
        Hombre hombre = null;
        for(int i=0;i<tiendaCalzado.size();i++) { //Recorrer la colección
            if(tiendaCalzado.get(i) instanceof Mujer){
                //es un objeto de dicha clase
                mujer = (Mujer) tiendaCalzado.get(i);
                totalImpuestos = totalImpuestos + (mujer.impuestoEspecifico() * mujer.getProducto().getStock());
            }else if(tiendaCalzado.get(i) instanceof Hombre){
                hombre = (Hombre) tiendaCalzado.get(i);
                totalImpuestos = totalImpuestos + (hombre.impuestoEspecifico() * hombre.getProducto().getStock());
            }
        }
            return totalImpuestos;
    }

    public int totalDescuentos(){
        int totalDescuentos = 0;
        Mujer mujer = null;
        Hombre hombre = null;
        for(int i=0;i<tiendaCalzado.size();i++) { //Recorrer la colección
            if(tiendaCalzado.get(i) instanceof Mujer){
                //es un objeto de dicha clase
                mujer = (Mujer) tiendaCalzado.get(i);
                totalDescuentos = totalDescuentos + (mujer.descuento() * mujer.getProducto().getStock());
            }else if(tiendaCalzado.get(i) instanceof Hombre){
                hombre = (Hombre) tiendaCalzado.get(i);
                totalDescuentos = totalDescuentos + (hombre.descuento() * hombre.getProducto().getStock());
            }
        }
        return totalDescuentos;
    }





}
