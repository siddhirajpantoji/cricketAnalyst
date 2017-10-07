var playerPath = "players-all"
var teamPath ="teams-all"
var chartPath  = "noOfRunsScored/search/findByAgainstTeamAndPlayer?";
//http://localhost:8080/noOfRunsScored/search/findByAgainstTeamAndPlayer?againstTeam=2&player=17
 cricketApp.controller('chartController', function($scope, $http) {

$scope.players = [];

$scope.selectedPlayer ;
$scope.loadAllPlayers = function (){
    $http.get(baseURL+playerPath)
    .then(function (response) {
      console.log("response recieved "+response.data.length)
 //     for( )
      $scope.players = response.data;
      console.log($scope.players);
    })
    .catch(function (data) {
        console.log("Error Occured");
    });
}
$scope.loadAllPlayers();
$scope.selectedPlayer = $scope.players[0];


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

$scope.loadChartData = function(){
   $http.get(baseURL+chartPath+"againstTeam="+$scope.selectedTeam.id+"&player="+$scope.selectedPlayer.id)
    .then(function (response) {

      console.log("response For Chart "+response.data._embedded.battingNoOfRunsScoreds.length)
      $scope.dataForChart = response.data._embedded.battingNoOfRunsScoreds;
      // No of Records will be matches played
      $scope.headerList = ["Over"];
      $scope.chartOver1 = ["1"];
      $scope.chartOver2 = ["2"];
      $scope.chartOver3 = ["3"];
      $scope.chartOver4 = ["4"];
      $scope.chartOver5 = ["5"];
      $scope.chartOver6 = ["6"];
      $scope.chartOver7 = ["7"];
      $scope.chartOver8 = ["8"];
      $scope.chartOver9 = ["9"];
      $scope.chartOver10 = ["10"];

      $scope.chartOver11 = ["11"];
      $scope.chartOver12 = ["12"];
      $scope.chartOver13 = ["13"];
      $scope.chartOver14 = ["14"];
      $scope.chartOver15 = ["15"];
      $scope.chartOver16 = ["16"];
      $scope.chartOver17 = ["17"];
      $scope.chartOver18 = ["18"];
      $scope.chartOver19 = ["19"];
      $scope.chartOver20 = ["20"];

      $scope.chartOver21 = ["21"];
      $scope.chartOver22 = ["22"];
      $scope.chartOver23 = ["23"];
      $scope.chartOver24 = ["24"];
      $scope.chartOver25 = ["25"];
      $scope.chartOver26 = ["26"];
      $scope.chartOver27 = ["27"];
      $scope.chartOver28 = ["28"];
      $scope.chartOver29 = ["29"];
      $scope.chartOver30 = ["30"];

      $scope.chartOver31 = ["31"];
      $scope.chartOver32 = ["32"];
      $scope.chartOver33 = ["33"];
      $scope.chartOver34 = ["34"];
      $scope.chartOver35 = ["35"];
      $scope.chartOver36 = ["36"];
      $scope.chartOver37 = ["37"];
      $scope.chartOver38 = ["38"];
      $scope.chartOver39 = ["39"];
      $scope.chartOver40 = ["40"];

      $scope.chartOver41 = ["41"];
      $scope.chartOver42 = ["42"];
      $scope.chartOver43 = ["43"];
      $scope.chartOver44 = ["44"];
      $scope.chartOver45 = ["45"];
      $scope.chartOver46 = ["46"];
      $scope.chartOver47 = ["47"];
      $scope.chartOver48 = ["48"];
      $scope.chartOver49 = ["49"];
      $scope.chartOver50 = ["50"];
      if( $scope.dataForChart.length >0 ) {
      for( var i =0; i< $scope.dataForChart.length ; i++ ){
        $scope.headerList.push("Match"+(i+1));
        $scope.chartOver1.push($scope.dataForChart[i].over1)
        $scope.chartOver2.push($scope.dataForChart[i].over2)
        $scope.chartOver3.push($scope.dataForChart[i].over3)
        $scope.chartOver4.push($scope.dataForChart[i].over4)
        $scope.chartOver5.push($scope.dataForChart[i].over5)
        $scope.chartOver6.push($scope.dataForChart[i].over6)
        $scope.chartOver7.push($scope.dataForChart[i].over7)
        $scope.chartOver8.push($scope.dataForChart[i].over8)
        $scope.chartOver9.push($scope.dataForChart[i].over9)
        $scope.chartOver10.push($scope.dataForChart[i].over10);
         $scope.chartOver11.push($scope.dataForChart[i].over11)
        $scope.chartOver12.push($scope.dataForChart[i].over12)
        $scope.chartOver13.push($scope.dataForChart[i].over13)
        $scope.chartOver14.push($scope.dataForChart[i].over14)
        $scope.chartOver15.push($scope.dataForChart[i].over15)
        $scope.chartOver16.push($scope.dataForChart[i].over16)
        $scope.chartOver17.push($scope.dataForChart[i].over17)
        $scope.chartOver18.push($scope.dataForChart[i].over18)
        $scope.chartOver19.push($scope.dataForChart[i].over19)
        $scope.chartOver20.push($scope.dataForChart[i].over20);
         $scope.chartOver21.push($scope.dataForChart[i].over21)
        $scope.chartOver22.push($scope.dataForChart[i].over22)
        $scope.chartOver23.push($scope.dataForChart[i].over23)
        $scope.chartOver24.push($scope.dataForChart[i].over24)
        $scope.chartOver25.push($scope.dataForChart[i].over25)
        $scope.chartOver26.push($scope.dataForChart[i].over26)
        $scope.chartOver27.push($scope.dataForChart[i].over27)
        $scope.chartOver28.push($scope.dataForChart[i].over28)
        $scope.chartOver29.push($scope.dataForChart[i].over29)
        $scope.chartOver30.push($scope.dataForChart[i].over30);
         $scope.chartOver31.push($scope.dataForChart[i].over31)
        $scope.chartOver32.push($scope.dataForChart[i].over32)
        $scope.chartOver33.push($scope.dataForChart[i].over33)
        $scope.chartOver34.push($scope.dataForChart[i].over34)
        $scope.chartOver35.push($scope.dataForChart[i].over35)
        $scope.chartOver36.push($scope.dataForChart[i].over36)
        $scope.chartOver37.push($scope.dataForChart[i].over37)
        $scope.chartOver38.push($scope.dataForChart[i].over38)
        $scope.chartOver39.push($scope.dataForChart[i].over39)
        $scope.chartOver40.push($scope.dataForChart[i].over40);
         $scope.chartOver41.push($scope.dataForChart[i].over41)
        $scope.chartOver42.push($scope.dataForChart[i].over42)
        $scope.chartOver43.push($scope.dataForChart[i].over43)
        $scope.chartOver44.push($scope.dataForChart[i].over44)
        $scope.chartOver45.push($scope.dataForChart[i].over45)
        $scope.chartOver46.push($scope.dataForChart[i].over46)
        $scope.chartOver47.push($scope.dataForChart[i].over47)
        $scope.chartOver48.push($scope.dataForChart[i].over48)
        $scope.chartOver49.push($scope.dataForChart[i].over49)
        $scope.chartOver50.push($scope.dataForChart[i].over50);
      }
    }
    else
    {
      $scope.headerList.push("Match");
        $scope.chartOver1.push(0);
        $scope.chartOver2.push(0)
        $scope.chartOver3.push(0);
        $scope.chartOver4.push(0);
        $scope.chartOver5.push(0);
        $scope.chartOver6.push(0);
        $scope.chartOver7.push(0);
        $scope.chartOver8.push(0);
        $scope.chartOver9.push(0);
        $scope.chartOver10.push(0);
        $scope.chartOver11.push(0);
        $scope.chartOver12.push(0);
        $scope.chartOver13.push(0);
        $scope.chartOver14.push(0);
        $scope.chartOver15.push(0);
        $scope.chartOver16.push(0);
        $scope.chartOver17.push(0);
        $scope.chartOver18.push(0);
        $scope.chartOver19.push(0);
        $scope.chartOver20.push(0);
        $scope.chartOver21.push(0);
        $scope.chartOver22.push(0);
        $scope.chartOver23.push(0);
        $scope.chartOver24.push(0);
        $scope.chartOver25.push(0);
        $scope.chartOver26.push(0);
        $scope.chartOver27.push(0);
        $scope.chartOver28.push(0);
        $scope.chartOver29.push(0);
        $scope.chartOver30.push(0);
        $scope.chartOver31.push(0);
        $scope.chartOver32.push(0);
        $scope.chartOver33.push(0);
        $scope.chartOver34.push(0);
        $scope.chartOver35.push(0);
        $scope.chartOver36.push(0);
        $scope.chartOver37.push(0);
        $scope.chartOver38.push(0);
        $scope.chartOver39.push(0);
        $scope.chartOver40.push(0);
        $scope.chartOver41.push(0);
        $scope.chartOver42.push(0);
        $scope.chartOver43.push(0);
        $scope.chartOver44.push(0);
        $scope.chartOver45.push(0);
        $scope.chartOver46.push(0);
        $scope.chartOver47.push(0);
        $scope.chartOver48.push(0);
        $scope.chartOver49.push(0);
        $scope.chartOver50.push(0);
    }
      $scope.finalData = [];
      $scope.finalData.push($scope.headerList);
      $scope.finalData.push($scope.chartOver1);
      $scope.finalData.push($scope.chartOver2);
      $scope.finalData.push($scope.chartOver3);
      $scope.finalData.push($scope.chartOver4);
      $scope.finalData.push($scope.chartOver5);
      $scope.finalData.push($scope.chartOver6);
      $scope.finalData.push($scope.chartOver7);
      $scope.finalData.push($scope.chartOver8);
      $scope.finalData.push($scope.chartOver9);
      $scope.finalData.push($scope.chartOver10);
      $scope.finalData.push($scope.chartOver11);
      $scope.finalData.push($scope.chartOver12);
      $scope.finalData.push($scope.chartOver13);
      $scope.finalData.push($scope.chartOver14);
      $scope.finalData.push($scope.chartOver15);
      $scope.finalData.push($scope.chartOver16);
      $scope.finalData.push($scope.chartOver17);
      $scope.finalData.push($scope.chartOver18);
      $scope.finalData.push($scope.chartOver19);
      $scope.finalData.push($scope.chartOver20);
      $scope.finalData.push($scope.chartOver21);
      $scope.finalData.push($scope.chartOver22);
      $scope.finalData.push($scope.chartOver23);
      $scope.finalData.push($scope.chartOver24);
      $scope.finalData.push($scope.chartOver25);
      $scope.finalData.push($scope.chartOver26);
      $scope.finalData.push($scope.chartOver27);
      $scope.finalData.push($scope.chartOver28);
      $scope.finalData.push($scope.chartOver29);
      $scope.finalData.push($scope.chartOver30);
      $scope.finalData.push($scope.chartOver31);
      $scope.finalData.push($scope.chartOver32);
      $scope.finalData.push($scope.chartOver33);
      $scope.finalData.push($scope.chartOver34);
      $scope.finalData.push($scope.chartOver35);
      $scope.finalData.push($scope.chartOver36);
      $scope.finalData.push($scope.chartOver37);
      $scope.finalData.push($scope.chartOver38);
      $scope.finalData.push($scope.chartOver39);
      $scope.finalData.push($scope.chartOver40);
      $scope.finalData.push($scope.chartOver41);
      $scope.finalData.push($scope.chartOver42);
      $scope.finalData.push($scope.chartOver43);
      $scope.finalData.push($scope.chartOver44);
      $scope.finalData.push($scope.chartOver45);
      $scope.finalData.push($scope.chartOver46);
      $scope.finalData.push($scope.chartOver47);
      $scope.finalData.push($scope.chartOver48);
      $scope.finalData.push($scope.chartOver49);
      $scope.finalData.push($scope.chartOver50);

      console.log("Header Info "+$scope.finalData)
      allData  = $scope.finalData;
      $scope.drawChart();
    })
    .catch(function (data) {
        console.log("Error Occured");
    });
}

$scope.drawChart =function drawChart() {
        console.log("Drawing Chart ")
        var data = new  google.visualization.arrayToDataTable(allData);
        var options = {
        isStacked: false,
          title: 'Batsman Peformance',
          hAxis: {title: 'Over',  titleTextStyle: {color: '#333'}},
          vAxis: {minValue: 0, title:' Runs '}
        };

        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
});
