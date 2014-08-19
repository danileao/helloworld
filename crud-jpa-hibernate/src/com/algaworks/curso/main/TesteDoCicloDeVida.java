package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.algaworks.curso.modelo.Cliente;

public class TesteDoCicloDeVida {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Fernando Alonso");
		cliente1.setIdade(32);
		cliente1.setProfissao("Piloto");
		cliente1.setSexo("M");
		
		em.getTransaction().begin();
		em.persist(cliente1);
		em.getTransaction().commit();
		
		// Agora passamos cliente1 para o estado "detached"
		em.detach(cliente1);
		
		// Se tentarmos agora, persistir uma entidade que está desanexada, 
		// iremos receber uma exception
		try {
			em.getTransaction().begin();
			cliente1.setIdade(33);
			em.persist(cliente1);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			System.err.println("Erro ao persistir a entidade. " + e.getMessage());
			em.getTransaction().rollback();
		}
		
		// Buscando no banco de dados. Atenção ao valor do código!
		cliente1 = em.find(Cliente.class, 1L);
		em.getTransaction().begin();
		cliente1.setIdade(33); // Agora sim conseguimos alterar a idade
		em.getTransaction().commit();
		
		// Agora entrando no estado removed
		em.getTransaction().begin();
		em.remove(cliente1);
		em.getTransaction().commit();
		
		// Reconectando um objeto removido.
		Cliente cliente2 = em.merge(cliente1);
		System.out.println(cliente1 == cliente2);
		em.getTransaction().begin();
		cliente1.setIdade(34); // Não irá alterar a idade!
		em.getTransaction().commit();
				
		em.getTransaction().begin();
		cliente2.setIdade(34); // Agora sim irá alterar a idade.
		em.getTransaction().commit();
	}

}
