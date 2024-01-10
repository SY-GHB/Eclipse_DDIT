/**
 * 
 */

function fprint(){
	//id=id인 요소를 접근, 값을 가져온다
	var idvalue = document.getElementById('id').value;
	
	//처리하고 
	str = "당신이 입력한 ID는: " + idvalue + "입니다.";
	
	//출력
	document.querySelector('#result').innerText = str;
}