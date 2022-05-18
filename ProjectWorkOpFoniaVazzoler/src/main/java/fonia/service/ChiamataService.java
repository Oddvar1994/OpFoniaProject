package fonia.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fonia.db.ChiamataRepository;
import fonia.model.Chiamata;

@Service
public class ChiamataService {
	
	@Autowired
	ChiamataRepository chiamataRepo;
	
	public void nuovaChiamata(Chiamata c) {
		c.setDurata(c.calcoloDurata());
		chiamataRepo.save(c);
	}
	
	public void modificaChiamata(Integer idChiamata, Chiamata c) {
		Chiamata daModificare = chiamataRepo.findByIdChiamata(idChiamata);
		daModificare.setIdLineaChiamante(c.getIdLineaChiamante());
		daModificare.setIdLineaChiamata(c.getIdChiamata());
		daModificare.setDataOraInizioTele(c.getDataOraInizioTele());
		daModificare.setDataOraFineTele(c.getDataOraFineTele());
		daModificare.setDurata(c.getDurata());
		
		chiamataRepo.save(daModificare);	
	}
	
	
	public void chiudiChiamata(Integer idChiamata) {
		Chiamata daChiudere = chiamataRepo.findByIdChiamata(idChiamata);
		chiamataRepo.delete(daChiudere);
	}
	
	public Long calcoloDurataTele(Integer id, Date dateStart, Date dateEnd) {
		
		return chiamataRepo.sommaDurate(id, dateStart, dateEnd);
	}
	
	
	
	

}
