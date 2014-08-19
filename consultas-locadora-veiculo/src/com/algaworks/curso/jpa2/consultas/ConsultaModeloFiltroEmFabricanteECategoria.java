package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaModeloFiltroEmFabricanteECategoria {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select mc.descricao, mc.categoria from ModeloCarro mc where "
													+ " mc.fabricante.nome = 'Honda'"
													+ " or mc.fabricante.nome = 'Chevrolet'"
													+ " and mc.categoria in('SEDAN_MEDIO')";
		@SuppressWarnings("unchecked")
		List<Object[]> resultados = em.createQuery(jpql).getResultList();
		
		for (Object[] obj : resultados) {
			System.out.println("Descricao: " + obj[0] + ". Categoria: " + obj[1]);
		}
		
		em.close();
	}

}
