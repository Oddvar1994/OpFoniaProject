package fonia.db;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fonia.model.LineaTelefonica;

@Repository
public interface LineaTelefonicaRepository extends CrudRepository<LineaTelefonica, Integer>{

	
List<LineaTelefonica> findByTipoLinea(String tipoLinea);
	
	
LineaTelefonica findByIdLinea(Integer idLinea);
}


	
	
