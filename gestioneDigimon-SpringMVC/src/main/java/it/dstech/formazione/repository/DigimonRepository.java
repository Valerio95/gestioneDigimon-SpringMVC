package it.dstech.formazione.repository;


import org.springframework.data.repository.CrudRepository;

import it.dstech.formazione.modelli.Digimon;

public interface DigimonRepository extends CrudRepository<Digimon, Long> {
	
	
}
