package ifrn.nc.SigaAi.servicoimoveis.repository;

import ifrn.nc.SigaAi.servicoimoveis.model.Imovel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ImovelRepository {
    private final List<Imovel> imoveis = new CopyOnWriteArrayList<>();
    private final AtomicLong proximoId = new AtomicLong(1);

    public List<Imovel> findAll() {
        return imoveis;
    }

    public Optional<Imovel> findbyId(Long id) {
        return imoveis.stream().filter(i-> i.getId().equals(id)).findFirst();
    }


    public Imovel save(Imovel imovel) {
        if (imovel.getId() == null) {
            imovel.setId(proximoId.getAndIncrement());
            imoveis.add(imovel);
        } else {
            deleteById(imovel.getId());
            imoveis.add(imovel);
        }

        return imovel;
    }


    public void deleteById(Long id) {
        imoveis.removeIf(i -> i.getId().equals(id));
    }
}
