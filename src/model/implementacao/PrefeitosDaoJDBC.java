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
import model.Prefeitos;
import model.dao.PrefeitosDao;

public class PrefeitosDaoJDBC implements PrefeitosDao {

	private Connection connection = null;

	public PrefeitosDaoJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void insert(Prefeitos prefeitos) {
		PreparedStatement prepared = null;
		try {
			prepared = connection.prepareStatement("INSERT INTO tb_prefeitos (nome_prefeito, cidade_id)VALUES(?, ?)");
			prepared.setString(1, prefeitos.getNome());
			prepared.setLong(2, prefeitos.getCidades().getId());
			prepared.executeUpdate();
		} catch (SQLException erro) {
			throw new DBException(erro.getMessage());
		} finally {
			Conexao.closeStatement(prepared);
		}

	}

	@Override
	public Prefeitos findById(Long id) {
		PreparedStatement prepared = null;
		ResultSet result = null;
		Prefeitos prefeitos = new Prefeitos();
		try {
			prepared = connection.prepareStatement(
					"SELECT * FROM tb_prefeitos INNER JOIN tb_cidades INNER JOIN tb_estados ON tb_prefeitos.cidade_id = tb_cidades.id_cidades "
					+ "AND tb_cidades.estado_id = tb_estados.id_estados WHERE tb_prefeitos.id_prefeito = ?");
			prepared.setLong(1, id);
			result = prepared.executeQuery();
			while (result.next()) {
				Estados estados = new Estados(result.getLong("id_estados"), result.getString("nome_estado"),
						result.getString("sigla_estado"), result.getString("regiao_estado"),
						result.getDouble("populacao_estados"));
				Cidades cidades = new Cidades(result.getLong("id_cidades"), result.getString("nome_cidade"), estados,
						result.getDouble("area_cidade"), result.getDouble("populacao_cidade"));
				prefeitos.setNome(result.getString("nome_prefeito"));
				prefeitos.setCidades(cidades);
			}
			return prefeitos;
		} catch (SQLException erro) {
			throw new DBException(erro.getMessage());
		} finally {
			Conexao.closeResultSet(result);
			Conexao.closeStatement(prepared);
		}
	}

	@Override
	public void update(Prefeitos prefeitos) {
		PreparedStatement prepared = null;
		try {
			prepared = connection
					.prepareStatement("UPDATE tb_prefeitos SET nome_prefeito = ?, cidade_id = ? WHERE id_prefeito = ?");
			prepared.setString(1, prefeitos.getNome());
			prepared.setLong(2, prefeitos.getCidades().getId());
			prepared.setLong(3, prefeitos.getId());
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
			prepared = connection.prepareStatement("DELETE FROM tb_prefeitos WHERE id_prefeito = ?");
			prepared.setLong(1, id);
			prepared.executeUpdate();
		} catch (SQLException erro) {
			throw new DBException(erro.getMessage());
		} finally {
			Conexao.closeStatement(prepared);
		}
	}

	@Override
	public List<Prefeitos> findAll() {
		PreparedStatement prepared = null;
		ResultSet result = null;
		List<Prefeitos> listaPrefeitos = new ArrayList<>();
		try {
			prepared = connection.prepareStatement(
					"SELECT * FROM tb_prefeitos INNER JOIN tb_cidades INNER JOIN tb_estados ON tb_prefeitos.cidade_id = tb_cidades.id_cidades AND tb_cidades.estado_id = tb_estados.id_estados");
			result = prepared.executeQuery();
			while (result.next()) {
				Estados estados = new Estados(result.getLong("id_estados"), result.getString("nome_estado"),
						result.getString("sigla_estado"), result.getString("regiao_estado"),
						result.getDouble("populacao_estados"));
				Cidades cidades = new Cidades(result.getLong("id_cidades"), result.getString("nome_cidade"), estados,
						result.getDouble("area_cidade"), result.getDouble("populacao_cidade"));
				Prefeitos prefeitos = new Prefeitos(result.getLong("id_prefeito"), result.getString("nome_prefeito"),
						cidades);
				listaPrefeitos.add(prefeitos);
			}
			return listaPrefeitos;
		} catch (SQLException erro) {
			throw new DBException(erro.getMessage());
		} finally {
			Conexao.closeResultSet(result);
			Conexao.closeStatement(prepared);
		}
	}

}
