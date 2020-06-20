package it.dstech.formazione.modelli;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Digimon implements   Comparable<Digimon> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@OneToMany(fetch = FetchType.EAGER)
    private List<Allenatore> listaAllenatori;
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

	@Override
	public String toString() {
		return "Digimon [id=" + id + ", listaAllenatori=" + listaAllenatori + ", nome=" + nome + ", atk=" + atk
				+ ", def=" + def + ", res=" + res + ", hp=" + hp + ", evoluzione=" + evoluzione + "]";
	}
	
	@Override
	public int compareTo(Digimon o) {
		if (this.getAtk() > o.getAtk())
			return -1;
		if (this.getAtk() < o.getAtk())
			return 1;
		return 0;
	}
	

}
