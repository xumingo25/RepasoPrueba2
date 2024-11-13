package modelo;

public class Hombre extends Formal {
    public Hombre(Producto producto, String diaVenta, int nroCalzado, String color) {
        super(producto, diaVenta, nroCalzado, color);
    }


    //    //o	Si el calzado es de hombre y de color
    //    es “Rojo” o “Verde el descuento será de un 25%
    @Override
    public int descuento() {
        int descuento = 0;
        if (this.color.equalsIgnoreCase("Rojo") ||
                this.color.equalsIgnoreCase("Verde")) {
            descuento = this.valorVenta() / 4;
        }

        return descuento;
    }

}

