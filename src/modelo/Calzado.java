package modelo;

public abstract class Calzado {
    protected Producto producto; //{123ABC,10,10000}
    protected String diaVenta; //{semana o fin de semana}
    protected int numero; //44

    public Calzado(Producto producto, String diaVenta, int numero) {
        this.producto = producto;
        this.diaVenta = diaVenta;
        this.numero = numero;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getDiaVenta() {
        return diaVenta;
    }

    public void setDiaVenta(String diaVenta) {
        this.diaVenta = diaVenta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override

    public String toString() {
        return "Calzado{" +
                "producto=" + producto +
                ", diaVenta='" + diaVenta + '\'' +
                ", numero=" + numero +
                '}';
    }

    //•	valorVenta: retornará el valor de venta del calzado,
    // sabiendo que el fin de semana, aumenta en un 24% el valor Base
    // y en la semana el valor Base disminuye en un 15%.
    public int valorVenta(){
        int valorVenta = 0;
        if(this.diaVenta.equalsIgnoreCase("Semana")){
            valorVenta = this.getProducto().getValorBase() - Math.round(this.getProducto().getValorBase()*15/100);

        }else if(this.diaVenta.equalsIgnoreCase("Fin de Semana")){
            valorVenta = this.getProducto().getValorBase() + Math.round(this.getProducto().getValorBase()*24/100);

        }
        return valorVenta;
    }

    //•	impuestoIva: retornará el valor por concepto de IVA que es el 19% del valor venta
    public int impuestoIva(){
        return Math.round(this.valorVenta()*19/100);
    }



    public abstract int valorAPagar();
}
