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
 * Classe que representa a camada de negócios de CarroBusiness
 * 
 * @generated
 **/
@Service("CarroBusiness")
public class CarroBusiness {



  /**
   * Instância da classe CarroDAO que faz o acesso ao banco de dados
   * 
   * @generated
   */
  @Autowired
  @Qualifier("CarroDAO")
  protected CarroDAO repository;

  // CRUD

  /**
   * Serviço exposto para novo registro de acordo com a entidade fornecida
   * 
   * @generated
   */
  public Carro post(final Carro entity) throws Exception {
    // begin-user-code  
    // end-user-code  
    Carro result = repository.save(entity);
    // begin-user-code
    // end-user-code
    return result;
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade fornecida
   * 
   * @generated
   */
  public Carro put(final Carro entity) throws Exception {
    // begin-user-code  
    // end-user-code
    Carro result = repository.saveAndFlush(entity);
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
    Carro entity = this.get(id);
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
  public Carro get(java.lang.String id) throws Exception {
    // begin-user-code  
    // end-user-code
    Carro result = repository.findOne(id);
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
  public Page<Carro> list(Pageable pageable){
    // begin-user-code
    // end-user-code
    Page<Carro> result = repository.list(pageable);
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
   * Foreign Key user
   * @generated
   */
  public Page<Carro> findCarrosByUser(java.lang.String instanceId, Pageable pageable) {
    // begin-user-code
    // end-user-code  
    Page<Carro> result = repository.findCarrosByUser(instanceId, pageable);
    // begin-user-code  
    // end-user-code        
    return result;
  }
  
}
