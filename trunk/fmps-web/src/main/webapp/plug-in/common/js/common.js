/**
 * 微理赔校验session是否失效，转至登录页
 */
function toLoginPage(){
	//if(window.parent){
	//	window.parent.close();
	//}
	window.location.href = $("#webRoot").val() + "/loginController.do?login";
}