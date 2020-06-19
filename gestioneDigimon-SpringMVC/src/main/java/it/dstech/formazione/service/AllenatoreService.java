package it.dstech.formazione.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.formazione.modelli.Allenatore;
import it.dstech.formazione.modelli.Digimon;
import it.dstech.formazione.repository.AllenatoreRepository;

@Service
@Transactional
public class AllenatoreService {
@Autowired AllenatoreRepository repo;
	
	public void save(Allenatore allenatore) {
		repo.save(allenatore);
		
	}
	
	public List<Allenatore> listAll() {
		return (List<Allenatore>) repo.findAll();
	}
	
	public Allenatore get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public void aggiungiDigimonAdAllenatore (Digimon digimon,Allenatore allenatore) {
		
		allenatore.getListaDigimon().add(digimon);
	}
	
}
