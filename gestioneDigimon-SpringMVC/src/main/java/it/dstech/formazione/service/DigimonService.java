package it.dstech.formazione.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.formazione.modelli.Digimon;
import it.dstech.formazione.repository.DigimonRepository;

@Service
@Transactional
public class DigimonService {
	@Autowired DigimonRepository repo;
	
	public void save(Digimon digimon) {
		repo.save(digimon);
		
	}
	
	public List<Digimon> listAll() {
		return (List<Digimon>) repo.findAll();
	}
	
	public Digimon get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Digimon> ordinamentoPerAtk (List<Digimon> listaDigimon) {
		 Collections.sort(listaDigimon);
		return listaDigimon;
	}
	
	public List<Digimon> ordinamentoPerDef (List<Digimon> listaDigimon) {
		Collections.sort(listaDigimon, new Comparator<Digimon>() {

			@Override
			public int compare(Digimon o1, Digimon o2) {
				if (o1.getDef() < o2.getDef())
					return 1;
				if (o1.getDef() > o2.getDef())
					return -1;

				return 0;
			}
		});
		return listaDigimon;
}
	
	public List<Digimon> ordinamentoPerRes (List<Digimon> listaDigimon) {
		Collections.sort(listaDigimon, new Comparator<Digimon>() {

			@Override
			public int compare(Digimon o1, Digimon o2) {
				if (o1.getRes() < o2.getRes())
					return 1;
				if (o1.getRes() > o2.getRes())
					return -1;

				return 0;
			}
		});
		return listaDigimon;
	}
	
	
	public List<Digimon> ordinamentoPerHp (List<Digimon> listaDigimon) {
		Collections.sort(listaDigimon, new Comparator<Digimon>() {

			@Override
			public int compare(Digimon o1, Digimon o2) {
				if (o1.getHp() < o2.getHp())
					return 1;
				if (o1.getHp() > o2.getHp())
					return -1;

				return 0;
			}
		});
		return listaDigimon;
	}
}
