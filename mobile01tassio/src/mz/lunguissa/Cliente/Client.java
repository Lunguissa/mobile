package mz.lunguissa.Cliente;

import java.io.Serializable;
import java.util.ArrayList;




/**
 * @author Tassio Do Rosario
 * classe modelo do cliente
 *
 */
/**
 * @author Tassio Do Rosario
 *
 */
/**
 * @author Tassio Do Rosario
 *
 */
public class Client implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name,celNumber,treatment;
	private String time;
	public Client(String name, String celNumber, String treatment,
			String time) {
		super();
		this.name = name;
		this.celNumber = celNumber;
		this.treatment = treatment;
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCelNumber() {
		return celNumber;
	}
	public void setCelNumber(String celNumber) {
		this.celNumber = celNumber;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
//	sao os tipos de tratamentos para o spinner da classe CreateClient
	public static ArrayList<String> tratamentos()
	{
		ArrayList<String> tratamentos=new ArrayList<String>();
		tratamentos.add("Corte de cabelo");
		tratamentos.add("Lavagem de cabelo");
		tratamentos.add("Desfrizagem");
		tratamentos.add("Dreads");
		return tratamentos;
		
	}
	
	

	
	
	
}
