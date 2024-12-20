package rolins.forumHub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rolins.forumHub.dtos.TopicoRequestDTO;
import rolins.forumHub.modelos.topico;
import rolins.forumHub.repository.TopicoRepository;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public topico cadastrarTopico(TopicoRequestDTO dto) {
        // Verifica duplicidade
        topicoRepository.findByTituloAndMensagem(dto.getTitulo(), dto.getMensagem())
                .ifPresent(t -> {
                    throw new IllegalArgumentException("Tópico com mesmo título e mensagem já existe!");
                });

        // Criação do tópico
        topico topico = new topico();
        topico.setTitulo(dto.getTitulo());
        topico.setMensagem(dto.getMensagem());
        topico.setAutor(dto.getAutor());
        topico.setCurso(dto.getCurso());

        // Persistência no banco de dados
        return topicoRepository.save(topico);
    }
}
