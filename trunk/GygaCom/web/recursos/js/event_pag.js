/**
 * @author Neo Cs
 */
function send(){
    alert("Has hecho click sobre enlace");
}

window.onload = function(){
    listen("click", "caja", send);
    var MenuBar1 = new Spry.Widget.MenuBar("MenuBar", {imgDown:"SpryMenuBarDownHover.gif", imgRight:"SpryMenuBarRightHover.gif"});
}
