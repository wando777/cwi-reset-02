package br.com.cwi.resetflix.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.request.CriarSerieRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesSerieResponse;
import br.com.cwi.resetflix.response.SerieResponse;
import br.com.cwi.resetflix.service.SeriesService;

@RestController
@RequestMapping("/series")
public class SeriesController implements SeriesContract{

	@Autowired
	private SeriesService seriesService;
	
	@Override
	@GetMapping
	public List<SerieResponse> getSeries(@RequestParam(value = "genero", required = false) final Genero genero) {
		return seriesService.getSeries();
	}

	@Override
	public ConsultarDetalhesSerieResponse getSerieById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PostMapping
	public Long criarSerie(@RequestBody final CriarSerieRequest request) {
		return seriesService.criarSerie(request);
	}

	@Override
	public List<SerieResponse> getSeries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assistirSerie(Long id, Integer temporada, Integer episodio) {
		// TODO Auto-generated method stub
		
	}

}
