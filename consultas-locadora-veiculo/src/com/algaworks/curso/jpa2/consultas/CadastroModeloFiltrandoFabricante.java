package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class CadastroModeloFiltrandoFabricante {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<String> modelosCarro = em.createQuery("select mc.descricao from ModeloCarro mc where mc.fabricante.nome = 'Honda'", String.class)
				.getResultList();
		
		for (String modelo : modelosCarro) {
			System.out.println(modelo);
		}
		
		em.close();

	}
}
