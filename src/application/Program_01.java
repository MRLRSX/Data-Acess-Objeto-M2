package application;

import model.Cidades;
import model.dao.CidadesDao;
import model.dao.DaoFactory;

public class Program_01 {
	public static void main(String[] args) {
           
		CidadesDao cidadesDao = DaoFactory.createCidadesDaoJDBC();
		Cidades cidades = cidadesDao.findById(1L);
		System.out.println(cidades + "\n" + cidades.getEstados());
	}
}
