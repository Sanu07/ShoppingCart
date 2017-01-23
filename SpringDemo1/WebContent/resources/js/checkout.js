var cart = JSON.parse(localStorage.getItem("shoppingCart")); // loading the
																// local storage
$(function() {
	showCartElements();
	updateShippingPrice();
	$(".shopper-info *").attr("disabled", true).off('click');
	$("#paymentTypeSpan").hide();
	$('#paypalOption').click(function() {
		$(".shopper-info *").attr("disabled", false);
		$(".bill-to *").attr("disabled", true);
		$("#paymentTypeSpan").show();
	})
	$('#byCash').click(function() {
		$(".bill-to *").attr("disabled", false);
		$(".shopper-info *").attr("disabled", true);
		$("#paymentTypeSpan").hide();
	})
});
/**
 * to update the shipping and cart prices
 */
function updateShippingPrice() {
	var $totalQuantity = parseInt(0); // to get the number of quantities
	var $cartSubtotal = parseInt(0); // to get the total price customer has
										// to pay
	var $cartTotal = parseInt(0); // to get the total value that the customer
									// has to pay
	for ( var i in cart) {
		$cartSubtotal = $cartSubtotal
				+ parseInt(parseInt(cart[i].count) * parseInt(cart[i].price)*.9); // adding
																				// price
		$totalQuantity = $totalQuantity + parseInt(cart[i].count); // adding
																	// the
																	// quantity
		// console.log(cart[i].name);
	}
	var $shippingCost;
	if (parseInt($cartSubtotal) < 1500) { // check shipping cost
		$shippingCost = parseInt(30);
		$cartTotal = $cartSubtotal + $shippingCost;
	} else {
		$shippingCost = 'Free';
		$cartTotal = $cartSubtotal;
	}

	$('#cartSubTotal').text($cartSubtotal);
	$('#totalQuantity').text($totalQuantity);
	$('#shippingCost').text($shippingCost);
	$('#totalCost').text($cartTotal);
}

/**
 * To show the cart elements
 */
function showCartElements() {
	$('.cart_info tbody:first').empty();
	for ( var i in cart) {
		$('.cart_info tbody:first')
				.append(
						'<tr><td class="cart_product"><a><img src="'
								+ cart[i].path
								+ '" alt="" style="width: 183.63px;height: 162.33px"/></a></td><td class="cart_description"><h4><a>'
								+ cart[i].name
								+ '</a></h4> <p>'
								+ 'discount 10 %'
								+ '</p></td><td class="cart_price"><p>'
								+ cart[i].price
								+ '</p></td><td class="cart_quantity"><div class="cart_quantity_button">'
								+ '<input class="cart_quantity_input" type="number" name="quantity" min="1" value="'
								+ cart[i].count
								+ '" autocomplete="off" disabled="true"/>'
								+ '</div></td><td class="cart_total"><p class="cart_total_price">'
								+ parseInt(parseInt(cart[i].price)
										* parseInt(cart[i].count) * .9)
								+ '</p></td></tr>');
	}
}
