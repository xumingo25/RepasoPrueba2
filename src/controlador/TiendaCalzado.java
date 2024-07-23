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
        for(int i=0;i< tiendaCalzado.size();i++){
            if(tiendaCalzado.get(i).getProducto().getCodigo().compareToIgnoreCase(codigo)==0){
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

    public String calzadosMujer(){
        return "los calzados de mujer son...";
    }

    public String valorVenta(){
        return "el valor de venta se viene...";
    }

    public String calzadosTop(){
        return "los calzados top son";
    }

    public int totalImpuestosEspecificos(){
        return 0;
    }

    public int totalDescuentos(){
        return 0;
    }

}
