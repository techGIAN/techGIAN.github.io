$(document).ready(function(){
  $('body').scrollspy({target: ".navbar", offset: 50});   
  $("#navbar a").on('click', function(event) {
    if (this.hash !== "") {
      event.preventDefault();
      var hash = this.hash;
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 800, function(){
        window.location.hash = hash;
      });
    }  // End if
  });
  $("#home a").on('click', function(event) {
    if (this.hash !== "") {
      event.preventDefault();
      var hash = this.hash;
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 800, function(){
        window.location.hash = hash;
      });
    }  // End if
  });
});

/* ---- nav smooth scroll ---- */
$(document).ready(function() {
    $('.scroll-link').on('click', function(event){
        event.preventDefault();
        var sectionID = $(this).attr("data-id");
        scrollToID('#' + sectionID, 750);
    });
    $('.scroll-top').on('click', function(event) {
        event.preventDefault();
        $('html, body').animate({scrollTop:0}, 1200);       
    });
});

/* ---- navbar offset ---- */
function scrollToID(id, speed){
    var offSet = 69;
    window.alert(id);
    var targetOffset = $(id).offset().top - offSet;
    $('html,body').animate({scrollTop:targetOffset}, speed);
}
var myVar;

function onload() {
    myVar = setTimeout(showPage, 1500);
    load_date();
}

function showPage() {
  document.getElementById("loader").style.display = "none";
  document.getElementById("myDiv").style.display = "block";
}

function load_date() {
	var n = new Date(document.lastModified);

	var y = n.getFullYear();
	var m = n.getMonth() + 1;
	var d = n.getDate();

 	var months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun",
	        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];

    var extraZero = "0";
    if (parseInt(d) >= 10) {
        extraZero = "";
    }

    document.getElementById("myDate").innerHTML = months[m-1] + " " + extraZero + d + ", " + y;
}