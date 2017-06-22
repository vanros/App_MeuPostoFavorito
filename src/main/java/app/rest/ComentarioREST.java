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
 * Controller para expor serviços REST de Comentario
 * 
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/Comentario")
public class ComentarioREST {

  /**
   * Classe de negócio para manipulação de dados
   * 
   * @generated
   */
  @Autowired
  @Qualifier("ComentarioBusiness")
  private ComentarioBusiness comentarioBusiness;

  /**
   * Serviço exposto para novo registro de acordo com a entidade fornecida
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.POST)
  public Comentario post(@Validated @RequestBody final Comentario entity) throws Exception {
    return comentarioBusiness.post(entity);
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade fornecida
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT)
  public Comentario put(@Validated @RequestBody final Comentario entity) throws Exception {
    return comentarioBusiness.put(entity);
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT, value = "/{comentarioId}")
  public Comentario put(@Validated @RequestBody final Comentario entity, @PathVariable("comentarioId") java.lang.String comentarioId) throws Exception {
    return comentarioBusiness.put(entity);
  }  

  /**
   * Serviço exposto para remover a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.DELETE, value = "/{comentarioId}")
  public void delete(@PathVariable("comentarioId") java.lang.String comentarioId) throws Exception {
    comentarioBusiness.delete(comentarioId);
  }

  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET)
  public HttpEntity<PagedResources<Comentario>> listParams(Pageable pageable, PagedResourcesAssembler assembler){
    return new ResponseEntity<>(assembler.toResource(comentarioBusiness.list(pageable)), HttpStatus.OK);    
  }

  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value = "/generalSearch")
  public HttpEntity<PagedResources<Comentario>> generalSearch(java.lang.String search, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(comentarioBusiness.generalSearch(search, pageable)), HttpStatus.OK);
  }
  
  /**
   * Searchable fields - Specific search
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value = "/specificSearch")
  public HttpEntity<PagedResources<Comentario>> specificSearch(java.lang.String data, java.lang.String texto, java.lang.Boolean moderado, Pageable pageable, PagedResourcesAssembler assembler) {
    Date dataAux = null;
    if (data != null && data.length() > 0 ) {
      try {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        dataAux = formatter.parse(data);
      } catch (Exception e) {
          e.printStackTrace();
      }
    }
    return new ResponseEntity<>(assembler.toResource(comentarioBusiness.specificSearch(dataAux, texto, moderado, pageable)), HttpStatus.OK);
  }

  /**
   * Serviço exposto para recuperar a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value = "/{comentarioId}")
  public Comentario get(@PathVariable("comentarioId") java.lang.String comentarioId) throws Exception {
    return comentarioBusiness.get(comentarioId);
  }

  /**
   * Foreign Key user
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value="/User/{userId}")    
  public HttpEntity<PagedResources<Comentario>> findComentariosByUser(@PathVariable("userId") java.lang.String userId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(comentarioBusiness.findComentariosByUser(userId, pageable)), HttpStatus.OK);
  }

  /**
   * Foreign Key posto
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value="/Posto/{postoId}")    
  public HttpEntity<PagedResources<Comentario>> findComentariosByPosto(@PathVariable("postoId") java.lang.String postoId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(comentarioBusiness.findComentariosByPosto(postoId, pageable)), HttpStatus.OK);
  }
}
