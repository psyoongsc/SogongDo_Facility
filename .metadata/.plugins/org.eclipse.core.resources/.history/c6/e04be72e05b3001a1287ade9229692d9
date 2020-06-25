<%@ page import="java.util.List" %>
<%@ page import="persistance.AuthorityDTO" %><%--
  Created by IntelliJ IDEA.
  User: Herase
  Date: 2020-06-03
  Time: 오후 2:51
  To change this template use File | Settings | File Templates.
--%>
<%--
 모둘 설계자 : 김인환

 검토자 : 박성용, 김주현
 검토 날짜: 06/05

 수정 일자: 06/05
 수정 내용: 팝업창 닫힐때 조회화면 초기화하게 하는 기능 추가, 삭제,수정시 체크박스에 체크 안했다면 삭제,수정창 진입못하는 기능 추가
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <style>
        .id {
            margin: 0;
            width: 100px;
            text-align: center;
            border-width: 1px;
        }

        .info {
            margin: 0;
            width: 200px;
            text-align: center;
            border-width: 1px;
        }
        .tableview {
            margin-left : 200px;
            margin-top : 120px;
            max-width : 400px;
        }

        .ch {
            margin: 0;
            width: 150px;
            text-align: center;
            border-width: 1px;
        }

        table {
            border: 1px solid #444444;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #444444;
            border-collapse: collapse;
        }

        .btn {
            margin-top: 10px;
            margin-left: 20px;
        }
        .spec {
            width: 200px;
            text-align : center;
        }
    </style>
    <title>권한 관리페이지</title>
</head>
<body>
<div class="AuthorityInfo">
    <div class = "tableview">
        <table  class="table1">
           <thead>
            <tr>
                <td class="ch">체크박스</td>
                <td class="id">ID</td>
                <td class="info">권한</td>
            </tr>
           </thead>
            <%
                List<AuthorityDTO> list = (List<AuthorityDTO>) request.getAttribute("authorityDto");
                for (AuthorityDTO dto : list) {
                    pageContext.setAttribute("dto",dto);
            %>
            <tr>
                <td class="ch">
                    <input type="checkbox" name="columncheck" onclick="oneCheckbox(this)">
                </td>
                <td class="id">${dto.ID}</td>
                <td class="info">${dto.authorityName}</td>
            </tr>
            <% } %>
        </table>
        <button class="btn" onclick="enrollPopUp()">등록</button>
        <button class="btn" onclick="deletePopUp()">삭제</button>
        <button class="btn" onclick="updatePopUp()">수정</button>
        <input type="text" id="recieve_id" hidden>
    </div>
</div>
<script>
    function oneCheckbox(a){
        var obj = document.getElementsByName("columncheck");
        for(var i=0; i<obj.length; i++){
            if(obj[i] != a){
                obj[i].checked = false;
            }
        }
    }
    function enrollPopUp(){
        openpopUp("AuthorityEnrollView.jsp","등록창","width=400, height=300, left=300, top=300");
    }


    var openpopUp = function (uri, name, options) {
        var win = window.open(uri , name , options);
        var interval = window.setInterval(function () {
            try{
                if (win == null || win.closed) {
                    window.clearInterval(interval);
                    window.location.reload();
                }
            }catch (e) {

            }
        },1000);
    };

    function deletePopUp() {
        var checkbox = $("input:checkbox[name=columncheck]:checked");
        if($("input:checkbox[name=columncheck]:checked").length == 1) {
            var col1 = "";
            var col2 = "";
            checkbox.each(function (i) {
                var tr = checkbox.parent().parent().eq(i);
                var td = tr.children();
                col1 = td.eq(1).text();
                col2 = td.eq(2).text();
            });
            var really = confirm("정말로 삭제하시겠습니까?");
            if (really) {
                var url = 'Delete?id=' + col1 + '&name=' + col2;
                var win = window.open(url, "삭제창", "width=400, height=300, left=300, top=300");
                var interval = window.setInterval(function () {
                    try {
                        if (win == null || win.closed) {
                            window.clearInterval(interval);
                            window.location.reload();
                        }
                    } catch (e) {
                    }
                }, 1000);
            }
        }
        else{
            alert("체크박스로 삭제할 항목을 선택해 주시기 바랍니다.");
        }
    }
    function updatePopUp(){
        var checkbox = $("input:checkbox[name=columncheck]:checked");
        if($("input:checkbox[name=columncheck]:checked").length == 1)
        {
            openpopUp("AuthorityUpdateView.jsp","수정창","width=400, height=300, left=300, top=300");
            setUpdateid();
        }
        else
        {
            alert("체크박스로 수정할 항목을 선택해 주시기 바랍니다.");
        }
    }
    function setUpdateid()
    {
        var checkbox = $("input:checkbox[name=columncheck]:checked");
        var col1 = "";
        checkbox.each(function (i) {
            var tr = checkbox.parent().parent().eq(i);
            var td = tr.children();
            col1 = td.eq(1).text();
        });
        document.getElementById("recieve_id").value = col1;
    }
</script>
</body>
</html>
