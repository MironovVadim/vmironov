title = "<tr>"
    + "<th>Id</th>"
    + "<th>Description</th>"
    + "<th>Create date</th>"
    + "<th>Is done</th>"
    + "</tr>";

addUrl = "http://localhost:8080/items/adding";

completeUrl = "http://localhost:8080/items/complete";

timeOptions = {
    year: 'numeric',
    month: 'long',
    day: 'numeric',
    timezone: 'UTC',
    hour: 'numeric',
    minute: 'numeric'
};

window.onload = function () {
    var checkbox = document.getElementById("isHide");
    checkbox.onclick = changeTaskView;
    fillPage();
    var addTask = document.getElementById("addTask");
    addTask.onclick = addNewTask;
    var endTask = document.getElementById("completeTask");
    endTask.onclick = completeTask;
};

function fillPage() {
    $.ajax(addUrl, {
        method: "GET",
        complete: function(data) {
            var tasks = JSON.parse(data.responseText);
            fillTable(tasks);
            fillSelect(tasks);
        }
    });
}

function fillTable(tasks) {
    var table = document.getElementById("toDoList");
    table.innerHTML = title;
    for (var i = 0; i < tasks.length; i++) {
        var tr = document.createElement("tr");
        var task = tasks[i];
        for (var field in task) {
            var td = document.createElement("td");
            if (field === "created") {
                var date = new Date(task[field]);
                td.innerHTML = date.toLocaleString("ru", timeOptions);
            } else {
                td.innerHTML = task[field];
            }
            tr.appendChild(td);
        }
        table.appendChild(tr);
    }
}

function fillSelect(tasks) {
    var select = document.getElementById("selectList");
    for (var i = 0; i < tasks.length; i++) {
        if (tasks[i]["done"] === false) {
            var option = document.createElement("option");
            option.innerHTML = tasks[i]["id"];
            select.appendChild(option);
        }
    }
}

function changeTaskView() {
    var checkbox = document.getElementById("isHide");
    var isHide = checkbox.checked;
    var toDoList = document.getElementById("toDoList");
    var tasks = toDoList.getElementsByTagName("tr");
    if (isHide) {
            hideTask(tasks);
    } else {
            showTask(tasks);
    }
}

function hideTask(tasks) {
    for (var i = 1; i < tasks.length; i++) {
        var task = tasks[i].getElementsByTagName("td");
        if (task[3].innerHTML === "true") {
            tasks[i].setAttribute("hidden", "true");
        }
    }
}

function showTask(tasks) {
    for (var i = 1; i < tasks.length; i++) {
        tasks[i].removeAttribute("hidden");
    }
}

function addNewTask() {
    var desc = document.getElementById("description");
    if (desc.value !== "") {
        $.post(addUrl, {
                description: desc.value
            },
            function () {
                fillPage();
            });
    }
}

function completeTask() {
    var id = document.getElementById("selectList");
    $.post(completeUrl, {
            id: id.options[id.selectedIndex].text
        },
        function () {
            fillPage();
        });
}