package fonia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fonia.db.LineaTelefonicaRepository;
import fonia.model.LineaTelefonica;

@Service
public class LineaTelefonicaService {
	
	@Autowired
	LineaTelefonicaRepository lineaTelefonicaRepo;
	
	public void attivaLinea(LineaTelefonica l) {
		lineaTelefonicaRepo.save(l);
	}
	
	
	public void sospendiLinea(Integer idLinea, LineaTelefonica l) {
		LineaTelefonica daSospendere = lineaTelefonicaRepo.findByIdLinea(idLinea);
		daSospendere.setStatoLinea(l.getStatoLinea());
		
		lineaTelefonicaRepo.save(daSospendere);	
	}
	
	
	public void cessazioneLinea(Integer idLinea) {
		LineaTelefonica daChiudere = lineaTelefonicaRepo.findByIdLinea(idLinea);
		lineaTelefonicaRepo.delete(daChiudere);
	}
	
	

}
