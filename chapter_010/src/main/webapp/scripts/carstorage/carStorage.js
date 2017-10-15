timeOptions = {
    year: 'numeric',
    month: 'long',
    day: 'numeric',
    timezone: 'UTC',
    hour: 'numeric',
    minute: 'numeric'
};

getAllUnsoldedCar = "/items/carstorage/carManager";

getCar = "/items/carstorage/getCar";

getCurrentUser = "/items/carstorage/getUser";

noPhoto = "http://mercedesdealers.co.in/images/no_car_image.jpg";

sendNewComment = "/items/carstorage/sendComment";

sellCurrentCar = "/items/carstorage/sellCar";

window.onload = function() {
    $.getJSON(getAllUnsoldedCar, function(data) {
        if (data.length > 0) {
            addFullCarInfo(data[0]["id"]);
        }
        $.each(data, function (key, value) {
            addShortCarInfo(value);
        })
    });
    var checkBox = document.getElementById("showCars");
    checkBox.onclick = showCars;
};

function addShortCarInfo(car) {
    var shortCarInfo = document.createElement("div");
    $(shortCarInfo)
        .addClass("carInfo")
        .attr("id", car["id"]);
    if (car["owner"]) {
        $(shortCarInfo).addClass("owner");
    }

    var carTextInfo = getTextInfo(car);
    var carImage = getImage(car);

    $(shortCarInfo)
        .append(carTextInfo)
        .append(carImage)
        .click(function() {
            addFullCarInfo(car["id"]);
        });
    $("#carFlexBox").append(shortCarInfo);
}

function getTextInfo(car) {

    var carTextInfo = document.createElement("div");
    $(carTextInfo).addClass("carTextInfo");

    var info = document.createElement("ul");
    $(info).attr("type", "none");
    $(info).attr("id", "shortFeatures");
    var mark = document.createElement("li");
    var model = document.createElement("li");
    var cost = document.createElement("li");
    var created = document.createElement("small");

    var markSpan = document.createElement("span");
    var modelSpan = document.createElement("span");
    var costSpan = document.createElement("span");

    $(markSpan).addClass("prefix");
    $(modelSpan).addClass("prefix");
    $(costSpan).addClass("prefix");

    $(markSpan).html("Mark:");
    $(modelSpan).html("Model:");
    $(costSpan).html("Cost:");

    $(mark)
        .append(markSpan)
        .append(car["mark"]);
    $(model)
        .append(modelSpan)
        .append(car["model"]);
    $(cost)
        .append(costSpan)
        .append(car["cost"]);
    $(created).html("Car added at: "
        + new Date(car["created"])
            .toLocaleString("en", timeOptions));
    $(info)
        .append(mark)
        .append(model)
        .append(cost);
    $(carTextInfo)
        .append(info)
        .append(created);

    return carTextInfo;
}

function getImage(car) {
    var carImage = document.createElement("div");
    $(carImage).addClass("carImage");

    var img = document.createElement("img");
    $(img).addClass("image");
    var images = car["images"];
    if (images.length > 0) {
        $(img).attr("src", "data:image/png;base64, " + images[0]["image"]);
    } else {
        $(img).attr("src", noPhoto);
    }

    $(carImage).append(img);

    return carImage;
}

function addFullCarInfo(carId) {
    $.ajax({
        type: "GET",
        url: getCar,
        data: {carId: carId},
        dataType: "application/json",
        complete: function (data) {
            var car = JSON.parse(data.responseText);
            settingSellButtonOptions(car);
            addTitle(car);
            addAllPhotos(car);
            addFullTextInfo(car);
            addComments(car);
            settingCommentFormOptions(car);
        }
    });
}

function addTitle(car) {
    $("#title")
        .find("h3")
        .empty()
        .html(car["mark"] + " " + car["model"]);
    $("#title")
        .find("small")
        .empty()
        .html("Car added at: "
            + new Date(car["created"])
                .toLocaleString("en", timeOptions)
            + " by "
            + car["user"]["nickname"]);
}

