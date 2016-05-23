$(".input").focusin(function() {
	$(this).find("span").animate({
		"opacity" : "0"
	}, 200);
});

$(".input").focusout(function() {
	$(this).find("span").animate({
		"opacity" : "1"
	}, 300);
});

function handleComplete(xhr,status,args){

	var isValid = args.isValid;

	$(".login").find(".submit i").removeAttr('class').addClass("fa fa-check").css({
		"color" : "#fff"
	});

	if(isValid){

		$(".feedback").addClass("success")
			          .show()
			          .animate({
			               "opacity" : "1",
						   "bottom" : "-80px"
		              }, 400);

		$(".submit").css({
			"background" : "#2ecc71",
			"border-color" : "#2ecc71"
		});

		$("input").css({
			"border-color" : "#2ecc71"
		});


	}else{

		$(".feedback").addClass("failure")
			.show()
			.animate({
				"opacity" : "1",
				"bottom" : "-80px"
			}, 400);

		$(".submit").css({
			"background" : "#cc1d1c",
			"border-color" : "#cc1d1c"
		});

		$("input").css({
			"border-color" : "#cc1d1c"
		});

	}

}