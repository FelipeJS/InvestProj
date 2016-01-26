angular.module("Financas").controller("movimentacaoCtrl", function($scope, $http, 
		movimentacoes, $location) {
$scope.titulo = "Movimentações";
$scope.descricao = "Descrição";
$scope.movimentacoes = movimentacoes.data;

$scope.apagarMovimentacoes = function(movimentacoes){
	$scope.movimentacoes = movimentacoes.filter(function(movimentacao){
		if(!movimentacao.selecionada) return movimentacao;
	});
	var movimentacoesSelecionadas = movimentacoes.filter(function(movimentacao){
		if(movimentacao.selecionada) return movimentacao;
	});
	
	for(var i = 0; i < movimentacoesSelecionadas.length; i++){
        $http({ url: '/rest/movimentacao', 
            method: 'DELETE', 
            data: movimentacoesSelecionadas[i], 
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function(response) {
        	var response = parseInt(response);
			if(response == -1){
				alert("Falha ao tentar excluir movimentação");
			}else{
				alert("Movimentação excluida com sucesso");
			}
        }, function(error) {
        	alert("Erro no servidor");
        });}};
$scope.cadastrarMovimento = function (movimento) {
    $http.post("http://localhost:8888/rest/movimentacao", movimento)
    .success(function (response) {
        var response = parseInt(response);
        if (response) {
            delete $scope.movimento;
            $scope.movimentoForm.$setPristine();
            $scope.movimentacoes.push(movimento);
        } else {
            alert("Movimento Invalido");
        }
    }).error(function (response) {
        alert("Erro " + response.status);
    });
};

$scope.isMovimentacaoSelecionada = function (movimentacoes) {
	return movimentacoes.some(function(movimentacao){
		return movimentacao.selecionada;
	});
};

$scope.ordenarPor = function(campo){
	$scope.ordenacao = campo;
	$scope.direcao = !$scope.direcao;
};
});