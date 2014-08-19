package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultasAgregadasEmCarro {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		String jpql = " select c, count(a), max(a.valorTotal), avg(a.valorTotal), sum(a.valorTotal) "
						+ " from Carro c JOIN c.alugueis a "
						+ " group by c "
						+ " having count(a) > 1";
		
		List<Object[]> resultados = em.createQuery(jpql).getResultList();
		
		for (Object[] obj : resultados) {
			System.out.println("----------------");
			System.out.println("Modelo do carro: " + ((Carro)obj[0]).getModelo().getDescricao());
			System.out.println("Quantidade de alugueis: " + obj[1]);
			System.out.println("Valor Maximo: " + obj[2]);
			System.out.println("Valor médio: " + obj[3]);
			System.out.println("Soma: " + obj[4]);
		}
		
		em.close();
	}

}
