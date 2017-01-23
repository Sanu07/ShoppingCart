$(function() {
	$('select[name="country"]').change(
			function(e) {
				var value = $('option:selected', $(this)).text();
				$.ajax({
					url : "/SpringDemo1/PopulateDropdownSevlet",
					type : "GET",
					datatype : "json",
					data : {
						item : value,
						itemType : "country"
					},
					success : function(data) {
						$('#state').empty();
						$('#state').append(
								'<option value="NULL_VALUE">' + "Please Select State" + '</option>');
						$.each(data, function(index, item) {
							$('#state').append(
									'<option value="'+item+'">' + item + '</option>')
						});

					}
				});

			});
	$('select[name="state"]').change(
			function(e) {
				var value = $('option:selected', $(this)).text();
				
				$.ajax({
					url : "/SpringDemo1/PopulateDropdownSevlet",
					type : "GET",
					datatype : "json",
					data : {
						item : value,
						itemType : "state"
					},
					success : function(data) {
						$('#city').empty();
						$('#city').append(
								'<option value="NULL_VALUE">' + "Please Select City" + '</option>');
						$.each(data, function(index, item) {
							$('#city').append(
									'<option value="'+item+'">' + item + '</option>')
						});

					}
				});

			});
	$('select[name="city"]').change(
			function(e) {
				var value = $('option:selected', $(this)).text();
				var typeSelected=$('select').attr(name);
				$.ajax({
					url : "/SpringDemo1/PopulateDropdownSevlet",
					type : "GET",
					datatype : "json",
					data : {
						item : value,
						itemType :"city"
					},
					success : function(data) {
						$('#zip').empty();
						$('#zip').append(
								'<option value="NULL_VALUE">' + "Please Select ZipCode" + '</option>');
						$.each(data, function(index, item) {
							$('#zip').append(
									'<option value="'+item+'">' + item + '</option>')
						});

					}
				});

			});
});