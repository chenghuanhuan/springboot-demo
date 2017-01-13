<!DOCTYPE HTML>
<html>
<head>
    <base href="localhost://localhost:8080/">
    <title>My WebSocket</title>
</head>

<body>
Welcome<br/>
<input id="text" type="text"/>
<button onclick="send()">Send</button>
<button onclick="closeWebSocket()">Close</button>
<div id="message">
</div>
</body>

<script type="text/javascript">
    var arr =[];
    var websocket = null;

    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        for (var i=0;i<100;i++){
            var websocket1 = new WebSocket("ws://localhost:9090/");
            arr.push(websocket1);
        }

    }
    else {
        alert('Not support websocket')
    }

    //连接发生错误的回调方法
    arr[0].onerror = function () {
        setMessageInnerHTML("error");
    };

    //连接成功建立的回调方法
    arr[0].onopen = function (event) {
        setMessageInnerHTML("open");
    }

    //接收到消息的回调方法
    arr[0].onmessage = function (event) {
        setMessageInnerHTML(event.data);
    }

    //连接关闭的回调方法
    arr[0].onclose = function () {
        setMessageInnerHTML("close");
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        arr[0].close();
    }

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        document.getElementById('message').innerHTML += innerHTML + '<br/>';
    }

    //关闭连接
    function closeWebSocket() {
        arr[0].close();
    }

    //发送消息
    function send() {
        var message = document.getElementById('text').value;
        arr[0].send(message);
    }
</script>
</html>