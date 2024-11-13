package modelo;

//una clase abstracta es aquella de la que no se instancian objetos
public abstract class Formal extends Calzado{
    protected String color; //verde

    public Formal(Producto producto, String diaVenta, int nroCalzado, String color) {
        super(producto, diaVenta, nroCalzado);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //•	impuestoEspecifico: retornará el valor de impuesto específico
    // el cual es un 7.4% del valor base (el calzado deportivo no paga éste impuesto)
    public int impuestoEspecifico(){
        return (int) Math.round(this.producto.getValorBase()*7.4/100);
    }

    //•	descuento: retornará el valor de descuento que tendrá el calzado, sabiendo que:
    public abstract int descuento();

    @Override
    public int valorACancelar() {
        int valorAPagar;
        if(this.producto.getStock()>0){
            valorAPagar = valorVenta() -descuento() + impuestoIva() + impuestoEspecifico();
        }else{
            System.out.println("No hay stock del calzado...");
            valorAPagar = -1;
        }
        return valorAPagar;
    }
}
