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
 * Controller para expor serviços REST de Posto
 * 
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/Posto")
public class PostoREST {

  /**
   * Classe de negócio para manipulação de dados
   * 
   * @generated
   */
  @Autowired
  @Qualifier("PostoBusiness")
  private PostoBusiness postoBusiness;

  /**
   * @generated
   */
  @Autowired
  @Qualifier("UserBusiness")
  private UserBusiness userBusiness;

  /**
   * @generated
   */
  @Autowired
  @Qualifier("ComentarioBusiness")
  private ComentarioBusiness comentarioBusiness;

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
  public Posto post(@Validated @RequestBody final Posto entity) throws Exception {
    return postoBusiness.post(entity);
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade fornecida
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT)
  public Posto put(@Validated @RequestBody final Posto entity) throws Exception {
    return postoBusiness.put(entity);
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT, value = "/{postoId}")
  public Posto put(@Validated @RequestBody final Posto entity, @PathVariable("postoId") java.lang.String postoId) throws Exception {
    return postoBusiness.put(entity);
  }  

  /**
   * Serviço exposto para remover a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.DELETE, value = "/{postoId}")
  public void delete(@PathVariable("postoId") java.lang.String postoId) throws Exception {
    postoBusiness.delete(postoId);
  }

  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET)
  public HttpEntity<PagedResources<Posto>> listParams(Pageable pageable, PagedResourcesAssembler assembler){
    return new ResponseEntity<>(assembler.toResource(postoBusiness.list(pageable)), HttpStatus.OK);    
  }

  /**
   * OneToMany Relationship GET - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value="/{postoId}/Comentario/generalSearch")    
  public HttpEntity<PagedResources<Comentario>> findComentarioGeneralSearch(java.lang.String search, @PathVariable("postoId") java.lang.String postoId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(postoBusiness.findComentarioGeneralSearch(search, postoId, pageable)), HttpStatus.OK);
  }
  
  /**
   * OneToMany Relationship GET - Searchable fields - Specific search
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value="/{postoId}/Comentario/specificSearch")    
  public HttpEntity<PagedResources<Comentario>> findComentarioSpecificSearch(@PathVariable("postoId") java.lang.String postoId, java.lang.String data, java.lang.String texto, java.lang.Boolean moderado, Pageable pageable, PagedResourcesAssembler assembler) {
    Date dataAux = null;
    if (data != null && data.length() > 0 ) {
      try {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        dataAux = formatter.parse(data);
      } catch (Exception e) {
          e.printStackTrace();
      }
    }
    return new ResponseEntity<>(assembler.toResource(postoBusiness.findComentarioSpecificSearch(postoId, dataAux, texto, moderado, pageable)), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value="/{postoId}/Comentario")    
  public HttpEntity<PagedResources<Comentario>> findComentario(@PathVariable("postoId") java.lang.String postoId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(postoBusiness.findComentario(postoId, pageable)), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE, value="/{postoId}/Comentario/{comentarioId}")    
  public void deleteComentario(@PathVariable("comentarioId") java.lang.String comentarioId) throws Exception {
    this.comentarioBusiness.delete(comentarioId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT, value="/{postoId}/Comentario")
  public Comentario putComentario(@Validated @RequestBody final Comentario entity, @PathVariable("postoId") java.lang.String postoId) throws Exception {
    return this.comentarioBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST, value="/{postoId}/Comentario")
  public Comentario postComentario(@Validated @RequestBody final Comentario entity, @PathVariable("postoId") java.lang.String postoId) throws Exception {
    Posto posto = this.postoBusiness.get(postoId);
    entity.setPosto(posto);
    return this.comentarioBusiness.post(entity);
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value="/{postoId}/Abastecimento")    
  public HttpEntity<PagedResources<Abastecimento>> findAbastecimento(@PathVariable("postoId") java.lang.String postoId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(postoBusiness.findAbastecimento(postoId, pageable)), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE, value="/{postoId}/Abastecimento/{abastecimentoId}")    
  public void deleteAbastecimento(@PathVariable("abastecimentoId") java.lang.String abastecimentoId) throws Exception {
    this.abastecimentoBusiness.delete(abastecimentoId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT, value="/{postoId}/Abastecimento")
  public Abastecimento putAbastecimento(@Validated @RequestBody final Abastecimento entity, @PathVariable("postoId") java.lang.String postoId) throws Exception {
    return this.abastecimentoBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST, value="/{postoId}/Abastecimento")
  public Abastecimento postAbastecimento(@Validated @RequestBody final Abastecimento entity, @PathVariable("postoId") java.lang.String postoId) throws Exception {
    Posto posto = this.postoBusiness.get(postoId);
    entity.setPosto(posto);
    return this.abastecimentoBusiness.post(entity);
  }
  
  /**
   * ManyToMany Relationship GET - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET,value="/{postoId}/User/generalSearch")
  public HttpEntity<PagedResources<User>> listUserGeneralSearch(java.lang.String search, @PathVariable("postoId") java.lang.String postoId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(postoBusiness.listUserGeneralSearch(search, postoId, pageable)), HttpStatus.OK); 
  }
  
  /**
   * ManyToMany Relationship GET - Searchable fields - Specific search
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET,value="/{postoId}/User/specificSearch")
  public HttpEntity<PagedResources<User>> listUserSpecificSearch(@PathVariable("postoId") java.lang.String postoId, java.lang.String email, java.lang.String name, java.lang.String login, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(postoBusiness.listUserSpecificSearch(postoId, email, name, login, pageable)), HttpStatus.OK); 
  }

  /**
   * ManyToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET,value="/{postoId}/User")
  public HttpEntity<PagedResources<User>> listUser(@PathVariable("postoId") java.lang.String postoId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(postoBusiness.listUser(postoId, pageable)), HttpStatus.OK); 
  }

  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST,value="/{postoId}/User")
  public Posto postUser(@Validated @RequestBody final User entity, @PathVariable("postoId") java.lang.String postoId) throws Exception {
    Comentario newComentario = new Comentario();

    Posto posto = this.postoBusiness.get(postoId);

    newComentario.setUser(entity);
    newComentario.setPosto(posto);
    
    this.comentarioBusiness.post(newComentario);

    return newComentario.getPosto();
  }   

  /**
   * ManyToMany Relationship DELETE
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE,value="/{postoId}/User/{UserId}")
  public void deleteUser(@PathVariable("postoId") java.lang.String postoId, @PathVariable("UserId") java.lang.String UserId) {
    this.postoBusiness.deleteUser(postoId, UserId);
  }  

  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value = "/generalSearch")
  public HttpEntity<PagedResources<Posto>> generalSearch(java.lang.String search, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(postoBusiness.generalSearch(search, pageable)), HttpStatus.OK);
  }
  
  /**
   * Searchable fields - Specific search
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value = "/specificSearch")
  public HttpEntity<PagedResources<Posto>> specificSearch(java.lang.String nome, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(postoBusiness.specificSearch(nome, pageable)), HttpStatus.OK);
  }

  /**
   * Serviço exposto para recuperar a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value = "/{postoId}")
  public Posto get(@PathVariable("postoId") java.lang.String postoId) throws Exception {
    return postoBusiness.get(postoId);
  }
}
