package app.dao;

import app.entity.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*; 

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * Os métodos de create, edit, delete e outros estão abstraídos no JpaRepository
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * 
 * @generated
 */
@Repository("UserDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface UserDAO extends JpaRepository<User, java.lang.String> {

  /**
   * Obtém a instância de User utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM User entity WHERE entity.id = :id")
  public User findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de User utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM User entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select u from User u")
  public Page<User> list(Pageable pageable);
  
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select u.user from UserRole u where u.role.id = :roleid")
  public Page<User> findByRole(@Param(value="roleid") java.lang.String roleid, Pageable pageable);
  
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select u from User u where u.login = :login")
  public Page<User> findByLogin(@Param(value="login") java.lang.String login, Pageable pageable);
  


  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Carro entity WHERE entity.user.id = :id")
  public Page<Carro> findCarro(@Param(value="id") java.lang.String id, Pageable pageable);
    
  /**
   * OneToMany Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Comentario entity WHERE entity.user.id = :id AND (entity.texto like concat('%',coalesce(:search,''),'%'))")
  public Page<Comentario> findComentarioGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /** 
   * OneToMany Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Comentario entity WHERE entity.user.id = :id AND (:data is null OR entity.data = :data) AND (:texto is null OR entity.texto like concat('%',:texto,'%')) AND (:moderado is null OR entity.moderado = :moderado)")
  public Page<Comentario> findComentarioSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="data") java.util.Date data, @Param(value="texto") java.lang.String texto, @Param(value="moderado") java.lang.Boolean moderado, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Comentario entity WHERE entity.user.id = :id")
  public Page<Comentario> findComentario(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Abastecimento entity WHERE entity.user.id = :id")
  public Page<Abastecimento> findAbastecimento(@Param(value="id") java.lang.String id, Pageable pageable);
  
  /**
   * ManyToOne Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity.posto FROM Comentario entity WHERE entity.user.id = :id AND (entity.posto.nome like concat('%',coalesce(:search,''),'%'))")
  public Page<Posto> listPostoGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity.posto FROM Comentario entity WHERE entity.user.id = :id AND (:nome is null OR entity.posto.nome like concat('%',:nome,'%'))")
  public Page<Posto> listPostoSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="nome") java.lang.String nome, Pageable pageable);

  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.posto FROM Comentario entity WHERE entity.user.id = :id")
  public Page<Posto> listPosto(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM Comentario entity WHERE entity.user.id = :instanceId AND entity.posto.id = :relationId")
  public int deletePosto(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  
  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM User entity WHERE entity.email like concat('%',coalesce(:search,''),'%') OR entity.name like concat('%',coalesce(:search,''),'%') OR entity.login like concat('%',coalesce(:search,''),'%')")
  public Page<User> generalSearch(@Param(value="search") java.lang.String search, Pageable pageable);

  /**
   * Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM User entity WHERE (:email is null OR entity.email like concat('%',:email,'%')) AND (:name is null OR entity.name like concat('%',:name,'%')) AND (:login is null OR entity.login like concat('%',:login,'%'))")
  public Page<User> specificSearch(@Param(value="email") java.lang.String email, @Param(value="name") java.lang.String name, @Param(value="login") java.lang.String login, Pageable pageable);
  
}
