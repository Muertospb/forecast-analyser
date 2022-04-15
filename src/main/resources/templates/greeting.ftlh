<#import "parts/common.ftlh" as c>

<@c.page>
    <div>Hi!</div>
    <div>My name is Dmitrii and I started this pet project 09-Apr-2022.</div>
    <div>Frontend isn't my favorite part, as you can see, so UI is created with Spring MVC + Freemaker framework.</div>
    <br></br>
    <strong>Description</strong>
    <div>Forecast Analyzer collects the forecast data for selected locations and provides statistics on the accuracy of forecasts depending on the depth of forecasting</div>
    <br></br>
    <strong>How to use</strong>
    <div>You can register new user from main page, or use "demo/demo" as credentials to login.</div>
    <div>You will see a list of locations that current user subscribed. From this list you can select location to process statistics. It is possible to search and subscribe to new location, but it will take at least 2 days to collect required amount of data</div>
    <a href="/main">Main page</a>
    <br></br>
    <strong>Milestones</strong>
    <div>1. Project init, preliminary configuration</div>
    <div>2. Main controller, MVC initialization</div>
    <div>3. Data model design</div>
    <div>4. Dto/entities/repositories</div>
    <div>5. Liquibase datasets</div>
    <div>6. Spring Security. Login page, registration. User controller</div>
    <div>7. Main page, list of subscribes</div>
    <div>8. Scheduled data collection from "openweathermap"</div>
    <div>9. Locations Controller. Search and subscribe locations</div>
    <div>10. VPS rent, configuration</div>
    <div>11. First deploy, start collecting demo data</div>
    <div>12. Statistic stub</div>
    <div>13. Docker</div>
    <div>14. CI/CD configuring via GitHub Actions</div>
    <div>---=== You are here ===---</div>
    <div>15. Statistic processing logic implementation</div>
    <div>16. Unexpected features</div>
    <div>17. UI improvement</div>
    <br></br>
    <strong>Stack</strong>
    <div>Spring Boot, Spring MVC, Spring Security, Hibernate, Liquibase, Freemaker, RestTemplate, PostgreSQL, Docker, Git, Maven, JUnit</div>
    <div>VPS - Ubuntu 20.04.4 LTS</div>
    <div>Sources - <a href="https://github.com/Muertospb/forecast-analyser">GitHub</a></div>
</@c.page>
