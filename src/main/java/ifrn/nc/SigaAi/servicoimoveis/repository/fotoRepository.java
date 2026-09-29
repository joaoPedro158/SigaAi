package ifrn.nc.SigaAi.servicoimoveis.repository;

import ifrn.nc.SigaAi.servicoimoveis.model.foto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class fotoRepository {

    private final List<foto> fotos = new CopyOnWriteArrayList<>();
    private final AtomicLong proximoId = new AtomicLong(1);

    public List<foto> findAll() {
        return fotos;
    }

    public Optional<foto> findbyId(Long id) {
        return fotos.stream().filter(i-> i.getId().equals(id)).findFirst();
    }


    public foto save(foto foto) {
        if (foto.getId() == null) {
            foto.setId(proximoId.getAndIncrement());
            fotos.add(foto);
        } else {
            deleteById(foto.getId());
            fotos.add(foto);
        }

        return foto;
    }


    public void deleteById(Long id) {
        fotos.removeIf(i -> i.getId().equals(id));
    }
}
