package mz.co.Lunguissa.modelo;

public class Cliente
{
	private String nome;
	private String Apelito;
	private String numCel;
	private boolean reg;
	private String enderenco;
	private Servico servico;
	
	public Cliente(String nome, String apelito, String numCel, boolean reg, String enderenco,Servico servico)
	{
		super();
		this.nome = nome;
		Apelito = apelito;
		this.numCel = numCel;
		this.reg = reg;
		this.enderenco = enderenco;
		this.servico=servico;
	}

	public String getNome()
	{
		return nome;
	}

	@Override
	public String toString()
	{
		return "Cliente [nome=" + nome + ", Apelito=" + Apelito + ", numCel="
				+ numCel + ", reg=" + reg + ", enderenco=" + enderenco
				+ ", servico=" + servico + "]";
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getApelito()
	{
		return Apelito;
	}

	public void setApelito(String apelito)
	{
		Apelito = apelito;
	}

	public String getNumCel()
	{
		return numCel;
	}

	public void setNumCel(String numCel)
	{
		this.numCel = numCel;
	}

	public boolean isReg()
	{
		return reg;
	}

	public void setReg(boolean reg)
	{
		this.reg = reg;
	}

	public String getEnderenco()
	{
		return enderenco;
	}

	public void setEnderenco(String enderenco)
	{
		this.enderenco = enderenco;
	}

	public Servico getServico()
	{
		return servico;
	}

	public void setServico(Servico servico)
	{
		this.servico = servico;
	}

	
}
