package com.example;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

public class Tipos_contaDAO {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("default");

    public boolean inserir(int tipoid, String tiponome) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Tipos_conta tipos_conta = new Tipos_conta();
            tipos_conta.setTipoid(tipoid);
            tipos_conta.setTiponome(tiponome);
            em.persist(tipos_conta);
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

    public boolean alterar(int id, String value, String column) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Tipos_conta tipos_conta = em.find(Tipos_conta.class, id);
            em.getTransaction().begin();
            switch (column) {
                case "tiponome":
                    tipos_conta.setTiponome(value);
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

            Query query = em.createQuery("DELETE FROM Tipos_conta tipos_conta WHERE tipos_conta." + campo + " = :valor");
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

            Tipos_conta tipos_conta = new Tipos_conta();

            Query query = em.createQuery("SELECT tipos_conta FROM Tipos_conta tipos_conta ORDER BY tipos_conta.tipoid");
            List<Tipos_conta> tipos_contas = query.getResultList();

            System.out.println("Lista de Tipos Contas:");
            System.out.println("------------------");
            for (Tipos_conta tc : tipos_contas) {
                System.out.println("Tipos_conta Id: " + tc.getTipoid());
                System.out.println("Nome: " + tc.getTiponome());
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
