package rolins.forumHub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rolins.forumHub.modelos.topico;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<topico, Long> {
    Optional<topico> findByTituloAndMensagem(String titulo, String mensagem);
}
