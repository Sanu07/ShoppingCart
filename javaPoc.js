*********************************************************
/* Auto Populate a drop down from another drop down*/
*********************************************************
//JSP
<div class="mainDiv" style="margin-left: 50px">
		<select class="dropDown">
			<option selected="selected">Select Item</option>
			<option value="item">ITEM</option>
			<option value="car">CAR</option>
			<option value="bike">BIKE</option>
			<option value="dress">DRESS</option>
		</select>
	</div>
	<div class="subDiv" style="margin-left: 180px">
		<select class="subDropDown"></select>
	</div>

	//JS
	$(function() {
	$('select').each(function() {
		$(this).val($(this).find("option[selected=selected]").val());
	});
	$('.dropDown').change(
			function(e) {
				// alert("working");
				var selectedText = $(".dropDown").children("option").filter(
						":selected").text();
				var selectedVal = $(".dropDown").children("option").filter(
						":selected").val();
				// alert(selectedText);
				// alert(selectedVal);
				$.ajax({
					url : "MainController",
					type : "GET",
					datatype : "json",
					data : {
						item : selectedText
					},
					success : function(data) {
						$('.subDropDown').empty();
						$.each(data, function(index, item) {
							// alert("ajax working");
							// alert('count starts '+item);
							$('.subDropDown').append(
									'<option>' + item + '</option>')
						})

					}
				})

			})
});
	//MainController
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	String selectedItem=request.getParameter("item");
		System.out.println(selectedItem);
		List<String> list=new ArrayList<String>();
		
		if(selectedItem.equalsIgnoreCase("DRESS")){
			list.add("Dress 1");
			list.add("Dress 2");
		}
		if(selectedItem.equalsIgnoreCase("BIKE")){
			list.add("Bike 1");
			list.add("Bike 2");
		}
		if(selectedItem.equalsIgnoreCase("ITEM")){
			list.add("Item 1");
			list.add("Item 2");
		}
		if(selectedItem.equalsIgnoreCase("CAR")){
			list.add("Car 1");
			list.add("Car 2");
		}
		
		PrintWriter out=response.getWriter();
		String json=new Gson().toJson(list);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.println(json);}
		-----------------------------------------------------------