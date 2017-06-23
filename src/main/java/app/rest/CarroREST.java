package app.rest;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.*;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import app.entity.*;
import app.business.*;

/**
 * Controller para expor serviços REST de Carro
 * 
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/Carro")
public class CarroREST {

  /**
   * Classe de negócio para manipulação de dados
   * 
   * @generated
   */
  @Autowired
  @Qualifier("CarroBusiness")
  private CarroBusiness carroBusiness;

  /**
   * @generated
   */
  @Autowired
  @Qualifier("AbastecimentoBusiness")
  private AbastecimentoBusiness abastecimentoBusiness;

  /**
   * Serviço exposto para novo registro de acordo com a entidade fornecida
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.POST)
  public Carro post(@Validated @RequestBody final Carro entity) throws Exception {
    return carroBusiness.post(entity);
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade fornecida
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT)
  public Carro put(@Validated @RequestBody final Carro entity) throws Exception {
    return carroBusiness.put(entity);
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT, value = "/{carroId}")
  public Carro put(@Validated @RequestBody final Carro entity, @PathVariable("carroId") java.lang.String carroId) throws Exception {
    return carroBusiness.put(entity);
  }  

  /**
   * Serviço exposto para remover a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.DELETE, value = "/{carroId}")
  public void delete(@PathVariable("carroId") java.lang.String carroId) throws Exception {
    carroBusiness.delete(carroId);
  }

  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET)
  public HttpEntity<PagedResources<Carro>> listParams(Pageable pageable, PagedResourcesAssembler assembler){
    return new ResponseEntity<>(assembler.toResource(carroBusiness.list(pageable)), HttpStatus.OK);    
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value="/{carroId}/Abastecimento")    
  public HttpEntity<PagedResources<Abastecimento>> findAbastecimento(@PathVariable("carroId") java.lang.String carroId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(carroBusiness.findAbastecimento(carroId, pageable)), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE, value="/{carroId}/Abastecimento/{abastecimentoId}")    
  public void deleteAbastecimento(@PathVariable("abastecimentoId") java.lang.String abastecimentoId) throws Exception {
    this.abastecimentoBusiness.delete(abastecimentoId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT, value="/{carroId}/Abastecimento")
  public Abastecimento putAbastecimento(@Validated @RequestBody final Abastecimento entity, @PathVariable("carroId") java.lang.String carroId) throws Exception {
    return this.abastecimentoBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST, value="/{carroId}/Abastecimento")
  public Abastecimento postAbastecimento(@Validated @RequestBody final Abastecimento entity, @PathVariable("carroId") java.lang.String carroId) throws Exception {
    Carro carro = this.carroBusiness.get(carroId);
    entity.setCarro(carro);
    return this.abastecimentoBusiness.post(entity);
  }

  /**
   * Serviço exposto para recuperar a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value = "/{carroId}")
  public Carro get(@PathVariable("carroId") java.lang.String carroId) throws Exception {
    return carroBusiness.get(carroId);
  }

  /**
   * Foreign Key user
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value="/User/{userId}")    
  public HttpEntity<PagedResources<Carro>> findCarrosByUser(@PathVariable("userId") java.lang.String userId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(carroBusiness.findCarrosByUser(userId, pageable)), HttpStatus.OK);
  }
}
