
var keyDown = 0;
var input_key = 0;
var currentLocation;

var TextBufSize;
var TextBuf = new Array();
var str_input = '',	str_color_start = '', str_color_end = '', str_color_err = '';
var text_db = "tFe FGDFGold man and the sea is the story of";// a battle between an old, experienced cuban fisherman and a large marlin. the novel.";
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
var LightTrueKey, LightFalseKey = 'key_1', LightShift = 0, LightCounter = 0;	//	LightTrueKey, LightFalseKey - значение предыдущего символа, который нужно будет выключить. LightCounter - номер элемента в массиве для подсветки.
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

var CodeUpKey = function (input) {
	PressKey = -1;
	LightShift = 0;
	switch (input) {
		case '~': PressKey = 'key_1'; LightShift = 1; break;
		case '!': PressKey = 'key_2'; LightShift = 1; break;
		case '@': PressKey = 'key_3'; LightShift = 1; break;
		case '#': PressKey = 'key_4'; LightShift = 1; break;
		case '$': PressKey = 'key_5'; LightShift = 1; break;
		case '%': PressKey = 'key_6'; LightShift = 1; break;
		case '^': PressKey = 'key_7'; LightShift = 1; break;
		case '&': PressKey = 'key_8'; LightShift = 1; break;
		case '*': PressKey = 'key_9'; LightShift = 1; break;
		case '(': PressKey = 'key_10'; LightShift = 1; break;
		case ')': PressKey = 'key_11'; LightShift = 1; break;
		case '_': PressKey = 'key_12'; LightShift = 1; break;
		case '+': PressKey = 'key_13'; LightShift = 1; break;

		case '`': PressKey = 'key_1'; break;
		case '1': PressKey = 'key_2'; break;
		case '2': PressKey = 'key_3'; break;
		case '3': PressKey = 'key_4'; break;
		case '4': PressKey = 'key_5'; break;
		case '5': PressKey = 'key_6'; break;
		case '6': PressKey = 'key_7'; break;
		case '7': PressKey = 'key_8'; break;
		case '8': PressKey = 'key_9'; break;
		case '9': PressKey = 'key_10'; break;
		case '0': PressKey = 'key_11'; break;
		case '-': PressKey = 'key_12'; break;
		case '=': PressKey = 'key_13'; break;

		case 'Q': PressKey = 'key_14'; LightShift = 1; break;
		case 'W': PressKey = 'key_15'; LightShift = 1; break;
		case 'E': PressKey = 'key_16'; LightShift = 1; break;
		case 'R': PressKey = 'key_17'; LightShift = 1; break;
		case 'T': PressKey = 'key_18'; LightShift = 1; break;
		case 'Y': PressKey = 'key_19'; LightShift = 1; break;
		case 'U': PressKey = 'key_20'; LightShift = 1; break;
		case 'I': PressKey = 'key_21'; LightShift = 1; break;
		case 'O': PressKey = 'key_22'; LightShift = 1; break;
		case 'P': PressKey = 'key_23'; LightShift = 1; break;
		case '{': PressKey = 'key_24'; LightShift = 1; break;
		case '}': PressKey = 'key_25'; LightShift = 1; break;
		case '|': PressKey = 'key_26'; LightShift = 1; break;

		case 'q': PressKey = 'key_14'; break;
		case 'w': PressKey = 'key_15'; break;
		case 'e': PressKey = 'key_16'; break;
		case 'r': PressKey = 'key_17'; break;
		case 't': PressKey = 'key_18'; break;
		case 'y': PressKey = 'key_19'; break;
		case 'u': PressKey = 'key_20'; break;
		case 'i': PressKey = 'key_21'; break;
		case 'o': PressKey = 'key_22'; break;
		case 'p': PressKey = 'key_23'; break;
		case '[': PressKey = 'key_24'; break;
		case ']': PressKey = 'key_25'; break;
		case '\\': PressKey = 'key_26'; break;

		case 'A': PressKey = 'key_27'; LightShift = 1; break;
		case 'S': PressKey = 'key_28'; LightShift = 1; break;
		case 'D': PressKey = 'key_29'; LightShift = 1; break;
		case 'F': PressKey = 'key_30'; LightShift = 1; break;
		case 'G': PressKey = 'key_31'; LightShift = 1; break;
		case 'H': PressKey = 'key_32'; LightShift = 1; break;
		case 'J': PressKey = 'key_33'; LightShift = 1; break;
		case 'K': PressKey = 'key_34'; LightShift = 1; break;
		case 'L': PressKey = 'key_35'; LightShift = 1; break;
		case ':': PressKey = 'key_36'; LightShift = 1; break;
		case '"': PressKey = 'key_37'; LightShift = 1; break;

		case 'a': PressKey = 'key_27'; break;
		case 's': PressKey = 'key_28'; break;
		case 'd': PressKey = 'key_29'; break;
		case 'f': PressKey = 'key_30'; 	break;
		case 'g': PressKey = 'key_31'; 	break;
		case 'h': PressKey = 'key_32'; break;
		case 'j': PressKey = 'key_33'; break;
		case 'k': PressKey = 'key_34'; break;
		case 'l': PressKey = 'key_35'; break;
		case ';': PressKey = 'key_36'; break;
		case '\'': PressKey = 'key_37'; break;

		case 'Z': PressKey = 'key_38'; LightShift = 1; break;
		case 'X': PressKey = 'key_39'; LightShift = 1; break;
		case 'C': PressKey = 'key_40'; LightShift = 1; break;
		case 'V': PressKey = 'key_41'; LightShift = 1; break;
		case 'B': PressKey = 'key_42'; LightShift = 1; break;
		case 'N': PressKey = 'key_43'; LightShift = 1; break;
		case 'M': PressKey = 'key_44'; LightShift = 1; break;
		case '<': PressKey = 'key_45'; LightShift = 1; break;
		case '>': PressKey = 'key_46'; LightShift = 1; break;
		case '?': PressKey = 'key_47'; LightShift = 1; break;

		case 'z': PressKey = 'key_38'; break;
		case 'x': PressKey = 'key_39'; break;
		case 'c': PressKey = 'key_40'; break;
		case 'v': PressKey = 'key_41'; break;
		case 'b': PressKey = 'key_42'; break;
		case 'n': PressKey = 'key_43'; break;
		case 'm': PressKey = 'key_44'; break;
		case ',': PressKey = 'key_45'; break;
		case '.': PressKey = 'key_46'; break;
		case '/': PressKey = 'key_47'; break;

		case ' ': PressKey = 'key_48'; break;

		// For RUS Keyboard
		case 'Ё': PressKey = 'key_1'; LightShift = 1; break;
		case '!': PressKey = 'key_2'; LightShift = 1; break;
		case '"': PressKey = 'key_3'; LightShift = 1; break;
		case '№': PressKey = 'key_4'; LightShift = 1; break;
		case ';': PressKey = 'key_5'; LightShift = 1; break;
		case '%': PressKey = 'key_6'; LightShift = 1; break;
		case ':': PressKey = 'key_7'; LightShift = 1; break;
		case '?': PressKey = 'key_8'; LightShift = 1; break;
		case '*': PressKey = 'key_9'; LightShift = 1; break;
		case '(': PressKey = 'key_10'; LightShift = 1; break;
		case ')': PressKey = 'key_11'; LightShift = 1; break;
		case '_': PressKey = 'key_12'; LightShift = 1; break;
		case '+': PressKey = 'key_13'; LightShift = 1; break;

		case 'ё': PressKey = 'key_1'; break;
		case '1': PressKey = 'key_2'; break;
		case '2': PressKey = 'key_3'; break;
		case '3': PressKey = 'key_4'; break;
		case '4': PressKey = 'key_5'; break;
		case '5': PressKey = 'key_6'; break;
		case '6': PressKey = 'key_7'; break;
		case '7': PressKey = 'key_8'; break;
		case '8': PressKey = 'key_9'; break;
		case '9': PressKey = 'key_10'; break;
		case '0': PressKey = 'key_11'; break;
		case '-': PressKey = 'key_12'; break;
		case '=': PressKey = 'key_13'; break;

		case 'Й': PressKey = 'key_14'; LightShift = 1; break;
		case 'Ц': PressKey = 'key_15'; LightShift = 1; break;
		case 'У': PressKey = 'key_16'; LightShift = 1; break;
		case 'К': PressKey = 'key_17'; LightShift = 1; break;
		case 'Е': PressKey = 'key_18'; LightShift = 1; break;
		case 'Н': PressKey = 'key_19'; LightShift = 1; break;
		case 'Г': PressKey = 'key_20'; LightShift = 1; break;
		case 'Ш': PressKey = 'key_21'; LightShift = 1; break;
		case 'Щ': PressKey = 'key_22'; LightShift = 1; break;
		case 'З': PressKey = 'key_23'; LightShift = 1; break;
		case 'Х': PressKey = 'key_24'; LightShift = 1; break;
		case 'Ъ': PressKey = 'key_25'; LightShift = 1; break;
		case '/': PressKey = 'key_26'; LightShift = 1; break;

		case 'й': PressKey = 'key_14'; break;
		case 'ц': PressKey = 'key_15'; break;
		case 'у': PressKey = 'key_16'; break;
		case 'к': PressKey = 'key_17'; break;
		case 'е': PressKey = 'key_18'; break;
		case 'н': PressKey = 'key_19'; break;
		case 'г': PressKey = 'key_20'; break;
		case 'ш': PressKey = 'key_21'; break;
		case 'щ': PressKey = 'key_22'; break;
		case 'з': PressKey = 'key_23'; break;
		case 'х': PressKey = 'key_24'; break;
		case 'ъ': PressKey = 'key_25'; break;
		case '\\': PressKey = 'key_26'; break;

		case 'Ф': PressKey = 'key_27'; LightShift = 1; break;
		case 'Ы': PressKey = 'key_28'; LightShift = 1; break;
		case 'В': PressKey = 'key_29'; LightShift = 1; break;
		case 'А': PressKey = 'key_30'; LightShift = 1; break;
		case 'П': PressKey = 'key_31'; LightShift = 1; break;
		case 'Р': PressKey = 'key_32'; LightShift = 1; break;
		case 'О': PressKey = 'key_33'; LightShift = 1; break;
		case 'Л': PressKey = 'key_34'; LightShift = 1; break;
		case 'Д': PressKey = 'key_35'; LightShift = 1; break;
		case 'Ж': PressKey = 'key_36'; LightShift = 1; break;
		case 'Э': PressKey = 'key_37'; LightShift = 1; break;

		case 'ф': PressKey = 'key_27'; break;
		case 'ы': PressKey = 'key_28'; break;
		case 'в': PressKey = 'key_29'; break;
		case 'а': PressKey = 'key_30'; 	break;
		case 'п': PressKey = 'key_31'; 	break;
		case 'р': PressKey = 'key_32'; break;
		case 'о': PressKey = 'key_33'; break;
		case 'л': PressKey = 'key_34'; break;
		case 'д': PressKey = 'key_35'; break;
		case 'ж': PressKey = 'key_36'; break;
		case 'э': PressKey = 'key_37'; break;

		case 'Я': PressKey = 'key_38'; LightShift = 1; break;
		case 'Ч': PressKey = 'key_39'; LightShift = 1; break;
		case 'С': PressKey = 'key_40'; LightShift = 1; break;
		case 'М': PressKey = 'key_41'; LightShift = 1; break;
		case 'И': PressKey = 'key_42'; LightShift = 1; break;
		case 'Т': PressKey = 'key_43'; LightShift = 1; break;
		case 'Ь': PressKey = 'key_44'; LightShift = 1; break;
		case 'Б': PressKey = 'key_45'; LightShift = 1; break;
		case 'Ю': PressKey = 'key_46'; LightShift = 1; break;
		case '.': PressKey = 'key_47'; LightShift = 1; break;

		case 'я': PressKey = 'key_38'; break;
		case 'ч': PressKey = 'key_39'; break;
		case 'с': PressKey = 'key_40'; break;
		case 'м': PressKey = 'key_41'; break;
		case 'и': PressKey = 'key_42'; break;
		case 'т': PressKey = 'key_43'; break;
		case 'ь': PressKey = 'key_44'; break;
		case 'б': PressKey = 'key_45'; break;
		case 'ю': PressKey = 'key_46'; break;
		case '.': PressKey = 'key_47'; break;
	}
	return PressKey;

}

