package modelo;

public class Mujer extends Formal{
    protected int alturaTaco;

    public Mujer(Producto producto, String diaVenta, int numero, String color, int alturaTaco) {
        super(producto, diaVenta, numero, color);
        this.alturaTaco = alturaTaco;
    }

    public int getAlturaTaco() {
        return alturaTaco;
    }

    public void setAlturaTaco(int alturaTaco) {
        this.alturaTaco = alturaTaco;
    }

    @Override
    public String toString() {
        return "Mujer{" +
                "alturaTaco=" + alturaTaco +
                ", color='" + color + '\'' +
                ", numero=" + numero +
                ", producto=" + producto +
                ", diaVenta='" + diaVenta + '\'' +
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

    //o	Si la altura del taco es mayor a 10, el descuento será de un 20% del valor venta
    @Override
    public int descuento() {
        int descuento = 0;
        if(this.getAlturaTaco() > 10){
            descuento = Math.round(this.valorVenta()*20/100);
        }
        return descuento;
    }
}
