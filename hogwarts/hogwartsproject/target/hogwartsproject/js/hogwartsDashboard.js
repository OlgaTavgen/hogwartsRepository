
//$('#li-element').click(function() {
//	$.ajax({
//		url: "localhost:8080/hogwartsproject/hogwarts/dashboard",
//		data : {
//			format: 'json'
//		},
//		success: function(data) {
//			var $team = $('<h1>').text(data.team)
//		},
//		type: 'GET'
//	})
//})

$(function() {
    $('#li-element').click(function() {
        alert(this.id); 
    });
})