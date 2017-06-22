(function($app) {

	app.controller("CtrlViaCep", CtrlViaCep);
	CtrlViaCep.$inject = ['$scope', '$http', '$q'];

	function CtrlViaCep($scope, $http, $q) {

		$scope.address = {
			cep : null,
			logradouro : null,
			bairro : null,
			localidade : null,
			uf : null
		
		}

		$scope.valor = null;
		$scope.viacep = function() {
			viaCepUrl = "https://viacep.com.br/ws/" + $scope.address.cep + "/json/";
			deferred = $q.defer();
			$http.get(viaCepUrl).then(function(response) {
				var raw;
				raw = response.data;
				$scope.address = raw;
				if (raw.erro) {
					$scope.address = deferred.reject('CEP não encontrado');
					return deferred.reject('CEP não encontrado');
				} else {
				  Posto.active.cep = raw.cep;
				  Posto.active.logradouro = raw.logradouro;
				  Posto.active.bairro = raw.bairro;
				  Posto.active.cidade = raw.localidade;
				  Posto.active.uf = raw.uf;
				  console.log(raw);
					return deferred.resolve(raw);
					
				}
			});
		}
	}

}(app));
