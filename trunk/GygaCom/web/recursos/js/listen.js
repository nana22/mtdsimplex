/**
 * @author Neo Cs
 */

function $() {
	var elements = new Array();
	for (var i = 0; i < arguments.length; i++) {
		var element = arguments[i];
		if (typeof element == 'string'){
			element = document.getElementById(element);
                }
		if (arguments.length == 1){
			return element;
                }
		elements.push(element);
	}
	return elements;
}

function listen(event, elem, func){
    elem = $(elem);
    if (elem.addEventListener) // W3C DOM
        elem.addEventListener(event, func, true);
    else 
        if (elem.attachEvent) { // IE DOM
            var r = elem.attachEvent("on" + event, func);
            return r;
        }
        else{
            throw 'No es posible añadir evento';
        }
}