package modelo;

public class Mujer extends Formal{
    private int alturaTaco;

    public int getAlturaTaco() {
        return alturaTaco;
    }

    public void setAlturaTaco(int alturaTaco) {
        this.alturaTaco = alturaTaco;
    }

    public Mujer(Producto producto, String diaVenta, int nroCalzado, String color, int alturaTaco) {
        super(producto, diaVenta, nroCalzado, color);
        this.alturaTaco = alturaTaco;
    }

    ///Si la altura del taco es mayor a 10, el descuento será de un 20% del valor venta
    @Override
    public int descuento() {
        int descuento = 0;
        if(this.getAlturaTaco()>10){
            descuento = valorVenta() /5;
        }
        return descuento; //logica calzado de mujer
    }


}