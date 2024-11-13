package modelo;

public abstract class Calzado {
    //atributos
    protected Producto producto; //{qwe123,10,10000}
    protected String diaVenta; //Semana o Fin de semana
    protected int nroCalzado; //44

    public Calzado(Producto producto, String diaVenta, int nroCalzado) {
        this.producto = producto;
        this.diaVenta = diaVenta;
        this.nroCalzado = nroCalzado;
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

    public int getNroCalzado() {
        return nroCalzado;
    }

    public void setNroCalzado(int nroCalzado) {
        this.nroCalzado = nroCalzado;
    }

    //•	valorVenta: retornará el valor de venta del calzado,
    // sabiendo que el fin de semana, aumenta en un 24% el valor Base
    // y en la semana el valor Base disminuye en un 15%.
    //10000 Fin de semana = 12400
    public int valorVenta(){ //10000 Semana = 8500
        int valorVenta = 0;
        if(this.diaVenta.equalsIgnoreCase("Semana")){
            valorVenta = this.producto.getValorBase() - Math.round(this.producto.getValorBase()*15/100);
        }else if(this.diaVenta.equalsIgnoreCase("Fin de Semana")){
            valorVenta = this.producto.getValorBase() + Math.round(this.producto.getValorBase()*24/100);
        }
        return valorVenta;
    }

    //•	impuestoIva: retornará el valor por concepto de
    // IVA que es el 19% del valor venta
    public int impuestoIva(){
         return Math.round(this.valorVenta()*19/100);
    }


    public abstract int valorACancelar();
}
