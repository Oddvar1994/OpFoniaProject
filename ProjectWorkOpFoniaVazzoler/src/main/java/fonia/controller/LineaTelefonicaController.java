package fonia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import fonia.db.LineaTelefonicaRepository;
import fonia.model.LineaTelefonica;
import fonia.service.LineaTelefonicaService;

@RestController
public class LineaTelefonicaController {
	
	@Autowired
	LineaTelefonicaRepository lineaRepo;
	
	@Autowired
	LineaTelefonicaService lineaTelefonicaService;
	
	
	@PostMapping("/attivalinea")
	public void attivaLinea(@RequestBody LineaTelefonica l) {
		lineaTelefonicaService.attivaLinea(l);
	}
	
	@GetMapping("/lineetelefoniche")
	public Iterable<LineaTelefonica> vediLinee() {
		return lineaRepo.findAll();
	}
	
	@PutMapping("/sospendilinea/{idLinea}")
	public void sospendiLinea(@PathVariable("idLinea")Integer idLinea, @RequestBody LineaTelefonica l) {
		lineaTelefonicaService.sospendiLinea(idLinea, l);			
	}
	
	@DeleteMapping("/cessazionelinea/{idLinea}")
	public void  chiudiLinea(@PathVariable("idLinea")Integer idLinea) {
		lineaTelefonicaService.cessazioneLinea(idLinea);
	}
	
	
	

}
