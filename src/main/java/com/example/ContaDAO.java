package com.example;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

public class ContaDAO {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("default");


    public boolean inserir(String contaid, String agenciaid,String clienteId, Float saldo, Date abertura, int tipo, boolean ativa) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Conta conta = new Conta();
            conta.setContaid(contaid);
            conta.setAgenciaid(agenciaid);
            conta.setClienteid(clienteId);
            conta.setSaldo(saldo);
            conta.setAbertura(abertura);
            conta.setTipo(tipo);
            conta.setAtiva(ativa);
            em.persist(conta);
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

    public boolean alterar(String id, Float value, String column) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Conta conta = em.find(Conta.class, id);
            em.getTransaction().begin();
            switch (column) {
                case "saldo":
                    conta.setSaldo(value);
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

    public boolean alterar(String id, Boolean value, String column) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Conta conta = em.find(Conta.class, id);
            em.getTransaction().begin();
            switch (column) {
                case "ativa":
                    conta.setAtiva(value);
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

    public boolean alterar(String id, Date value, String column) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Conta conta = em.find(Conta.class, id);
            em.getTransaction().begin();
            switch (column) {
                case "abertura":
                    conta.setAbertura(value);
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

    public boolean alterar(String id, int value, String column) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Conta conta = em.find(Conta.class, id);
            em.getTransaction().begin();
            switch (column) {
                case "tipo":
                    conta.setTipo(value);
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

            Query query = em.createQuery("DELETE FROM Conta conta WHERE conta." + campo + " = :valor");
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

            Conta conta = new Conta();

            Query query = em.createQuery("SELECT conta FROM Conta conta ORDER BY conta.contaid");
            List<Conta> contas = query.getResultList();
            System.out.println("Lista de contas:");
            System.out.println("------------------");
            for (Conta co : contas) {
                System.out.println("Conta Id: " + co.getContaid());
                System.out.println("Cliente Id: " + co.getClienteid());
                System.out.println("Agencia Id: " + co.getAgenciaid());
                System.out.println("Saldo: " + co.getSaldo());
                System.out.println("Abertura: " + co.getAbertura());
                System.out.println("Tipo: " + co.getTipo());
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
