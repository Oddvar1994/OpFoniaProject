package fonia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fonia.service.ChiamataService;

@SpringBootTest
class ProjectWorkAcademyJavaCab1ApplicationTests {

	@Autowired
	ChiamataService chiamataService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testaChiamata() { 
			String oraInizioTele = "2022-05-19 16:34:03.501";
			String oraFineTele = "2022-05-19 16:38:05.504";
			Long risultato = 0L;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			
			try {
			risultato = chiamataService.calcoloDurataTele(1, sdf.parse(oraInizioTele), sdf.parse(oraFineTele));
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
	
			System.out.println("Risultato orario chiamata");
			System.out.println(risultato);
			
			
		
	}

}
