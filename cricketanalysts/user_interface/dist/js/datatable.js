$(document).ready (function() {
$.ajax({
    url: 'http://localhost:8080/players',
    success : function(response) {
			console.log(response);
        var jsonObject = response;
        $('#employeesTable').dataTable( {
            data : response.content,
            //data : response,
            aoColumns: [
                      {"mData" : "id"},
                      {"data" : "name"},
                      {"data" : "status"}
                      ],
            "searching" : false,
						"serverSide": true
        });
    }
});});
