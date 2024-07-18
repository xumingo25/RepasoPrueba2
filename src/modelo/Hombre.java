package modelo;

public class Hombre extends Formal{

    public Hombre(Producto producto, String diaVenta, int numero, String color) {
        super(producto, diaVenta, numero, color);
    }

    @Override
    public String toString() {
        return "Hombre{" +
                "color='" + color + '\'' +
                ", producto=" + producto +
                ", diaVenta='" + diaVenta + '\'' +
                ", numero=" + numero +
                '}';
    }

    @Override
    public int valorAPagar() {
        int valorAPagar;
        if(this.getProducto().getStock()>0){
            valorAPagar = this.valorVenta()-this.descuento()+impuestoEspecifico()+impuestoIva();
        }else{
            valorAPagar=-1;
        }
        return valorAPagar;
    }

    //o	Si el calzado es de hombre y de color es “Rojo” o “Verde el descuento será de un 25%
    @Override
    public int descuento() {
        int descuento = 0;
        if(this.getColor().equalsIgnoreCase("Rojo") ||
                this.getColor().equalsIgnoreCase("Verde")){
            descuento = Math.round(this.valorVenta()*25/100);
        }
        return descuento;
    }
}
