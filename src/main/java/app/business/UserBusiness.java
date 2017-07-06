package app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.*;
import app.dao.*;
import app.entity.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import cloud.CloudManager;

/**
 * Classe que representa a camada de negócios de UserBusiness
 * 
 * @generated
 **/
@Service("UserBusiness")
public class UserBusiness {

  /**
   * Variável privada para verificação da criptofrafia
   * 
   * @generated 
   */
  private String ENCRYPT = "$2a$10$";

  private static final String DROPBOX_APP_ACCESS_TOKEN = "DpjBW-OF3tAAAAAAAAAAWCX4bUpsKcaetf3T6YOHMu1T7ljoZwOs4F8gEzStKi4L";

  private final CloudManager cloudManager = CloudManager.newInstance().byID("id").toFields("picture");

  /**
   * Instância da classe UserDAO que faz o acesso ao banco de dados
   * 
   * @generated
   */
  @Autowired
  @Qualifier("UserDAO")
  protected UserDAO repository;

  // CRUD

  /**
   * Serviço exposto para novo registro de acordo com a entidade fornecida
   * 
   * @generated
   */
  public User post(final User entity) throws Exception {
    // begin-user-code  
    // end-user-code  
    // isEncryption() Password
    String formPassword = entity.getPassword();
    String encryptionPassword = new BCryptPasswordEncoder().encode(formPassword);
    entity.setPassword(encryptionPassword);      
    User result = null;
    byte[] picture = entity.getPicture();
     try {
       result = repository.save(entity);

     }catch(Exception e) {
        throw new Exception("Erro no cadastro, usuário já existente.");
    }  
    
    result.setPicture(picture);
    this.cloudManager.byEntity(result).build().dropbox(DROPBOX_APP_ACCESS_TOKEN).upload(); 
       // begin-user-code
    // end-user-code
    return result;
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade fornecida
   * 
   * @generated
   */
  public User put(final User entity) throws Exception {
    // begin-user-code  
    // end-user-code
    // isEncryption() Password
    String formPassword = entity.getPassword();
    String encryptionPassword = formPassword.startsWith(ENCRYPT) ? formPassword : new BCryptPasswordEncoder().encode(formPassword);
    entity.setPassword(encryptionPassword);      
    User result = null;
    byte[] picture = entity.getPicture();

    result = repository.saveAndFlush(entity);
    result.setPicture(picture);
    this.cloudManager.byEntity(result).build().dropbox(DROPBOX_APP_ACCESS_TOKEN).upload();
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
    User entity = this.get(id);
    // begin-user-code  
    // end-user-code
    this.repository.delete(entity);
      this.cloudManager.byEntity(entity).build().dropbox(DROPBOX_APP_ACCESS_TOKEN).delete();
    // begin-user-code  
    // end-user-code        
  }
  
  /**
   * Serviço exposto para recuperar a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  public User get(java.lang.String id) throws Exception {
    // begin-user-code  
    // end-user-code
    User result = repository.findOne(id);
    this.cloudManager.byEntity(result).build().dropbox(DROPBOX_APP_ACCESS_TOKEN).popule(result);
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
  public Page<User> list(Pageable pageable){
    // begin-user-code
    // end-user-code
    Page<User> result = repository.list(pageable);
    result.forEach(item -> cloudManager.byEntity(item).build().dropbox(DROPBOX_APP_ACCESS_TOKEN).popule(item));
    // begin-user-code
    // end-user-code
    return result;
  }
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<User> findByRole( java.lang.String roleid, Pageable pageable){
    // begin-user-code
    // end-user-code
    Page<User> result = repository.findByRole( roleid, pageable);
    result.forEach(item -> cloudManager.byEntity(item).build().dropbox(DROPBOX_APP_ACCESS_TOKEN).popule(item));
    // begin-user-code
    // end-user-code
    return result;
  }
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<User> findByLogin( java.lang.String login, Pageable pageable){
    // begin-user-code
    // end-user-code
    Page<User> result = repository.findByLogin( login, pageable);
    result.forEach(item -> cloudManager.byEntity(item).build().dropbox(DROPBOX_APP_ACCESS_TOKEN).popule(item));
    // begin-user-code
    // end-user-code
    return result;
  }
  
  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<Carro> findCarro(java.lang.String id, Pageable pageable) {
    // begin-user-code
    // end-user-code  
    Page<Carro> result = repository.findCarro(id, pageable);
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
  public Page<Posto> listPostoGeneralSearch(java.lang.String search, java.lang.String id, Pageable pageable) {
    // begin-user-code
    // end-user-code  
    Page<Posto> result = repository.listPostoGeneralSearch(search, id, pageable);
    // begin-user-code
    // end-user-code
    return result;            
  }
  
  /**
   * @generated modifiable
   * ManyToMany Relation - Searchable fields - Specific search
   */  
  public Page<Posto> listPostoSpecificSearch(java.lang.String id, java.lang.String nome, Pageable pageable) {
    // begin-user-code
    // end-user-code  
    Page<Posto> result = repository.listPostoSpecificSearch(id, nome, pageable);
    // begin-user-code
    // end-user-code
    return result;            
  }
  
  /**
   * @generated modifiable
   * ManyToMany Relation
   */  
  public Page<Posto> listPosto(java.lang.String id, Pageable pageable) {
    // begin-user-code
    // end-user-code  
    Page<Posto> result = repository.listPosto(id, pageable);
    // begin-user-code
    // end-user-code
    return result;            
  }
  
  /**
   * @generated modifiable
   * ManyToMany Relation
   */    
  public int deletePosto(java.lang.String instanceId, java.lang.String relationId) {
    // begin-user-code
    // end-user-code  
    int result = repository.deletePosto(instanceId, relationId);
    // begin-user-code
    // end-user-code  
    return result;  
  }
  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  public Page<User> generalSearch(java.lang.String search, Pageable pageable) {
    return repository.generalSearch(search, pageable);
  }
  
  /**
   * Searchable fields - Specific search
   * @generated
   */
  public Page<User> specificSearch(java.lang.String email, java.lang.String name, java.lang.String login, Pageable pageable) {
    return repository.specificSearch(email, name, login, pageable);
  }
  
}
