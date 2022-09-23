package model.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.Conexao;
import db.DBException;
import model.Cidades;
import model.Estados;
import model.dao.CidadesDao;

public class CidadesDaoJDBC implements CidadesDao {

	private Connection connection = null;

	public CidadesDaoJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void insert(Cidades cidades) {
		PreparedStatement prepared = null;
		try {
			prepared = connection.prepareStatement(
					"INSERT INTO tb_cidades (nome_cidade, estado_id, area_cidade, populacao_cidade) VALUES (?, ?,?, ?)");
			prepared.setString(1, cidades.getNome());
			prepared.setLong(2, cidades.getEstados().getId());
			prepared.setDouble(3, cidades.getArea());
			prepared.setDouble(4, cidades.getPopulacao());
			prepared.executeUpdate();
		} catch (SQLException erro) {
			throw new DBException(erro.getMessage());
		} finally {
			Conexao.closeStatement(prepared);
		}
	}

	@Override
	public Cidades findById(Long id) {
		PreparedStatement prepared = null;
		ResultSet result = null;
		Cidades cidades = null;
		Estados estados = null;
		try {
			prepared = connection.prepareStatement(
					"SELECT * FROM tb_cidades INNER JOIN tb_estados ON id_cidades = ? WHERE estado_id = id_estados");
			prepared.setLong(1, id);
			result = prepared.executeQuery();
			while (result.next()) {
				estados = new Estados(result.getLong("id_estados"), result.getString("nome_estado"),
						result.getString("sigla_estado"), result.getString("regiao_estado"),
						result.getDouble("populacao_estados"));
				cidades = new Cidades(result.getLong("id_cidades"), result.getString("nome_cidade"), estados,
						result.getDouble("area_cidade"), result.getDouble("populacao_cidade"));
			}
			return cidades;
		} catch (SQLException erro) {
			throw new DBException(erro.getMessage());
		} finally {
			Conexao.closeResultSet(result);
			Conexao.closeStatement(prepared);
		}

	}

	@Override
	public void update(Cidades cidades) {
		PreparedStatement prepared = null;
		try {
			prepared = connection.prepareStatement(
					"UPDATE tb_cidades SET nome_cidade = ?, estado_id = ?, area_cidade = ?, populacao_cidade = ? WHERE id_cidades = ? ");
			prepared.setString(1, cidades.getNome());
			prepared.setLong(2, cidades.getEstados().getId());
			prepared.setDouble(3, cidades.getArea());
			prepared.setDouble(4, cidades.getPopulacao());
			prepared.setLong(5, cidades.getId());
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
			prepared = connection.prepareStatement("DELETE FROM tb_cidades WHERE id_cidades = ?");
			prepared.setLong(1, id);
			prepared.executeUpdate();
		} catch (SQLException erro) {
			throw new DBException(erro.getMessage());
		} finally {
			Conexao.closeStatement(prepared);
		}

	}

	@Override
	public List<Cidades> findAll() {
		PreparedStatement prepared = null;
		ResultSet result = null;
		List<Cidades> listaCidades = new ArrayList<>();
		try {
			prepared = connection
					.prepareStatement("SELECT * FROM tb_cidades INNER JOIN tb_estados ON estado_id = id_estados");
			result = prepared.executeQuery();
			while (result.next()) {

				Estados estados = new Estados(result.getLong("id_estados"), result.getString("nome_estado"),
						result.getString("sigla_estado"), result.getString("regiao_estado"),
						result.getDouble("populacao_estados"));
				Cidades cidades = new Cidades(result.getLong("id_cidades"), result.getString("nome_cidade"), estados,
						result.getDouble("area_cidade"), result.getDouble("populacao_cidade"));
				
				listaCidades.add(cidades);
			}

			return listaCidades;
		} catch (SQLException erro) {
			throw new DBException(erro.getMessage());
		} finally {
			Conexao.closeResultSet(result);
			Conexao.closeStatement(prepared);
		}
	}

}
