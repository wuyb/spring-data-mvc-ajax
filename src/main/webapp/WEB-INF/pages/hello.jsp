<html>
<head>
    <title>JATA</title>
    <link rel="stylesheet" type="text/css" href="/static/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/static/css/style.css">
</head>
<body>
    <div class="row-fluid">
        <div class="span4 offset1">
            <h2>Just Another Todo App</h2>
            <form action="/todo/" id="create-todo-form">
                <input id="create-todo-text" class="input-large" name="text" placeholder=" Remind me to ..."/>
                <button class="btn">Add</button>
            </form>
            <ul id="todos"></ul>
        </div>
    </div>

    <script src="/static/js/jquery-1.10.1.js"></script>
    <script src="/static/js/bootstrap.js"></script>
    <script src="/static/js/scripts.js"></script>
</body>
</html>