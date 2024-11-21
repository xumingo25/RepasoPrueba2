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
        if(mensaje.equalsIgnoreCase("")){
            mensaje = "no hay calzados de mujer";
        }
        return mensaje;      //mostrar info
    }

    //3.	Valor Venta
    //En Valor Venta mostrará el valor Venta y número del calzado de uno en particular.
    public String valorVenta(String codigo){
        for(int i=0;i<tiendaCalzado.size();i++){
            //Lista          Objeto.atributo
            if(tiendaCalzado.get(i).getProducto().getCodigo().compareToIgnoreCase(codigo)==0){
                return "El valor venta del calzado es: $"+tiendaCalzado.get(i).valorVenta()
                        + "  y el nro de calzado es: "+tiendaCalzado.get(i).getNroCalzado();

            }
        }

        return "El codigo "+codigo + " no pertenece a ningun calzado :/";
    }

    //4.	Calzados top
    //En Calzados top mostrará la cantidad de calzados cuyo valorVenta sea mayor a $80000

    //funciones de negocio
    //{objeto1,objeto2,objeto3,objeto4} //fsdafsdaads
    //{Mujer  ,Deport , Hombre, Mujer }
    //{100000  ,30000,70000  ,250000 }
    //{  5    ,   10   ,   3   ,  4

    public String calzadosTop(){
        int suma = 0;
        for(int i=0;i<tiendaCalzado.size();i++){
            if(tiendaCalzado.get(i).valorVenta()>80000){
                suma = suma + tiendaCalzado.get(i).getProducto().getStock();
            }
        }
        return "La cantidad de calzados top (mayor a $80.000) es: "+suma;
        //el total de calzados top de la tienda es "variable"
    }

    //5.	Total Impuesto Especifico
    //En opción 5 mostrará el total de impuesto específico si se vendieran todos los calzados
    public int totalImpuestosEspecificos(){
        Mujer mujer;
        Hombre hombre;
        int total = 0;
        for(int i=0;i<tiendaCalzado.size();i++){
            if(tiendaCalzado.get(i) instanceof Mujer){
                mujer = (Mujer) tiendaCalzado.get(i);
                total = total + (mujer.impuestoEspecifico() * mujer.getProducto().getStock());
            }else if(tiendaCalzado.get(i) instanceof  Hombre){
                hombre = (Hombre) tiendaCalzado.get(i);
                total = total + (hombre.impuestoEspecifico() * hombre.getProducto().getStock());
            }
        }
        return total;
    }

    //6.	Total descuento
    //En Total descuento mostrará el total de descuento en toda la tienda
    public int totalDescuentos(){
        Mujer mujer;
        Hombre hombre;
        int total = 0;
        for(int i=0;i<tiendaCalzado.size();i++){
            if(tiendaCalzado.get(i) instanceof Mujer){
                mujer = (Mujer) tiendaCalzado.get(i);
                total = total + (mujer.descuento() * mujer.getProducto().getStock());
            }else if(tiendaCalzado.get(i) instanceof  Hombre){
                hombre = (Hombre) tiendaCalzado.get(i);
                total = total + (hombre.descuento() * hombre.getProducto().getStock());
            }
        }
        return total;
    }


}
