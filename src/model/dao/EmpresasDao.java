package model.dao;

import java.util.List;

import model.Empresas;

public interface EmpresasDao {
   
	public void insert(Empresas empresas);
	
	public Empresas findById(Long id);
	
	public void update(Empresas empresas);
	
	public void deleteById(Long id);
	
	public List<Empresas> findAll();
}
