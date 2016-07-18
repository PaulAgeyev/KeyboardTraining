
var keyDown = 0;
var input_key = 0;

var TextBufSize;
var TextBuf = new Array();
var str_input = '',	str_color_start = '', str_color_end = '', str_color_err = '';
var text_db = "the old man and the sea is the story of";// a battle between an old, experienced cuban fisherman and a large marlin. the novel.";
var text;
var str;
var char_e;
var counter = -1

var fl = 0;
var key = 1;
var exit = 0;
var errors = 0;
var typed = 0;
var timer;

var SelectKey = 96;
var LightTrueKey, LightCounter = 0, LightFalseKey = 96;
var PressKey = -1;

var setKey = function (keyCode) {
	keyDown=keyCode;
}

var clearKey = function () {
	keyDown = 0;
}

var isKeyDown = function () {
	return keyDown;
}

var CodeKey = function () {
	if (input_key == 96 || input_key == 126) PressKey = 96;
	if (input_key == 49 || input_key == 33) PressKey = 49;
	if (input_key == 50 || input_key == 64) PressKey = 50;
	if (input_key == 51 || input_key == 35) PressKey = 51;
	if (input_key == 52 || input_key == 36) PressKey = 52;
	if (input_key == 53 || input_key == 37) PressKey = 53;
	if (input_key == 54 || input_key == 94) PressKey = 54;
	if (input_key == 55 || input_key == 38) PressKey = 55;
	if (input_key == 56 || input_key == 42) PressKey = 56;
	if (input_key == 57 || input_key == 40) PressKey = 57;
	if (input_key == 48 || input_key == 41) PressKey = 48;
	if (input_key == 45 || input_key == 95) PressKey = 45;
	if (input_key == 61 || input_key == 43) PressKey = 61;

	if (input_key == 113 || input_key == 81) PressKey = 113;
	if (input_key == 119 || input_key == 87) PressKey = 119;
	if (input_key == 101 || input_key == 69) PressKey = 101;
	if (input_key == 114 || input_key == 82) PressKey = 114;
	if (input_key == 116 || input_key == 84) PressKey = 116;
	if (input_key == 121 || input_key == 89) PressKey = 121;
	if (input_key == 117 || input_key == 85) PressKey = 117;
	if (input_key == 105 || input_key == 73) PressKey = 105;
	if (input_key == 111 || input_key == 79) PressKey = 111;
	if (input_key == 112 || input_key == 80) PressKey = 112;
	if (input_key == 91 || input_key == 123) PressKey = 91;
	if (input_key == 93 || input_key == 125) PressKey = 93;
	if (input_key == 92 || input_key == 124) PressKey = 92;

	if (input_key == 97 || input_key == 65) PressKey = 97;
	if (input_key == 115 || input_key == 83) PressKey = 115;
	if (input_key == 100 || input_key == 68) PressKey = 100;
	if (input_key == 102 || input_key == 70) PressKey = 102;
	if (input_key == 103 || input_key == 71) PressKey = 103;
	if (input_key == 104 || input_key == 72) PressKey = 104;
	if (input_key == 106 || input_key == 74) PressKey = 106;

	if (input_key == 107 || input_key == 73) PressKey = 107;
	if (input_key == 108 || input_key == 79) PressKey = 108;
	if (input_key == 59 || input_key == 80) PressKey = 59;
	if (input_key == 39 || input_key == 123) PressKey = 39;



	//return PressKey;
}

var CodeUpKey = function (input) {
	PressKey = -1;
	document.getElementById('key_shift_lft_long').style.backgroundColor = "#fff";
	switch (input) {
		case '~': PressKey = '`'; break;
		case '!': PressKey = '1'; break;
		case '@': PressKey = '2'; break;
		case '#': PressKey = '3'; break;
		case '$': PressKey = '4'; break;
		case '%': PressKey = '5'; break;
		case '^': PressKey = '6'; break;
		case '&': PressKey = '7'; break;
		case '*': PressKey = '8'; break;
		case '(': PressKey = '9'; break;
		case ')': PressKey = '0'; break;
		case '_': PressKey = '-'; break;
		case '+': PressKey = '='; break;

		case 'Q': PressKey = 'q'; break;
		case 'W': PressKey = 'w'; break;
		case 'E': PressKey = 'e'; break;
		case 'R': PressKey = 'r'; break;
		case 'T': PressKey = 't'; break;
		case 'Y': PressKey = 'y'; break;
		case 'U': PressKey = 'u'; break;
		case 'I': PressKey = 'i'; break;
		case 'O': PressKey = 'o'; break;
		case 'P': PressKey = 'p'; break;
		case '{': PressKey = '['; break;
		case '}': PressKey = ']'; break;
		case '|': PressKey = '\\'; break;

		case 'A': PressKey = 'a'; break;
		case 'S': PressKey = 's'; break;
		case 'D': PressKey = 'd'; break;
		case 'F': PressKey = 'f'; break;
		case 'G': PressKey = 'g'; break;
		case 'H': PressKey = 'h'; break;
		case 'J': PressKey = 'j'; break;
		case 'K': PressKey = 'k'; break;
		case 'L': PressKey = 'l'; break;
		case ':': PressKey = ';'; break;
		case '"': PressKey = '\''; break;

		case 'Z': PressKey = 'z'; break;
		case 'X': PressKey = 'x'; break;
		case 'C': PressKey = 'c'; break;
		case 'V': PressKey = 'v'; break;
		case 'B': PressKey = 'b'; break;
		case 'N': PressKey = 'n'; break;
		case 'M': PressKey = 'm'; break;
		case '<': PressKey = ','; break;
		case '>': PressKey = '.'; break;
		case '?': PressKey = '/'; break;
	}
	if (PressKey != -1)
		return PressKey;
	else return input;
}

