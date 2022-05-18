package fonia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import fonia.db.ClienteRepository;
import fonia.model.Cliente;
import fonia.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepo;
	
	@Autowired
	ClienteService clienteService;
	
	
	@PostMapping("/salvacliente")
	public void salvaCliente(@RequestBody Cliente c) {
		clienteService.salvaCliente(c);
	}
	
	@GetMapping("/clienti")
	public Iterable<Cliente> vediClienti() {
		return clienteRepo.findAll();
	}
	
	
	@RequestMapping(value="/modificacliente/{idCliente}", method=RequestMethod.PUT)
	public void modificaCliente(@PathVariable("idCliente")Integer idCliente, @RequestBody Cliente c) {
		clienteService.modificaCliente(idCliente, c);
	}
	
	
	@DeleteMapping("cancellacliente/{idCliente}")
	public void cancellaCliente(@PathVariable("idCliente") Integer idCliente) {
		clienteService.cancellaCliente(idCliente);
	}

}
