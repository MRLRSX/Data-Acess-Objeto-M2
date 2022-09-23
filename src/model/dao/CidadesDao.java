package model.dao;

import java.util.List;

import model.Cidades;

public interface CidadesDao {

	public void insert(Cidades cidades);
	
	public Cidades findById(Long id);
	
	public void update(Cidades cidadess);
	
	public void deleteById(Long id);
	
	public List<Cidades> findAll();
}
