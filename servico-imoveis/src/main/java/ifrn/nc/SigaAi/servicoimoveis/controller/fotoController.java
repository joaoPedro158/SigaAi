package ifrn.nc.SigaAi.servicoimoveis.controller;


import ifrn.nc.SigaAi.servicoimoveis.model.dto.foto.fotoRequestDTO;
import ifrn.nc.SigaAi.servicoimoveis.model.dto.foto.fotoResponseDTO;
import ifrn.nc.SigaAi.servicoimoveis.service.fotoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController("/foto")
@AllArgsConstructor
public class fotoController {



    private  final fotoService fotoService;

    @PostMapping()
    public ResponseEntity<fotoResponseDTO> salvarFoto(@Valid @RequestBody fotoRequestDTO response) {
        fotoResponseDTO fotoResponse = fotoService.salvarFoto(response);
        URI location = URI.create(String.format("/foto/%s", fotoResponse.getId()));
        return ResponseEntity.created(location).body(fotoResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<fotoResponseDTO> buscarFoto(@PathVariable Long id) {
        fotoResponseDTO response = fotoService.buscarFotoId(id);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<fotoResponseDTO> atualizarFoto(@PathVariable Long id, @Valid @RequestBody fotoRequestDTO record) {
        fotoResponseDTO response = fotoService.atualizarFoto(id, record);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<fotoResponseDTO> deletarFoto(@PathVariable Long id) {
        fotoResponseDTO foto = fotoService.deletarFoto(id);
        return ResponseEntity.ok(foto);
    }


}
