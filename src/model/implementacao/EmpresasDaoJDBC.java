package model.implementacao;

import java.sql.Connection;
import java.util.List;

import model.Empresas;
import model.dao.EmpresasDao;

public class EmpresasDaoJDBC implements EmpresasDao{

	
private static Connection connection = null;
	
	public EmpresasDaoJDBC(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void insert(Empresas empresas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Empresas findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Empresas empresas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Empresas> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
