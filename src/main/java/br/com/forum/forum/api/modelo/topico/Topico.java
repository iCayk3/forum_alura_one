package br.com.forum.forum.api.modelo.topico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.forum.forum.api.modelo.resposta.Resposta;
import br.com.forum.forum.api.modelo.usuario.Usuario;
import br.com.forum.forum.api.modelo.curso.Curso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
	@ManyToOne
	@JoinColumn(name = "id_autor")
	private Usuario autor;
	@ManyToOne
	@JoinColumn(name = "id_curso")
	private Curso curso;
	@OneToMany(mappedBy = "topico")
	private List<Resposta> respostas = new ArrayList<>();

	public Topico(String titulo, String mensagem, Usuario usuario, Curso curso) {
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.autor = usuario;
		this.curso = curso;
	}

	public void atualizarInformacoes(DadosAtualizacaoTopico dados) {
		if (dados.topico() != null) {
			this.titulo = dados.topico();
		}
		if (dados.mensagem() != null) {
			this.mensagem = dados.mensagem();
		}

	}



//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		return result;
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Topico other = (Topico) obj;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		return true;
//	}

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getTitulo() {
//		return titulo;
//	}
//
//	public void setTitulo(String titulo) {
//		this.titulo = titulo;
//	}
//
//	public String getMensagem() {
//		return mensagem;
//	}
//
//	public void setMensagem(String mensagem) {
//		this.mensagem = mensagem;
//	}
//
//	public LocalDateTime getDataCriacao() {
//		return dataCriacao;
//	}
//
//	public void setDataCriacao(LocalDateTime dataCriacao) {
//		this.dataCriacao = dataCriacao;
//	}
//
//	public StatusTopico getStatus() {
//		return status;
//	}
//
//	public void setStatus(StatusTopico status) {
//		this.status = status;
//	}
//
//	public Usuario getAutor() {
//		return autor;
//	}
//
//	public void setAutor(Usuario autor) {
//		this.autor = autor;
//	}
//
//	public Curso getCurso() {
//		return curso;
//	}
//
//	public void setCurso(Curso curso) {
//		this.curso = curso;
//	}
//
//	public List<Resposta> getRespostas() {
//		return respostas;
//	}
//
//	public void setRespostas(List<Resposta> respostas) {
//		this.respostas = respostas;
//	}

}
