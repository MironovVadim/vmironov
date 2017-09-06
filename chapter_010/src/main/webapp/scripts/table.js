window.onload = function () {
    fillTable();
    var checkbox = document.getElementById("isHide");
    checkbox.onclick = changeTaskView;
    var submit = document.getElementById("addNewTask");
    submit.onclick = fillTable;
};

function getTaskObjects() {
    var tasks = [];
    var url = "http://localhost:8080/items/manage";
    $.ajax(url, {
        method: "get",
        complete: function(json) {
            tasks = JSON.parse(json);
        }
    });
    return tasks;
}

function fillTable() {
    var title = "<tr>"
        + "<th>Id</th>"
        + "<th>Description</th>"
        + "<th>Create date</th>"
        + "<th>Is done</th>"
        + "</tr>";
    var tasks = getTaskObjects();
    var table = document.getElementById("toDoList");
    table.innerHTML = title;
    for (var i = 0; i < tasks.length; i++) {
        var tr = document.createElement("tr");
        var task = tasks[i];
        for (var field in task) {
            var td = document.createElement("td");
            td.innerHTML = task[field];
            tr.appendChild(td);
        }
        table.appendChild(tr);
    }
}

function changeTaskView() {
    var checkbox = document.getElementById("isHide");
    var isHide = checkbox.checked;
    var toDoList = document.getElementById("toDoList");
    var tasks = toDoList.getElementsByTagName("tr");
    if (isHide) {
        for (var i = 1; i < tasks.length; i++) {
            hideTask(tasks[i]);
        }
    } else {
        for (var i = 1; i < tasks.length; i++) {
            showTask(tasks[i]);
        }
    }
}

function hideTask(rowWithTask) {
    var task = rowWithTask.getElementsByTagName("td");
    if (task[3].innerHTML === "true") {
            rowWithTask.setAttribute("hidden", "true");
    }
}

function showTask(rowWithTask) {
    rowWithTask.removeAttribute("hidden");
}