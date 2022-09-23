package model.dao;

import java.util.List;

import model.Estados;

public interface EstadosDao {

	public void insert(Estados estados);

	public Estados findById(Long id);

	public void update(Estados estados);

	public void deleteById(Long id);

	public List<Estados> findAll();
}
