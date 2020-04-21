<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <title>Url Shortner Home</title>
    <script type="text/javascript" src="/static/asset/js/jquery-3.5.0.min.js"></script>
</head>
<body>
    <div>
        변경 할 URL (http:// | https:// 포함) : <input id="url_input" text="" />
        <input type="button" onclick="convert();" value="변경"/>
    </div>
    <div id="result" style="max-width: 1024px;"></div>
</body>
</html>

<script type="text/javascript">

    //단일 데이터 메칭
    function convert(){
        var text = $("#url_input").val();
        if(text != null){

            $.ajax({
                type: "get",
                url: "/rest/convert",
                data: {urlStr: text},
                success: function(data) {
                    console.log(data)
                    if(data.successFlag){
                        if(data.shortUrlType == "ORIGIN"){
                            $("#result").html("<p>원본 URL : " + data.shortUrl.originUrl +"</p><p> 요청 횟수:" + data.shortUrl.reqCount + "</p>");
                        }else{
                            $("#result").html("<p>변경 URL : " + data.shortUrl.shortUrl +"</p><p> 요청 횟수:" + data.shortUrl.reqCount + "</p>");
                        }

                    }else{
                        $("#result").html("<p>"+text + ' 줄이기 실패. </p>');
                    }

                }
            });

        }
    }
</script>