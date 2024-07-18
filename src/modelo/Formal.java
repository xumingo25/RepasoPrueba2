package modelo;

//una clase abstracta define la estructura comun, pero no se implementa
public abstract class Formal extends Calzado{
    protected String color; //rojo

    public Formal(Producto producto, String diaVenta, int numero, String color) {
        super(producto, diaVenta, numero);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Formal{" +
                "color='" + color + '\'' +
                ", producto=" + producto +
                ", diaVenta='" + diaVenta + '\'' +
                ", numero=" + numero +
                '}';
    }

    //•	impuestoEspecifico: retornará el valor de impuesto específico el
    // cual es un 7.4% del valor base (el calzado deportivo no paga éste impuesto)
    public int impuestoEspecifico(){
        return (int) Math.round(this.getProducto().getValorBase()*7.4/100);
    }

    /*
    public int descuento(){
        return 0;
    }*/

    //un método abstracto es aquel que se define en la clase, pero se implementa en las sub clases
    public abstract int descuento();
}
