<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="text">
    <table>
        <tbody>
        <c:forEach items="${productsInCart}" var="position">
            <tr>
                <td>
                    <pre><a href="${position.product.imageURL}"><img src="${position.product.imageURL}"
                                                                     alt="${position.product.productTitle}"
                                                                     height="100"></a></pre>
                </td>
                <td>
                    <p style="margin-top: 10px; margin-bottom: 0px">
                        <strong><a class="title-review" href="/product-${position.product.productId}">
                            <span style="font-size: 16px; color: #7eb105">${position.product.productTitle}</span>
                        </a></strong></p>
                    <p><span
                            style="font-size: 12px; color: darkgrey; ">Код товара: ${position.product.productId}</span>
                    </p>
                </td>
                <td></td>
                <td style="text-align: right;">
                    <form action="/cart-remove-position" method=post>
                        <input type="hidden" name="id" value="${position.product.productId}">
                        <input type="hidden" name="url" value="${url}">
                        <input type="submit" value="" alt="Удалить товар"/>
                    </form>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="cart-review">
                        <span style="color:gray;">Цена</span>
                        <span style="color:black;"><strong><p>${position.product.getFormatFullPrice()} ₴</p></strong></span>
                    </div>
                </td>
                <c:choose>
                    <c:when test="${position.product.fullPrice != position.product.salePrice}">
                        <td>
                            <div class="cart-review">
                                <span style="color:gray;">Цена со скидкой</span>
                                <span style="color:red;"><strong><p>${position.product.getFormatSalePrice()} ₴</p></strong></span>
                            </div>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td></td>
                    </c:otherwise>
                </c:choose>
                <td>
                    <div class="cart-review">
                        <span style="color:gray;">Количество</span>
                        <span style="text-align: center;"><strong><p>${position.number}</p></strong></span>
                    </div>
                </td>
                <td>
                    <div class="cart-review">
                        <span style="color:gray;">Сумма</span>
                        <strong><p><span>${position.getFormatPrice()}</span> ₴
                        </p></strong>
                    </div>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td>
                <div class="cart-review">
                    <span style="color:gray;text-align: right;">Итого к оплате</span>
                    <strong><p><span>${cart_format_price}</span> ₴
                    </p></strong>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
</div>