checkUser = "/items/carstorage/signIn";

window.onload = function () {
    $("#loginForm").on("submit", function (e) {
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: checkUser,
            data: $("#loginForm").serialize(),
            statusCode: {
                400: function (jqXHR, textStatus, errorThrown) {
                    var responseHtml = $.parseHTML(jqXHR.responseText);
                    console.log(responseHtml[0]);
                    $("#error").html("Error!").css("color", "red");
                }
            },
            success: function () {
                window.location.replace("/items/carstorage/carStorage.html");
            }
        });
    })
};

