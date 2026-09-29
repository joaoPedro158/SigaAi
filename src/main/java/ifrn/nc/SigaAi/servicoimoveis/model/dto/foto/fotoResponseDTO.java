package ifrn.nc.SigaAi.servicoimoveis.model.dto.foto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class fotoResponseDTO {
    private Long id;
    private Long imovelId;
    private String url;
    private boolean principal;
    private String legenda;

}
