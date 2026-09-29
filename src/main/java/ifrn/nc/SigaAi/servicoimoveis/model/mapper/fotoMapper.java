package ifrn.nc.SigaAi.servicoimoveis.model.mapper;

import ifrn.nc.SigaAi.servicoimoveis.model.dto.foto.fotoRequestDTO;
import ifrn.nc.SigaAi.servicoimoveis.model.dto.foto.fotoResponseDTO;
import ifrn.nc.SigaAi.servicoimoveis.model.foto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface fotoMapper {
    foto toModel(fotoRequestDTO record);

    fotoResponseDTO toResponse(foto savedFoto);
}
