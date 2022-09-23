package application;

import java.util.function.Consumer;

import model.Cidades;
import model.Prefeitos;
import model.dao.DaoFactory;
import model.dao.PrefeitosDao;

public class Program_01 {
	public static void main(String[] args) {
       PrefeitosDao pDAO = DaoFactory.createPrefeitosDaoJDBC();
       Consumer<Object> print = System.out::println;
       
       
       System.out.println(pDAO.findById(1L));
       System.out.println("\n");
       System.out.println("PREFEITO -> ");
       pDAO.findAll().stream().forEach(print);
       System.out.println("cidade -> ");
       pDAO.findAll().stream().map(c -> c.getCidades()).forEach(print);
       System.out.println("ESTADO -> ");
       pDAO.findAll().stream().map(c -> c.getCidades().getEstados()).forEach(print);
       pDAO.deleteById(1L);
       Cidades cidades = pDAO.findById(2L).getCidades();
       pDAO.update(new Prefeitos(2L, "LUCAS", cidades));
	}
}
