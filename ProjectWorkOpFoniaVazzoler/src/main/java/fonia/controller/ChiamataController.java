package fonia.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import fonia.db.ChiamataRepository;
import fonia.model.Chiamata;
import fonia.service.ChiamataService;

@RestController
public class ChiamataController {
	
	@Autowired
	ChiamataRepository chiamataRepo;
	
	@Autowired
	ChiamataService chiamataService;
	
	
	@PostMapping("/nuovachiamata")
	public void nuovaChiamata(@RequestBody Chiamata c) {
		chiamataService.nuovaChiamata(c);
	}
		
	@GetMapping("/chiamate")
	public Iterable<Chiamata> vediChiamate() {
		return chiamataRepo.findAll();
	}
	
	@PutMapping("/modificachiamata/{idChiamata}")
	public void modificaChiamata(@PathVariable("idChiamata")Integer idChiamata, @RequestBody Chiamata c) {
		chiamataService.modificaChiamata(idChiamata, c);			
	}
	
	@DeleteMapping("/cancellachiamata/{idChiamata}")
	public void  chiudiChiamata(@PathVariable("idChiamata")Integer idChiamata) {
		chiamataService.chiudiChiamata(idChiamata);
	}
	
	@GetMapping("/duratachiamate/{idLinea}/{dataOraInizioTele}/{dateEnd}")
	public Long reportChiamate(@PathVariable("idLinea")Integer IdLinea,
	@PathVariable("dataOraInizioTele")@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")Date dataOraInizioTele,
	@PathVariable("dataOraFineTele")@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")Date dataOraFineTele) {
		return chiamataService.calcoloDurataTele(IdLinea, dataOraInizioTele, dataOraFineTele);
	}
}
