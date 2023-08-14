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

function play_audio(url) {
  new Audio(url).play();
}

function upd_scr(val) {
  
  play_audio('./media/btn_beep.m4a');

  var screen = document.getElementById("screen");
  screenText = screen.innerHTML;

  if (val === -1) {
    screen.innerHTML = "";
  } else {
    if (screenText.length < 4){
      newText = screenText + val;
      screen.innerHTML = newText;
    }
  }

  screen = document.getElementById("screen");
  screenText = screen.innerHTML;

  if (screenText.length == 4) {
    document.getElementById("orangeLight").disabled = false;
  } else {
    document.getElementById("orangeLight").disabled = true;
  }
  
}

function hint() {
  alert("Here's a hint in the form of a riddle:\n\n\"A day that's all about me, that's clear\nWith joy and celebration, comes once a year.\"");

  var msg = document.getElementById("msg");
  msgText = msg.innerHTML;

  msgText.innerHTML = "";
}

function verify() {
  var screen = document.getElementById("screen");
  screenText = screen.innerHTML;

  var msg = document.getElementById("msg");
  msgText = msg.innerHTML;

  if (screenText === "0418") {
    play_audio('./media/yay_kids.m4a');

    msg.innerHTML = "Congratulations! That is the correct code. Click the green button below to continue.\n";
    msg.style.color = "#32a852";

    document.getElementById("greenLight").disabled = false;
    document.getElementById("blueLight").disabled = true;
    document.getElementById("orangeLight").disabled = true;
    screen.innerHTML = "";
  } else {
    play_audio('./media/wrong_beep.m4a');

    msg.innerHTML = "That code is incorrect. Please try again.\n";
    msg.style.color = "#bc2405";
    screen.innerHTML = "";
  }
}