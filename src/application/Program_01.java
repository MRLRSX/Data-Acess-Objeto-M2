package application;

import java.util.List;

import model.Cidades;
import model.dao.CidadesDao;
import model.dao.DaoFactory;

public class Program_01 {
	public static void main(String[] args) {
           
		CidadesDao cidadesDao = DaoFactory.createCidadesDaoJDBC();
		Cidades cidades = cidadesDao.findById(1L);
		System.out.println(cidades + "\n" + cidades.getEstados());
		Cidades cidades01 = new Cidades(4L, "João Pinheiro YY", cidades.getEstados() ,320.00, 0.07);
		//cidadesDao.insert(cidades01);
		//cidadesDao.update(cidades01);
		cidadesDao.deleteById(4L);
		List<Cidades> listaCidades = cidadesDao.findAll();
		listaCidades.stream().forEach(System.out::println);
		listaCidades.stream().map(c -> c.getEstados()).forEach(System.out::println);
	}
}
