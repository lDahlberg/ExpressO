angular.module("expressOApp").factory("idService", function(){
	var id = -1;
	
	//service to set ids
	return{
		setId: function(idChange){
			id = idChange;
		},
		getId: function(){
			return id;
		}
	};
})