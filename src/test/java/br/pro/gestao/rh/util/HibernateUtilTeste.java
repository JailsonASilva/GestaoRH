package br.pro.gestao.rh.util;

import org.hibernate.Session;
import org.junit.Test;

import br.pro.gestao.rh.util.HibernateUtil;

public class HibernateUtilTeste {
	@Test
	public void conectar(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}
}
