var ChatApi = {
	axiosPost : function(url, jsonData, fn) {
		axios({
			method  : 'post'
		  , url     : url
		  , data    : jsonData
          , async   : true
		  , headers : {
				'Content-Type' : 'application/json',
				'dataType'     : 'json'
			}
		})
		.then((success) => {
			fn(success);
		})	
		.catch((error) => {
			console.log(error);
			fn(error);
		});
	},
}
