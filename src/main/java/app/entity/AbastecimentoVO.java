package app.entity;


/**
 * Classe que representa ...
 * 
 * @author vanessa.silva@techne.com.br
 * @version 1.0
 * @since 2017-06-09
 *
 */
 
 
public class AbastecimentoVO {

	private String idPosto;

	private String nomePosto;

	private Double mediaRentabilidadesPosto;

	private Double mediaRentabilidadeGeral;

	/**
	 * Construtor
	 **/
	public AbastecimentoVO() {
	}
	
	public AbastecimentoVO(String idPosto, String nomePosto, Double mediaRentabilidadesPosto, Double mediaRentabilidadeGeral) {
	  this.idPosto = idPosto;
	  this.nomePosto = nomePosto;
	  this.mediaRentabilidadesPosto = mediaRentabilidadesPosto;
	  this.mediaRentabilidadeGeral = mediaRentabilidadeGeral;
	}

	public String getIdPosto() {
		return idPosto;
	}

	public void setIdPosto(String idPosto) {
		this.idPosto = idPosto;
	}

	public String getNomePosto() {
		return nomePosto;
	}

	public void setNomePosto(String nomePosto) {
		this.nomePosto = nomePosto;
	}

	public Double getMediaRentabilidadesPosto() {
		return mediaRentabilidadesPosto;
	}

	public void setMediaRentabilidadesPosto(Double mediaRentabilidadesPosto) {
		this.mediaRentabilidadesPosto = mediaRentabilidadesPosto;
	}

	public Double getMediaRentabilidadeGeral() {
		return mediaRentabilidadeGeral;
	}

	public void setMediaRentabilidadeGeral(Double mediaRentabilidadeGeral) {
		this.mediaRentabilidadeGeral = mediaRentabilidadeGeral;
	}





}
