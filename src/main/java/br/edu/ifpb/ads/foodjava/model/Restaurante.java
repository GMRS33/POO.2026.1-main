package br.edu.ifpb.ads.foodjava.model;

public class Restaurante {
	
	private String nomeFantasia;
	private String cnpj;
	private String endereco;
	private String telefone;
	private String categoriaCulinaria;
	private String email;
	
	public Restaurante(String nomeFantasia, String cnpj, String endereco, String telefone, String categoriaCulinaria,
			String email) {
		super();
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
		this.categoriaCulinaria = categoriaCulinaria;
		this.email = email;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCategoriaCulinaria() {
		return categoriaCulinaria;
	}

	public void setCategoriaCulinaria(String categoriaCulinaria) {
		this.categoriaCulinaria = categoriaCulinaria;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}


