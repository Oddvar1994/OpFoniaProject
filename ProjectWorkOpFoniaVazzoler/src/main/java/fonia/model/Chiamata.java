package fonia.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="chiamate")
public class Chiamata {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_chiamata")
	private Integer idChiamata;
	
	@JoinColumn(name="id_linea_chiamante")
    private Integer idLineaChiamante;
	
	@Column(name="id_linea_chiamata")
	private Integer idLineaChiamata;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	@Column(name = "data_ora_inizio_tele")
    private Date dataOraInizioTele;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	@Column(name = "data_ora_fine_tele")
	private Date dataOraFineTele;
	
	@Column(name = "durata")
	private Long durata;
	
	public Long calcoloDurata() {
		
		return (this.dataOraFineTele.getTime() - this.dataOraInizioTele.getTime())/1000;
		        
	}

	public Chiamata() {
		super();
	}

	public Integer getIdChiamata() {
		return idChiamata;
	}

	public void setIdChiamata(Integer idChiamata) {
		this.idChiamata = idChiamata;
	}

	public Integer getIdLineaChiamante() {
		return idLineaChiamante;
	}

	public void setIdLineaChiamante(Integer idLineaChiamante) {
		this.idLineaChiamante = idLineaChiamante;
	}

	public Integer getIdLineaChiamata() {
		return idLineaChiamata;
	}

	public void setIdLineaChiamata(Integer idLineaChiamata) {
		this.idLineaChiamata = idLineaChiamata;
	}

	public Date getDataOraInizioTele() {
		return dataOraInizioTele;
	}

	public void setDataOraInizioTele(Date dataOraInizioTele) {
		this.dataOraInizioTele = dataOraInizioTele;
	}

	public Date getDataOraFineTele() {
		return dataOraFineTele;
	}

	public void setDataOraFineTele(Date dataOraFineTele) {
		this.dataOraFineTele = dataOraFineTele;
	}

	public Long getDurata() {
		return durata;
	}

	public void setDurata(Long durata) {
		this.durata = durata;
	}

	@Override
	public String toString() {
		return "Chiamata=" + idChiamata + ", idLineaChiamante=" + idLineaChiamante + ", idLineaChiamata=" 
	+ idLineaChiamata + ", dataOraInizioTele=" + dataOraInizioTele + ", dataOraFineTele=" + dataOraFineTele 
	+ ", durata=" + durata;
	}

}
