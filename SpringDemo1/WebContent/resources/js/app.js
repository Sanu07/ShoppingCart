
/**
 * Handling the cart.Declaration,Initialization and Definition of the cart and its related methods
 */

$(function() {
	/**
	 * details of the image
	 */
//	$('.add-to-cart').click(function(e) {
//		var $imagePath=$(this).closest('div').find('img').attr('src');
//		var $imagePrice=$(this).closest('div').find('h2').text();
//		var $imageName=$(this).closest('div').find('p').text();
//		//alert($imagePrice);
//	});
	
	/**
	 * add item to cart
	 */
		var cart=[];
		var Item=function(path,name,price,count){
			this.path=path;
			this.name=name;
			this.price=price;
			this.count=count;
		};
		$('.add-to-cart').click(function(e) {
			var $imagePath=$(this).closest('div').find('img').attr('src');
			var $imagePrice=$(this).closest('div').find('h2').text();
			var $imageName=$(this).closest('div').find('p').text();
			var $count=1;
		function addItemToCart(path,name,price,count) {
		//	alert(cart.length);
			for(var i in cart){
				if(cart[i].name === name){
					cart[i].count=parseInt(cart[i].count)+parseInt(count);
					saveCart();
					updateCartTotal();
					return;
				}
			}
			if(cart==null){
				cart=new Array();
				var item=new Item(path,name,price,count);
				cart.push(item);	
			}else{
				var item=new Item(path,name,price,count);
				cart.push(item);		
			}
			
		}
		addItemToCart($imagePath,$imageName,$imagePrice,$count);
		saveCart();
		updateCartTotal();
		console.log(cart);
	});
		/**
		 * remove cart item and reduce count value
		 */
		function removeItemFromCart(name){
			for(var i in cart){
				if(cart[i].name===name){
					cart[i].count--;
					break;
					if(cart[i].count===0){
						cart.splice(i,1);
					}
				}
			}
		}
		
		/**
		 * remove all items from cart with a specific name
		 */
		function removeItemsFromCartAll(name){
			for(var i in cart){
				if(cart[i].name === name){
				cart.splice(i,1);
				break;
				}
			}
		}
	
		/**
		 * total count of items in the cart
		 */
		function countTotalItemsInCart(){
			var total=0;
			for(var i in cart){
				total=total+parseInt(cart[i].count);
			}
			return total;
		}
		/**
		 * list array
		 */
		function listCart(){
			var cartCopy=[];
			for(var i in cart){
				var item= cart[i];
				var itemCopy={};
				for(var p in item){
					itemCopy[p]=item[p];
				}
				cartCopy.push(itemCopy);
			}
			return cart.slice();
		}
		/**
		 * save cart to local storage
		 */
		function saveCart(){
			localStorage.setItem("shoppingCart", JSON.stringify(cart));
		}
		/**
		 * load shopping cart
		 */
		function loadCart(){
			cart=JSON.parse(localStorage.getItem("shoppingCart"));
			return cart;
		}
		/**
		 * display cart items
		 */
		function displayCart() {
			var cartArray=listCart();
			console.log(cartArray);
		}
		/**
		 * check display cart items
		 */
		$(function() {
			var cart=loadCart();
			$('.cart_info tbody').empty();
			for(var i in cart){
				$('.cart_info tbody').append('<tr><td class="cart_product"><a><img src="'
						+ cart[i].path +
						'" alt="" style="width: 183.63px;height: 162.33px"/></a></td><td class="cart_description"><h4><a>'
						+ cart[i].name + 
						'</a></h4> <p>' + 'discount 10 %' + '</p></td><td class="cart_price"><p>'
						+ cart[i].price +
						'</p></td><td class="cart_quantity"><div class="cart_quantity_button">'+
						'<input class="cart_quantity_input" type="number" name="quantity" min="1" value="' + cart[i].count + '" autocomplete="off" size="2"/>'+
						'</div></td><td class="cart_total"><p class="cart_total_price">' 
						+ parseInt(parseInt(cart[i].price)*parseInt(cart[i].count)*.9)  + 
						'</p></td><td class="cart_delete"><a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a></td></tr>');
			}
		});
			/**
			 * display total number of items in the cart 
			 */
			function updateCartTotal() {
				var totalItemsInCart=countTotalItemsInCart();
				$('#totalItemsInCart').empty();
				$('#totalItemsInCart').append(totalItemsInCart);
		};
		/**
		 * Update the cart on page load
		 */
		$(function() {
			updateCartTotal();
		});
		
		/**
		 * on clicking cross button delete item from cart
		 */
		$(function() {
			$('.cart_quantity_delete').click(function(event) {
				event.preventDefault();
				var $imageName=$(this).closest('tr').find('.cart_description a').text();
				 var item = $(this).closest('tr').remove();
				removeItemFromCart($imageName);
				for(var i in cart){
					if($imageName===cart[i].name){
						    cart.splice(i, 1);
					}
				}
				for(var i in cart){
					console.log(cart[i]);
				}
				updateCartTotal();
				saveCart();
				countTotalItemsInCart();
				//alert(localStorage.getItem("shoppingCart"));
				
			})
		})

/**
 * Cart price Controller
 */
	 //$('tbody').on('change', 'input[type=number]', function(){
	/*$('input[type=number]').change(function(e) {
		var $qty=$(this).val();
		var $cartPrice=$(this).closest('tr').find('.cart_price p').text();
		var $cartPrice=parseInt($qty)*parseInt($cartPrice);
		var $text=$(this).closest('tr').find('.cart_total p').text();
		$(this).closest('tr').find('.cart_total p').empty();
		$(this).closest('tr').find('.cart_total p').append($cartPrice);
	});*/
$('tbody').on('change', 'input[type=number]', function(){
	var $qty=$(this).val();
	var $cartPrice=$(this).closest('tr').find('.cart_price p').text();
	var $cartPrice=parseInt(parseInt($qty)*parseInt($cartPrice)*.9);
	var $text=$(this).closest('tr').find('.cart_total p').text();
	$(this).closest('tr').find('.cart_total p').empty();
	$(this).closest('tr').find('.cart_total p').append($cartPrice);
	var $productName=$(this).closest('tr').find('h4').text();
	for(var i in cart){
		if(cart[i].name==$productName){
			cart[i].count=$qty;
		}
	}
	console.log(cart);
	updateCartTotal();
	saveCart();
	updateShippingPrice();
})
});

