package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Estados implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String sigla;
	private String regiao;
	private Double populacao;
    private List<Cidades> cidades = new ArrayList<>();
	
	public Estados() {}
	
	/**@SEE addCidades()*/
	public Estados(Long id, String nome, String sigla, String regiao, Double populacao) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.regiao = regiao;
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public Double getPopulacao() {
		return populacao;
	}

	public void setPopulacao(Double populacao) {
		this.populacao = populacao;
	}
    
	public List<Cidades> getCidades() {
		return cidades;
	}
    
	public void addCidades(Cidades cidades) {
		this.cidades.add(cidades);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estados other = (Estados) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Estados [id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", regiao=" + regiao + ", populacao="
				+ populacao + "]";
	}

}
