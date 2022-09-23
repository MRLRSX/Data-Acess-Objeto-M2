package model.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.Conexao;
import db.DBException;
import model.Empresas;
import model.dao.EmpresasDao;

public class EmpresasDaoJDBC implements EmpresasDao {

	private Connection connection = null;

	public EmpresasDaoJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void insert(Empresas empresas) {
		PreparedStatement prepared = null;
		try {
			prepared = connection.prepareStatement("INSERT INTO tb_empresas (nome_empresa, cnpj_empresa) VALUES(?, ?)");
			prepared.setString(1, empresas.getNome());
			prepared.setString(2, empresas.getCnpj());
			prepared.executeUpdate();
		} catch (SQLException erro) {
			throw new DBException(erro.getMessage());
		} finally {
			Conexao.closeStatement(prepared);
		}

	}

	@Override
	public Empresas findById(Long id) {
		PreparedStatement prepared = null;
		ResultSet result = null;
		Empresas empresa = new Empresas();
		try {
			prepared = connection.prepareStatement("SELECT * FROM tb_empresas WHERE id_empresa = ?");
			prepared.setLong(1, id);
			result = prepared.executeQuery();
			while (result.next()) {
				empresa.setId(result.getLong("id_empresa"));
				empresa.setNome(result.getString("nome_empresa"));
				empresa.setCnpj(result.getString("cnpj_empresa"));
			}
			return empresa;
		} catch (SQLException erro) {
			throw new DBException(erro.getMessage());
		} finally {
			Conexao.closeResultSet(result);
			Conexao.closeStatement(prepared);
		}
	}

	@Override
	public void update(Empresas empresas) {
		PreparedStatement prepared = null;
		try {
			prepared = connection
					.prepareStatement("UPDATE tb_empresas SET nome_empresa = ?, cnpj_empresa = ? WHERE id_empresa = ?");
			prepared.setString(1, empresas.getNome());
			prepared.setString(2, empresas.getCnpj());
			prepared.setLong(3, empresas.getId());
			prepared.executeUpdate();
		} catch (SQLException erro) {
			throw new DBException(erro.getMessage());
		} finally {
			Conexao.closeStatement(prepared);
		}

	}

	@Override
	public void deleteById(Long id) {
		PreparedStatement prepared = null;
		try {
			prepared = connection.prepareStatement("DELETE FROM tb_empresas WHERE id_empresa = ?");
			prepared.setLong(1, id);
			prepared.executeUpdate();
		} catch (SQLException erro) {
			throw new DBException(erro.getMessage());
		} finally {
			Conexao.closeStatement(prepared);
		}

	}

	@Override
	public List<Empresas> findAll() {

		PreparedStatement prepared = null;
		ResultSet result = null;
        List<Empresas> listaEmpresa = new ArrayList<>();
		try {
			prepared = connection.prepareStatement("SELECT * FROM tb_empresas");
			result = prepared.executeQuery();
			while (result.next()) {
				Empresas empresa = new Empresas();
				empresa.setId(result.getLong("id_empresa"));
				empresa.setNome(result.getString("nome_empresa"));
				empresa.setCnpj(result.getString("cnpj_empresa"));
				listaEmpresa.add(empresa);
			}
			return listaEmpresa;
		} catch (SQLException erro) {
			throw new DBException(erro.getMessage());
		} finally {
			Conexao.closeResultSet(result);
			Conexao.closeStatement(prepared);
		}
	}

}
