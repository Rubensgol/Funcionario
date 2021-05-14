package model;

import util.Incriptacao;

public class Usuario {
	private String usuario;
	private String senha;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		if (!senha.equals(getUsuario())) {
			this.senha = Incriptacao.transforma(senha);
		}
		
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [usuario=");
		builder.append(usuario);
		builder.append(", senha=");
		builder.append(senha);
		builder.append("]");
		return builder.toString();
	}
	
	

}
