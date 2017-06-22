package app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.*;
import app.dao.*;
import app.entity.*;

/**
 * Classe que representa a camada de negócios de PostoBusiness
 * 
 * @generated
 **/
@Service("PostoBusiness")
public class PostoBusiness {



  /**
   * Instância da classe PostoDAO que faz o acesso ao banco de dados
   * 
   * @generated
   */
  @Autowired
  @Qualifier("PostoDAO")
  protected PostoDAO repository;

  // CRUD

  /**
   * Serviço exposto para novo registro de acordo com a entidade fornecida
   * 
   * @generated
   */
  public Posto post(final Posto entity) throws Exception {
    // begin-user-code  
    // end-user-code  
    Posto result = repository.save(entity);
    // begin-user-code
    // end-user-code
    return result;
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade fornecida
   * 
   * @generated
   */
  public Posto put(final Posto entity) throws Exception {
    // begin-user-code  
    // end-user-code
    Posto result = repository.saveAndFlush(entity);
    // begin-user-code
    // end-user-code
    return result;
  }

  /**
   * Serviço exposto para remover a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  public void delete(java.lang.String id) throws Exception {
    Posto entity = this.get(id);
    // begin-user-code  
    // end-user-code
    this.repository.delete(entity);
    // begin-user-code  
    // end-user-code        
  }
  
  /**
   * Serviço exposto para recuperar a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  public Posto get(java.lang.String id) throws Exception {
    // begin-user-code  
    // end-user-code
    Posto result = repository.findOne(id);
    // begin-user-code
    // end-user-code
    return result;
  }

  // CRUD
  
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<Posto> list(Pageable pageable){
    // begin-user-code
    // end-user-code
    Page<Posto> result = repository.list(pageable);
    // begin-user-code
    // end-user-code
    return result;
  }
  /**
   * @generated modifiable
   * OneToMany Relation - Searchable fields - General search (Only strings fields)
   */  
  public Page<Comentario> findComentarioGeneralSearch(java.lang.String search, java.lang.String id,  Pageable pageable) {
    // begin-user-code
    // end-user-code  
    Page<Comentario> result = repository.findComentarioGeneralSearch(search, id,  pageable);
    // begin-user-code  
    // end-user-code        
    return result;    
  }
  
  /**
   * @generated modifiable
   * OneToMany Relation - Searchable fields - Specific search
   */  
  public Page<Comentario> findComentarioSpecificSearch(java.lang.String id, java.util.Date data, java.lang.String texto, java.lang.Boolean moderado, Pageable pageable) {
    // begin-user-code
    // end-user-code  
    Page<Comentario> result = repository.findComentarioSpecificSearch(id, data, texto, moderado, pageable);
    // begin-user-code  
    // end-user-code        
    return result;    
  }
  
  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<Comentario> findComentario(java.lang.String id, Pageable pageable) {
    // begin-user-code
    // end-user-code  
    Page<Comentario> result = repository.findComentario(id, pageable);
    // begin-user-code  
    // end-user-code        
    return result;    
  }
  
  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<Abastecimento> findAbastecimento(java.lang.String id, Pageable pageable) {
    // begin-user-code
    // end-user-code  
    Page<Abastecimento> result = repository.findAbastecimento(id, pageable);
    // begin-user-code  
    // end-user-code        
    return result;    
  }
  /**
   * @generated modifiable
   * ManyToMany Relation - Searchable fields - General search (Only strings fields)
   */  
  public Page<User> listUserGeneralSearch(java.lang.String search, java.lang.String id, Pageable pageable) {
    // begin-user-code
    // end-user-code  
    Page<User> result = repository.listUserGeneralSearch(search, id, pageable);
    // begin-user-code
    // end-user-code
    return result;            
  }
  
  /**
   * @generated modifiable
   * ManyToMany Relation - Searchable fields - Specific search
   */  
  public Page<User> listUserSpecificSearch(java.lang.String id, java.lang.String email, java.lang.String name, java.lang.String login, Pageable pageable) {
    // begin-user-code
    // end-user-code  
    Page<User> result = repository.listUserSpecificSearch(id, email, name, login, pageable);
    // begin-user-code
    // end-user-code
    return result;            
  }
  
  /**
   * @generated modifiable
   * ManyToMany Relation
   */  
  public Page<User> listUser(java.lang.String id, Pageable pageable) {
    // begin-user-code
    // end-user-code  
    Page<User> result = repository.listUser(id, pageable);
    // begin-user-code
    // end-user-code
    return result;            
  }
  
  /**
   * @generated modifiable
   * ManyToMany Relation
   */    
  public int deleteUser(java.lang.String instanceId, java.lang.String relationId) {
    // begin-user-code
    // end-user-code  
    int result = repository.deleteUser(instanceId, relationId);
    // begin-user-code
    // end-user-code  
    return result;  
  }
  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  public Page<Posto> generalSearch(java.lang.String search, Pageable pageable) {
    return repository.generalSearch(search, pageable);
  }
  
  /**
   * Searchable fields - Specific search
   * @generated
   */
  public Page<Posto> specificSearch(java.lang.String nome, Pageable pageable) {
    return repository.specificSearch(nome, pageable);
  }
  
}
