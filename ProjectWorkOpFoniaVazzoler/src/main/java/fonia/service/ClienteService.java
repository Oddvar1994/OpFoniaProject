package fonia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fonia.model.Cliente;
import fonia.db.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepo;
	
	public void salvaCliente(Cliente c) {
		clienteRepo.save(c);
	}
	
	public void modificaCliente(Integer idCliente, Cliente c) {
		Cliente found = clienteRepo.findByIdCliente(idCliente);
		found.setNome(c.getNome());
		found.setCognome(c.getCognome());
		found.setNumeroTelefono(c.getNumeroTelefono());
		found.setEmail(c.getEmail());
		found.setCodiceFiscale(c.getCodiceFiscale());
		found.setIdLinea(c.getIdLinea());
		
		clienteRepo.save(found);
		
	}
	
	
	public void cancellaCliente(Integer idCliente) {
		Cliente daCancellare = clienteRepo.findByIdCliente(idCliente);
		clienteRepo.delete(daCancellare);
	}
	
}
