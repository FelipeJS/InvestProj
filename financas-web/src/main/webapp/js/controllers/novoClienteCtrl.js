angular.module("Cadastro").controller("novoClienteCtrl", function($scope, $http, $location) {
    $scope.titulo = "Novo Contato";
    $scope.usuarios = [];
    
	$scope.perfis = [{codigo:"1", nome:"Gerente", categoria:"Gerencia"},
	                 {codigo:"2", nome:"Vendedor", categoria:"Vendas"},
	                 {codigo:"3", nome:"Atendente", categoria:"Recepção"}]
	
	$scope.adicionarUsuario = function(usuario){
		$http.post("/salvar?cadUsuario=" + usuario.nome + "$" + usuario.cpf + "$" + 
										   usuario.login + "$" + usuario.senha)
		  .success(function (response) {
			  $scope.usuarios.push(response);
			  delete $scope.usuario;
			  $scope.usuarioForm.$setPristine();
			  $location.path("/clientes");
		  }).error(function (response) {
			  alert("Erro " + response.status);
		  });
	};
	
	$scope.isValidCPF = function (cpf) {
		return CPF.isValid(cpf);
	};
	
});