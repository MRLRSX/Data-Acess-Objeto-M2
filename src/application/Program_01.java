package application;

import model.Cidades;
import model.dao.CidadesDao;
import model.dao.DaoFactory;

public class Program_01 {
	public static void main(String[] args) {
           
		CidadesDao cidadesDao = DaoFactory.createCidadesDaoJDBC();
		Cidades cidades = cidadesDao.findById(1L);
		System.out.println(cidades + "\n" + cidades.getEstados());
		Cidades cidades01 = new Cidades(1L, "João Pinheiro", cidades.getEstados() ,320.00, 0.07);
		cidadesDao.insert(cidades01);
	}
}
