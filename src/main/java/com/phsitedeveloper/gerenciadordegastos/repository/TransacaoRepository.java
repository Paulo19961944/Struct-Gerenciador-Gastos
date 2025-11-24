package com.phsitedeveloper.gerenciadordegastos.repository;

import com.phsitedeveloper.gerenciadordegastos.model.Transacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class TransacaoRepository {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");

    public Transacao salvar(Transacao transacao) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (transacao.getId() == null) {
                em.persist(transacao);
            } else {
                transacao = em.merge(transacao);
            }
            tx.commit();
            return transacao;
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            em.close();
        }
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Transacao transacao = em.find(Transacao.class, id);
            if (transacao != null) {
                em.remove(transacao);
            }
            tx.commit();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            em.close();
        }
    }

    public List<Transacao> listarTodas() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT t FROM Transacao t ORDER BY t.data DESC", Transacao.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Transacao> listarPorTipo(String tipo) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT t FROM Transacao t WHERE t.tipo = :tipo ORDER BY t.data DESC", Transacao.class)
                    .setParameter("tipo", tipo)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public double somarPorTipo(String tipo) {
        EntityManager em = emf.createEntityManager();
        try {
            Double total = em.createQuery("SELECT COALESCE(SUM(t.valor), 0) FROM Transacao t WHERE t.tipo = :tipo", Double.class)
                    .setParameter("tipo", tipo)
                    .getSingleResult();
            return total != null ? total : 0;
        } finally {
            em.close();
        }
    }
}
