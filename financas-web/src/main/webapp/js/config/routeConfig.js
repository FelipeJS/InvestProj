angular.module("Financas").config(function($routeProvider){
	$routeProvider.when("/movimentacoes", {
		templateUrl: "view/movimentacao.html",
		controller: "movimentacaoCtrl",
		resolve: {
			movimentacoes: function($http){
				return $http.get("/rest/movimentacao");
			}
		}
	}).when("/login",{
		templateUrl: "view/login.html",
		controller: "loginCtrl"
	}).when("/cadastro",{
		templateUrl: "view/cadastro.html",
		controller: "cadastroCtrl"
	}).otherwise({
		redirectTo: "/login"
	});
});