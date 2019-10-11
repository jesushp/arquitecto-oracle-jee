$(function(){

  
  $(".ask-libro").click(function(event) {
  		
  		var $button = $(this);
  		var isbn = $button.data("isbn")
  		var cliente = $button.data("cliente")

  		$.ajax({
  			url: 'ask',
  			data : {"idCliente": cliente, "isbn": isbn}
  		})
  		.done(function(feedback) {
  			debugger;
  			var data = JSON.parse(feedback);
  			var message = "<div class='alert alert-" + (data.success ? "info" : "danger") + "'>"+
			"<strong>"+data.message+"</strong></div>";
		
  			$button.parents(".container").prepend(message);

  		})
  		.fail(function(data) {
  			console.error(data);
  		})
  		
  });

  

}); 