function serverPost() {

	var str = {
		"progress" : proc,
		"errors" : errors,
		"time" : minutes + ":" + secs,
		"typed" : typed
	}

	$.ajax({
		type: 'POST',
		url: "/",
		dataType: 'json',
		data: str,
		success: function(data, textStatus, xhr) {
			window.location.href = currentLocation;
		},
		error: function (xhr, ajaxOptions, thrownError) {
			window.location.href = currentLocation;
		}
	});
}

$(document).ready(function() {

	currentLocation = window.location.href;

	json = $('#text').val();

	console.log(json);

	var obj = jQuery.parseJSON(json);
	console.log(obj);
	text_db = obj.text;
	text_db = text_db.trim();

	window.document.getElementById('input_text').focus();

	document.getElementById('errors').innerHTML = "Errors: " + errors;
	document.getElementById('typed').innerHTML = "Typed: 0/" + text_db.length;
	var xsa = $( window ).width();
	console.log(xsa);
	l = ( xsa / 10 ) - 20; // elements in string

	for ( i = 0, j = i + l;	 	i+l <= text_db.length;  	i += l)
		TextBuf.push ( text_db.substr(i, j));
	TextBuf.push ( text_db.substr(i, text_db.length) );
	TextBufSize = TextBuf.length;
	str = TextBuf.shift();
	document.getElementById('next').innerHTML = str;
	text = str.split('');

	TrueKey = CodeUpKey(str[0]);
	LightTrueKey = TrueKey;
	document.getElementById(TrueKey).style.backgroundColor = "#b0bdcc" ;
	if (LightShift)
		document.getElementById('key_shift_lft_long').style.backgroundColor = "#B89F99" ;

	input_text.onkeypress = function (e) {
		var keycode;
		if(!event) var event = window.event;
		if (event.keyCode) keycode = event.keyCode; // IE
		else if(event.which) keycode = event.which; // all browsers
		setKey(keycode);
	}

	input_text.onkeyup = function () {
		clearKey();
	}
});

