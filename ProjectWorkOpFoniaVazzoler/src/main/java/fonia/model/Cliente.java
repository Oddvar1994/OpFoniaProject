package fonia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="clienti")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_cliente")
	private Integer idCliente;
	
	@Column(name = "nome")
    private String nome;
	
	@Column(name = "cognome")
    private String cognome;
	
	@Column(name = "numero_telefono")
    private Long numeroTelefono;
	
    @Pattern(regexp = "(.+?)@(.+?)", message="email non valida")
    @Column(name = "email")
    private String email;
	
	@Column(name = "codice_fiscale")
    private String codiceFiscale;
	
	@Column(name="id_linea")
	private Integer idLinea;

	public Cliente() {
		super();
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Long getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(Long numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Integer getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(Integer idLinea) {
		this.idLinea = idLinea;
	}

	@Override
	public String toString() {
		return "Cliente=" + idCliente + ", nome=" + nome + ", cognome=" + cognome + ", numeroTelefono="
				+ numeroTelefono + ", email=" + email + ", codiceFiscale="
				+ codiceFiscale + ", idLinea=" + idLinea;
	}

	

	
	

}
