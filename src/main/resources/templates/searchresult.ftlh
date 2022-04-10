<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div>
        <@l.logout />
        <br></br>
    </div>
    <#list locations as city>
        <div>
            <form action="/subscribe" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input type="hidden" name="name" value="${city.name}" />
                <input type="hidden" name="lat" value="${city.lat}" />
                <input type="hidden" name="lon" value="${city.lon}" />
                <input type="hidden" name="country" value="${city.country}" />
                <input type="hidden" name="state" value="${city.state}" />
                <div><a>${city.name}, ${city.country} ${city.state}</a>><input type="submit" value="Subscribe"></div>
            </form>
        </div>
    <#else>
        No city found
    </#list>
    <br></br>
    <a href="/search">New search</a>
</@c.page>