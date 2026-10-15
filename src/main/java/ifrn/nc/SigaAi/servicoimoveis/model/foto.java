package ifrn.nc.SigaAi.servicoimoveis.model;

import jakarta.persistence.*;
import jdk.jfr.BooleanFlag;
import lombok.*;

@Entity
@Table(name = "fotos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "imovel_id")

    private Imovel imovel;

    private String url;
    private boolean principal;
    private String legenda;

}
