package mx.unam.fi.mpoo.parkmanager.controller;

import mx.unam.fi.mpoo.parkmanager.dto.CompraRequest;
import mx.unam.fi.mpoo.parkmanager.dto.CompraResponse;
import mx.unam.fi.mpoo.parkmanager.dto.DescuentoRequest;
import mx.unam.fi.mpoo.parkmanager.dto.DescuentoResponse;
import mx.unam.fi.mpoo.parkmanager.service.ParkManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ParkManagerController {

    private final ParkManagerService parkManagerService;

    public ParkManagerController(ParkManagerService parkManagerService) {
        this.parkManagerService = parkManagerService;
    }

    @PutMapping("/descuentos/{tipo}")
    public ResponseEntity<DescuentoResponse> configurarDescuento(
            @PathVariable String tipo,
            @RequestBody(required = false) DescuentoRequest request) {
        return ResponseEntity.ok(parkManagerService.configurarDescuento(tipo, request));
    }

    @DeleteMapping("/descuentos/{tipo}")
    public ResponseEntity<DescuentoResponse> removerDescuento(@PathVariable String tipo) {
        return ResponseEntity.ok(parkManagerService.eliminarDescuento(tipo));
    }

    @PostMapping("/compras")
    public ResponseEntity<CompraResponse> registrarCompra(
            @RequestBody(required = false) CompraRequest request) {
        return ResponseEntity.ok(parkManagerService.registrarCompra(request));
    }
}
