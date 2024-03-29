package br.com.etechoracio.jpa.test;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.lang.exception.ExceptionUtils;

import br.com.etechoracio.jpa.model.Produto;


@ManagedBean
public class ValidadorMB {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void doValida() {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ETEC");
			EntityManager em = emf.createEntityManager();
			em.find(Produto.class, 1L);
			message = "Conex�o OK";
		} catch (Exception e) {
			message = ExceptionUtils.getFullStackTrace(e);
			message = message.replaceAll("\\n", "<br/>");
		}
	}
}
