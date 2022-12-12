package com.example.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Name {
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
