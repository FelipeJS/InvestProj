package br.com.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.domain.Cliente;
import br.com.util.HibernateUtil;

public class ClienteDAO {

	public void salvar(Cliente cliente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.save(cliente);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null)
				transacao.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Cliente> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<Cliente> clientes = null;

		try {
			Query consulta = session.getNamedQuery("Cliente.listar");
			clientes = (ArrayList<Cliente>) consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}

		return clientes;
	}

	public Cliente buscarPorCodigo(int codigo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Cliente cliente = null;

		try {
			Query consulta = session.getNamedQuery("Cliente.buscarPorCodigo");
			consulta.setInteger("codigo", codigo);

			cliente = (Cliente) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return cliente;
	}

	public void excluir(Cliente cliente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.delete(cliente);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null)
				transacao.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	public void editar(Cliente cliente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.update(cliente);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null)
				transacao.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	public Cliente autenticar(Cliente autenticado) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Cliente cliente = null;

		try {
			Query consulta = session.getNamedQuery("Cliente.autenticar");
			consulta.setParameter("login", autenticado.getLogin());
			consulta.setParameter("senha", autenticado.getSenha());

			cliente = (Cliente) consulta.uniqueResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return cliente;
	}
}
