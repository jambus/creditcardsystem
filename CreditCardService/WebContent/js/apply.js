function checkform(){
	var flag = false;
	
	if(checkCustomType() && checkCustomType() == "E"){
		if(checkidNumber()){
			flag = true;
		}
	}else{
		if(checkFullName() && checkidNumber() && checkbirth() && checksalary() && checkaddress() && checktel() && checkmail() && checkagree()){
			flag = true;
		}
	}
	return flag;
}

function checkCustomType(){
	var cutomType = document.getElementById('customType');
	cutomType = cutomType.value;
	if(cutomType != null && cutomType != ""){
		document.getElementById("nullcustomType").style.display = "none";
	}else{
		document.getElementById("nullcustomType").style.display = "block";
	}
	return cutomType;
}

function checkFullName(){
	var flag = false;
	var firstname = document.getElementById('firstname');
	var lastname = document.getElementById('lastname');

	if(firstname != null && firstname.value != "" && lastname != null && lastname.value){
		document.getElementById("nullfullname").style.display = "none";
		flag = true;
	}else{
		document.getElementById("nullfullname").style.display = "block";
	}
	return flag;
}
function checkidNumber(){
	var flag = false;
	var salary = document.getElementById('idNumber');
	idNumber = idNumber.value;
	if(idNumber != null && idNumber != ""){
		document.getElementById("nullidNubmer").style.display = "none";
		flag = true;
	}else{
		document.getElementById("nullidNubmer").style.display = "block";
	}
	return flag;
}
function checkbirth(){
	var flag = false;
	var birthday = document.getElementById('birthday');
	birth = birthday.value;
	if(birth != null && birth != ""){
		document.getElementById("nullbirth").style.display = "none";
		flag = true;
	}else{
		document.getElementById("nullbirth").style.display = "block";
	}
	return flag;
}
function checksalary(){
	var flag = false;
	var salary = document.getElementById('salary');
	sal = salary.value;
	if(sal != null && sal != ""){
		document.getElementById("nullsalary").style.display = "none";
		flag = true;
	}else{
		document.getElementById("nullsalary").style.display = "block";
	}
	return flag;
}
function checkaddress(){
	var flag = false;
	var salary = document.getElementById('address');
	add = address.value;
	if(add != null && add != ""){
		document.getElementById("nulladdress").style.display = "none";
		flag = true;
	}else{
		document.getElementById("nulladdress").style.display = "block";
	}
	return flag;
}
function checktel(){
	var flag = false;
	var tell = document.getElementById('tell');
	tel = tell.value;
	if(tel != null && tel != ""){
		document.getElementById("nulltel").style.display = "none";
		flag = true;
	}else{
		document.getElementById("nulltel").style.display = "block";
	}
	return flag;
}
function checkmail(){
	var flag = false;
	var mail = document.getElementById('mail');
	mail0 = mail.value;
	if(mail0 != null && mail0 != ""){
		document.getElementById("nullmail").style.display = "none";
		flag = true;
	}else{
		document.getElementById("nullmail").style.display = "block";
	}
	return flag;
}
function checkagree(){
	var flag = false;
	var agree = document.getElementById('agree');
	if(!agree.checked){
		document.getElementById("nullagree").style.display = "block";
	}else{
		flag = true;
	}
	return flag;
}

function switchType(){
	var cutomType = document.getElementById('customType');
	cutomType = cutomType.value;
	
	if(cutomType != null && cutomType != ""){
		if(cutomType == "N"){
			$("#applyTable").find("tr").each(function(){
				$(this).show();
			});
		}else if(cutomType == "E"){
			$("#applyTable").find("tr").each(function(){
				$(this).hide();
			});
			$("#idNumberTr").show();
			$("#customTypeTr").show();
			$("#submitTr").show();	
		}
	}
}