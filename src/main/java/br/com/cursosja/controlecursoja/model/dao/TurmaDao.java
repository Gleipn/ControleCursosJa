package br.com.cursosja.controlecursoja.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cursosja.controlecursoja.model.entidade.Turma;

public class TurmaDao extends Conexao {
	
	public boolean incluir(Turma t) {
		boolean ok = false;
		
		String sql = "insert into turma (datainicio, datafim, curso_id, professor_id) "
				+ "values (?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setDate(1, new java.sql.Date(t.getDataInicio().getTime()));
			ps.setDate(2, new java.sql.Date(t.getDataFim().getTime()));
			ps.setLong(3, t.getCurso().getId());
			ps.setLong(4, t.getProfessor().getId());
			
			ok = ps.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return ok;
	}

	public List<Turma> listar(){
		List<Turma> turmas = new ArrayList<Turma>();
		
		String sql = "select * from turma";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			Turma t = null;
			
			while(rs.next()) {
				t = new Turma();
				
				t.setId(rs.getLong("idturma"));
				t.setDataInicio(rs.getDate("datainicio"));
				t.setDataFim(rs.getDate("datafim"));
				
				turmas.add(t);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return turmas;
	}
}
