package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 * Classe que representa a tabela COMENTARIO
 * @generated
 */
@Entity
@Table(name = "\"COMENTARIO\"")
@XmlRootElement
public class Comentario implements Serializable {

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
  @Column(name = "data", nullable = true, unique = false, insertable=false, updatable=true)
  private java.util.Date data;
  
  /**
  * @generated
  */
  @Column(name = "texto", nullable = true, unique = false, insertable=true, updatable=true)
  private java.lang.String texto;
  
  /**
  * @generated
  */
  @Column(name = "nota", nullable = true, unique = false, insertable=true, updatable=true)
  private java.lang.Integer nota;
  
  /**
  * @generated
  */
  @Column(name = "moderado", nullable = true, unique = false, insertable=true, updatable=true)
  private java.lang.Boolean moderado;
  
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
   * Construtor
   * @generated
   */
  public Comentario(){
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
  public Comentario setId(java.lang.String id){
    this.id = id;
    return this;
  }
  
  /**
   * Obtém data
   * return data
   * @generated
   */
  public java.util.Date getData(){
    return new Date();
  }
  
  /**
   * Define data
   * @param data data
   * @generated
   */
  public Comentario setData(java.util.Date data){
    this.data = new Date();
    return this;
  }
  
  /**
   * Obtém texto
   * return texto
   * @generated
   */
  public java.lang.String getTexto(){
    return this.texto;
  }
  
  /**
   * Define texto
   * @param texto texto
   * @generated
   */
  public Comentario setTexto(java.lang.String texto){
    this.texto = texto;
    return this;
  }
  
  /**
   * Obtém nota
   * return nota
   * @generated
   */
  public java.lang.Integer getNota(){
    return this.nota;
  }
  
  /**
   * Define nota
   * @param nota nota
   * @generated
   */
  public Comentario setNota(java.lang.Integer nota){
    this.nota = nota;
    return this;
  }
  
  /**
   * Obtém moderado
   * return moderado
   * @generated
   */
  public java.lang.Boolean getModerado(){
    return this.moderado;
  }
  
  /**
   * Define moderado
   * @param moderado moderado
   * @generated
   */
  public Comentario setModerado(java.lang.Boolean moderado){
    this.moderado = moderado;
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
  public Comentario setUser(User user){
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
  public Comentario setPosto(Posto posto){
    this.posto = posto;
    return this;
  }
  
  /**
   * @generated
   */ 
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Comentario object = (Comentario)obj;
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