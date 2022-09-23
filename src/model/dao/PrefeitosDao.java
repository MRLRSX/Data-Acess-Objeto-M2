package model.dao;

import java.util.List;

import model.Prefeitos;

public interface PrefeitosDao {

	public void insert(Prefeitos prefeitos);

	public Prefeitos findById(Long id);

	public void update(Prefeitos prefeitos);

	public void deleteById(Long id);

	public List<Prefeitos> findAll();
}
