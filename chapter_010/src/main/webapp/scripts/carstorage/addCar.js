/**
 * Address of car manage servlet.
 * @type {string}
 */
addNewCar = "carManager";

/**
 * Function prevent direct appeal from "#addCarForm" form and adds AJAX transaction of it to car manage servlet.
 */
window.onload = function () {
    $("#addCarForm").submit(function(event) {
        event.preventDefault();
        var files = $("input[name='files']")[0].files;
        var formData = new FormData(this);
        transferCarInfo(formData);
    });
};

/**
 * Function passes "#addCarForm" form to car manage servlet by AJAX.
 * @param formData - FormData with new car info.
 */
function transferCarInfo(formData) {
    $.ajax({
        type: 'POST',
        url: addNewCar,
        cache: false,
        contentType: false,
        processData: false,
        data: formData,
        success: function () {
            hideSubmit();
            printSuccessInfo();
        }
    });
}

/**
 * Function hides submit button after transfer car info to servlet.
 */
function hideSubmit() {
    $("#submit").attr("hidden", "true");
}

/**
 * Print success message.
 */
function printSuccessInfo() {
    $("#success")
        .html("Car was successfully added to car storage!")
        .css("color", "green");
}