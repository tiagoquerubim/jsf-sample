package br.com.livraria.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.RollbackException;

import br.com.livraria.dao.DAO;
import br.com.livraria.modelo.Autor;

@ManagedBean
@ViewScoped
public class AutorBean {

	private Autor autor = new Autor();

	public Autor getAutor() {
		return autor;
	}
	
	public List<Autor> getAutores(){
		return new DAO<Autor>(Autor.class).listaTodos();
	}

	public String gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());
		
		if(autor.getId() == null){
			new DAO<Autor>(Autor.class).adiciona(this.autor);
		} else{
			new DAO<Autor>(Autor.class).atualiza(this.autor);
		}

		
		this.autor = new Autor();
		
		return "livro?faces-redirect=trur";
	}
	
	public void carregar(Autor autor){
		this.autor = autor;
	}
	
	public void remover(Autor autor){
		try {
			new DAO<Autor>(Autor.class).remove(autor);
		} catch (RollbackException e) {
			FacesContext.getCurrentInstance().addMessage("formTabelaAutores",
					new FacesMessage("Não é possivel remover esse autor pois já existem livros associados a ele."));
		}
	}
}
