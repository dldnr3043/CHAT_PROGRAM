var ChatApi = {
	axiosPost : function(url, jsonData) {
		return axios({
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
			return success;
		})	
		.catch((error) => {
			return error;
		});
	},
}
