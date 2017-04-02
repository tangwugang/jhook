<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packageName}.dal.dao.${modelName}.${entityName?cap_first}Dao">
    <#assign tagfirst= '{'/>
    <#assign tagend= '}'/>
    <#assign pagefirst= '$'/>

    <sql id="${entityName}Columns">
        <trim suffixOverrides=",">
            <#list columns as c>
            ${c.originalColumnName} as ${c.columnName},
            </#list>
        </trim>
    </sql>

    <sql id="${entityName}Insert">
        <trim suffixOverrides=",">
        <#list columns as c>
        ${c.originalColumnName},
        </#list>
        </trim>
    </sql>

    <sql id="${entityName}Update">
        <set>
            <trim prefixOverrides=",">

            <#list columns as c>
            <#if c.columnName == "isDeleted" >
                <if test="${c.columnName} != null">${c.originalColumnName} = #${tagfirst}${c.columnName}${tagend},</if>
            </#if>
            <#if c.columnName == 'modifier'>
                <if test="${c.columnName} != null">${c.originalColumnName} = #${tagfirst}${c.columnName}${tagend},</if>
            </#if>
            <#if c.columnName == 'gmtModified'>
                <if test="${c.columnName} != null">${c.originalColumnName} = #${tagfirst}${c.columnName}${tagend},</if>
            </#if>
            <#if c.columnName != 'id'
            && c.columnName != 'isDeleted'
            && c.columnName != 'creator'
            && c.columnName != 'modifier'
            && c.columnName != 'gmtCreate'
            && c.columnName != 'gmtModified'>
                <if test="${c.columnName} != null">${c.originalColumnName} = #${tagfirst}${c.columnName}${tagend},</if>
            </#if>
            </#list>
            </trim>
        </set>
    </sql>

    <sql id="${entityName}Where">
        <trim prefix="WHERE" prefixOverrides="AND | OR">
        <#list columns as c>
            <if test="${c.columnName} != null">
                AND ${c.originalColumnName} = #${tagfirst}${c.columnName}${tagend}
            </if>
        </#list>
        </trim>
    </sql>

    <update id="delete">
        UPDATE ${tableName}
        SET is_deleted = 1
        <include refid="${entityName}Where"/>
    </update>

    <update id="deleteById">
        UPDATE ${tableName}
        SET is_deleted = 1
        WHERE 1=1
        AND id = #${tagfirst}id${tagend}
    </update>

    <update id="deleteByIds">
        UPDATE ${tableName}
        SET is_deleted = 1
        WHERE 1=1
        AND id IN
        <foreach collection="list" open="(" close=")" item="item" index="index" separator=",">
        #${tagfirst}item${tagend}
        </foreach>
    </update>

    <select id="get" resultType="${entityName?cap_first}">
        SELECT
        <include refid="${entityName}Columns"/>
        FROM ${tableName}
        <include refid="${entityName}Where"/>
    </select>

    <select id="getById" resultType="${entityName?cap_first}" parameterType="Long">
        SELECT
        <include refid="${entityName}Columns"/>
        FROM ${tableName}
        WHERE is_deleted = 0
        AND id = #${tagfirst}id${tagend}
    </select>

    <select id="queryCount" resultType="Integer" parameterType="${entityName?cap_first}">
        SELECT COUNT(id)
        FROM ${tableName}
        <include refid="${entityName}Where"/>
    </select>

    <select id="queryAll" resultType="${entityName?cap_first}">
        SELECT
        <include refid="${entityName}Columns"/>
        FROM ${tableName}
        <include refid="${entityName}Where"/>
    </select>

    <select id="queryByIds" resultType="${entityName?cap_first}">
        SELECT
        <include refid="${entityName}Columns"/>
        FROM ${tableName}
        WHERE 1=1
        AND id IN
        <foreach collection="list" open="(" close=")" index="index" item="item" separator=",">
        #${tagfirst}item${tagend}
        </foreach>
    </select>

    <select id="queryByPage" resultType="${entityName?cap_first}">
        SELECT
        <include refid="${entityName}Columns"/>
        FROM ${tableName}
        <include refid="${entityName}Where"/>
        <if test="page.orders != null &amp;&amp; page.orders.size > 0">
            ORDER BY
            <foreach collection="page.orders" index="index" item="item" separator=",">
            #${tagfirst}item${tagend}
            </foreach>
        </if>
        LIMIT ${pagefirst}${tagfirst}page.offSet${tagend},${pagefirst}${tagfirst}page.limit${tagend}
    </select>

    <insert id="insert">
        INSERT INTO ${tableName}
        (
        <include refid="${entityName}Insert"/>
        )
        VALUES
        (
        <trim suffixOverrides=",">
        <#list columns as c>
        #${tagfirst}${c.columnName}${tagend},
        </#list>
        </trim>
        )
    </insert>

    <insert id="batchInsert">
        INSERT INTO ${tableName}
        (
        <include refid="${entityName}Insert"/>
        )
        VALUES
        <foreach collection="list" index="index" item="item" separator=",">
            (
            <trim suffixOverrides=",">
            <#list columns as c>
            #${tagfirst}item.${c.columnName}${tagend},
            </#list>
            </trim>
            )
        </foreach>
    </insert>

    <update id="update">
        UPDATE ${tableName}
        <include refid="${entityName}Update"/>
        WHERE 1=1
        AND id = #${tagfirst}id${tagend}
    </update>
</mapper>