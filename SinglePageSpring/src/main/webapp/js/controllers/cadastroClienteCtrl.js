angular.module("Cadastro").controller("cadastroClienteCtrl", function($scope, $http, clientes) {
    $scope.titulo = "Usuarios";
	$scope.usuarios = clientes.data;
	
	/*
	//Exemplo de outra forma
	$scope.listarUsuario = function(usuario){
		$http.get("/listar")
		  .success(function (response) {
              for (i = 0; i < response.length; i++) {
                  var item = response[i];
                  $scope.usuarios.push({ codigo:item.codigo, nome:item.nome, cpf:item.cpf, login:item.login, senha:item.senha});
              }
		  }).error(function (response) {
			  alert("Erro" + response.status);
		  });
	};
	
	//Forma Mais Simples
	var carregarLista = function(){
		$http.get("/listar").success(function (response, status) {
            $scope.usuarios = response;
		}).error(function (response, status) {
			  alert("Erro" + response.status);
		});
	};
	carregarLista();
	*/
	
	$scope.apagarUsuarios = function(usuarios){
		$scope.usuarios = usuarios.filter(function(usuario){
			if(!usuario.selecionado) return usuario;
		});
		
		var usuariosSelecionados = usuarios.filter(function(usuario){
			if(usuario.selecionado) return usuario;
		});
		
		for(var i = 0; i < usuariosSelecionados.length; i++){
			$http.get("/apagar?usuario=" + usuariosSelecionados[i].codigo)
			.success(function (response) {
				alert(response);
			}).error(function (response) {
				alert("Erro ao apagar usuarios" + response.status);
			});
		}
	};
	
	$scope.isUsuarioSelecionado = function (usuarios) {
		return usuarios.some(function(usuario){
			return usuario.selecionado;
		});
	};
	
	$scope.ordenarPor = function(campo){
		$scope.ordenacao = campo;
		$scope.direcao = !$scope.direcao;
	};
});