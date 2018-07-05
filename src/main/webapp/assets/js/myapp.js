var app=angular.module("myChatApp",[]);
app.controller("myChatController", function($scope,$http){
	$scope.userId=parseInt('1',10);
	$scope.message=null;
	$scope.conversationId=parseInt('1',10);
	
	$scope.pageMessages=[];
	$scope.pageCouranteMessage=0;
	$scope.pageSizeMessage=10;
	$scope.pagesMessage=[];
	$scope.errorMessage=null;
	
	$scope.pageUsers=[];
	$scope.pageCouranteUser=0;
	$scope.pageSizeUser=3;
	$scope.pagesUser=[];
	$scope.errorUser=null;
	
	$scope.chargerUtilisateurs=function(){
		$scope.pageCouranteUser=0;
		$scope.errorMessageUser=null;
		$http.get("/chat/users")
		.then(function(response){
			$scope.pageUsers=response.data;
			$scope.pagesUser= new Array(response.data.totalPages);
		});
	};
	
	$scope.goToPage=function(p){
		$scope.pageCouranteUser=p;
		$scope.loadUsers();
	};
	
	
	$scope.chargerMessages=function(){
		$scope.pageCouranteMessage=0;
		$scope.errorMessage=null;
		$http.get("/chat/showMessage/1")
		.then(function(response){
			$scope.pageMessages=response.data;
			$scope.pagesMessage= new Array(response.data.totalPages);
			//console.log(response, 'res');
		}
		,function(error){
			$scope.errorMessage=error.message;
		});
	};
	
	
	
	$scope.envoyer=function(){
		$http({
			method : "POST",
			url : "envoyer",
			data : "message=" + $scope.message + "&userId=" + $scope.userId + "&conversationId=" + $scope.conversationId,
			headers : {'Content-Type':'application/x-www-form-urlencoded'} 
		})
		.then(function(response) {
			//$scope.chargerMessages();
		}
		,function(error){
			$scope.errorMessage=error.message;
		})
		;
	};
	
	app.filter('num', function() {
	    return function(input) {
	      return parseInt(input, 10);
	    };
	});
	
});