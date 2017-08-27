window.onload = function () {
    fillTable();
    var checkbox = document.getElementById("isDone");
    console.log(checkbox.value);
    checkbox.onclick = changeTaskView;
    var submit = document.getElementById("addNewTask");
    submit.onclick = fillTable;
};

function getTaskObjects() {
    var tasks;
    var url = "http://localhost:8080/items/manage";
    var request = new XMLHttpRequest();
    request.open("GET", url, true);
    request.send(null);
    tasks = JSON.parse(request.responseText);
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
    table.innerHTML = "";
    table.innerHTML = title;
    for (var task in tasks) {
        var tr = document.createElement("tr");
        for (var field in task) {
            var td = document.createElement("td");
            td.innerHTML = field.value;
            tr.appendChild(td);
        }
    }
    table.appendChild(tr);
}

function changeTaskView() {
    var checkbox = document.getElementById("isHide");
    var isHide = checkbox.checked;
    console.log(isHide);
    var toDoList = document.getElementById("toDoList");
    var tasks = toDoList.getElementsByTagName("tr");
    if (isHide) {
        for (var row in tasks) {
            hideTask(row);
        }
    } else {
        for (var row in tasks) {
            showTask(row);
        }
    }
}

function hideTask(rowWithTask) {
    var task = rowWithTask.getElementsByTagName("th");
    if (task[3].value === true) {
            rowWithTask.setAttribute("hidden", "true");
    }
}

function showTask(rowWithTask) {
    rowWithTask.setAttribute("hidden", "false");
}