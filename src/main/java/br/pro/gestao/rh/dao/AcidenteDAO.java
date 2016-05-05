package br.pro.gestao.rh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.pro.gestao.rh.domain.Acidente;
import br.pro.gestao.rh.util.HibernateUtil;

public class AcidenteDAO extends GenericDAO<Acidente> {
	
	@SuppressWarnings("unchecked")
	public List<Acidente> buscarPorEmpregado(Long empregadoCodigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Acidente.class);
			consulta.add(Restrictions.eq("empregado.codigo", empregadoCodigo));

			List<Acidente> resultado = consulta.list();
			return resultado;
			
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

}
