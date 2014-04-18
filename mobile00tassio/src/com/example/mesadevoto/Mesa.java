package com.example.mesadevoto;


public class Mesa  
{
	private String nomeMesa;
	private String provincia;
	private String distrito;
	private String localidade;
	private long votos;
	
	
		public Mesa(String nomeMesa,String provincia, String distrito, String localidade, long votos) {
		super();
		this.nomeMesa=nomeMesa;
		this.provincia = provincia;
		this.distrito = distrito;
		this.localidade = localidade;
		this.votos = votos;
	}

	public String getProvincia() {
		return provincia;
	}
	
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public long getVotos() {
		return votos;
	}

	public void setVotos(long votos) {
		this.votos = votos;
	}
	

	public String getNomeMesa() {
		return nomeMesa;
	}

	public void setNomeMesa(String nomeMesa) {
		this.nomeMesa = nomeMesa;
	}

	@Override
	public String toString() {
		return  nomeMesa + "\nprovincia: " + provincia
				+ "\ndistrito: " + distrito + "\nlocalidade: " + localidade
				+ "\nvotos: " + votos ;
	}

	
	
	
	
}
