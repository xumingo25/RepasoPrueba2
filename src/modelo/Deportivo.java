package modelo;

public class Deportivo extends Calzado{
    //definir los atributos
    protected String tipoDeporte;
    protected String tipoMaterial;

    public Deportivo(Producto producto, String diaVenta, int numero, String tipoDeporte, String tipoMaterial) {
        super(producto, diaVenta, numero);
        this.tipoDeporte = tipoDeporte;
        this.tipoMaterial = tipoMaterial;
    }

    @Override
    public String toString() {
        return "Deportivo{" +
                "tipoDeporte='" + tipoDeporte + '\'' +
                ", tipoMaterial='" + tipoMaterial + '\'' +
                ", producto=" + producto +
                ", diaVenta='" + diaVenta + '\'' +
                ", numero=" + numero +
                '}';
    }

    @Override
    public int valorAPagar() {
        int valorAPagar;
        if(this.getProducto().getStock()>0){
            valorAPagar = this.valorVenta()+impuestoMaterial()+impuestoIva();
        }else{
            valorAPagar=-1;
        }
        return valorAPagar;
    }

    //•	impuestoMaterial: retornará el valor de impuesto de material el cual
    // es un 15% del valor base si el
    // calzado es de Cuero y de un 6% del valor base si es de Lona
    public int impuestoMaterial(){
        int impuestoMaterial =0;
        if(this.getTipoMaterial().equalsIgnoreCase("cuero")){
            impuestoMaterial = Math.round(this.getProducto().getValorBase()*15/100);
        }else if(this.getTipoMaterial().equalsIgnoreCase("lona")){
            impuestoMaterial = Math.round(this.getProducto().getValorBase()*6/100);
        }
        return impuestoMaterial;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public String getTipoDeporte() {
        return tipoDeporte;
    }

    public void setTipoDeporte(String tipoDeporte) {
        this.tipoDeporte = tipoDeporte;
    }
}
