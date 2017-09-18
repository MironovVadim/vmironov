window.onload = function() {
    var button = document.getElementById("submit");
    button.onclick = takeValues;
};

function takeValues() {
    var milleage = document.getElementById("mil");
    var engCap = document.getElementById(("engCap"));
    console.log(typeof milleage);
    console.log(milleage.value);
    console.log(engCap.value);
}