package br.pro.gestao.rh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.pro.gestao.rh.domain.Bairro;
import br.pro.gestao.rh.util.HibernateUtil;

public class BairroDAO extends GenericDAO<Bairro> {
	@SuppressWarnings("unchecked")
	public List<Bairro> buscarPorCidade(Long cidadeCodigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Bairro.class);
			consulta.add(Restrictions.eq("cidade.codigo", cidadeCodigo));
			consulta.addOrder(Order.asc("nome"));
			List<Bairro> resultado = consulta.list();
			return resultado;
			
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
}
