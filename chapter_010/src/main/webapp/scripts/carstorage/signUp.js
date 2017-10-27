/**
 * Address of create user servlet.
 * @type {string}
 */
createUser = "createUser";
/**
 * Adding form behavior of checking user login and password.
 */
window.onload = function () {
    $("#createUserForm").on("submit", function (e) {
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: createUser,
            data: $("#createUserForm").serialize(),
            statusCode: {
                400: function () {
                    $("#error").html("This login already exist!").css("color", "red");
                }
            },
            success: function () {
                window.location.replace("/items/carstorage/carStorage.html");
            }
        });
    })
};

