package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cidades implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Estados estados;
	private Double area;
	private Integer populacao;
    private List<Empresas> empresas = new ArrayList<>();
	public Cidades() {
	}

	public Cidades(Long id, String nome, Estados estados, Double area, Integer populacao) {
		this.id = id;
		this.nome = nome;
		this.estados = estados;
		this.area = area;
		this.populacao = populacao;
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

	public Estados getEstados() {
		return estados;
	}

	public void setEstados(Estados estados) {
		this.estados = estados;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Integer getPopulacao() {
		return populacao;
	}

	public void setPopulacao(Integer populacao) {
		this.populacao = populacao;
	}

	public List<Empresas> getEmpresas() {
		return empresas;
	}

	public void addEmpresas(Empresas empresas) {
		this.empresas.add(empresas);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(estados, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidades other = (Cidades) obj;
		return Objects.equals(estados, other.estados) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Cidades [id=" + id + ", nome=" + nome + ", area=" + area + ", populacao=" + populacao + "]";
	}

}
