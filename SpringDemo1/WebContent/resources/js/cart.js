$(function() {
	$('#successAlert').hide();
	$('#errorAlert').hide();
	$('#applyCoupon').click(function(e) {
		e.preventDefault();
		var $couponValue=$('#coupon').val();
		if(!$couponValue==undefined || !$couponValue==0 || $couponValue.length>0){
			$.ajax({
				url : "applyingCoupon",
				type : "POST",
				datatype : "json",
				data : {
					couponId :$couponValue,
				},
				success : function(data) {
					if(data=="Not Valid"){
						$('#errorAlert').show();
						$('#successAlert').hide();
					}else{
						//var $totalCost=parseInt($('#totalCost').text());
						//var $presentCost=$totalCost-parseInt(data);
					//	$('#totalCost').text($presentCost);
						$(".total_area li #totalCost").css( 'color','green' );
						$('#couponAmount').empty();
						$('#couponAmount').append(data);
						$('#getTotalCost').empty();
						$('#getTotalCost').append($('#totalCost').text());
						$('#successAlert').show();
						$('#errorAlert').hide();
					}

				}
			});
		}else{
			$('#errorAlert').show();
			$('#successAlert').hide();
		}
	});
});
