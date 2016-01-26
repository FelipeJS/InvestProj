angular.module("Financas").controller("loginCtrl", function ($scope, $http, $location) {
    $scope.titulo = "Login";

    $scope.autenticarUsuario = function (login) {
        $http.post("http://localhost:8888/rest/login", login)
        .success(function (response) {
            var response = parseInt(response);
            if (response) {
                $location.path("/movimentacoes");
            } else {
                alert("Usuario ou senha invalidos");
            }
        }).error(function (response) {
            alert("Erro " + response.status);
        });
    };
});