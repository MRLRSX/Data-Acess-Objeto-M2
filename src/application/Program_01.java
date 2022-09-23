package application;

import model.Estados;
import model.dao.DaoFactory;
import model.dao.EstadosDao;

public class Program_01 {
	public static void main(String[] args) {
          EstadosDao estadoDao = DaoFactory.createEstadosDaoJDBC();
          System.out.println(estadoDao.findById(1L));
          System.out.println("\n\n");
          //estadoDao.deleteById(1L);
          //estadoDao.insert(new Estados(1L, "Alagoas", "AL", "Nordeste", 3.38));
          estadoDao.findAll().stream().forEach(System.out::println);
          
	}
}
