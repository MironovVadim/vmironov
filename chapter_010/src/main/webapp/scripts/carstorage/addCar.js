window.onload = function () {
    var sumbit = document.getElementById("submit");
    sumbit.onclick = print;
};

function print() {
    var images = document.getElementById("images");
    console.log(images.value);
}