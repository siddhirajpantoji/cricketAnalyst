var controllerPath = "teams"
 cricketApp.controller('teamController', function($scope, $http) {
   $scope.page={};
   $scope.page.pagesizes=[
     { key:"5", value:"5"},{key:"10", value:"10"},{key:"15", value:"15"}
  ];
  $scope.page.selectedSize=  $scope.page.pagesizes[0];

   $scope.pageInfo ={
     size:10,
     pageNumber:0
   }

   $scope.singlePlayer={
     id:'',
     name:'',
     status:true,
     textForModal:'',
     textForButton:'',
     showCreateButton:true
   };
$scope.getPageDetails = function(){
	$http.get(baseURL+controllerPath+"?size="+$scope.page.selectedSize.value+"&page="+$scope.pageInfo.pageNumber)
    .then(function (response) {
    $scope.totalPages=response.data.totalPages;
	   $scope.players = response.data.content;
    $scope.first=response.data.first;
    $scope.last=response.data.last;
    $scope.pageInfo.pageNumber = response.data.number;

    })
    .catch(function (data) {
        console.log("data");
    });
};
$scope.getPageDetails();
$scope.getNextPageDetails = function(){
  $scope.pageInfo.pageNumber = $scope.pageInfo.pageNumber+1;
  $scope.getPageDetails();
};

$scope.getPrevPageDetails = function(){
  $scope.pageInfo.pageNumber = $scope.pageInfo.pageNumber-1;
  $scope.getPageDetails();
};

$scope.createPlayer = function(){

  $scope.singlePlayer.textForModal = "Create Player"
	$http.post(baseURL+controllerPath,$scope.singlePlayer)
    .then(function (response) {
      $scope.singlePlayer.id ='';
      $scope.singlePlayer.name='';
	    $scope.getPageDetails();
    })
    .catch(function (data) {
        console.log("Error while calling ");
    });
}

$scope.changeTextForCreate = function(){
  $scope.singlePlayer.textForModal = "Create Team";
  $scope.singlePlayer.textForButton ="Create";
  $scope.singlePlayer.showCreateButton=true;
}

// delete player Record From the database
$scope.deletePlayer = function () {
  $http.delete(baseURL+controllerPath+$scope.singlePlayer.id)
    .then(function (response) {
        $scope.getPageDetails();
    })
    .catch(function (data) {
        console.log("Error While getting Single Data");
    });
}

$scope.prepareForDelete= function(id){
  $scope.singlePlayer.id = id;
}
// Function for Loading Detail of a single player
$scope.loadSinglePlayerDetail = function(id){

  $http.get(baseURL+controllerPath+"/"+id)
    .then(function (response) {
      $scope.singlePlayer.id =response.data.team.id;
      $scope.singlePlayer.name=response.data.team.name;
    })
    .catch(function (data) {
        console.log("Error While getting Single Data");
    });
}

// Load Details for Editing the player information
$scope.loadEditDetails =function (id) {
  $scope.loadSinglePlayerDetail(id);
  $scope.singlePlayer.textForModal = "Edit Team";
  $scope.singlePlayer.textForButton ="Edit";
  $scope.singlePlayer.showCreateButton=false;
}

$scope.editPlayer = function(){
  $scope.singlePlayer.textForModal = "Create Teamr"
	$http.put(baseURL+controllerPath+"/"+$scope.singlePlayer.id ,$scope.singlePlayer)
    .then(function (response) {
      $scope.singlePlayer.id ='';
      $scope.singlePlayer.name='';
      $scope.getPageDetails();
    })
    .catch(function (data) {
        console.log("Error while calling ");
    });
}
});
