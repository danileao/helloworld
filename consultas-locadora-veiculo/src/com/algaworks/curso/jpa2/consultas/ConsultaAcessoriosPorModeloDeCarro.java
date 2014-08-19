package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaAcessoriosPorModeloDeCarro {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		
		String jpql = "select a.descricao from Carro c JOIN c.acessorios a where c.modelo.descricao = 'Civic'";
		
		List<String> acessorios = em.createQuery(jpql, String.class).getResultList();
		
		for (String acessorio : acessorios) {
			System.out.println(acessorio);
		}
		
		em.close();
	}

}
