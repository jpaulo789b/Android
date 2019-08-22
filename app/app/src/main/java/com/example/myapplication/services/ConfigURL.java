package com.example.myapplication.services;

public enum ConfigURL {

    DADOSCLIENTE("https://api.myjson.com/bins/1bo7qj/"),
    PEDIDOSCLIENTE("https://api.myjson.com/bins/wjl97/");

    private String url;

    private ConfigURL(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
