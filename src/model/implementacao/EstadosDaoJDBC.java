package model.implementacao;

import java.sql.Connection;
import java.util.List;

import model.Estados;
import model.dao.EstadosDao;

public class EstadosDaoJDBC implements EstadosDao {

	private static Connection connection = null;
	
	public EstadosDaoJDBC (Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void insert(Estados estados) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Estados findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Estados estados) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Estados> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
   
}
