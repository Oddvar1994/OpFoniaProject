package fonia.db;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import fonia.model.Chiamata;


@Repository
public interface ChiamataRepository extends CrudRepository<Chiamata, Integer>{

	Chiamata deleteByIdChiamata(Integer idChiamata);
	Chiamata findByIdChiamata(Integer idChiamata);
	
	@Query(value="SELECT SUM(durata)" + " FROM public.chiamata" +
	" WHERE(id_linea_chiamante=:idLinea OR id_linea_chiamata=:idLinea) AND (data_ora_inizio_tele>=:dateStart AND"
	+ " data_ora_fine_tele<=:dateEnd)", nativeQuery=true)
	Long sommaDurate(@Param("idLinea")Integer idLinea, @Param("dateStart")Date dateStart, @Param("dateEnd")Date dateEnd);
}
