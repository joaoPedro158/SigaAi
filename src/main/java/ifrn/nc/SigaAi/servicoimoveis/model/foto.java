package ifrn.nc.SigaAi.servicoimoveis.model;

import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class foto {
    private Long id;
    private Long imovelId;
    private String url;
    private boolean principal;
    private String legenda;

}
