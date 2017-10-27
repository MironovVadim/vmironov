/**
 * Time format to output.
 * @type {{year: string, month: string, day: string, timezone: string, hour: string, minute: string}}
 */
timeOptions = {
    year: 'numeric',
    month: 'long',
    day: 'numeric',
    timezone: 'UTC',
    hour: 'numeric',
    minute: 'numeric'
};
/**
 * Address of car manage servlet.
 * @type {string}
 */
getAllUnsoldedCar = "carManager";

/**
 * Address of car getter servlet.
 * @type {string}
 */
getCar = "getCar";
/**
 * Address of user getter servlet.
 * @type {string}
 */
getCurrentUser = "getUser";
/**
 * URL of "no car photo" image
 * @type {string}
 */
noPhoto = "http://mercedesdealers.co.in/images/no_car_image.jpg";
/**
 * Address of add comment servlet.
 * @type {string}
 */
sendNewComment = "sendComment";
/**
 * Address of cell car servlet.
 * @type {string}
 */
sellCurrentCar = "sellCar";
/**
 * Address of filtered car servlet.
 * @type {string}
 */
sendFilters = "filterCars";
/**
 * Fill page when page on load.
 */
window.onload = function() {
    $.getJSON(getAllUnsoldedCar, function(data) {
        fillPage(data);
    });
    $("#showCars").click(function() {
        showCars();
    });
    setFilterOptions();
};

/**
 * Function fills page by car short info.
 * @param cars - object with info about all unsold cars.
 */
function fillPage(cars) {
    if (cars.length > 0) {
        addFullCarInfo(cars[0]["id"]);
    }
    $.each(cars, function (key, value) {
        addShortCarInfo(value);
    })
}

/**
 * Function fills div element by short info about current car.
 * @param car - car object.
 */
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

/**
 * Function gets text info from current car.
 * @param car - object with car info.
 * @returns {Element} filled div element by text info.
 */
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

/**
 * Functions gets image from current car.
 * @param car - object with car info.
 * @returns {Element} filled div element with image.
 */
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

/**
 * Function get full info about one car from servlet and then fill main part of page by this.
 * @param carId - car id.
 */
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

/**
 * Function add info when car was added by who.
 * @param car - current car.
 */
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

/**
 * Function add full text info about car to main part of page.
 * @param car - current car.
 */
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

/**
 * Function adds all photos of car to main part of page.
 * @param car - current car.
 */
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

/**
 * Function set full size photo of car on page.
 * @param photo of car
 */
function setMainPhoto(photo) {
    $("#mainPhoto").attr("src", photo.target.currentSrc);
}

/**
 * Function add comments of car to page.
 * @param car - current car.
 */
function addComments(car) {
    $("#comments").empty();
    var comments = car["comments"];

    for (var i = 0; i < comments.length; i++) {
        addComment(comments[i]);
    }
}

/**
 * Function add new comment to page.
 * @param newComment - new comment to car
 */
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

/**
 * Function send on servlet new comment by AJAX.
 * @param comment - new comment.
 * @param carId - car id.
 */
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

/**
 * Function adds action (send comment ot servlet by AJAX) on button "Send comment".
 * @param car - current car.
 */
function settingCommentFormOptions(car) {
    var carId = car["id"];
    $("#sendComment").off();
    $("#sendComment").click(function () {
        var comment = $("#addComment").val();
        if (comment !== "") {
            sendComment(comment, carId);
        }
    });
}

/**
 * Function send message that car was sold on servlet by AJAX.
 * @param car - current car.
 */
function sellCar(car) {
    var carId = car["id"];
    $.ajax({
        type: "POST",
        url: sellCurrentCar,
        data: {carId: carId}
    });
    removeCarFromStorage(car);
}

/**
 * Function set behavior on "#sellButton" button.
 * @param car - current car.
 */
function settingSellButtonOptions(car) {
    if (car["owner"]) {
        showSellButton(car);
    } else {
        hideSellButton();
    }
}

/**
 * Function show "#sellButton" button.
 * @param car - current car.
 */
function showSellButton(car) {
    $("#sellButton")
        .removeAttr("hidden")
        .click(function () {
                sellCar(car);
            }
        );
}

/**
 * Function hide "#sellButton" button.
 * @param car - current car.
 */
function hideSellButton() {
    $("#sellButton")
        .off()
        .attr("hidden", true);
}

/**
 * Function remove info about sold car from page.
 * @param car - current car.
 */
function removeCarFromStorage(car) {
    $("#" + car["id"]).remove();
    var carId = $(".carInfo")[0]["id"];
    addFullCarInfo(carId);
}

/**
 * Function set behavior of "#showCars" checkbox.
 */
function showCars() {
    if ($("#showCars").is(":checked")) {
        showOnlyMyCars();
    } else {
        showAllCars();
    }
}

/**
 * Function shows only cars that owned to current user.
 */
function showOnlyMyCars() {
    var cars = $(".carInfo");
    $.each(cars, function (index, carInfo) {
        if (!$(carInfo).hasClass("owner")) {
            $(carInfo).attr("hidden", "true");
        }
    })
}

/**
 * Function shows all unsold cars.
 */
function showAllCars() {
    var cars = $(".carInfo");
    $.each(cars, function (index, carInfo) {
        $(carInfo).removeAttr("hidden");
    })
}

/**
 * Function set behavior of filters.
 */
function setFilterOptions() {
    setFilterButton();
    setDropFiltersButton();
}

/**
 * Function send filters to servlet by AJAX and show received filtered cars.
 */
function setFilterButton() {
    $("#addFilters").submit(function (event) {
        event.preventDefault();
        var mark = $("#filterMark").val();
        var model = $("#filterModel").val();
        var costFrom = $("#filterCostFrom").val();
        var costTo = $("#filterCostTo").val();
        if (mark !== "" || model !== "" || costFrom !== "" || costTo !== "") {
            $.ajax({
                type: 'GET',
                url: sendFilters,
                cache: false,
                dataType: "application/json",
                data: {
                    mark: mark,
                    model: model,
                    costFrom: costFrom,
                    costTo: costTo
                },
                complete: function (data) {
                    $("#carFlexBox").empty();
                    var cars = JSON.parse(data.responseText);
                    fillPage(cars);
                    showCars();
                }
            });
        }
    })
}

/**
 * Function drops filters.
 */
function setDropFiltersButton() {
    $("#dropFilters").submit(function (event) {
        event.preventDefault();
        $("#addFilters").trigger("reset");
        $.getJSON(getAllUnsoldedCar, function(data) {
            $("#carFlexBox").empty();
            fillPage(data);
            showCars();
        });
    })
}