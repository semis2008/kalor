function getStringLimit(Str,Limit) {
	var returnValue = ''; 
	var byteValLen = 0; 
	for (var i = 0; i < Str.length; i++) { 
    	if (Str.substr(i , 1).match(/[^\x00-\xff]/ig) != null){ 
    		byteValLen += 2; 
    	}else{ 
    		byteValLen += 1;
    	} 
    	if (byteValLen > Limit){
    		returnValue += "...";
    		break; 
    	}	
    	returnValue += Str.substr(i , 1); 
	} 
	return returnValue; 
} 