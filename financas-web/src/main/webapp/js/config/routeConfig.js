angular.module("Cadastro").config(function($routeProvider){
	$routeProvider.when("/clientes", {
		templateUrl: "view/cliente/clientes.html",
		controller: "cadastroClienteCtrl",
		resolve: {
			clientes: function($http){
				return $http.get("/listar");
			}
		}
	}).when("/novoCliente",{
		templateUrl: "view/cliente/novoCliente.html",
		controller: "novoClienteCtrl"
	}).when("/detalhesCliente/:id", {
		templateUrl: "view/cliente/detalhesCliente.html",
		controller: "detalhesClienteCtrl",
		resolve: {
			cliente: function($http, $route){
				return $http.get("/buscarPorCodigo?idCliente=" + $route.current.params.id);
			}
		}
			
	}).when("/login",{
		templateUrl: "view/cliente/loginCliente.html",
		controller: "loginClienteCtrl"
	}).otherwise({
		redirectTo: "/clientes"
	});
});