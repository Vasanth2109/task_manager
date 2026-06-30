const API = "/api/tasks";

window.onload = loadTasks;

function loadTasks() {

    fetch(API)
        .then(response => response.json())
        .then(tasks => {

            let list =
                document.getElementById("taskList");

            list.innerHTML = "";

            updateCounts(tasks);

            tasks.forEach(task => {

                list.innerHTML += `
                    <li class="task-item">

                        <span class="${
                            task.status === 'COMPLETED'
                            ? 'completed'
                            : ''
                        }">

                            ${task.title}
                            (${task.status})

                        </span>

                        <br><br>

                        ${
                            task.status === 'PENDING'
                            ? `<button class="complete-btn"
                                onclick="completeTask(${task.id})">
                                Complete
                               </button>`
                            : ''
                        }

                        <button class="delete-btn"
                            onclick="deleteTask(${task.id})">
                            Delete
                        </button>
                    </li>
                `;
            });
        });
}
function addTask() {

    let title =
        document.getElementById("taskInput")
                .value;

    if(title.trim() === "") {

        alert("Task title cannot be empty");
        return;
    }

    fetch(API, {

        method: "POST",

        headers: {
            "Content-Type":"application/json"
        },

        body: JSON.stringify({
            title:title
        })

    })
    .then(() => {

        document.getElementById("taskInput")
                .value = "";

        loadTasks();
    });
}
function completeTask(id) {

    fetch(`${API}/${id}`, {
        method:"PUT"
    })
    .then(() => loadTasks());
}
function deleteTask(id) {

    fetch(`${API}/${id}`, {
        method:"DELETE"
    })
    .then(() => loadTasks());
}
function updateCounts(tasks) {

    const total =
        tasks.length;

    const completed =
        tasks.filter(
            task =>
                task.status === "COMPLETED"
        ).length;

    const pending =
        total - completed;

    document.getElementById("total")
            .innerText = total;

    document.getElementById("completed")
            .innerText = completed;

    document.getElementById("pending")
            .innerText = pending;
}
function searchTasks() {

    let keyword =
        document.getElementById("searchInput")
                .value
                .toLowerCase();

    let tasks =
        document.querySelectorAll(".task-item");

    tasks.forEach(task => {

        let text =
            task.innerText.toLowerCase();

        if(text.includes(keyword)) {

            task.style.display = "block";

        } else {

            task.style.display = "none";
        }
    });
}