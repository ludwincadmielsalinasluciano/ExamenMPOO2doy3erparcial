package mx.unam.fi.mpoo.parkmanager.dto;

public class DescuentoRequest {
    
    private Integer porcentaje;

    public DescuentoRequest() {
    }

    public DescuentoRequest(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }
}