window.onload = function() {
	document.getElementById('errors').innerHTML = "Ошибки: " + errors;
	document.getElementById('typed').innerHTML = "Набрано: 0/" + text_db.length;
	l = 10; // elements in string
	for ( i = 0, j = i + l;	 	i+l <= text_db.length;  	i += l)
		TextBuf.push ( text_db.substr(i, j));
	TextBuf.push ( text_db.substr(i, text_db.length) );
	TextBufSize = TextBuf.length;
	str = TextBuf.shift();
	document.getElementById('next').innerHTML = str;
	text = str.split('');

	TrueKey = str.charCodeAt(LightCounter);
	LightTrueKey = TrueKey;
	document.getElementById(TrueKey).style.backgroundColor = "blue" ;

	input_text.onkeypress = function (e) {
		if (!timer) start_timer();
		var keycode;
		if(!event) var event = window.event;
		if (event.keyCode) keycode = event.keyCode; // IE
		else if(event.which) keycode = event.which; // all browsers
		setKey(keycode);
	}

	input_text.onkeyup = function () {
		clearKey();
	}
}

window.onkeypress=function(){

	input_key = isKeyDown();
	//console.log("input_key="+input_key);
	char_e = String.fromCharCode(input_key);

	char_e = CodeUpKey(char_e);
	input_key = char_e.charCodeAt(0);
	if (PressKey != -1)
		document.getElementById('key_shift_lft_long').style.backgroundColor = "yellow" ;


	document.getElementById('input_text').value = str_input;
	if (exit < TextBufSize ) {
		if (key < text.length)
		{	++counter;
			if (char_e) {
				if (char_e == text[counter]) {

					document.getElementById(LightTrueKey).style.backgroundColor = "#fff";
					document.getElementById(LightFalseKey).style.backgroundColor = "#fff";
					LightCounter = counter + 1;
					TrueKey = str.charCodeAt(LightCounter);
					document.getElementById(TrueKey).style.backgroundColor = "blue" ;
					LightTrueKey = TrueKey;

					typed++;
					++key;
					str_input += char_e;
					if (str_color_err != '') {
						str_color_start += str_color_err;
						str_color_err = '';
					}
					else
						str_color_start += '<span class="letter_ok">' + char_e + '</span>';
					document.getElementById('text_type').innerHTML = str_color_start;
					if (counter<text.length) {
						document.getElementById('text_type').innerHTML += '<span class="current">' + text[++counter]+ '</span>';
					}
					if (counter<text.length) {
						var aar = text.slice(++counter, text.length);
						counter-=2;
						str_color_end = aar.join('');
						document.getElementById('text_type').innerHTML += '<span class="next">' + str_color_end + '</span>';
					}
					document.getElementById('typed').innerHTML = "Набрано: " + typed +'/' + text_db.length;
					fl = 0;
				}
				else {
					if (fl == 0) {
						errors ++;
						str_color_err += '<span class="letter_bad">' + text[counter] + '</span>';
						document.getElementById('text_type').innerHTML = str_color_start;
						if (counter<text.length) {
							document.getElementById('text_type').innerHTML += '<span class="current">' + text[counter]+ '</span>';
						}
						if (counter<text.length) {
							var aar = text.slice(++counter, text.length);
							--counter;
							str_color_end = aar.join('');
							document.getElementById('text_type').innerHTML += '<span class="next">' + str_color_end + '</span>';
						}
						fl = 1;
					}
					--counter;
					document.getElementById('errors').innerHTML = "Ошибки: " + errors;

					document.getElementById(LightFalseKey).style.backgroundColor = "#fff";
					document.getElementById(input_key).style.backgroundColor = "red" ;
					LightFalseKey = input_key;
				}
			}
		}
		else { // Change string of text for typing 
			exit++;
			typed++;
			document.getElementById('typed').innerHTML = "Набрано: " + typed +'/' + text_db.length;
			if (exit < TextBufSize) {
				counter = -1;
				fl = 0;
				key = 1;
				str_input = '',	str_color_start = '', str_color_end = '', str_color_err = '';
				str = TextBuf.shift();
				text = str.split('');

				document.getElementById('input_text').value = str_input;
				document.getElementById('text_type').innerHTML = '<span class="next">' + str + '</span>';
				LightFalseKey = input_key;
				document.getElementById(LightFalseKey).style.backgroundColor = "#fff";
				document.getElementById(LightTrueKey).style.backgroundColor = "#fff";
				TrueKey = str.charCodeAt(0);
				LightTrueKey = TrueKey;
				document.getElementById(TrueKey).style.backgroundColor = "blue" ;
			}
		}
	}
	else {
		clearInterval(timer);
	}
}


function start_timer()
{
	if (timer) clearInterval(timer);
	minutes = "00";
	secs = "00";
	document.getElementById('timer').innerHTML = 'Время: '+ minutes + ":" + secs;
	timer = setInterval(
		function () {
			secs++;
			if (secs == 60) {
				minutes ++;
				secs = 0;
				minutes =((minutes < 10) ? "0" : "") + minutes;
			}
			secs =((secs < 10) ? "0" : "") + secs;
			document.getElementById('timer').innerHTML = 'Время: '+ minutes + ":" + secs;
		},1000	);
}
