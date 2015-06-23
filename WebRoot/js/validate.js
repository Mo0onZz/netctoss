//身份证提取生日信息
function stringToDate(idcard,obj){
            	var str = $(idcard).val();
            	var year = str.substring(6,10);
            	var month = str.substring(10,12);
            	var day = str.substring(12,14);
            	var date = new Date(year,day,month);
            	var a = date2str(date,'yyyy-MM-dd');
            	$(obj).val(a);
            }
function date2str(x,y) {
    var z ={y:x.getFullYear(),M:x.getMonth()+1,d:x.getDate(),h:x.getHours(),m:x.getMinutes(),s:x.getSeconds()};
    return y.replace(/(y+|M+|d+|h+|m+|s+)/g,function(v) {return ((v.length>1?"0":"")+eval('z.'+v.slice(-1))).slice(-(v.length>2?v.length:2))});
}

//不能为空
$.fn.mustfill=function(msg,obj){
	var text = this.val();
	if(text==null||text.length==0){
		$(obj).text(msg);
		return false;
	}else{
		$(obj).text("");
		return true;
	}
};
//不能为特殊字符
$.fn.nameRange=function(msg,obj){
	var pattern = /^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$/ ; 
	if(pattern.test(this.val())){
		$(obj).text("");
		return true;
	}else{
		$(obj).text(msg);
		return false;
	}
}  
//验证长度
$.fn.lengthRange=function(min,max,msg,obj){
	var str1 = this.val();
	if(str1.length>=min&&str1.length<=max){
		$(obj).text("");
		return true;
	}else{
		$(obj).text(msg);
		return false;
	}
} 
//验证手机号码
$.fn.telephoneRange=function(msg,obj){
	var pattern = /^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/; 
	if(pattern.test(this.val())){
		$(obj).text("");
		return true;
	}else{
		$(obj).text(msg);
		return false;
	}
} 

//验证邮箱
$.fn.emailRange=function(msg,obj){
	var pattern =  /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	if(pattern.test(this.val())){
		$(obj).text("");
		return true;
	}else{
		$(obj).text(msg);
		return false;
	}
}    
//匹配两个字符串是否相同
function checkCode1(obj1,obj2,msg,obj){
	var code1 = $(obj1).val();
	var code2 = $(obj2).val();
	if(code1==code2){
		$(obj).text("");
		return true;
	}else{
		$(obj).text(msg);
		return false;
	}
}    

$.fn.mustfill2=function(msg){
	var text = this.val();
	alert($(this).attr('name'));
	
};
$.fn.nameExists=function(url,msg,obj){
	var name = this.attr('name');
	var value=this.val();
	var b = false;
	var obj1 = {};
	obj1[name]=value;
	var str = $.param(obj1);
	$.ajax({
		url:url,
		data:str,
		type:'post',
		dataType:'json',
		async:false,
		success:function(data){
		 if(data){
		 	b=true;
		 	$(obj).text("");
		 }else{
		 	$(obj).text(msg);
		 }
		}
	});
	return b;
};
$.fn.intRange=function(min,max,msg,obj){
	var str = this.val();
	var pattern = /^[0-9]\d*$/;
	var b = false;
	if(pattern.test(str)){
		var num = parseInt(str);
		if(num>=min&&num<=max){
			b=true;
		}
	}
	if(b){
		$(obj).text("");
		return true;
	}else{
		$(obj).text(msg);
		return false;
	}
}


$.fn.doubleRange=function(min,max,msg,obj){
	var str = this.val();
	var pattern = /^[0-9]\d*\.\d*|0\d*[1-9]\d*$/;
	var b = false;
	if(pattern.test(str)){
		var num = parseFloat(str);
		if(num>min&&num<max){
			b=true;
		}
	}
	if(b){
		$(obj).text("");
		return true;
	}else{
		$(obj).text(msg);
		return false;
	}
}
 
//根据路径和参数（json字符串） 返回boolean值
function simpleAjax(url,arguments){
	var b = false;
	var str = $.param(arguments);
	$.ajax({
		url:url,
		data:str,
		type:'post',
		dataType:'json',
		async:false,
		success:function(data){
		 if(data){
		 	b=true;
		 }
		}
	});
	return b;
};
$.fn.ipRange = function(msg,obj){
	alert('iprange');
	var pattern = /^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$/;
	if(pattern.test($(this).val())){
		$(obj).text("");
		return true;
	}else{
		$(obj).text(msg);
	}
	
}
function deleteData(url,arguments){
	var str = $.param(arguments);
	var ok = false;
	$.ajax({
		url:url,
		data:str,
		dataType:'json',
		async:false,
		success:function(data){
			if(data){
				ok = true; 
			}
		}
		
	});
	return ok;
}
$.fn.selectLowRange=function(msg,obj){
	var b = false;
	$(this).each(function(){
		if($(this).attr('checked')==true){
			b = true;
		}
	});
	if(b){
		$(obj).text("");
	}else{
		$(obj).text(msg);
	}
	return b;
}
  
$.fn.checkboxRange=function(msg,obj){
	var b = false;
	$(this).each(function(){
		if($(this).attr('checked')==true){
			b = true;
		}
	});	
	if(b){
		$(obj).text("");
	}else{
		$(obj).text(msg);
	}
	return b;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

