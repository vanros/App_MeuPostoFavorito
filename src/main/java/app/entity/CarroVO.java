package app.entity;


/**
 * Classe que representa ...
 * 
 * @author vanessa.silva@techne.com.br
 * @version 1.0
 * @since 2017-06-21
 *
 */
 
public class CarroVO {
  	private Double mediaConsumoCarro;
  	private String placaCarro;

	/**
	 * Construtor
	 **/
	public CarroVO (){
	}
	
	public CarroVO(Double mediaConsumoCarro, String placaCarro) {
	  this.mediaConsumoCarro = mediaConsumoCarro;
	  this.placaCarro = placaCarro;
	}
	
	public Double getMediaConsumoCarro() {
		return mediaConsumoCarro;
	}

	public void setMediaConsumoCarro(Double mediaConsumoCarro) {
		this.mediaConsumoCarro = mediaConsumoCarro;
	}
	
	public String getPlacaCarro() {
		return placaCarro;
	}

	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}

}
