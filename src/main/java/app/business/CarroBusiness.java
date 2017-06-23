package app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.*;
import app.dao.*;
import app.entity.*;
import org.springframework.data.domain.PageImpl;

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
  
  @Qualifier("AbastecimentoDAO")
  protected AbastecimentoDAO abastecimento;

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
     try {
    this.repository.delete(entity);
     }catch(Exception e) {
        throw new Exception("Verifique se existe abastecimento para esse carro");
    }   
    // begin-user-code  
    // end-user-code        
  }
        
    // begin-user-code  
    // end-user-code        
  
  
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
  
   public Page<CarroVO> findConsumoMedio(java.lang.String id, Pageable pageable) {
    // begin-user-code
    // end-user-code 
    List<Abastecimento> abastecimentosDeUmCarro;
    List<CarroVO> listaMediaConsumo = new ArrayList<CarroVO>();
    Carro carro = new Carro();
    
    carro = repository.findOne(id);
    
    CarroVO carroVO;
    
    Double acm = 0.0;
    Double mediaConsumo = 0.0;
     
    Page<Abastecimento> result = repository.findAbastecimento(id, pageable);
    
    abastecimentosDeUmCarro = result.getContent();
    
    for(Abastecimento abastecimento: abastecimentosDeUmCarro){
        acm = acm + (abastecimento.getQuilometragemRodada()/abastecimento.getPrecoPorLitro());
    }
    
    mediaConsumo = acm/abastecimentosDeUmCarro.size(); 
    
     carroVO = new CarroVO(mediaConsumo, carro.getPlaca());
     listaMediaConsumo.add(carroVO);
     
    final Page<CarroVO> retorno = new PageImpl<>(listaMediaConsumo);
  
    return retorno;
     
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
  
  public Page<CarroVO2> listaRankingCarro(Pageable pageable) {
    List<String> marcas = abastecimento.recuperaMarcasQueTemAbastecimento();
    Double acm = 0.0;
    Double mediaRentabilidade = 0.0;
    Page<Abastecimento> temp;
    List<CarroVO2> listaMediaDasRentabilidades = new ArrayList<CarroVO2>();
    
    CarroVO2 carroVO2;
    
    List<Abastecimento> abastecimentosDeUmaMarcaModeloAno;
    
    Carro carro = null;
    
    for(String m: marcas) {
      List<String> modelos = repository.listaModelosPorMarca(m);
      
      for(String mo: modelos){
        List<Integer> anos = repository.listaAnosPorModelo(mo);
        
        for(Integer a: anos){
          
          temp = abastecimento.listaAbastecimentosPorMarcaModeloAno(m, mo, a, pageable);
          abastecimentosDeUmaMarcaModeloAno = temp.getContent();
           
           for (Abastecimento abastecimento : abastecimentosDeUmaMarcaModeloAno) {
				      acm = acm + (abastecimento.getQuilometragemRodada() / abastecimento.getPrecoPorLitro());
			      }
			      
			      mediaRentabilidade = acm / abastecimentosDeUmaMarcaModeloAno.size();
			      
			      carroVO2 = new CarroVO2(m, mo, a, mediaRentabilidade, 0.0);
			      
			      listaMediaDasRentabilidades.add(carroVO2);
			      carroVO2 = null;
			      acm = 0.0;
			      mediaRentabilidade = 0.0;
        }
        
      }

    }
    
     Double acmDeMedias = 0.0;
		 for (CarroVO2 c : listaMediaDasRentabilidades) {
			      acmDeMedias = acmDeMedias + c.getMediaRentabilidadesCarro();
		  }
		    
		Double mediaTotal = acmDeMedias / listaMediaDasRentabilidades.size();
		for (CarroVO2 ca : listaMediaDasRentabilidades) {
			   ca.setMediaRentabilidadeGeral(mediaTotal);
		}
		
		
		Collections.sort(listaMediaDasRentabilidades, new Comparator<CarroVO2>() {
			@Override
			public int compare(CarroVO2 c1, CarroVO2 c2) {
				return c1.getMediaRentabilidadesCarro().compareTo(c2.getMediaRentabilidadesCarro());
			}
		});

		final Page<CarroVO2> retorno = new PageImpl<>(listaMediaDasRentabilidades);

		return retorno;
    
  }

  
}
