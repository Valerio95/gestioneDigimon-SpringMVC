package it.dstech.formazione.modelli;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Allenatore {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Digimon> listaDigimon ;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Digimon> getListaDigimon() {
		return listaDigimon;
	}
	public void setListaDigimon(List<Digimon> listaDigimon) {
		this.listaDigimon = listaDigimon;
	}
	@Override
	public String toString() {
		return "Allenatore [id=" + id + ", nome=" + nome + ", listaDigimon=" + listaDigimon + "]";
	}
	
	
}
