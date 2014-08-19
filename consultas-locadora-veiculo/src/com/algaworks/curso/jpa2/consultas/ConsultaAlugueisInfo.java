package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.modelo.AluguelCarroInfo;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaAlugueisInfo {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select NEW com.algaworks.curso.jpa2.modelo.AluguelCarroInfo(c, count(a), " 
               + "max(a.valorTotal), avg(a.valorTotal), sum(a.valorTotal)) "
               + "from Carro c JOIN c.alugueis a " 
               + "group by c " 
               + "having count(a) > 1";
		
		List<AluguelCarroInfo> resultados = em.createQuery(jpql, AluguelCarroInfo.class).getResultList();
		for (AluguelCarroInfo aci : resultados) {
		    System.out.println("Modelo: " + aci.getCarro().getModelo().getDescricao());
		    System.out.println("Quantidade de alugueis: " + aci.getTotalAlugueis());
		    System.out.println("Valor máximo: " + aci.getValorMaximo());
		    System.out.println("Valor médio: " + aci.getValorMedio());
		    System.out.println("Valor total: " + aci.getValorTotal());
		    System.out.println();
		}
		
		
		em.close();
		
	}

}
