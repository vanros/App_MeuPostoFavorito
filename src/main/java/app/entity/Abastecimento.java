package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 * Classe que representa a tabela ABASTECIMENTO
 * @generated
 */
@Entity
@Table(name = "\"ABASTECIMENTO\"")
@XmlRootElement
public class Abastecimento implements Serializable {

  /**
   * UID da classe, necessário na serialização 
   * @generated
   */
  private static final long serialVersionUID = 1L;
  
  /**
   * @generated
   */
  @Id
  @Column(name = "id", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();
  
  /**
  * @generated
  */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "data", nullable = true, unique = false, insertable=true, updatable=true)
  private java.util.Date data;
  
  /**
  * @generated
  */
  @Column(name = "quilometragemRodada", nullable = true, unique = false, scale=2, insertable=true, updatable=true)
  private java.lang.Double quilometragemRodada;
  
  /**
  * @generated
  */
  @Column(name = "litros", nullable = true, unique = false, scale=2, insertable=true, updatable=true)
  private java.lang.Double litros;
  
  /**
  * @generated
  */
  @Column(name = "combustivel", nullable = true, unique = false, insertable=true, updatable=true)
  private java.lang.String combustivel;
  
  /**
  * @generated
  */
  @Column(name = "precoPorLitro", nullable = true, unique = false, scale=2, insertable=true, updatable=true)
  private java.lang.Double precoPorLitro;
  
  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_user", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  private User user;
  
  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_posto", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  private Posto posto;
  
  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_carro", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  private Carro carro;
  
  /**
   * Construtor
   * @generated
   */
  public Abastecimento(){
  }

  
  /**
   * Obtém id
   * return id
   * @generated
   */
  public java.lang.String getId(){
    return this.id;
  }
  
  /**
   * Define id
   * @param id id
   * @generated
   */
  public Abastecimento setId(java.lang.String id){
    this.id = id;
    return this;
  }
  
  /**
   * Obtém data
   * return data
   * @generated
   */
  public java.util.Date getData(){
    return this.data;
  }
  
  /**
   * Define data
   * @param data data
   * @generated
   */
  public Abastecimento setData(java.util.Date data){
    this.data = data;
    return this;
  }
  
  /**
   * Obtém quilometragemRodada
   * return quilometragemRodada
   * @generated
   */
  public java.lang.Double getQuilometragemRodada(){
    return this.quilometragemRodada;
  }
  
  /**
   * Define quilometragemRodada
   * @param quilometragemRodada quilometragemRodada
   * @generated
   */
  public Abastecimento setQuilometragemRodada(java.lang.Double quilometragemRodada){
    this.quilometragemRodada = quilometragemRodada;
    return this;
  }
  
  /**
   * Obtém litros
   * return litros
   * @generated
   */
  public java.lang.Double getLitros(){
    return this.litros;
  }
  
  /**
   * Define litros
   * @param litros litros
   * @generated
   */
  public Abastecimento setLitros(java.lang.Double litros){
    this.litros = litros;
    return this;
  }
  
  /**
   * Obtém combustivel
   * return combustivel
   * @generated
   */
  public java.lang.String getCombustivel(){
    return this.combustivel;
  }
  
  /**
   * Define combustivel
   * @param combustivel combustivel
   * @generated
   */
  public Abastecimento setCombustivel(java.lang.String combustivel){
    this.combustivel = combustivel;
    return this;
  }
  
  /**
   * Obtém precoPorLitro
   * return precoPorLitro
   * @generated
   */
  public java.lang.Double getPrecoPorLitro(){
    return this.precoPorLitro;
  }
  
  /**
   * Define precoPorLitro
   * @param precoPorLitro precoPorLitro
   * @generated
   */
  public Abastecimento setPrecoPorLitro(java.lang.Double precoPorLitro){
    this.precoPorLitro = precoPorLitro;
    return this;
  }
  
  /**
   * Obtém user
   * return user
   * @generated
   */
  public User getUser(){
    return this.user;
  }
  
  /**
   * Define user
   * @param user user
   * @generated
   */
  public Abastecimento setUser(User user){
    this.user = user;
    return this;
  }
  
  /**
   * Obtém posto
   * return posto
   * @generated
   */
  public Posto getPosto(){
    return this.posto;
  }
  
  /**
   * Define posto
   * @param posto posto
   * @generated
   */
  public Abastecimento setPosto(Posto posto){
    this.posto = posto;
    return this;
  }
  
  /**
   * Obtém carro
   * return carro
   * @generated
   */
  public Carro getCarro(){
    return this.carro;
  }
  
  /**
   * Define carro
   * @param carro carro
   * @generated
   */
  public Abastecimento setCarro(Carro carro){
    this.carro = carro;
    return this;
  }
  
  /**
   * @generated
   */ 
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Abastecimento object = (Abastecimento)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    return true;
  }
  
  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }
  
}