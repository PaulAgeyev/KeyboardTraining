var keyDown = 0;
var char_textarea;

var setKey = function (keyCode) {
	keyDown=keyCode;
}

var clearKey = function () {
	keyDown = 0;
}

var isKeyDown = function () {
	return keyDown;
}

/*var getWidthTeaxtarea = function (){
 char_textarea = document.getElementById('text_type').offsetWidth ;
 alert(char_textarea) ;
 document.body.style.width = char_textarea/0.8+'px';
 alert( body.style.width );
 }*/



window.onload = function() {

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


	//document.getElementById('next').innerHTML = text_db;
	document.getElementById('errors').innerHTML = "Ошибки: " + errors;
	document.getElementById('typed').innerHTML = "Набрано: 0/" + text_db.length;
	console.log( "text_db.length=" + text_db.length );
	//document.getElementById('next').innerHTML = text_db.substr(0,110);
	l = 110; // elements in string


	for ( i = 0, j = i + l;	 	i+l <= text_db.length;  	i += l)
		TextBuf.push ( text_db.substr(i, j) );
	TextBuf.push ( text_db.substr(i, text_db.length) );

	TextBufSize = TextBuf.length;
	console.log( "text_db.length=" + text_db.length );

	str = TextBuf.shift();
	document.getElementById('next').innerHTML = str;
	console.log( "str=" + 	str );
	console.log( "l=" + TextBuf.length );
	text = str.split('');

	/*for (i = 0; i < len; i++ )	{
	 console.log( "l=" + TextBuf.length );
	 console.log( "mas[]=" + 	TextBuf.shift() );
	 }*/

}
var TextBufSize;
var TextBuf = new Array();
var input_key = 0;
var str_input = '',	str_color_start = '', str_color_end = '', str_color_err = '';
var text_db = "the old man and the Sea is the story of a battle between an old, experienced cuban fisherman and a large marlin. The novel opens with the explanation that the fisherman, who is named Santiago, has gone 84 days without catching a fish. In fact, he is so unlucky that his young apprentice, Manolin, has been forbidden by his parents to sail with the old man and been ordered to fish with more successful fishermen. Still dedicated to the old man, however, the boy visits Santiago's shack each night.";
//text_db += '\n';


var text;// = str.split('');
var str;

var counter = -1
var char_e;
var fl = 0;
var key = 1;
var errors = 0;
var typed = 0;
var exit = 1;


/*window.onresize=function(){
 client_w=document.body.clientWidth;
 textarea_length = client_w * 0.78 / 20;
 textarea_length = textarea_length.toFixed();
 setTextLength (textarea_length);
 }*/

window.onkeypress=function(){
	input_key = isKeyDown();
	char_e = String.fromCharCode(input_key);
	document.getElementById('input_text').value = str_input;
	//console.log( "TextBufSize=" + TextBufSize );
	if (exit < TextBufSize ) {
		//console.log( "exit=" + exit );
		console.log( "key=" + key );
		console.log( "length=" + text.length );
		if (key < text.length)

		{
			//console.log("text[counter]="+text[counter++]+" length="+text.length);counter--;
			++counter;
			if (char_e) {  //console.log("text="+text[counter]);
				if (char_e == text[counter]) {
					typed++;
					++key;
					str_input += char_e;
					//console.log("+ e="+char_e + "  text="+text[counter]);
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
						//console.log("c="+str_color_end);
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
							//console.log("c="+str_color_end);
							document.getElementById('text_type').innerHTML += '<span class="next">' + str_color_end + '</span>';
						}
						fl = 1;
						//console.log("- e="+char_e + "  text="+text[counter]);
					}
					--counter;
					document.getElementById('errors').innerHTML = "Ошибки: " + errors;
				}

			}
		}
		else { // здесь буду изменять массив который использую по textBufmas [exit];;;;

			exit++;
			counter = -1;
			fl = 0;
			key = 1;
			//text=TextBuf.shift().split('');
			str_input = '',	str_color_start = '', str_color_end = '', str_color_err = '';

			str = TextBuf.shift();

			console.log( "else =" + 	str );

			//document.getElementById('next').innerHTML = str;

			console.log( "str=" + 	str );
			console.log( "l=" + TextBuf.length );
			console.log( "key_else=" + key );
			console.log( "length=" + text.length );

			text = str.split('');
			console.log("Finish");
		}

	}
	else console.log("END!");
}

var timer;
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