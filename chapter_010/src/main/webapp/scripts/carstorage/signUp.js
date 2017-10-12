createUser = "/items/carstorage/createUser";

window.onload = function () {
    $("#createUserForm").on("submit", function (e) {
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: createUser,
            data: $("#createUserForm").serialize(),
            statusCode: {
                400: function (jqXHR, textStatus, errorThrown) {
                    var responseHtml = $.parseHTML(jqXHR.responseText);
                    console.log(responseHtml[0]);
                    $("#error").html("This login already exist!").css("color", "red");
                }
            },
            success: function () {
                window.location.replace("/items/carstorage/signUp.html");
            }
        });
    })
};

