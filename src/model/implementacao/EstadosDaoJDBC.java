package model.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.Conexao;
import db.DBException;
import model.Estados;
import model.dao.EstadosDao;

public class EstadosDaoJDBC implements EstadosDao {

	private Connection connection = null;

	public EstadosDaoJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void insert(Estados estados) {
		PreparedStatement prepared = null;
		try {
			prepared = connection.prepareStatement("INSERT INTO tb_estados (nome_estado, sigla_estado, regiao_estado, populacao_estados) VALUES (?, ?, ?, ?)");
			prepared.setString(1, estados.getNome());
			prepared.setString(2, estados.getSigla());
			prepared.setString(3, estados.getRegiao());
			prepared.setDouble(4, estados.getPopulacao());
			prepared.executeUpdate();

		} catch (SQLException erro) {
			throw new DBException(erro.getMessage());
		} finally {
			Conexao.closeStatement(prepared);
		}

	}

	@Override
	public Estados findById(Long id) {
		PreparedStatement prepared = null;
		ResultSet result = null;
		Estados estados = new Estados();
		try {
			prepared = connection.prepareStatement("SELECT * FROM tb_estados WHERE id_estados = ?");
			prepared.setLong(1, id);
			result = prepared.executeQuery();
			while (result.next()) {
				estados.setId(result.getLong("id_estados"));
				estados.setNome(result.getString("nome_estado"));
				estados.setSigla(result.getString("sigla_estado"));
				estados.setRegiao(result.getString("regiao_estado"));
				estados.setPopulacao(result.getDouble("populacao_estados"));
			}
			return estados;
		} catch (SQLException erro) {
			throw new DBException(erro.getMessage());
		} finally {
			Conexao.closeResultSet(result);
			Conexao.closeStatement(prepared);
		}
	}

	@Override
	public void update(Estados estados) {
		PreparedStatement prepared = null;
		try {
			prepared = connection.prepareStatement(
					"UPDATE tb_estados SET nome_estado = ?, sigla_estado = ?, regiao_estado =?, populacao_estados = ? WHERE id_estados = ?");
			prepared.setString(1, estados.getNome());
			prepared.setString(2, estados.getSigla());
			prepared.setString(3, estados.getRegiao());
			prepared.setDouble(4, estados.getPopulacao());
			prepared.setLong(5, estados.getId());
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
			prepared = connection.prepareStatement("DELETE FROM tb_estados WHERE id_estados = ?");
			prepared.setLong(1, id);
			prepared.executeUpdate();
		} catch (SQLException erro) {
			throw new DBException(erro.getMessage());
		} finally {
			Conexao.closeStatement(prepared);
		}

	}

	@Override
	public List<Estados> findAll() {
		PreparedStatement prepared = null;
		ResultSet result = null;
		List<Estados> listaEstados = new ArrayList<>();
		try {
			prepared = connection.prepareStatement("SELECT * FROM tb_estados");
			result = prepared.executeQuery();
			while (result.next()) {
				Estados estados = new Estados();
				estados.setId(result.getLong("id_estados"));
				estados.setNome(result.getString("nome_estado"));
				estados.setSigla(result.getString("sigla_estado"));
				estados.setRegiao(result.getString("regiao_estado"));
				estados.setPopulacao(result.getDouble("populacao_estados"));
				listaEstados.add(estados);
			}
			return listaEstados;
		} catch (SQLException erro) {
			throw new DBException(erro.getMessage());
		} finally {
			Conexao.closeResultSet(result);
			Conexao.closeStatement(prepared);
		}
	}

}
