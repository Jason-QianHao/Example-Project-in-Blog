package com.jason.generator.config;

import java.util.List;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.PrimitiveTypeWrapper;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.AbstractJavaGenerator;

/**
 * 自定义分页规则
 * @author qianhao
 *
 */
public class MysqlPaginationPlugin extends PluginAdapter {
    public MysqlPaginationPlugin() {}

    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        this.addLimit(topLevelClass, introspectedTable, "limitStart");
        this.addLimit(topLevelClass, introspectedTable, "limitSize");
        return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }

    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
            IntrospectedTable introspectedTable) {
        XmlElement isNotNullElement = new XmlElement("if");
        isNotNullElement
                .addAttribute(new Attribute("test", "limitStart != null and limitSize >= 0"));
        isNotNullElement.addElement(new TextElement("limit #{limitStart} , #{limitSize}"));
        element.addElement(isNotNullElement);
        return super.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element,
            IntrospectedTable introspectedTable) {
        XmlElement isNotNullElement = new XmlElement("if");
        isNotNullElement
                .addAttribute(new Attribute("test", "limitStart != null and limitSize >= 0"));
        isNotNullElement.addElement(new TextElement("limit #{limitStart} , #{limitSize}"));
        element.addElement(isNotNullElement);
        return super.sqlMapSelectByExampleWithBLOBsElementGenerated(element, introspectedTable);
    }

    private void addLimit(TopLevelClass topLevelClass, IntrospectedTable introspectedTable,
            String name) {
        CommentGenerator commentGenerator = this.context.getCommentGenerator();
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(PrimitiveTypeWrapper.getIntegerInstance());
        field.setName(name);
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        char c = name.charAt(0);
        String camel = Character.toUpperCase(c) + name.substring(1);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + camel);
        method.addParameter(new Parameter(PrimitiveTypeWrapper.getIntegerInstance(), name));
        StringBuilder sb = new StringBuilder();
        sb.append("this.");
        sb.append(name);
        sb.append(" = ");
        sb.append(name);
        sb.append(";");
        method.addBodyLine(sb.toString());
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        Method getterMethod = AbstractJavaGenerator.getGetter(field);
        commentGenerator.addGeneralMethodComment(getterMethod, introspectedTable);
        topLevelClass.addMethod(getterMethod);
    }

    public boolean validate(List<String> warnings) {
        return true;
    }



    /**
     * 生成mapper.xml,文件内容会被清空再写入
     * */
    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        sqlMap.setMergeable(false);
        return super.sqlMapGenerated(sqlMap, introspectedTable);
    }

}