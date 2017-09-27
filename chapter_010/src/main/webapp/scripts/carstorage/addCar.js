window.onload = function () {
    $('form').submit(function() {
        var formData = new FormData(this);
        $.ajax({
            type: 'POST',
            url: 'carManager',
            data: formData,
            cache: false,
            processData: false,
            contentType: false,
            success: function () {
                alert("Car successfully added");
                $('submit').off('click');
            },
            error: function (data) {
                console.log(data);
                alert("error");
            }
        });
    });
};