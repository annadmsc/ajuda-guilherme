package com.example;

import jakarta.persistence.*;

import java.util.List;

public class AgenciaDAO {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("default");
    public boolean inserir(String agenciaid, String nome, String cidade) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Agencia agencia = new Agencia();
            agencia.setAgenciaid(agenciaid);
            agencia.setNome(nome);
            agencia.setCidade(cidade);
            em.persist(agencia);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean alterar(String id, String value, String column) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Agencia agencia = em.find(Agencia.class, id);
            em.getTransaction().begin();
            switch (column) {
                case "nome":
                    agencia.setNome(value);
                    break;
                case "cidade":
                    agencia.setCidade(value);
                    break;
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception s) {
            s.printStackTrace();
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }


    public boolean remover(String campo, Object valor) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = emf.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();

            Query query = em.createQuery("DELETE FROM Agencia agencia WHERE agencia." + campo + " = :valor");
            query.setParameter("valor", valor);
            int rowsDeleted = query.executeUpdate();

            transaction.commit();
            return rowsDeleted > 0;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    public void retornarTodos() {
        EntityManager em = null;

        try {
            em = emf.createEntityManager();

            Agencia agencia = new Agencia();

            Query query = em.createQuery("SELECT agencia FROM Agencia agencia ORDER BY agencia.agenciaid");
            List<Agencia> agencias = query.getResultList();

            System.out.println("Lista de agencias:");
            System.out.println("------------------");
            for (Agencia ag : agencias) {
                System.out.println("Agencia Id: " + ag.getAgenciaid());
                System.out.println("Nome: " + ag.getNome());
                System.out.println("Cidade: " + ag.getCidade());
                System.out.println("------------------");
            }

            em.close();
            emf.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
