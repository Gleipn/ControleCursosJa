package br.com.cursosja.controlecursoja.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cursosja.controlecursoja.model.entidade.Curso;

public class CursoDao extends Conexao{
	
	public boolean incluir(Curso curso) {
		boolean ok = false;
		String sql = "insert into curso (nome, valor) " + "values (?, ?) ";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, curso.getNome());
			ps.setDouble(2, curso.getValor());
			
			ok = ps.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
			
			ok = false;
		} finally {
			fecharConexao();
		}
		
		return false;
	}

	public List<Curso> listar(String nomeBusca){
		List<Curso> lista = new ArrayList<Curso>();
		
		String sql = "select * from curso "
				+ "where nome like ? "
				+ "order by nome";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, "%" + nomeBusca + "%");
			
			ResultSet rs = ps.executeQuery();
			
			Curso c;
			while(rs.next()) {
				c = new Curso();
				c.setId(rs.getLong("idcurso"));
				c.setNome(rs.getString("nome"));
				c.setValor(rs.getDouble("valor"));
				
				lista.add(c);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return lista;
	}

	public Curso buscar(long id) {
		Curso c = null;
		
		String sql = "select * from curso where idcurso = ? ";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				c = new Curso();
				c.setId(rs.getLong("idcurso"));
				c.setNome(rs.getString("nome"));
				c.setValor(rs.getDouble("valor"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return c;
	}

	public boolean alterar(Curso c) {
		boolean ok = true;
		
		String sql = "update curso set nome = ?, valor = ? where idcurso = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setDouble(2, c.getValor());
			ps.setLong(3, c.getId());
			
			ps.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
			
			ok = false;
		} finally {
			fecharConexao();
		}
		
		return ok;
	}

	public boolean excluir(long id) {
		boolean ok = true;
		 
		String sql = "delete from curso where idcurso = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ok = ps.execute();
		} catch(Exception e) {
			e.printStackTrace();
			ok = false;
		} finally {
			fecharConexao();
		}
		
		return ok;
	}
}
