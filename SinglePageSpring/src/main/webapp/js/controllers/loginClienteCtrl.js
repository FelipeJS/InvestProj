angular.module("Cadastro").controller("loginClienteCtrl", function($scope, $http, $location){
	$scope.titulo = "Login Usuário";
	
	$scope.autenticarUsuario = function(usuario){
		$http.post("/autenticar?loginSenha=" + usuario.login + "$" + usuario.senha)
		.success(function (response) {
			$scope.cliente = response;
			if($scope.cliente == ""){
				$scope.titulo = "Usuario ou senha invalidos";
			}else{
				$scope.titulo = "Login feito com sucesso";
				$location.path("/menu");
			}
		}).error(function (response) {
			alert("Erro " + response.status);
		});
	};
});