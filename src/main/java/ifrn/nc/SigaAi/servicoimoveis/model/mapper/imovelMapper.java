package ifrn.nc.SigaAi.servicoimoveis.model.mapper;

import ifrn.nc.SigaAi.servicoimoveis.model.Imovel;
import ifrn.nc.SigaAi.servicoimoveis.model.dto.imovel.ImovelRequestDTO;
import ifrn.nc.SigaAi.servicoimoveis.model.dto.imovel.ImovelResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface imovelMapper  {

 Imovel toModel(ImovelRequestDTO dto);
 ImovelResponseDTO toResponseDTO(Imovel imovel);


 List<ImovelResponseDTO> toListResponseDTO(List<Imovel> imoveis);
}
