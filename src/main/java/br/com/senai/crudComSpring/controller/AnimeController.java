package br.com.senai.crudComSpring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.senai.crudComSpring.model.Anime;
import br.com.senai.crudComSpring.repository.AnimeRepository;

@Controller
public class AnimeController {

	@Autowired
	private AnimeRepository animeRepository;

	@GetMapping("/")
	public String paginaPrincipal() {
		return "index";
	}

	@GetMapping("/animes")
	public String listarAnimes(Model model) {
		List<Anime> animes = animeRepository.findAll();
		model.addAttribute("animes", animes);
		return "animes";
	}

	@GetMapping("/cadastrarAnime")
	public String paginaAdicionarAnime(Anime anime) {
		return "cadastrar_anime";
	}

	@PostMapping("/adicionarAnime")
	public String adicionarAnime(@Valid Anime anime, Errors erros, BindingResult result, Model model) {
		if (result.hasErrors() || (null != erros && erros.getErrorCount() > 0)) {
			return "cadastrar_anime";
		}
		animeRepository.save(anime);
		return "redirect:/animes";
	}

	@GetMapping("/editar/{id}")
	public String paginaAtualizarAnime(@PathVariable("id") long id, Model model) {
		Anime anime = animeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Identificador do anime é inválido" + id));

		model.addAttribute("anime", anime);
		return "editar_anime";
	}

	@PostMapping("/atualizar/{id}")
	public String atualizarAnime(@PathVariable("id") long id, @Valid Anime anime, BindingResult result, Model model) {
		if (result.hasErrors()) {
			anime.setId(id);
			return "editar_anime";

		}
		animeRepository.save(anime);
		return "redirect:/animes";
	}

	@GetMapping("/excluir/{id}")
	public String deletarAnime(@PathVariable("id") long id, Model model) {
		Anime anime = animeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Produto não encontrado."));
		animeRepository.delete(anime);
		return "redirect:/animes";
	}
}
