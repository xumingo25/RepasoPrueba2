package modelo;

public class Deportivo extends Calzado{
    private String tipoDeporte; //rugby
    private String tipoMaterial; //Cuero o Lona

    public Deportivo(Producto producto, String diaVenta, int nroCalzado, String tipoDeporte, String tipoMaterial) {
        super(producto, diaVenta, nroCalzado);
        this.tipoDeporte = tipoDeporte;
        this.tipoMaterial = tipoMaterial;
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

    //•	impuestoMaterial: retornará el valor de impuesto de
    // material el cual es un 15% del valor base si el calzado
    // es de Cuero y de un 6% del valor base si es de Lona
    public int impuestoMaterial(){
        int impuestoMaterial = 0;
        if(this.getTipoMaterial().equalsIgnoreCase("Cuero")){
            impuestoMaterial = Math.round(this.getProducto().getValorBase()*15/100);
        }else if(this.getTipoMaterial().equalsIgnoreCase("Lona")){
            impuestoMaterial = Math.round(this.getProducto().getValorBase()*6/100);
        }
        return impuestoMaterial;
    }

    @Override
    public int valorACancelar() {
        int valorAPagar;
        if(this.producto.getStock()>0){
            valorAPagar = valorVenta() + impuestoIva() + impuestoMaterial();
        }else{
            System.out.println("No hay stock del calzado...");
            valorAPagar = -1;
        }
        return valorAPagar;
    }
}

