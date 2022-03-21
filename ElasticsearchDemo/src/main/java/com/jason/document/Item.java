package com.jason.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "item")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Item {
    @Id
    private Long id;
    // title使用ik进行分词
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String title;
    // brand 不被分词
    @Field(type=FieldType.Keyword)
    private String brand;
    @Field(type=FieldType.Double)
    private Double price;
    // brand 不被分词，且不创建索引
    @Field(index = false,type = FieldType.Keyword)
    private String images;
}
