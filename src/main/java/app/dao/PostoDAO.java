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
@Repository("PostoDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface PostoDAO extends JpaRepository<Posto, java.lang.String> {

  /**
   * Obtém a instância de Posto utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Posto entity WHERE entity.id = :id")
  public Posto findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Posto utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Posto entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select c from Posto c")
  public Page<Posto> list(Pageable pageable);
  

    
  /**
   * OneToMany Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Comentario entity WHERE entity.posto.id = :id AND (entity.texto like concat('%',coalesce(:search,''),'%'))")
  public Page<Comentario> findComentarioGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /** 
   * OneToMany Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Comentario entity WHERE entity.posto.id = :id AND (:data is null OR entity.data = :data) AND (:texto is null OR entity.texto like concat('%',:texto,'%')) AND (:moderado is null OR entity.moderado = :moderado)")
  public Page<Comentario> findComentarioSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="data") java.util.Date data, @Param(value="texto") java.lang.String texto, @Param(value="moderado") java.lang.Boolean moderado, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Comentario entity WHERE entity.posto.id = :id")
  public Page<Comentario> findComentario(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Abastecimento entity WHERE entity.posto.id = :id")
  public Page<Abastecimento> findAbastecimento(@Param(value="id") java.lang.String id, Pageable pageable);
  
  /**
   * ManyToOne Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity.user FROM Comentario entity WHERE entity.posto.id = :id AND (entity.user.email like concat('%',coalesce(:search,''),'%') OR entity.user.name like concat('%',coalesce(:search,''),'%') OR entity.user.login like concat('%',coalesce(:search,''),'%'))")
  public Page<User> listUserGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity.user FROM Comentario entity WHERE entity.posto.id = :id AND (:email is null OR entity.user.email like concat('%',:email,'%')) AND (:name is null OR entity.user.name like concat('%',:name,'%')) AND (:login is null OR entity.user.login like concat('%',:login,'%'))")
  public Page<User> listUserSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="email") java.lang.String email, @Param(value="name") java.lang.String name, @Param(value="login") java.lang.String login, Pageable pageable);

  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.user FROM Comentario entity WHERE entity.posto.id = :id")
  public Page<User> listUser(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM Comentario entity WHERE entity.posto.id = :instanceId AND entity.user.id = :relationId")
  public int deleteUser(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  
  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Posto entity WHERE entity.nome like concat('%',coalesce(:search,''),'%')")
  public Page<Posto> generalSearch(@Param(value="search") java.lang.String search, Pageable pageable);

  /**
   * Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Posto entity WHERE (:nome is null OR entity.nome like concat('%',:nome,'%'))")
  public Page<Posto> specificSearch(@Param(value="nome") java.lang.String nome, Pageable pageable);
  
}
