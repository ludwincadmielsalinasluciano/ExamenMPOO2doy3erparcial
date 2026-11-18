package mx.unam.fi.mpoo.parkmanager.dto;

public class CompraRequest {

    private String tipo;
    private Integer cantidad;

    public CompraRequest() {
    }

    public CompraRequest(String tipo, Integer cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
