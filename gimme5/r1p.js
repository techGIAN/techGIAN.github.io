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
    // load_stargame();
}

function showPage() {
  document.getElementById("loader").style.display = "none";
  document.getElementById("myDiv").style.display = "block";
}

function shuffle(array) {
  let currentIndex = array.length,  randomIndex;

  // While there remain elements to shuffle.
  while (currentIndex != 0) {

    // Pick a remaining element.
    randomIndex = Math.floor(Math.random() * currentIndex);
    currentIndex--;

    // And swap it with the current element.
    [array[currentIndex], array[randomIndex]] = [
      array[randomIndex], array[currentIndex]];
  }

  var j = 0;
  for (var i = 0; i < 16; i++){
    if(array[i] === "star") {
      star_locs[j] = i+1;
      j += 1;
    }
  }

  return array;
}

function rand_zero_one() {
  var rnd = Math.random();
  if (rnd < 0.5){
    return -1;
  } else {
    return 1;
  }
}


var audio;
function play_audio(url, sound_made) {
  if (sound_made == "tick") {
    audio = new Audio(url);
    audio.play();
  } else{
    new Audio(url).play();
  }
}

function play_audio_vol(url, vol){
  var audio = new Audio(url);
  audio.volume = vol;
  audio.play();
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


var stars_found;
var shuffled_icons;
var star_locs;
var in_count_mode;

function load_stargame() {
  var icons = ['star', 'star', 'flip', 'flip', 'flip', 'flip', 'skull', 'zero',
              'img1', 'img2', 'img3', 'img4', 'img5', 'img6', 'img7', 'img8'];
  
  stars_found = 0;
  star_locs = [-1,-1];

  shuffled_icons = shuffle(icons);

  in_count_mode = false;

  set_cards();
        
}

function set_cards() {

  for (var i = 0; i < 16; i++){
    var num = i+1;
    var pic = document.getElementById("p" + num);
    var img_url = "./img/" + shuffled_icons[i] + ".png";
    pic.src = img_url;
  }
}

function close_card(index) {

  var q = document.getElementById("q" + index);
  q.style.display = "inline";

  var pic = document.getElementById("p" + index);
  pic.style.visibility = "hidden";

  var bg = document.getElementById("c" + index);
  bg.style.backgroundColor = "#eb34b1";
  // bg.onclick = "reveal(" + index + ")";
  bg.setAttribute("onclick", "reveal(" + index + ")")
  // bg.addEventListener("click", reveal(index));
  // bg.onclick = reveal(index);
}

function reveal(val) {

  if(in_count_mode) {
    return;
  }


  play_audio('./media/card_flip.m4a');

  var q = document.getElementById("q" + val);
  q.style.display = "none";

  var pic = document.getElementById("p" + val);
  pic.style.visibility = "visible";


  var bg = document.getElementById("c" + val);
  // bg.style.backgroundColor = "#32a852";
  bg.style.backgroundColor = "#bc2405";
  bg.onclick = null;

  var msg_line = document.getElementById("msg");
  if (pic.src.includes("star")) {
    bg.style.backgroundColor = "#32a852";
    msg_line.style.color = "#32a852";
    if (stars_found == 0) {
      
      play_sound_with_delay('./media/correct.m4a', 0);
      msg_line.innerHTML = "You found one of the stars! Only one left.";
      stars_found += 1;

    } else {
      play_sound_vol_with_delay('./media/yay_kids.m4a', 0, 1.0);
      msg_line.innerHTML = "Congratulations. You found two of the stars! Now click on the NEXT button below.";

      document.getElementById("greenLight").disabled = false;
      in_count_mode = true;
    }
  } else if (pic.src.includes("zero")) {

    play_sound_with_delay('./media/woof.m4a', 0);
    msg_line.style.color = "#0593ff";
    if (stars_found == 0) {
      var star_loc = get_location_given_index(star_locs[0]);
      msg_line.innerHTML = "Your guardian angel wants to give a hint! One of the stars is IN row " + star_loc[0] + " and column " + star_loc[1] + ".";
    } else {
      var index_to_consider = star_locs[0];
      if (check_if_opened(index_to_consider)) {
        index_to_consider = star_locs[1];
      }
      var star_loc = get_location_given_index(index_to_consider);
      var near_location = near_loc(star_loc[0], star_loc[1]);
      // msg_line.innerHTML = "Your guardian angel wants to give a hint! The star you're looking for is near: ...";
      msg_line.innerHTML = "Your guardian angel wants to give a hint! The other star is NEAR row " + near_location[0] + " and column " + near_location[1] + ".";
    }
  } else if (pic.src.includes("flip")) {

    play_sound_with_delay('./media/oh_no.m4a', 0);
    bg.style.backgroundColor = "#eda61a";
    msg_line.style.color = "#eda61a";
    msg_line.innerHTML = "REWIND: All cards will flip over in 5 seconds.";
    countdown(4);
  } else if (pic.src.includes("skull")) {
    
    play_sound_with_delay('./media/game_over.m4a', 0);
    msg_line.style.color = "#bc2405";
    msg_line.innerHTML = "GAME OVER: The page will be reset in 9 seconds. Please try again.";
    countdown_gameover(8);

  }
  
  else {
    msg_line.style.color = "white";
  }
}

function play_sound_vol_with_delay(audio, time, vol) {
  var timeleft = time;
  var downloadTimer = setInterval(function(){
    if(timeleft <= 0){
      clearInterval(downloadTimer);
      play_audio_vol(audio, vol);
    } 
    timeleft -= 1;
  }, 1000);
}

function play_sound_with_delay(audio, time) {
  var timeleft = time;
  var downloadTimer = setInterval(function(){
    if(timeleft <= 0){
      clearInterval(downloadTimer);
      play_audio(audio);
    } 
    timeleft -= 1;
  }, 1000);
}

function check_if_opened(index) {
  var pic = document.getElementById("p" + index);
  if (pic.style.visibility == "visible"){
    return true;
  } else{
    return false;
  }
}

function get_location_given_index(index) {
  var row = Math.floor((index-1)/4)+1;
  var col = index % 4;
  if (col == 0){
    col = 4;
  }
  return [row, col];
}

function near_loc(row, col) {
  var row_new = row + rand_zero_one();
  var col_new = col + rand_zero_one();

  if (row_new > 4) {
    row_new = 4;
  } else if (row_new < 1) {
    row_new = 1;
  }

  if (col_new > 4) {
    col_new = 4;
  } else if (col_new < 1) {
    col_new = 1;
  }

  return [row_new, col_new];
}

// function countdown(ct) {
//   in_count_mode = true;
//   var timeleft = ct;
//   var downloadTimer = setInterval(function(){
//     if(timeleft <= 0){
//       clearInterval(downloadTimer);
//       document.getElementById("msg").style.color = "white";
//       document.getElementById("msg").innerHTML = "Message";
//       in_count_mode = false;

//       for (var i = 0; i < 16; i++) {
//         close_card(i+1);
//       }
//       stars_found = 0;
//     } else if (timeleft == 1) {
//       document.getElementById("msg").innerHTML = "REWIND: All cards will flip over in " + timeleft + " second.";
//     } else {
//       document.getElementById("msg").innerHTML = "REWIND: All cards will flip over in " + timeleft + " seconds.";
//     }
//     timeleft -= 1;
//   }, 1000);
// }

function countdown_gameover(ct) {
  in_count_mode = true;
  var timeleft = ct;
  var downloadTimer = setInterval(function(){
    if(timeleft <= 0){
      clearInterval(downloadTimer);
      document.getElementById("msg").style.color = "white";
      document.getElementById("msg").innerHTML = "Message";
      in_count_mode = false;

      // for (var i = 0; i < 16; i++) {
      //   close_card(i+1);
      // }
      stars_found = 0;
      location.reload();
    } else if (timeleft == 1) {
      document.getElementById("msg").innerHTML = "GAME OVER: The page will be reset in " + timeleft + " second. Please try again.";
    } else {
      document.getElementById("msg").innerHTML = "GAME OVER: The page will be reset in " + timeleft + " seconds. Please try again.";
    }
    timeleft -= 1;
  }, 1000);
}





// =======
function toggleButton(index) {
  const buttons = document.querySelectorAll('.button');

  buttons.forEach((button, i) => {
    if (i === index) {
      button.classList.add('active');
      button.classList.remove('inactive');
    } else {
      button.classList.add('inactive');
      button.classList.remove('active');
    }
  });
}

// let countdown = 45.0;
// const timerElement = document.getElementById('timer');

// function updateTimer() {
//   countdown -= 0.01;
//   timerElement.textContent = countdown.toFixed(2);

//   if (countdown <= 0) {
//     clearInterval(timerInterval);
//     timerElement.textContent = 'Countdown complete';
//   }
// }

// const timerInterval = setInterval(updateTimer, 10);

var timeleft = 45;

var questions = [
  "(E) Mga uri ng soup",
  "(E) Mga pagkain na kadalasang mahahanap sa menu ng isang Chinese restaurant",
  "(E) Mga cakes",
  "(EAT) Mga inumin na masarap kapag malamig ang panahon",
  "(T) Mga pagkaing nagsisimula sa letter ‘G’"
];

var answers = [
  ["Mushroom", "Miso", "Pumpkin", "Crab and Corn", "Tomato"],
  ["General Tao Chicken", "Sweet and Sour Pork", "Honey Lemon Fish", "Chinese Broccoli", "Mapo Tofu"],
  ["Carrot Cake", "Fruit Cake", "Cheesecake", "Cupcake", "Wedding Cake"],
  ["Tsaa", "Kape", "Hot Chocolate", "Warm Water", "Apple Cider"],
  ["Guyabano", "Gulaman", "Galunggong", "Ginataang Mais", "Gabi"]
];





var rnd_ix = -1;
function start_game() {
  countdown(45);
  var q_div = document.getElementById('question_div');
  q_div.style.color = 'black';

  rnd_idx = Math.floor(Math.random()*5);
  q_div.innerHTML = questions[rnd_idx].toUpperCase();


}

function reset_game() {
  for (var i = 1; i <6; i++) {
    document.getElementById("w" + i).innerHTML = i;
    document.getElementById("w" + i).style.borderColor = "#523348";
    document.getElementById("w" + i).style.fontSize = "50px";
  }
  document.getElementById('question_div').innerHTML = "";
  clearInterval(downloadTimer);
  audio.pause();
  document.getElementById('timer').innerHTML = "00:45:00";
  document.getElementById('stats').innerHTML = "Score: ";
}
var score = 0;

function show_word(a_id) {
  var word_div = document.getElementById("w" + a_id);
  var word_to_reveal = answers[rnd_idx][a_id-1].toUpperCase();
  word_div.innerHTML = word_to_reveal;
  word_div.style.fontSize = "40px";

  if (timeleft > 0) {
    word_div.style.borderColor = "#32a852";
    play_audio('./media/correct.m4a', "correct");
    score += 1;

    if (score == 1) {
      first_word_time = "00:" + (45 - timeleft).toFixed(2);
      if (45 - timeleft < 10) {
        first_word_time = "00:0" + (45 - timeleft).toFixed(2);
      }
    }

    document.getElementById('stats').innerHTML = "Score: " + score + ", First Word: " + first_word_time;
  } else {
    word_div.style.borderColor = "#c71035";
  }

}

function play_wrong() {
  play_audio("./media/wrong_beep.m4a", "wrong");
}


var first_word_time = "00:00:00";
var downloadTimer;
var tick_stops = ["00:45.00", "00:33.87", "00:22.74", "00:11.61"];
function countdown(ct) {
  in_count_mode = true;
  timeleft = ct;
  downloadTimer = setInterval(function(){

    if(timeleft <= 0.01){
      clearInterval(downloadTimer);
      document.getElementById('timer').innerHTML = "00:00:00";
    }
    if (score == 5) {
      clearInterval(downloadTimer);
      audio.pause();
    } 
    var t_left = "" + timeleft.toFixed(2);
    if (timeleft < 10) {
      t_left = "0" + t_left;
    }
    document.getElementById('timer').innerHTML = "00:" + t_left;
    
    if (tick_stops.includes(document.getElementById('timer').innerHTML)) {
      play_audio('./media/ticking.m4a', "tick");
    }
    // play_audio('./media/ticking.m4a');

    timeleft -= 0.01;
  }, 10);
}