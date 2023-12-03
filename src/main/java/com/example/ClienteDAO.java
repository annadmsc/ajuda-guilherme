package com.example;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

public class ClienteDAO {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("default");


    public boolean inserir(String clienteid, String nome, String cidade, String telefone, String profissao, Date nascimento) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Cliente cliente = new Cliente();
            cliente.setClienteid(clienteid);
            cliente.setNome(nome);
            cliente.setCidade(cidade);
            cliente.setTelefone(telefone);
            cliente.setProfissao(profissao);
            cliente.setNascimento(nascimento);
            em.persist(cliente);
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
            Cliente cliente = em.find(Cliente.class, id);
            em.getTransaction().begin();
            switch (column) {
                case "nome":
                    cliente.setNome(value);
                    break;
                case "cidade":
                    cliente.setCidade(value);
                    break;
                case "telefone":
                    cliente.setTelefone(value);
                    break;
                case "profissao":
                    cliente.setProfissao(value);
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

    public boolean alterar(int id, Date value, String column) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Cliente cliente = em.find(Cliente.class, id);
            em.getTransaction().begin();
            switch (column) {
                case "nascimento":
                    cliente.setNascimento(value);
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

            Query query = em.createQuery("DELETE FROM Cliente cliente WHERE cliente." + campo + " = :valor");
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

            Cliente cliente = new Cliente();

            Query query = em.createQuery("SELECT cliente FROM Cliente cliente ORDER BY cliente.clienteid");
            List<Cliente> clientes = query.getResultList();

            System.out.println("Lista de clientes:");
            System.out.println("------------------");
            for (Cliente cl : clientes) {
                System.out.println("Cliente Id: " + cl.getClienteid());
                System.out.println("Nome: " + cl.getNome());
                System.out.println("Cidade: " + cl.getCidade());
                System.out.println("Telefone: " + cl.getTelefone());
                System.out.println("Profissão: " + cl.getProfissao());
                System.out.println("Nascimento: " + cl.getNascimento());
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