window.onkeypress=function(){

	if (!timer) start_timer();
	
	input_key = isKeyDown();
	char_e = String.fromCharCode(input_key);

	document.getElementById('input_text').value = str_input;
	if (key <= text.length)
	{	++counter;
		if (char_e) {
			if (char_e == text[counter]) {

				document.getElementById(LightTrueKey).style.backgroundColor = "#fff";
				document.getElementById(LightFalseKey).style.backgroundColor = "#fff";

				if(key < text.length) {
					LightCounter = counter + 1;
					TrueKey = CodeUpKey(str[LightCounter]);
					if (LightShift) document.getElementById('key_shift_lft_long').style.backgroundColor = "#B89F99" ;
					else document.getElementById('key_shift_lft_long').style.backgroundColor = "#fff";
					document.getElementById(TrueKey).style.backgroundColor = "#b0bdcc" ;
					LightTrueKey = TrueKey;
				}
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
				if (counter<text.length-1) {
					document.getElementById('text_type').innerHTML += '<span class="current">' + text[++counter]+ '</span>';
				}
				if (counter<text.length) {
					var aar = text.slice(++counter, text.length);
					counter-=2;
					str_color_end = aar.join('');
					document.getElementById('text_type').innerHTML += '<span class="next">' + str_color_end + '</span>';
				}
				document.getElementById('typed').innerHTML = "Typed: " + typed +'/' + text_db.length;
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
				document.getElementById('errors').innerHTML = "Errors: " + errors;

				document.getElementById(LightFalseKey).style.backgroundColor = "#fff";
				document.getElementById(TrueKey).style.backgroundColor = "#b0bdcc" ;
				FalseKey = CodeUpKey(char_e);
				document.getElementById(FalseKey).style.backgroundColor = "#E89980" ;
				LightFalseKey = FalseKey;
			}

			if (key > text.length) {	// Change string of text for typing

				LightCounter = 0;
				exit++;
				document.getElementById('typed').innerHTML = "Typed: " + typed +'/' + text_db.length;
				if (exit < TextBufSize) {
					counter = -1;
					fl = 0;
					key = 1;
					str_input = '',	str_color_start = '', str_color_end = '', str_color_err = '';
					str = TextBuf.shift();
					text = str.split('');
					document.getElementById('input_text').value = str_input;
					document.getElementById('text_type').innerHTML = '<span class="next">' + str + '</span>';

					LightFalseKey = CodeUpKey(char_e);
					document.getElementById(LightFalseKey).style.backgroundColor = "#fff";
					document.getElementById(LightTrueKey).style.backgroundColor = "#fff";

					TrueKey = CodeUpKey(str[0]);
					if (LightShift) document.getElementById('key_shift_lft_long').style.backgroundColor = "#B89F99" ;
					else document.getElementById('key_shift_lft_long').style.backgroundColor = "#fff";
					LightTrueKey = TrueKey;
					document.getElementById(TrueKey).style.backgroundColor = "#b0bdcc" ;
				}
				if (exit == TextBufSize) {
					console.log("To server!!!");
					clearInterval(timer);
					console.log(errors);
					console.log(minutes + ":" + secs);
					var dedc = text_db.length-errors;
					proc = dedc*100 / text_db.length;
					console.log(proc);
					serverPost();
				}
			}
		}
	}
}


function start_timer()
{
	if (timer) clearInterval(timer);
	minutes = "00";
	secs = "00";
	document.getElementById('timer').innerHTML = 'Time: '+ minutes + ":" + secs;
	timer = setInterval(
		function () {
			secs++;
			if (secs == 60) {
				minutes ++;
				secs = 0;
				minutes =((minutes < 10) ? "0" : "") + minutes;
			}
			secs =((secs < 10) ? "0" : "") + secs;
			document.getElementById('timer').innerHTML = 'Time: '+ minutes + ":" + secs;
		},1000	);
}
