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
 * Classe que representa a camada de negócios de AbastecimentoBusiness
 * 
 * @generated
 **/
@Service("AbastecimentoBusiness")
public class AbastecimentoBusiness {

	/**
	 * Instância da classe AbastecimentoDAO que faz o acesso ao banco de dados
	 * 
	 * @generated
	 */
	@Autowired
	@Qualifier("AbastecimentoDAO")
	protected AbastecimentoDAO repository;

	@Autowired
	@Qualifier("PostoDAO")
	protected PostoDAO postoDAO;

	// CRUD

	/**
	 * Serviço exposto para novo registro de acordo com a entidade fornecida
	 * 
	 * @generated
	 */
	public Abastecimento post(final Abastecimento entity) throws Exception {
		// begin-user-code  
		// end-user-code  
		Abastecimento result = repository.save(entity);
		// begin-user-code
		// end-user-code
		return result;
	}

	/**
	 * Serviço exposto para salvar alterações de acordo com a entidade fornecida
	 * 
	 * @generated
	 */
	public Abastecimento put(final Abastecimento entity) throws Exception {
		// begin-user-code  
		// end-user-code
		Abastecimento result = repository.saveAndFlush(entity);
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
		Abastecimento entity = this.get(id);
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
	public Abastecimento get(java.lang.String id) throws Exception {
		// begin-user-code  
		// end-user-code
		Abastecimento result = repository.findOne(id);
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
	public Page<Abastecimento> list(Pageable pageable) {
		// begin-user-code
		// end-user-code
		Page<Abastecimento> result = repository.list(pageable);
		// begin-user-code
		// end-user-code
		return result;
	}

	/**
	 * Foreign Key user
	 * @generated
	 */
	public Page<Abastecimento> findAbastecimentosByUser(java.lang.String instanceId, Pageable pageable) {
		// begin-user-code
		// end-user-code  
		Page<Abastecimento> result = repository.findAbastecimentosByUser(instanceId, pageable);
		// begin-user-code  
		// end-user-code        
		return result;
	}

	/**
	 * Foreign Key posto
	 * @generated
	 */
	public Page<Abastecimento> findAbastecimentosByPosto(java.lang.String instanceId, Pageable pageable) {
		// begin-user-code
		// end-user-code  
		Page<Abastecimento> result = repository.findAbastecimentosByPosto(instanceId, pageable);
		// begin-user-code  
		// end-user-code        
		return result;
	}

	/**
	 * Foreign Key carro
	 * @generated
	 */
	public Page<Abastecimento> findAbastecimentosByCarro(java.lang.String instanceId, Pageable pageable) {
		// begin-user-code
		// end-user-code  
		Page<Abastecimento> result = repository.findAbastecimentosByCarro(instanceId, pageable);
		// begin-user-code  
		// end-user-code        
		return result;
	}

	public Page<AbastecimentoVO> listaRanking(Pageable pageable) {

		AbastecimentoVO abastecimentoVO;
		List<AbastecimentoVO> listaMediaDasRentabilidades = new ArrayList<AbastecimentoVO>();

		List<String> postos = repository.recuperaPostosQueTemAbastecimento();

		List<Abastecimento> abastecimentosDeUmPosto;
		Page<Abastecimento> temp;
		Double acm = 0.0;
		Double mediaRentabilidade = 0.0;

		Posto posto = null;

		for (String p : postos) {

			posto = postoDAO.findOne(p);

			temp = repository.listaAbastecimentosPorPosto(p, pageable);
			abastecimentosDeUmPosto = temp.getContent();

			for (Abastecimento abastecimento : abastecimentosDeUmPosto) {
				acm = acm + (abastecimento.getQuilometragemRodada() / abastecimento.getPrecoPorLitro());
			}

			mediaRentabilidade = acm / abastecimentosDeUmPosto.size();

			abastecimentoVO = new AbastecimentoVO(posto.getId(), posto.getNome(), mediaRentabilidade, 0.0);
			listaMediaDasRentabilidades.add(abastecimentoVO);

			abastecimentoVO = null;
			acm = 0.0;
			mediaRentabilidade = 0.0;
		}

		Double acmDeMedias = 0.0;
		for (AbastecimentoVO a : listaMediaDasRentabilidades) {
			acmDeMedias = acmDeMedias + a.getMediaRentabilidadesPosto();
		}

		Double mediaTotal = acmDeMedias / listaMediaDasRentabilidades.size();

		for (AbastecimentoVO a : listaMediaDasRentabilidades) {
			a.setMediaRentabilidadeGeral(mediaTotal);
		}

		Collections.sort(listaMediaDasRentabilidades, new Comparator<AbastecimentoVO>() {
			@Override
			public int compare(AbastecimentoVO a1, AbastecimentoVO a2) {
				return a1.getMediaRentabilidadesPosto().compareTo(a2.getMediaRentabilidadesPosto());
			}
		});

		final Page<AbastecimentoVO> retorno = new PageImpl<>(listaMediaDasRentabilidades);

		return retorno;
	}

}
