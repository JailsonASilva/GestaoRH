package br.pro.gestao.rh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.pro.gestao.rh.domain.Beneficiario;
import br.pro.gestao.rh.util.HibernateUtil;

public class BeneficiarioDAO extends GenericDAO<Beneficiario> {
	@SuppressWarnings("unchecked")
	public List<Beneficiario> listar2() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Beneficiario.class);
			List<Beneficiario> resultado = consulta.list();
			
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

}
