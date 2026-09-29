package ifrn.nc.SigaAi.servicoimoveis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Imovel {
    private Long id;
    private String endereco;
    private Double valorAluguel;
    private String descricao;
}
