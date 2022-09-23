package model.implementacao;

import java.sql.Connection;
import java.util.List;

import model.Prefeitos;
import model.dao.PrefeitosDao;

public class PrefeitosDaoJDBC implements PrefeitosDao {

	private static Connection connection = null;
	
	public PrefeitosDaoJDBC (Connection connection) {
	    this.connection = connection;
	}
	
	@Override
	public void insert(Prefeitos prefeitos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Prefeitos findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Prefeitos prefeitos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Prefeitos> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
