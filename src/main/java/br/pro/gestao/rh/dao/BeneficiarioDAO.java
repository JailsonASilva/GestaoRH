package br.pro.gestao.rh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import br.pro.gestao.rh.domain.Beneficiario;
import br.pro.gestao.rh.util.HibernateUtil;

public class BeneficiarioDAO extends GenericDAO<Beneficiario> {

	@SuppressWarnings("unchecked")
	public List<Beneficiario> listarBeneficiarios(Long empregadoCodigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();	
		
		try {
			String sql = "SELECT * "+
					     "FROM beneficiario "+
					     "WHERE empregado_codigo = " + empregadoCodigo +
					     " ORDER BY nome";

			SQLQuery query = sessao.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

			List<Beneficiario> resultado = query.list();

			return resultado;

		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}		
	}

}
	
