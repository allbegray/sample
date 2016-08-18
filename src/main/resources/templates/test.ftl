select
    b.*
from board b
<@where>
    <#if searchContext.age??>
        AND B.AGE = ${param(searchContext.age)}
    </#if>
    <#if searchContext.name?has_content>
        AND B.NAME = ${param(searchContext.name)}
    </#if>
</@where>