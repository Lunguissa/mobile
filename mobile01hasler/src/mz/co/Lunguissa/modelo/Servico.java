package mz.co.Lunguissa.modelo;

public class Servico
{
	private boolean corte;
	private boolean desflizagem;
	private boolean lavagem;
	
	
	public Servico(boolean corte, boolean desflizagem, boolean lavagem)
	{
		super();
		this.corte = corte;
		this.desflizagem = desflizagem;
		this.lavagem = lavagem;
	}
	public boolean isCorte()
	{
		return corte;
	}
	@Override
	public String toString()
	{
		return "Servico [corte=" + corte + ", desflizagem=" + desflizagem
				+ ", lavagem=" + lavagem + "]";
	}
	public void setCorte(boolean corte)
	{
		this.corte = corte;
	}
	public boolean isDesflizagem()
	{
		return desflizagem;
	}
	public void setDesflizagem(boolean desflizagem)
	{
		this.desflizagem = desflizagem;
	}
	public boolean isLavagem()
	{
		return lavagem;
	}
	public void setLavagem(boolean lavagem)
	{
		this.lavagem = lavagem;
	}
	
	
}
