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

    //funciones de negocio
    //{objeto1,objeto2,objeto3,objeto4} //fsdafsdaads
    //{Mujer  ,Deport , Hombre, Mujer }
    //{12345  ,sdfgsda,3454w  ,fsdfsd }
    //{  0    ,   1   ,   2   ,  3
    //   -1
    public int buscarCalzado(String codigoCalzado) {//fsdfsd
        for (int i = 0; i < tiendaCalzado.size(); i++) {
            //lista.elemento.caracteristica cumple criterio
            if (tiendaCalzado.get(i).getProducto().getCodigo().compareToIgnoreCase(codigoCalzado) == 0) {
                //encontre el calzado
                return i; //3
            }
        }
        return -1;
    }

    public void ingresarCalzadoMujer(Mujer mujer){
        if(this.buscarCalzado(mujer.getProducto().getCodigo())==-1){
            //no existe
            tiendaCalzado.add(mujer);
        }
    }

    public void ingresarCalzadoHombre(Hombre hombre){
        if(this.buscarCalzado(hombre.getProducto().getCodigo())==-1){
            //no existe
            tiendaCalzado.add(hombre);
        }
    }

    public void ingresarCalzadoDeportivo(Deportivo deportivo){
        if(this.buscarCalzado(deportivo.getProducto().getCodigo())==-1){
            //no existe
            tiendaCalzado.add(deportivo);
        }
    }

    //2.	Mostrar sólo los calzado de mujer
    //En opción 2, debe mostrar Día de venta, altura de taco y descuento.
    public String calzadosMujer(){
        //recorrer la lista
        String mensaje = "";
        Mujer mujer = null;
        for(int i=0;i<tiendaCalzado.size();i++){
            //definir una estructura de control
            if(tiendaCalzado.get(i) instanceof Mujer){
                mujer = (Mujer) tiendaCalzado.get(i);
                mensaje = mensaje + "\ndia de venta: "+ mujer.getDiaVenta()+
                        " ,Altura taco: "+ mujer.getAlturaTaco() + " y descuento: $" +
                        mujer.descuento();
            }
        }
        return mensaje;      //mostrar info
    }
}
