addNewCar = "/items/carstorage/carManager";

window.onload = function () {
    $("#addCarForm").submit(function(event) {
        event.preventDefault();
        var files = $("input[name='files']")[0].files;
        var formData = new FormData(this);
        for (var i = 0; i < files.length; i++) {
            formData.append("photo" + i, files[i]);
        }
        formData.delete("files");
        $.ajax({
            type: 'POST',
            url: addNewCar,
            cache: false,
            contentType: false,
            processData: false,
            data: formData,
            success: function () {
                $("#submit").attr("hidden", "true");
                $("#success").html("Car was successfully added to car storage!").css("color", "green");
            }
        });
    });
};