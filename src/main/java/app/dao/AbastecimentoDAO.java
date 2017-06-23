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
@Repository("AbastecimentoDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface AbastecimentoDAO extends JpaRepository<Abastecimento, java.lang.String> {

  /**
   * Obtém a instância de Abastecimento utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Abastecimento entity WHERE entity.id = :id")
  public Abastecimento findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Abastecimento utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Abastecimento entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select c from Abastecimento c")
  public Page<Abastecimento> list(Pageable pageable);
  


  /**
   * Foreign Key user
   * @generated
   */
  @Query("SELECT entity FROM Abastecimento entity WHERE entity.user.id = :id")
  public Page<Abastecimento> findAbastecimentosByUser(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key posto
   * @generated
   */
  @Query("SELECT entity FROM Abastecimento entity WHERE entity.posto.id = :id")
  public Page<Abastecimento> findAbastecimentosByPosto(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key carro
   * @generated
   */
  @Query("SELECT entity FROM Abastecimento entity WHERE entity.carro.id = :id")
  public Page<Abastecimento> findAbastecimentosByCarro(@Param(value="id") java.lang.String id, Pageable pageable);
  
  
   @Query("select a from Abastecimento a where a.posto.id = :postoId ")
  public Page<Abastecimento> listaAbastecimentosPorPosto(@Param(value="postoId") java.lang.String postoId, Pageable pageable);
  
  @Query("select a from Abastecimento a where a.carro.marca = :marca and a.carro.modelo = :modelo and a.carro.ano= :ano")
  public Page<Abastecimento> listaAbastecimentosPorMarcaModeloAno(@Param(value="marca")java.lang.String marca, @Param(value="modelo")java.lang.String modelo, @Param(value="ano")java.lang.Integer ano, Pageable pageable);
  
  @Query("select distinct a.posto.id from Abastecimento a")
  public List<String> recuperaPostosQueTemAbastecimento();
  
  @Query("select distinct a.carro.id from Abastecimento a")
  public List<String> recuperaCarrosQueTemAbastecimento();
  
  @Query("select distinct a.carro.marca from Abastecimento a")
  public List<String> recuperaMarcasQueTemAbastecimento();


}
