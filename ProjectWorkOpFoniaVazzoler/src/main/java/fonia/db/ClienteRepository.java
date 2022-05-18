package fonia.db;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import fonia.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer>{
	
	List<Cliente> findByNome(String nome);
	
	Cliente findByIdCliente(Integer idCliente);
	Cliente deleteByIdCliente(Integer idCliente);
	
}