package com.senai.devs.senaiexchange.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "posts_tags")
public class PostTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tag_id;
}