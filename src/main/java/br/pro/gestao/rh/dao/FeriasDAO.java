package br.pro.gestao.rh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.pro.gestao.rh.domain.Ferias;
import br.pro.gestao.rh.util.HibernateUtil;

public class FeriasDAO extends GenericDAO<Ferias>  {
	@SuppressWarnings("unchecked")
	public List<Ferias> buscarPorEmpregado(Long empregadoCodigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Ferias.class);
			consulta.add(Restrictions.eq("empregado.codigo", empregadoCodigo));

			List<Ferias> resultado = consulta.list();
			return resultado;
			
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
}
