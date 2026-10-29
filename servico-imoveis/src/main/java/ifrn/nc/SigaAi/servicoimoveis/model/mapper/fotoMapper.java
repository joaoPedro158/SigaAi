package ifrn.nc.SigaAi.servicoimoveis.model.mapper;

import ifrn.nc.SigaAi.servicoimoveis.model.dto.foto.fotoRequestDTO;
import ifrn.nc.SigaAi.servicoimoveis.model.dto.foto.fotoResponseDTO;
import ifrn.nc.SigaAi.servicoimoveis.model.foto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface fotoMapper {
    @Mapping(target = "imovel", ignore = true)
    foto toModel(fotoRequestDTO record);

    @Mapping(source = "imovel.id", target = "imovelId")
    fotoResponseDTO toResponse(foto savedFoto);
}
