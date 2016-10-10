<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html lang="ru">
<head>

    <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>MANGO STORE</title>

    <!-- Bootstrap -->

    <style type="text/css">
        <%@include file="css/bootstrap.css" %>
        <%@include file="css/style.css" %>
        <%@include file="css/bootstrap-theme.css" %>
    </style>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<div class="container">
    <div class="row topmenu">
        <div class="col-lg-12">
            <ul class="nav nav-pills">
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Компания <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">О нас</a></li>
                        <li><a href="#">Магазины</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Резюме разработчика</a></li>
                    </ul>
                </li>
                <li class="topbutton">
                    <a href="#">Акции</a>
                </li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Клиентам<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Оплата</a></li>
                        <li><a href="#">Доставка</a></li>
                        <li><a href="#">Сервисный центр</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Поддержка<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Служба поддержки клиентов</a></li>
                        <li><a href="#">Прошивка смартфонов</a></li>
                    </ul>
                </li>
                <li class="topbutton">
                    <a href="#">Новости</a>
                </li>
                <li class="topbutton">
                    <a href="#">Обзоры</a>
                </li>
                <li class="dropdown pull-right">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Личный кабинет</a>
                </li>
            </ul>
        </div>
    </div>

    <div class="row middle">
        <div class="col-lg-7 logo">
            <img src="http://urlid.ru/au3m">
        </div>
        <div class="col-lg-3">
            <div class="middle-menu-centr">
                <p class="order">Оформить заказ:</p>
                <p class="phone">0 800 00 71 20</p>
                <p class="order">Служба поддержки клиентов:</p>
                <p class="phone">0 800 00 71 30</p>
            </div>

        </div>
        <div class="col-lg-1 pull-right">
            <p class="basket"><img src="http://urlid.ru/aucg" alt="basket">
                Корзина </p>


        </div>
    </div>

</div>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual images as needed -->
<script src="js/bootstrap.js"></script>
</body>
</html>