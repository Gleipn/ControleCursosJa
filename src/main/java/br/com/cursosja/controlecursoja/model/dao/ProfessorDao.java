package br.com.cursosja.controlecursoja.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cursosja.controlecursoja.model.entidade.Professor;

public class ProfessorDao extends Conexao{
	
	public boolean incluir(Professor professor) {
		boolean ok = false;
		String sql = "insert into professor (nome, celular, valorhora) " +
								"values (?, ?, ?) ";
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cursoja",
					//"root", "");
			
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, professor.getNome());
			ps.setString(2, professor.getCelular());
			ps.setDouble(3, professor.getValorHora());
			
			ok = ps.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
			
			ok = false;
		} finally {
			fecharConexao();
		}
		
		return false;
	}
	
	public List<Professor> listar(String nomeBusca){
		List<Professor> lista = new ArrayList<Professor>();
		
		String sql = "select * from professor where nome like ? order by nome";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, "%" + nomeBusca + "%");
			
			ResultSet rs = ps.executeQuery();
			
			Professor c;
			while(rs.next()) {
				c = new Professor();
				c.setId(rs.getLong("idProfessor"));
				c.setNome(rs.getString("nome"));
				c.setValorHora(rs.getDouble("valorHora"));
				c.setCelular(rs.getString("celular"));
				
				lista.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return lista;
	}

	public Professor buscar(long id) {
		Professor c = null;
		
		String sql = "select * from professor where idprofessor = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				c = new Professor();
				c.setId(rs.getLong("idProfessor"));
				c.setNome(rs.getString("nome"));
				c.setCelular(rs.getString("celular"));
				c.setValorHora(rs.getDouble("valorHora"));
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return c;
	}

	public boolean alterar(Professor c) {
		boolean ok = true;
		
		String sql = "update professor set nome = ?, celular = ?, valorhora = ? "
				+ "where idprofessor = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getCelular());
			ps.setDouble(3, c.getValorHora());
			ps.setLong(4, c.getId());
			
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
		
		String sql = "delete from professor where idprofessor = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ps.execute();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return ok;
	}

	
	
	
}
