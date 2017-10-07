var controllerPath = "battingNoOfRunsScoreds"
var playerPath = "players-all"
var teamPath ="teams-all"

cricketApp.controller('scoreController', function($scope, $http) {
$scope.page={};
$scope.page.pagesizes=[
{ key:"5", value:"5"},{key:"10", value:"10"},{key:"15", value:"15"}
];
$scope.page.selectedSize=  $scope.page.pagesizes[0];

$scope.pageInfo ={
size:10,
pageNumber:0
}


$scope.teams = [];
$scope.loadAllTeams  = function(){
$http.get(baseURL+teamPath)
.then(function (response) {
console.log("response recieved "+response.data.length)
//     for( )
$scope.teams = response.data;
})
.catch(function (data) {
console.log("Error Occured");
});
}
$scope.loadAllTeams();
$scope.selectedTeam = $scope.teams[0];

$scope.playerList = [];
$scope.loadAllPlayersListing  = function(){
$http.get(baseURL+playerPath)
.then(function (response) {
console.log("response recieved "+response.data.length)
//     for( )
$scope.playerList = response.data;
})
.catch(function (data) {
console.log("Error Occured");
});
}
$scope.loadAllPlayersListing();
$scope.selectedPlayer = $scope.playerList[0];

    $scope.singlePlayer={
    id:'',
    playerId:'',
    teamId:'',
    over1:'',
    over2:'',
    over3:'',
    over4:'',
    over5:'',
    over6:'',
    over7:'',
    over8:'',
    over9:'',
    over10:'',
    over11:'',
    over12:'',
    over13:'',
    over14:'',
    over15:'',
    over16:'',
    over17:'',
    over18:'',
    over19:'',
    over20:'',
    over21:'',
    over22:'',
    over23:'',
    over24:'',
    over25:'',
    over26:'',
    over27:'',
    over28:'',
    over29:'',
    over30:'',
    over31:'',
    over32:'',
    over33:'',
    over34:'',
    over35:'',
    over36:'',
    over37:'',
    over38:'',
    over39:'',
    over40:'',
    over41:'',
    over42:'',
    over43:'',
    over44:'',
    over45:'',
    over46:'',
    over47:'',
    over48:'',
    over49:'',
    over50:'',
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
  $scope.singlePlayer.teamId= $scope.selectedTeam.id;
  $scope.singlePlayer.playerId= $scope.selectedPlayer.id;
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
      $scope.singlePlayer.textForModal = "Create Score`";
      $scope.singlePlayer.textForButton ="Create";
      $scope.singlePlayer.showCreateButton=true;
      $scope.singlePlayer.id ='';
      $scope.selectedTeam = $scope.teams[0];
      $scope.selectedPlayer = $scope.players[0];
      $scope.singlePlayer.over1='';
      $scope.singlePlayer.over2='';
      $scope.singlePlayer.over3='';
      $scope.singlePlayer.over4='';
      $scope.singlePlayer.over5='';
      $scope.singlePlayer.over6='';
      $scope.singlePlayer.over7='';
      $scope.singlePlayer.over8='';
      $scope.singlePlayer.over9='';
      $scope.singlePlayer.over10='';
      $scope.singlePlayer.over11='';
      $scope.singlePlayer.over12='';
      $scope.singlePlayer.over13='';
      $scope.singlePlayer.over14='';
      $scope.singlePlayer.over15='';
      $scope.singlePlayer.over16='';
      $scope.singlePlayer.over17='';
      $scope.singlePlayer.over18='';
      $scope.singlePlayer.over19='';
      $scope.singlePlayer.over20='';

      $scope.singlePlayer.over21='';
      $scope.singlePlayer.over22='';
      $scope.singlePlayer.over23='';
      $scope.singlePlayer.over24='';
      $scope.singlePlayer.over25='';
      $scope.singlePlayer.over26='';
      $scope.singlePlayer.over27='';
      $scope.singlePlayer.over28='';
      $scope.singlePlayer.over29='';
      $scope.singlePlayer.over30='';
      $scope.singlePlayer.over31='';
      $scope.singlePlayer.over32='';
      $scope.singlePlayer.over33='';
      $scope.singlePlayer.over34='';
      $scope.singlePlayer.over35='';
      $scope.singlePlayer.over36='';
      $scope.singlePlayer.over37='';
      $scope.singlePlayer.over38='';
      $scope.singlePlayer.over39='';
      $scope.singlePlayer.over40='';
      $scope.singlePlayer.over41='';
      $scope.singlePlayer.over42='';
      $scope.singlePlayer.over43='';
      $scope.singlePlayer.over44='';
      $scope.singlePlayer.over45='';
      $scope.singlePlayer.over46='';
      $scope.singlePlayer.over47='';
      $scope.singlePlayer.over48='';
      $scope.singlePlayer.over49='';
      $scope.singlePlayer.over50='';
}

// delete player Record From the database
$scope.deletePlayer = function () {
$http.delete(baseURL+controllerPath+"/"+$scope.singlePlayer.id)
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
$scope.singlePlayer.id =response.data.battingNoOfRunsScored.id;
$scope.selectedPlayer=response.data.battingNoOfRunsScored.player;
$scope.selectedTeam=response.data.battingNoOfRunsScored.againstTeam;
$scope.singlePlayer.playerId=$scope.selectedPlayer.id;
$scope.singlePlayer.teamId = $scope.selectedTeam.id;
$scope.singlePlayer.over1=response.data.battingNoOfRunsScored.over1;
$scope.singlePlayer.over2=response.data.battingNoOfRunsScored.over2;
$scope.singlePlayer.over3=response.data.battingNoOfRunsScored.over3;
$scope.singlePlayer.over4=response.data.battingNoOfRunsScored.over4;
$scope.singlePlayer.over5=response.data.battingNoOfRunsScored.over5;
$scope.singlePlayer.over6=response.data.battingNoOfRunsScored.over6;
$scope.singlePlayer.over7=response.data.battingNoOfRunsScored.over7;
$scope.singlePlayer.over8=response.data.battingNoOfRunsScored.over8;
$scope.singlePlayer.over9=response.data.battingNoOfRunsScored.over9;
$scope.singlePlayer.over10=response.data.battingNoOfRunsScored.over10;
$scope.singlePlayer.over11=response.data.battingNoOfRunsScored.over11;
$scope.singlePlayer.over12=response.data.battingNoOfRunsScored.over12;
$scope.singlePlayer.over13=response.data.battingNoOfRunsScored.over13;
$scope.singlePlayer.over14=response.data.battingNoOfRunsScored.over14;
$scope.singlePlayer.over15=response.data.battingNoOfRunsScored.over15;
$scope.singlePlayer.over16=response.data.battingNoOfRunsScored.over16;
$scope.singlePlayer.over17=response.data.battingNoOfRunsScored.over17;
$scope.singlePlayer.over18=response.data.battingNoOfRunsScored.over18;
$scope.singlePlayer.over19=response.data.battingNoOfRunsScored.over19;
$scope.singlePlayer.over20=response.data.battingNoOfRunsScored.over20;
$scope.singlePlayer.over21=response.data.battingNoOfRunsScored.over21;
$scope.singlePlayer.over22=response.data.battingNoOfRunsScored.over22;
$scope.singlePlayer.over23=response.data.battingNoOfRunsScored.over23;
$scope.singlePlayer.over24=response.data.battingNoOfRunsScored.over24;
$scope.singlePlayer.over25=response.data.battingNoOfRunsScored.over25;
$scope.singlePlayer.over26=response.data.battingNoOfRunsScored.over26;
$scope.singlePlayer.over27=response.data.battingNoOfRunsScored.over27;
$scope.singlePlayer.over28=response.data.battingNoOfRunsScored.over28;
$scope.singlePlayer.over29=response.data.battingNoOfRunsScored.over29;
$scope.singlePlayer.over30=response.data.battingNoOfRunsScored.over30;
$scope.singlePlayer.over31=response.data.battingNoOfRunsScored.over31;
$scope.singlePlayer.over32=response.data.battingNoOfRunsScored.over32;
$scope.singlePlayer.over33=response.data.battingNoOfRunsScored.over33;
$scope.singlePlayer.over34=response.data.battingNoOfRunsScored.over34;
$scope.singlePlayer.over35=response.data.battingNoOfRunsScored.over35;
$scope.singlePlayer.over36=response.data.battingNoOfRunsScored.over36;
$scope.singlePlayer.over37=response.data.battingNoOfRunsScored.over37;
$scope.singlePlayer.over38=response.data.battingNoOfRunsScored.over38;
$scope.singlePlayer.over39=response.data.battingNoOfRunsScored.over39;
$scope.singlePlayer.over40=response.data.battingNoOfRunsScored.over40;
$scope.singlePlayer.over41=response.data.battingNoOfRunsScored.over41;
$scope.singlePlayer.over42=response.data.battingNoOfRunsScored.over42;
$scope.singlePlayer.over43=response.data.battingNoOfRunsScored.over43;
$scope.singlePlayer.over44=response.data.battingNoOfRunsScored.over44;
$scope.singlePlayer.over45=response.data.battingNoOfRunsScored.over45;
$scope.singlePlayer.over46=response.data.battingNoOfRunsScored.over46;
$scope.singlePlayer.over47=response.data.battingNoOfRunsScored.over47;
$scope.singlePlayer.over48=response.data.battingNoOfRunsScored.over48;
$scope.singlePlayer.over49=response.data.battingNoOfRunsScored.over49;
$scope.singlePlayer.over50=response.data.battingNoOfRunsScored.over50;
})
.catch(function (data) {
console.log("Error While getting Single Data");
});
}

// Load Details for Editing the player information
$scope.loadEditDetails =function (id) {
console.log("In Edit load Details ");
$scope.loadSinglePlayerDetail(id);
$scope.singlePlayer.textForModal = "Edit Score";
$scope.singlePlayer.textForButton ="Edit";
$scope.singlePlayer.showCreateButton=false;
}

$scope.editPlayer = function(){
$scope.singlePlayer.textForModal = "Create Player"
$scope.singlePlayer.teamId= $scope.selectedTeam.id;
$scope.singlePlayer.playerId = $scope.selectedPlayer.id;
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
