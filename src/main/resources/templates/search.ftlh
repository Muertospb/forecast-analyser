<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div>
        <@l.logout />
        <br></br>
    </div>
    <div>
        <form action="/search" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div><label> Enter city name : <input type="text" name="request"/> </label></div>
            <div><input type="submit" value="Search"></div>
        </form>
    </div>
</@c.page>