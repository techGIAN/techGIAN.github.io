function start()
{
  var now = document.getElementById("now");
  var today = new Date();
  now.innerHTML = "Last updated: " + today;
}

var toggleA = true;
var toggleB = false;
var toggleC = false;
function swap()
{
	var picture = document.getElementById("picture");
	
	if (toggleA) {
		picture.src = "for lab1.jpg";
		toggleA = false;
		toggleB = true;
	} else if (toggleB) {
		picture.src = "for lab1a.jpg";
		toggleB = false;
		toggleC = true;
	} else {
		picture.src = "for lab1b.jpg";
		toggleC = false;
		toggleA = true;
	}
}
