<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div>
        <@l.logout />
        <br></br>
    </div>
    <div>
        You are subscribed to:
    </div>
    <#list cities?sort_by("name") as city>
        <div>
            <form action="/stats" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input type="hidden" name="city_id" value="${city.id}" />
                <div><a>${city.name}, ${city.country}, ${city.state}  </a><input type="submit" value="Show statistics"></div>
            </form>
        </div>
    <#else>
        No city found
    </#list>
    <br></br>
    <a href="/search">Subscribe new location</a>
</@c.page>