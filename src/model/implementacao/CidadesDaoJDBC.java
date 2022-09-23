package model.implementacao;

import java.sql.Connection;
import java.util.List;

import model.Cidades;
import model.dao.CidadesDao;

public class CidadesDaoJDBC implements CidadesDao {

	
	private static Connection connection = null;
	
	public CidadesDaoJDBC(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void insert(Cidades cidades) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cidades findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Cidades cidadess) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cidades> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
