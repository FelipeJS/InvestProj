package br.com.financas.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.financas.domain.Movimentacao;
import br.com.financas.util.HibernateUtil;

public class MovimentacaoDAO {

	public void salvar(Movimentacao movimentacao) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.save(movimentacao);
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
	public ArrayList<Movimentacao> listar(int codigoUsuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<Movimentacao> movimentacoes = null;

		try {
			Query consulta = session.getNamedQuery("Movimentacao.listar");
			consulta.setInteger("codigoUsuario", codigoUsuario);

			movimentacoes = (ArrayList<Movimentacao>) consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}

		return movimentacoes;
	}

	public Movimentacao buscarPorCodigo(int codigo, int codigoUsuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Movimentacao movimentacao = null;

		try {
			Query consulta = session.getNamedQuery("Movimentacao.buscarPorCodigo");
			consulta.setInteger("codigo", codigo);
			consulta.setInteger("codigoUsuario", codigoUsuario);

			movimentacao = (Movimentacao) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return movimentacao;
	}

	public void excluir(Movimentacao movimentacao) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.delete(movimentacao);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null)
				transacao.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	public void editar(Movimentacao movimentacao) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.update(movimentacao);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null)
				transacao.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}
}
