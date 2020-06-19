package it.dstech.formazione.modelli;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Digimon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@OneToMany
    private List<Allenatore> listaAllenatori= new ArrayList<Allenatore>();
	private String nome;
	private int atk;
	private int def;
	private int res;
	private int hp;

	private Evoluzione evoluzione;

	
	public List<Allenatore> getListaAllenatori() {
		return listaAllenatori;
	}

	public void setListaAllenatori(List<Allenatore> listaAllenatori) {
		this.listaAllenatori = listaAllenatori;
	}

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

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public Evoluzione getEvoluzione() {
		return evoluzione;
	}

	public void setEvoluzione(Evoluzione evoluzione) {
		this.evoluzione = evoluzione;
	}
	
	
	

}
