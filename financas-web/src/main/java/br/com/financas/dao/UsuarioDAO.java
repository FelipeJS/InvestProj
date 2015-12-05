package br.com.financas.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.financas.domain.Usuario;
import br.com.financas.util.HibernateUtil;

public class UsuarioDAO {

	public void salvar(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
	
		try {
			transacao = session.beginTransaction();
			session.save(usuario);
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
	public ArrayList<Usuario> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<Usuario> usuarios = null;

		try {
			Query consulta = session.getNamedQuery("Usuario.listar");
			usuarios = (ArrayList<Usuario>) consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}

		return usuarios;
	}

	public Usuario buscarPorCodigo(int codigo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario = null;

		try {
			Query consulta = session.getNamedQuery("Usuario.buscarPorCodigo");
			consulta.setInteger("codigo", codigo);

			usuario = (Usuario) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return usuario;
	}

	public void excluir(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.delete(usuario);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null)
				transacao.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	public void editar(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.update(usuario);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null)
				transacao.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	public Usuario autenticar(Usuario autenticado) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario = null;

		try {
			Query consulta = session.getNamedQuery("Usuario.autenticar");
			consulta.setParameter("email", autenticado.getEmail());
			consulta.setParameter("senha", autenticado.getSenha());

			usuario = (Usuario) consulta.uniqueResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return usuario;
	}
}
