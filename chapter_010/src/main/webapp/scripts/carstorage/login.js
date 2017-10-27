/**
 * Address of sign in servlet.
 * @type {string}
 */
checkUser = "signIn";
/**
 * Adding form behavior of checking login and password.
 */
window.onload = function () {
    $("#loginForm").on("submit", function (e) {
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: checkUser,
            data: $("#loginForm").serialize(),
            statusCode: {
                400: function () {
                    $("#error").html("Error!").css("color", "red");
                }
            },
            success: function () {
                window.location.replace("/items/carstorage/carStorage.html");
            }
        });
    })
};

