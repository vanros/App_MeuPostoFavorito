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
@Repository("ComentarioDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface ComentarioDAO extends JpaRepository<Comentario, java.lang.String> {

  /**
   * Obtém a instância de Comentario utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Comentario entity WHERE entity.id = :id")
  public Comentario findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Comentario utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Comentario entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select c from Comentario c")
  public Page<Comentario> list(Pageable pageable);
  


  
  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Comentario entity WHERE entity.texto like concat('%',coalesce(:search,''),'%')")
  public Page<Comentario> generalSearch(@Param(value="search") java.lang.String search, Pageable pageable);

  /**
   * Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Comentario entity WHERE (:data is null OR entity.data = :data) AND (:texto is null OR entity.texto like concat('%',:texto,'%')) AND (:moderado is null OR entity.moderado = :moderado)")
  public Page<Comentario> specificSearch(@Param(value="data") java.util.Date data, @Param(value="texto") java.lang.String texto, @Param(value="moderado") java.lang.Boolean moderado, Pageable pageable);
  
  /**
   * Foreign Key user
   * @generated
   */
  @Query("SELECT entity FROM Comentario entity WHERE entity.user.id = :id")
  public Page<Comentario> findComentariosByUser(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key posto
   * @generated
   */
  @Query("SELECT entity FROM Comentario entity WHERE entity.posto.id = :id")
  public Page<Comentario> findComentariosByPosto(@Param(value="id") java.lang.String id, Pageable pageable);

}
