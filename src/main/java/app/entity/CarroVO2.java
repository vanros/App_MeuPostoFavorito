package app.entity;


/**
 * Classe que representa ...
 * 
 * @author vanessarodrigues.vj@gmail.com
 * @version 1.0
 * @since 2017-06-22
 *
 */
 
public class CarroVO2 {
  private String marca;

	private String modelo;

	private Integer ano;
	
	private Double mediaRentabilidadesCarro;

	private Double mediaRentabilidadeGeral;


	/**
	 * Construtor
	 **/
	public CarroVO2 (){
	}
	
	public CarroVO2(String marca, String modelo, Integer ano, Double mediaRentabilidadesCarro, Double mediaRentabilidadeGeral) {
	  this.marca = marca;
	  this.modelo = modelo;
	  this.ano = ano;
	  this.mediaRentabilidadesCarro = mediaRentabilidadesCarro;
	  this.mediaRentabilidadeGeral = mediaRentabilidadeGeral;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
		public String getModelo() {
		return modelo;
	}

	public void setModelo(String marca) {
		this.modelo = modelo;
	}
	
	public Integer getAno() {
		return ano;
	}

	public void setAno(String marca) {
		this.ano = ano;
	}
	
	public Double getMediaRentabilidadesCarro() {
		return mediaRentabilidadesCarro;
	}

	public void setMediaRentabilidadesCarro(Double mediaRentabilidadesCarro) {
		this.mediaRentabilidadesCarro = mediaRentabilidadesCarro;
	}
	
	public Double getMediaRentabilidadeGeral() {
		return mediaRentabilidadeGeral;
	}

	public void setMediaRentabilidadeGeral(Double mediaRentabilidadeGeral) {
		this.mediaRentabilidadeGeral = mediaRentabilidadeGeral;
	}

	

}
