# Member Controller

## 전체 회원 조회

{% swagger method="get" path="" baseUrl="http://localhost:8080/v1/members" summary="전체 회원 목록 조회" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="header" name="Content-Type" type="String" required="true" %}
application/json
{% endswagger-parameter %}

{% swagger-parameter in="header" name="Content-Length" type="String" required="true" %}

{% endswagger-parameter %}

{% swagger-parameter in="body" name="data" type="Array" required="true" %}
결과 데이터
{% endswagger-parameter %}

{% swagger-parameter in="body" name="data.id" type="Number" required="true" %}
번호
{% endswagger-parameter %}

{% swagger-parameter in="body" name="data.name" type="String" required="true" %}
이름
{% endswagger-parameter %}

{% swagger-parameter in="body" name="data.sex" type="String" required="true" %}
성별
{% endswagger-parameter %}

{% swagger-parameter in="body" name="data.company_name" type="String" required="true" %}
회사 이름
{% endswagger-parameter %}

{% swagger-parameter in="body" name="data.company_type" type="String" required="true" %}
회사 타입 코드
{% endswagger-parameter %}

{% swagger-parameter in="body" type="String" name="data.company_location" required="true" %}
회사 위치 코드
{% endswagger-parameter %}

{% swagger-parameter in="query" name="page" type="Number" required="true" %}
페이지 번호
{% endswagger-parameter %}

{% swagger-parameter in="query" name="size" type="Number" required="true" %}
페이지 수
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="" %}
```javascript
{
    // Response
}
```
{% endswagger-response %}
{% endswagger %}

## 특정 조건에 맞는 회원 조회

{% swagger method="get" path="" baseUrl="http://localhost:8080/v1/find" summary="특정 조건에 맞는 회원 조회" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="query" name="page" type="Number" required="true" %}
페이지 번호
{% endswagger-parameter %}

{% swagger-parameter in="query" name="size" type="Number" required="true" %}
페이지 수
{% endswagger-parameter %}

{% swagger-parameter in="query" name="name" type="String" required="true" %}
이름
{% endswagger-parameter %}

{% swagger-parameter in="query" name="sex" type="String" required="true" %}
성별
{% endswagger-parameter %}

{% swagger-parameter in="header" name="Content-Type" type="String" required="true" %}
application/json
{% endswagger-parameter %}

{% swagger-parameter in="header" name="Content-Length" type="String" required="true" %}

{% endswagger-parameter %}

{% swagger-parameter in="body" name="data" type="Array" required="true" %}
결과 데이터
{% endswagger-parameter %}

{% swagger-parameter in="body" name="data.id" type="String" required="true" %}
번호
{% endswagger-parameter %}

{% swagger-parameter in="body" name="data.name" type="String" required="true" %}
이름
{% endswagger-parameter %}

{% swagger-parameter in="body" name="data.sex" type="String" required="true" %}
성별
{% endswagger-parameter %}

{% swagger-parameter in="body" name="data.company_name" type="String" required="true" %}
회사 이름
{% endswagger-parameter %}

{% swagger-parameter in="body" name="data.company_type" type="String" required="true" %}
회사 타입 코드
{% endswagger-parameter %}

{% swagger-parameter in="body" name="data.company_location" type="String" required="true" %}
회사 위치 코드
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="" %}
```javascript
{
    // Response
}
```
{% endswagger-response %}
{% endswagger %}
