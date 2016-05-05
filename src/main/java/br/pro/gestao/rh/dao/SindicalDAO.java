package br.pro.gestao.rh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.pro.gestao.rh.domain.Sindical;
import br.pro.gestao.rh.util.HibernateUtil;

public class SindicalDAO extends GenericDAO<Sindical> {
	@SuppressWarnings("unchecked")
	public List<Sindical> buscarPorEmpregado(Long empregadoCodigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Sindical.class);
			consulta.add(Restrictions.eq("empregado.codigo", empregadoCodigo));

			List<Sindical> resultado = consulta.list();
			return resultado;
			
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
}
