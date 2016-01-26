angular.module("Financas").controller("cadastroCtrl", function ($scope, 
		$http, $location) {
    $scope.titulo = "Cadastro";

    $scope.cadastrarUsuario = function (cadastro) {
        $http.post("http://localhost:8888/rest/usuario", cadastro)
        .success(function (response) {
            var response = parseInt(response);
            if (response) {
                delete $scope.cadastro;
                alert("Cadastro realizado com sucesso");
                $location.path("/login");
            } else {
                $scope.mensagem = "Cadastro Invalido";
            }
        }).error(function (response) {
            alert("Erro " + response.status);
        });
    };
});