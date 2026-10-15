package ifrn.nc.SigaAi.servicoimoveis.repository;

import ifrn.nc.SigaAi.servicoimoveis.model.foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public interface fotoRepository extends JpaRepository<foto, Long> {


}
