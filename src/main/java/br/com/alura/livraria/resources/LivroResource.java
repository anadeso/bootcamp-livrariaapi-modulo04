package br.com.alura.livraria.resources;

import br.com.alura.livraria.dto.AtualizacaoLivroFormDto;
import br.com.alura.livraria.dto.LivroDto;
import br.com.alura.livraria.dto.LivroFormDto;
import br.com.alura.livraria.service.AutorService;
import br.com.alura.livraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/livros")
public class LivroResource {

    @Autowired
    private LivroService livroService;

    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<Page<LivroDto>> listar(Pageable pageable) {
        Page<LivroDto> list = livroService.listar(pageable);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid LivroFormDto livroFormDto) {
        LivroDto livroDto = livroService.cadastrar(livroFormDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(livroDto.getId()).toUri();
        return ResponseEntity.created(uri).body(livroDto);
    }

    @PutMapping
    public ResponseEntity<LivroDto> atualizar(@RequestBody @Valid AtualizacaoLivroFormDto dto) {
        LivroDto atualizada = livroService.atualizar(dto);
        return ResponseEntity.ok(atualizada);
    }
}
