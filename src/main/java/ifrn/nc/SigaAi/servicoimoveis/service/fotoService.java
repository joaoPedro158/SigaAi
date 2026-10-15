package ifrn.nc.SigaAi.servicoimoveis.service;

import ifrn.nc.SigaAi.servicoimoveis.exception.ImovelNaoEncontradoExcption;
import ifrn.nc.SigaAi.servicoimoveis.model.Imovel;
import ifrn.nc.SigaAi.servicoimoveis.model.dto.foto.fotoRequestDTO;
import ifrn.nc.SigaAi.servicoimoveis.model.dto.foto.fotoResponseDTO;
import ifrn.nc.SigaAi.servicoimoveis.model.foto;
import ifrn.nc.SigaAi.servicoimoveis.model.mapper.fotoMapper;
import ifrn.nc.SigaAi.servicoimoveis.repository.ImovelRepository;
import ifrn.nc.SigaAi.servicoimoveis.repository.fotoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class fotoService {

    private final fotoRepository fotoRepository;
    private final ImovelRepository imovelRepository;
    private final fotoMapper fotoMapper;


    public fotoResponseDTO salvarFoto(fotoRequestDTO record) {
        foto fotoModel = fotoMapper.toModel(record);

        Imovel imovelEncontrado = imovelRepository.findById(record.getImovelId())
                .orElseThrow(() -> new ImovelNaoEncontradoExcption(record.getImovelId()));
        fotoModel.setImovel(imovelEncontrado);
        foto savedFoto = fotoRepository.save(fotoModel);
        return fotoMapper.toResponse(savedFoto);
    }



    public fotoResponseDTO buscarFotoId(Long id) {
        foto fotoModel = fotoRepository.findById(id).orElseThrow(() -> new RuntimeException("Foto não encontrada"));
        return fotoMapper.toResponse(fotoModel);
    }


    public fotoResponseDTO atualizarFoto(Long id, fotoRequestDTO record) {
        foto existingFoto = fotoRepository.findById(id).orElseThrow(() -> new RuntimeException("Foto não encontrada"));
        foto updatedFoto = fotoMapper.toModel(record);
        updatedFoto.setId(existingFoto.getId());
        foto savedFoto = fotoRepository.save(updatedFoto);
        return fotoMapper.toResponse(savedFoto);
    }


    public fotoResponseDTO deletarFoto(Long id) {
        fotoResponseDTO foto = buscarFotoId(id);
        fotoRepository.deleteById(id);
        return foto;
    }
}
