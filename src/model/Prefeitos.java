package model;

import java.io.Serializable;
import java.util.Objects;

public class Prefeitos implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private Cidades cidades;

	
	public Prefeitos() {
		
	} 
	
	public Prefeitos(Long id, String nome, Cidades cidades) {
		this.id = id;
		this.nome = nome;
		this.cidades = cidades;
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

	public Cidades getCidades() {
		return cidades;
	}

	public void setCidades(Cidades cidades) {
		this.cidades = cidades;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cidades, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prefeitos other = (Prefeitos) obj;
		return Objects.equals(cidades, other.cidades) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Prefeitos [id=" + id + ", nome=" + nome + "]";
	}

}
