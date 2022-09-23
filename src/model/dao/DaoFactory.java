package model.dao;

import db.Conexao;
import model.implementacao.CidadesDaoJDBC;
import model.implementacao.EmpresasDaoJDBC;
import model.implementacao.EstadosDaoJDBC;
import model.implementacao.PrefeitosDaoJDBC;

public class DaoFactory {

	public static CidadesDao createCidadesDaoJDBC() {
		return new CidadesDaoJDBC(Conexao.getConnection());
	}
	
	public static EmpresasDao createEmpresasDaoJDBC() {
		return new EmpresasDaoJDBC(Conexao.getConnection());
	}
	
	public static EstadosDao createEstadosDaoJDBC() {
		return new EstadosDaoJDBC(Conexao.getConnection());
	}
	
	public static PrefeitosDao createPrefeitosDaoJDBC() {
		return new PrefeitosDaoJDBC(Conexao.getConnection());
	}
}
