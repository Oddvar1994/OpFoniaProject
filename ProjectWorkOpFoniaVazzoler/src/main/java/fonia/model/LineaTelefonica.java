package fonia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="linea_telefonica")
public class LineaTelefonica {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_linea")
	private Integer idLinea;
	
	@NotNull(message="Id cliente obbligatorio")
	@Column(name="id_cliente")
    private Integer idCliente;
   
	@NotBlank(message="Tipo linea obbligatorio")
	@Column(name="tipo_linea")
	private String tipoLinea;
	
	@NotBlank(message="Stato linea obbligatorio")
	@Column(name="stato_linea")
	private String statoLinea;

	public LineaTelefonica(){
		super();
		
	}

	public Integer getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(Integer idLinea) {
		this.idLinea = idLinea;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getTipoLinea() {
		return tipoLinea;
	}

	public void setTipoLinea(String tipoLinea) {
		this.tipoLinea = tipoLinea;
	}

	public String getStatoLinea() {
		return statoLinea;
	}

	public void setStatoLinea(String statoLinea) {
		this.statoLinea = statoLinea;
	}

	@Override
	public String toString() {
		return "Linea Telefonica=" + idLinea + ", idCliente=" + idCliente + ", tipoLinea=" + tipoLinea
				+ ", statoLinea=" + statoLinea;
	}
	
	
	

}
