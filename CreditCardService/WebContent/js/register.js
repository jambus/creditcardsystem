function checkform(){
	var flag = false;
	if(checkname() && checkpass() && checkFullName() && checkbirth() && checkAccountNumber() && checkidNumber && checktel() && checkagree()){
		flag = true;
	}
	return flag;
}



function checkidNumber(){
	var flag = false;
	var userName = document.getElementById('idNumber');
	accountNumber = accountNumber.value;
	if(accountNumber != null && accountNumber != ""){
		document.getElementById("nullidNumber").style.display = "none";
		flag = true;
	}else{
		document.getElementById("nullidNumber").style.display = "block";
	}
	return flag;
}

function checkAccountNumber(){
	var flag = false;
	var userName = document.getElementById('accountNumber');
	accountNumber = accountNumber.value;
	if(accountNumber != null && accountNumber != ""){
		document.getElementById("nullaccountNumber").style.display = "none";
		flag = true;
	}else{
		document.getElementById("nullaccountNumber").style.display = "block";
	}
	return flag;
}

function checkname(){
	var flag = false;
	var userName = document.getElementById('userName');
	name = userName.value;
	if(name != null && name != ""){
		document.getElementById("nullname").style.display = "none";
		flag = true;
	}else{
		document.getElementById("nullname").style.display = "block";
	}
	return flag;
}
function checkpass(){
	var flag = false;
	var password0 = document.getElementById('password0');
	var password = document.getElementById('password');
	var p0 = password0.value;
	var p = password.value;
	if(p != null && p != ""){
		document.getElementById("nullpwd").style.display = "none";
		if(p0 != p){
			document.getElementById("errorpwd").style.display = "block";
		}else{
			document.getElementById("errorpwd").style.display = "none";
			flag = true;
		}
	}else{
		document.getElementById("nullpwd").style.display = "block";
	}
	return flag;
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