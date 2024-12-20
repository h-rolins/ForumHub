package rolins.forumHub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rolins.forumHub.dtos.TopicoRequestDTO;
import rolins.forumHub.modelos.topico;
import rolins.forumHub.repository.TopicoRepository;
import rolins.forumHub.services.TopicoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<topico> cadastrarTopico(@RequestBody @Validated TopicoRequestDTO dto) {
        topico topico = topicoService.cadastrarTopico(dto);
        return ResponseEntity.ok(topico);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirTopico(@PathVariable Long id) {
        Optional<topico> topicoOptional = topicoRepository.findById(id);

        // Verifica se o tópico existe
        if (topicoOptional.isPresent()) {
            topicoRepository.deleteById(id); // Exclui o tópico
            return ResponseEntity.ok("Tópico excluído com sucesso.");
        } else {
            return ResponseEntity.status(404).body("Tópico não encontrado.");
        }
    }
    @GetMapping
    public ResponseEntity<List<topico>> listarTopicos(
            @RequestParam(required = false) String curso,  // Filtro por curso
            @RequestParam(required = false) Integer ano,  // Filtro por ano
            @RequestParam(defaultValue = "10") int limite,  // Limite de tópicos retornados
            @RequestParam(defaultValue = "ASC") String ordem  // Ordenação: ASC ou DESC
    ) {
        // Criar o critério de ordenação pela data de criação
        Sort sort = ordem.equalsIgnoreCase("ASC") ? Sort.by(Sort.Order.asc("dataCriacao")) : Sort.by(Sort.Order.desc("dataCriacao"));

        // Criar o PageRequest com a ordenação e limite
        PageRequest pageRequest = PageRequest.of(0, limite, sort);

        List<topico> topicos;
        topicos = topicoRepository.findAll(pageRequest).getContent();

        return ResponseEntity.ok(topicos);
    }
}
