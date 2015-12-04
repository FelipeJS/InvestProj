angular.module("Cadastro").controller("detalhesClienteCtrl", function($scope, $routeParams, $http, cliente, $location) {
	$scope.titulo = "Editar Usuario";
	$scope.cliente = cliente.data;
	$scope.perfis = [{codigo:"1", nome:"Gerente", categoria:"Gerencia"},
	                 {codigo:"2", nome:"Vendedor", categoria:"Vendas"},
	                 {codigo:"3", nome:"Atendente", categoria:"Recepção"}]
	
	$scope.editarCliente = function(cliente){
		$http.post("/editar?cadUsuario=" + cliente.codigo + "$" + cliente.nome + "$" + cliente.cpf + "$" + 
										   cliente.login + "$" + cliente.senha)
		.success(function (response) {
			$scope.cliente = response;
			$location.path("/clientes");
		}).error(function (response) {
			alert("Erro " + response.status);
		});
	};
	
	$scope.isValidCPF = function (cpf) {
		return CPF.isValid(cpf);
	};
});