// https://www.memrise.com/course/51903/liste-de-vocabulaire-anglais-toeic/19/

var english = jQuery(".col_a");
var french = jQuery(".col_b");
var newDiv = document.createElement("div");

var tab = [];

if(english.length == french.length){
	for(var i = 0; i < english.length; i++) {
		tab.push(english[i].textContent + ";" + french[i].textContent);
	}
}

for(var i = 0; i < tab.length; i++){
	var newP = document.createElement("span");
	newP.appendChild(document.createTextNode(tab[i]));
	newP.appendChild(document.createElement("br"));
	newDiv.appendChild(newP);
}

var currentDiv = document.getElementById(".progress-box");

document.body.insertBefore(newDiv, currentDiv);