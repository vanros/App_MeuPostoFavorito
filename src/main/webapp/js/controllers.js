(function ($app) {
    angular.module('custom.controllers', []);

    app.controller('LoginController', ['$scope', '$http', '$location', '$rootScope', '$window', '$state', '$translate', 'Notification', function ($scope, $http, $location, $rootScope, $window, $state, $translate, Notification) {
      for(var x in app.userEvents)
            $scope[x]= app.userEvents[x].bind($scope);
      
        $scope.message = {};
        $scope.login = function () {

            $scope.message.error = undefined;

            var user = { username: $scope.username.value, password: $scope.password.value };

            $http({
                method: 'POST',
                url: 'auth',
                data: $.param(user),
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
            }).success(handleSuccess).error(handleError);
        }
        
        function handleSuccess(data, status, headers, config) {
            // Store data response on session storage
            // The session storage will be cleaned when the browser window is closed
            if(typeof(Storage) !== "undefined") {
                // save the user data on localStorage
                sessionStorage.setItem("_u",JSON.stringify(data));
                $rootScope.session = JSON.parse(sessionStorage._u);
            } else {
                // Sorry! No Web Storage support.
                // The home page may not work if it depends
                // on the logged user data
            }
            
            // Redirect to home page
            $state.go("home");
        }

        function handleError(data, status, headers, config) {
            var error = status == 401 ? $translate.instant('Login.view.invalidPassword') : data;
            Notification.error(error);
        }
        
        $scope.redirectRegister = function() {
            $state.go("cadastro");
        }; 
        
    }]);


app.controller('CadastroController', ['$scope', '$http', '$rootScope', '$state', '$translate', 'Notification', function ($scope, $http, $rootScope, $state, $translate, Notification) {
  function General($scope, $element, $http, $filter)  
  {  
   $scope.data = $filter('date')(new Date(), 'yyyy-MM-dd HH:mm:ss');  
  }  
  
}]);

app.controller('ComentariosController', ['$scope', '$http', '$rootScope', '$state', '$translate', 'Notification', function ($scope, $http, $rootScope, $state, $translate, Notification) {
  
  $scope.dataHora = function() {
    
    Comentario.active.data = new Date();
  
  }
  
  
}]);




app.controller('CepController', ['$scope', '$http', '$rootScope', '$state', '$translate', 'Notification', function ($scope, $http, $rootScope, $state, $translate, Notification) {

$scope.buscarCEP = function(){
    var urlWebService = "https://correiosapi.apphb.com/cep/";
    var cep = $scope.cep;
    
    uri = urlWebService + cep;
    $http.get(uri).sucess(function(data, status){
      $scope.dadosCEP = data.tipoDeLogradouro + ' ' + 
        data.logradouro + ', ' + data.bairro + ', ' + 
        data.cidade + '' + ' - '+ data.estado;
    }).error(function(){alert("Ocorreu um erro ao pesquisar o CEP")});
    
    
  }

  
}]);


app.controller('LivreAcessoController', ['$scope', '$http', '$rootScope', '$state', '$translate', 'Notification', function ($scope, $http, $rootScope, $state, $translate, Notification) {
  
  $scope.redirectRegister = function() {
            $state.go("cadastro");
  }; 
  
   $scope.redirectLogin = function() {
            $state.go("login");
  }; 
  

  
}]);

    app.controller('HomeController', ['$scope', '$http', '$rootScope', '$state', '$translate', 'Notification', function ($scope, $http, $rootScope, $state, $translate, Notification) {
      
      $rootScope.http = $http;

      for(var x in app.userEvents)
            $scope[x]= app.userEvents[x].bind($scope);
      
        $scope.message = {};
        
        $scope.selecionado = {
          valor : 1
        }
        
         $scope.redirectCarrosCampeoes = function() {
            $state.go("mediaRentabilidadeCarro");
  };
  
         $scope.redirectConsumoMedio = function() {
            $state.go("consumoMedio");
  };
        
         $scope.redirectComentarios = function() {
            $state.go("comentarios");
  };
        // refresh token
        $scope.refreshToken = function() {
            $http({
                method: 'GET',
                url: 'auth/refresh'
            }).success(function(data, status, headers, config) {
                // Store data response on session storage
                  console.log('revive :' , new Date(data.expires));
                  sessionStorage.setItem("_u",JSON.stringify(data));
                  // Recussive 
                  setTimeout(function() {
                    $scope.refreshToken();
                    // refres time
                  },(1800*1000));
                  
            }).error(function() {
              // abafar TODO 
            });
        };

        $rootScope.session = (sessionStorage._u) ? JSON.parse(sessionStorage._u) : null;
        if($rootScope.session) {
          // When access home page we have to check
          // if the user is authenticated and the userData
          // was saved on the browser's sessionStorage
          $rootScope.myTheme = $rootScope.session.user.theme;
          $scope.$watch('myTheme', function(value) {
            if (value !== undefined && value !== "") {
              $('#themeSytleSheet').attr('href', "css/themes/"+value+".min.css");
            }
          });
          if ($rootScope.session.token) $scope.refreshToken();
        } else {
          $state.go("'livreAcesso");
          sessionStorage.removeItem("_u");
        }
        
        $rootScope.logout = function logout() {
          $rootScope.session = {};
          if(typeof (Storage) !== "undefined") {
            // save the user data on localStorage
            sessionStorage.removeItem("_u");
          }
          $state.go("livreAcesso");
        };
        
        $scope.changePassword = function () {

            var user = { oldPassword: oldPassword.value, newPassword: newPassword.value, newPasswordConfirmation: newPasswordConfirmation.value };

            $http({
                method: 'POST',
                url: 'changePassword',
                data: $.param(user),
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
            }).success(changeSuccess).error(changeError);
            
            function changeSuccess(data, status, headers, config) {
              Notification.info($translate.instant('Home.view.passwordChanged'));
              cleanPasswordFields();
            }
    
            function changeError(data, status, headers, config) {
                var error = status >= 401 ? $translate.instant('Home.view.InvalidPassword') : data;
                Notification.error(error);
            }     
            
            function cleanPasswordFields() {
                oldPassword.value = "";
                newPassword.value = "";
                newPasswordConfirmation.value = "";
                $("#modalPassword").modal("hide");
            }
        };
        
        var closeMenuHandler = function () {
          var element = $(this);
          if(element.closest('.sub-menu').length > 0) {
            element.closest(".navbar-nav").collapse('hide');
          }
        };
          
        $scope.$on('$viewContentLoaded', function(){
          var navMain = $(".navbar-nav");
          
          //Here your view content is fully loaded !!
          navMain.off("click", "a", closeMenuHandler);
          navMain.on("click", "a", closeMenuHandler);
        });
        
        $scope.themes = ["cerulean","cosmo","cyborg","darkly","flatly","journal","lumen","paper","readable","sandstone","simplex","slate","spacelab","superhero","united","yeti"];

        $scope.changeTheme = function(theme) {
          console.log(theme);
          if (theme !== undefined) {
            console.log(theme);
            $('body').append('<div id="transition" />');
            $('#transition').css({
              'background-color':'#FFF',
              'zIndex':100000,
              'position':'fixed',
              'top':'0px',
              'right':'0px',
              'bottom':'0px',
              'left':'0px',
              'overflow':'hidden',
              'display':'block'
            });
            $('#transition').fadeIn(800, function(){
              $('#themeSytleSheet').attr('href', "css/themes/"+theme+".min.css");
              $rootScope.myTheme = theme;
              $('#transition').fadeOut(1000,function(){$('#transition').remove();});  
            });
            
            var user = { theme: theme };

            $http({
                method: 'POST',
                url: 'changeTheme',
                data: $.param(user),
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
            }).success(changeSuccess).error(changeError);
            
            function changeSuccess(data, status, headers, config) {
              $rootScope.session.theme = theme;
              sessionStorage.setItem("_u",JSON.stringify($rootScope.session));
            }
    
            function changeError(data, status, headers, config) {
                var error = data;
                Notification.error(error);
            }     
            
          }
        };
    }]);
} (app));