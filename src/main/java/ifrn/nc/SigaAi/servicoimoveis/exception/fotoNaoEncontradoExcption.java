package ifrn.nc.SigaAi.servicoimoveis.exception;

public class fotoNaoEncontradoExcption extends RuntimeException {
    public fotoNaoEncontradoExcption(Long id) {

        super("Foto não encontrada com ID: " + id);
    }
}
