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
 * Controller para expor serviços REST de User
 * 
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/security/User")
public class UserREST {

  /**
   * Classe de negócio para manipulação de dados
   * 
   * @generated
   */
  @Autowired
  @Qualifier("UserBusiness")
  private UserBusiness userBusiness;

  /**
   * @generated
   */
  @Autowired
  @Qualifier("PostoBusiness")
  private PostoBusiness postoBusiness;

  /**
   * @generated
   */
  @Autowired
  @Qualifier("CarroBusiness")
  private CarroBusiness carroBusiness;

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
  public User post(@Validated @RequestBody final User entity) throws Exception {
    return userBusiness.post(entity);
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade fornecida
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT)
  public User put(@Validated @RequestBody final User entity) throws Exception {
    return userBusiness.put(entity);
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT, value = "/{userId}")
  public User put(@Validated @RequestBody final User entity, @PathVariable("userId") java.lang.String userId) throws Exception {
    return userBusiness.put(entity);
  }  

  /**
   * Serviço exposto para remover a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.DELETE, value = "/{userId}")
  public void delete(@PathVariable("userId") java.lang.String userId) throws Exception {
    userBusiness.delete(userId);
  }

  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET)
  public HttpEntity<PagedResources<User>> listParams(Pageable pageable, PagedResourcesAssembler assembler){
    return new ResponseEntity<>(assembler.toResource(userBusiness.list(pageable)), HttpStatus.OK);    
  }

  /**
   * NamedQuery findByRole
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value="/findByRole/{roleid}")
  public HttpEntity<PagedResources<User>> findByRoleParams(@PathVariable("roleid") java.lang.String roleid, Pageable pageable, PagedResourcesAssembler assembler){
    return new ResponseEntity<>(assembler.toResource(userBusiness.findByRole(roleid, pageable)), HttpStatus.OK);    
  }

  /**
   * NamedQuery findByLogin
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value="/findByLogin/{login}")
  public HttpEntity<PagedResources<User>> findByLoginParams(@PathVariable("login") java.lang.String login, Pageable pageable, PagedResourcesAssembler assembler){
    return new ResponseEntity<>(assembler.toResource(userBusiness.findByLogin(login, pageable)), HttpStatus.OK);    
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value="/{userId}/Carro")    
  public HttpEntity<PagedResources<Carro>> findCarro(@PathVariable("userId") java.lang.String userId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(userBusiness.findCarro(userId, pageable)), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE, value="/{userId}/Carro/{carroId}")    
  public void deleteCarro(@PathVariable("carroId") java.lang.String carroId) throws Exception {
    this.carroBusiness.delete(carroId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT, value="/{userId}/Carro")
  public Carro putCarro(@Validated @RequestBody final Carro entity, @PathVariable("userId") java.lang.String userId) throws Exception {
    return this.carroBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST, value="/{userId}/Carro")
  public Carro postCarro(@Validated @RequestBody final Carro entity, @PathVariable("userId") java.lang.String userId) throws Exception {
    User user = this.userBusiness.get(userId);
    entity.setUser(user);
    return this.carroBusiness.post(entity);
  }

  /**
   * OneToMany Relationship GET - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value="/{userId}/Comentario/generalSearch")    
  public HttpEntity<PagedResources<Comentario>> findComentarioGeneralSearch(java.lang.String search, @PathVariable("userId") java.lang.String userId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(userBusiness.findComentarioGeneralSearch(search, userId, pageable)), HttpStatus.OK);
  }
  
  /**
   * OneToMany Relationship GET - Searchable fields - Specific search
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value="/{userId}/Comentario/specificSearch")    
  public HttpEntity<PagedResources<Comentario>> findComentarioSpecificSearch(@PathVariable("userId") java.lang.String userId, java.lang.String data, java.lang.String texto, java.lang.Boolean moderado, Pageable pageable, PagedResourcesAssembler assembler) {
    Date dataAux = null;
    if (data != null && data.length() > 0 ) {
      try {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        dataAux = formatter.parse(data);
      } catch (Exception e) {
          e.printStackTrace();
      }
    }
    return new ResponseEntity<>(assembler.toResource(userBusiness.findComentarioSpecificSearch(userId, dataAux, texto, moderado, pageable)), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value="/{userId}/Comentario")    
  public HttpEntity<PagedResources<Comentario>> findComentario(@PathVariable("userId") java.lang.String userId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(userBusiness.findComentario(userId, pageable)), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE, value="/{userId}/Comentario/{comentarioId}")    
  public void deleteComentario(@PathVariable("comentarioId") java.lang.String comentarioId) throws Exception {
    this.comentarioBusiness.delete(comentarioId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT, value="/{userId}/Comentario")
  public Comentario putComentario(@Validated @RequestBody final Comentario entity, @PathVariable("userId") java.lang.String userId) throws Exception {
    return this.comentarioBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST, value="/{userId}/Comentario")
  public Comentario postComentario(@Validated @RequestBody final Comentario entity, @PathVariable("userId") java.lang.String userId) throws Exception {
    User user = this.userBusiness.get(userId);
    entity.setUser(user);
    return this.comentarioBusiness.post(entity);
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value="/{userId}/Abastecimento")    
  public HttpEntity<PagedResources<Abastecimento>> findAbastecimento(@PathVariable("userId") java.lang.String userId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(userBusiness.findAbastecimento(userId, pageable)), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE, value="/{userId}/Abastecimento/{abastecimentoId}")    
  public void deleteAbastecimento(@PathVariable("abastecimentoId") java.lang.String abastecimentoId) throws Exception {
    this.abastecimentoBusiness.delete(abastecimentoId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT, value="/{userId}/Abastecimento")
  public Abastecimento putAbastecimento(@Validated @RequestBody final Abastecimento entity, @PathVariable("userId") java.lang.String userId) throws Exception {
    return this.abastecimentoBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST, value="/{userId}/Abastecimento")
  public Abastecimento postAbastecimento(@Validated @RequestBody final Abastecimento entity, @PathVariable("userId") java.lang.String userId) throws Exception {
    User user = this.userBusiness.get(userId);
    entity.setUser(user);
    return this.abastecimentoBusiness.post(entity);
  }
  
  /**
   * ManyToMany Relationship GET - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET,value="/{userId}/Posto/generalSearch")
  public HttpEntity<PagedResources<Posto>> listPostoGeneralSearch(java.lang.String search, @PathVariable("userId") java.lang.String userId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(userBusiness.listPostoGeneralSearch(search, userId, pageable)), HttpStatus.OK); 
  }
  
  /**
   * ManyToMany Relationship GET - Searchable fields - Specific search
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET,value="/{userId}/Posto/specificSearch")
  public HttpEntity<PagedResources<Posto>> listPostoSpecificSearch(@PathVariable("userId") java.lang.String userId, java.lang.String nome, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(userBusiness.listPostoSpecificSearch(userId, nome, pageable)), HttpStatus.OK); 
  }

  /**
   * ManyToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET,value="/{userId}/Posto")
  public HttpEntity<PagedResources<Posto>> listPosto(@PathVariable("userId") java.lang.String userId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(userBusiness.listPosto(userId, pageable)), HttpStatus.OK); 
  }

  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST,value="/{userId}/Posto")
  public User postPosto(@Validated @RequestBody final Posto entity, @PathVariable("userId") java.lang.String userId) throws Exception {
    Comentario newComentario = new Comentario();

    User user = this.userBusiness.get(userId);

    newComentario.setPosto(entity);
    newComentario.setUser(user);
    
    this.comentarioBusiness.post(newComentario);

    return newComentario.getUser();
  }   

  /**
   * ManyToMany Relationship DELETE
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE,value="/{userId}/Posto/{PostoId}")
  public void deletePosto(@PathVariable("userId") java.lang.String userId, @PathVariable("PostoId") java.lang.String PostoId) {
    this.userBusiness.deletePosto(userId, PostoId);
  }  

  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value = "/generalSearch")
  public HttpEntity<PagedResources<User>> generalSearch(java.lang.String search, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(userBusiness.generalSearch(search, pageable)), HttpStatus.OK);
  }
  
  /**
   * Searchable fields - Specific search
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value = "/specificSearch")
  public HttpEntity<PagedResources<User>> specificSearch(java.lang.String email, java.lang.String name, java.lang.String login, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(userBusiness.specificSearch(email, name, login, pageable)), HttpStatus.OK);
  }

  /**
   * Serviço exposto para recuperar a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
  public User get(@PathVariable("userId") java.lang.String userId) throws Exception {
    return userBusiness.get(userId);
  }
}