/*
 * ---------------------------------------------------------------
 */

/**
 * handling cart.jsp  
*/

$(function() {
	updateShippingPrice();
});
/**
 * to update the shipping and cart prices
 */
function updateShippingPrice(){
	var cart=JSON.parse(localStorage.getItem("shoppingCart"));	//loading the local storage
	var $totalQuantity=parseInt(0);		//to get the number of quantities
	var $cartSubtotal=parseInt(0);		//to get the total price customer has to pay
	var $cartTotal=parseInt(0);			//to get the total value that the customer has to pay 
	for(var i in cart){
		$cartSubtotal=$cartSubtotal+parseInt(parseInt(cart[i].count)*parseInt(cart[i].price)*.9);	//adding price
		$totalQuantity=$totalQuantity+parseInt(cart[i].count);	//adding the quantity
		//console.log(cart[i].name);
	}
	var $shippingCost;
	if(parseInt($cartSubtotal)<1500){	//check shipping cost
		$shippingCost=parseInt(30);
		$cartTotal=$cartSubtotal+$shippingCost;
	}else{
		$shippingCost='Free';
		$cartTotal=$cartSubtotal;
	}
	
	$('#cartSubTotal').text($cartSubtotal);
	$('#totalQuantity').text($totalQuantity);
	$('#shippingCost').text($shippingCost);
	$('#totalCost').text($cartTotal);
}
