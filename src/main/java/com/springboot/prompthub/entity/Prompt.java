package com.springboot.prompthub.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import java.io.IOException;
import java.util.List;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
public class Prompt extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Column(name = "description", nullable = false, length = 256)
    private String description;

    @Column(nullable = false, length = 64)
    private String model;

    @Column(nullable = false)
    private int tokens;

    @Type(JsonType.class)
    @Column(name = "messages", nullable = true, columnDefinition = "JSON")
    //todo: usuń jeżeli @Type(JsonType.class) będzie poprawnie konwertować Listę wiadomości na tablicę JSON
    //@Convert(converter = MessageConverter.class)
    private List<Message> messages;
}


