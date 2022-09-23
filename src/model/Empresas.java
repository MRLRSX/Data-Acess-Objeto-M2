package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Empresas implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String cnpj;
	private List<Cidades> cidades = new ArrayList<>();

	public Empresas() {
	}

	/** @see addCidades() */
	public Empresas(Long id, String nome, String cnpj) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Cidades> getEmpresas() {
		return cidades;
	}

	public void addEmpresas(Cidades cidades) {
		this.cidades.add(cidades);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresas other = (Empresas) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Empresas [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + "]";
	}

}