function addFullTextInfo(car) {
    $("#mark")
        .empty()
        .html(car["mark"]);
    $("#model")
        .empty()
        .html(car["model"]);
    $("#releaseYear")
        .empty()
        .html(car["releaseYear"]);
    $("#mileage")
        .empty()
        .html(car["mileage"]);
    $("#bodyType")
        .empty()
        .html(car["bodyType"]);
    $("#color")
        .empty()
        .html(car["color"]);
    $("#engineCapacity")
        .empty()
        .html(car["engineCapacity"]);
    $("#engineType")
        .empty()
        .html(car["engineType"]);
    $("#power")
        .empty()
        .html(car["power"]);
    $("#cost")
        .empty()
        .html(car["cost"]);
    $("#description")
        .empty()
        .html(car["description"]);
}

function addAllPhotos(car) {
    var images = car["images"];
    $("#carPhotosFlexBox").empty();

    if (images.length > 0) {
        $("#mainPhoto").attr("src", "data:image/png;base64, " + images[0]["image"]);
        for (var i = 0; i < images.length; i++) {
            var img = document.createElement("img");
            var photo = images[i]["image"];
            $(img).addClass("photo");
            $(img).click(function(photo) {
                setMainPhoto(photo);
            });
            $(img).attr("src", "data:image/png;base64, " + images[i]["image"]);
            $("#carPhotosFlexBox").append(img);
        }
    } else {
        $("#mainPhoto").attr("src", noPhoto);
    }
}

function setMainPhoto(photo) {
    $("#mainPhoto").attr("src", photo.target.currentSrc);
}

function addComments(car) {
    $("#comments").empty();
    var comments = car["comments"];

    for (var i = 0; i < comments.length; i++) {
        addComment(comments[i]);
    }
}

function addComment(newComment) {
    var description = newComment["description"];
    var created = newComment["created"];
    var nickname = newComment["user"]["nickname"];

    var comment = document.createElement("p");
    var createdInfo = document.createElement("small");
    var hr = document.createElement("hr");

    $(comment).html(description);
    $(createdInfo).html("Commended by "
        + nickname
        + " at:"
        + new Date(created).toLocaleString("en", timeOptions));

    $("#comments")
        .append(comment)
        .append(createdInfo)
        .append(hr);
}

function sendComment(comment, carId) {
    $.ajax({
        type: "GET",
        url: sendNewComment,
        data: {
            description: comment,
            carId: carId
        },
        dataType: "application/json",
        complete: function (data) {
            var newComment = JSON.parse(data.responseText);
            addComment(newComment);
            $("#addComment").val("");
        }
    });
}

function settingCommentFormOptions(car) {
    var carId = car["id"];
    $("#sendComment").click(function () {
        var comment = $("#addComment").val();
        sendComment(comment, carId);
    });
}

function sellCar(car) {
    var carId = car["id"];
    $.ajax({
        type: "POST",
        url: sellCurrentCar,
        data: {carId: carId}
    });
    removeCarFromStorage(car);
}

function settingSellButtonOptions(car) {
    if (car["owner"]) {
        showSellButton(car);
    } else {
        hideSellButton();
    }
}

function showSellButton(car) {
    $("#sellButton")
        .removeAttr("hidden")
        .click(function () {
                sellCar(car);
            }
        );
}

function hideSellButton() {
    $("#sellButton")
        .off()
        .attr("hidden", true);
}

function removeCarFromStorage(car) {
    $("#" + car["id"]).remove();
    var carId = $(".carInfo")[0]["id"];
    addFullCarInfo(carId);
}

function showCars() {
    if ($("#showCars").is(":checked")) {
        showOnlyMyCars();
    } else {
        showAllCars();
    }
}

function showOnlyMyCars() {
    var cars = $(".carInfo");
    $.each(cars, function (index, carInfo) {
        if (!$(carInfo).hasClass("owner")) {
            $(carInfo).attr("hidden", "true");
        }
    })
}

function showAllCars() {
    var cars = $(".carInfo");
    $.each(cars, function (index, carInfo) {
        $(carInfo).removeAttr("hidden");
    })
}