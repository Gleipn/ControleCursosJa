package br.com.cursosja.controlecursoja.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cursosja.controlecursoja.model.entidade.Curso;
import br.com.cursosja.controlecursoja.model.entidade.Professor;
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
		
		String sql = "select t.*, c.nome as nomecurso, p.nome as nomeprof from turma t "
				+ "inner join curso c on c.idcurso = t.curso_id "
				+ "inner join professor p on p.idprofessor = t.professor_id "
				+ "order by t.datainicio";
				
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			Turma t = null;
			Curso c = null;
			Professor p = null;
			
			while(rs.next()) {
				t = new Turma();
				
				t.setId(rs.getLong("idturma"));
				t.setDataInicio(rs.getDate("datainicio"));
				t.setDataFim(rs.getDate("datafim"));
				
				c = new Curso();
				c.setId(rs.getLong("curso_id"));
				c.setNome(rs.getString("nomecurso"));
				t.setCurso(c);
				
				p = new Professor();
				p.setId(rs.getLong("professor_id"));
				p.setNome(rs.getString("nomeprof"));
				t.setProfessor(p);
				
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
