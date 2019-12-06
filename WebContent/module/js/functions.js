String.prototype.trim = function() {
	return this.replace(/^\s+|\s+$/g,"");
}
String.prototype.ltrim = function() {
	return this.replace(/^\s+/,"");
}
String.prototype.rtrim = function() {
	return this.replace(/\s+$/,"");
}

function trim(stringToTrim) {
	return stringToTrim.replace(/^\s+|\s+$/g,"");
}
function ltrim(stringToTrim) {
	return stringToTrim.replace(/^\s+/,"");
}
function rtrim(stringToTrim) {
	return stringToTrim.replace(/\s+$/,"");
}
function submitform(form,action) {
	//alert(form.name)
	form.action = action;
	form.submit(); 
} 
function txtChangeUpperCase(objeto){
	objeto.value = objeto.value.toUpperCase();
}

function Enter(){
	if (window.event.keyCode==13){
		document.getElementById("txtPassword").focus();
	}
}

function validaDatos(){
	if(document.forms.frmUsuario.txtUsuario.value=="" ||document.forms.frmUsuario.passwd.value=="")
		return false
	else 
		return true;
}

function checaRuta(ruta){
	var iframe = document.getElementById('iframeRuta');
	iframe.src = ruta
}
