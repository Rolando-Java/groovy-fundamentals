package com.thererolando.groovybasics.test.testuno

import groovy.transform.Canonical

import java.time.LocalDate
import java.time.ZoneId

@Canonical
class Tweet {

    String post
    String username
    LocalDate postDateTime

    private List<String> favorites = []
    private List<String> retweets = []
    private List mentions = []
    private List hashTags = []

    def favorite(String username) {
        favorites << username
    }

    def getFavorites() {
        this.favorites
    }

    def retweet(String username) {
        retweets << username
    }

    def getRetweets() {
        this.retweets
    }

    def getMentions() {
        def pattern = ~/\B@[a-z0-9_-]+/
        this.post.findAll(pattern)
    }

    def getHashTags() {
        def pattern = ~/(?:\s|\A)[##]+[A-Za-z0-9-_]+/
        this.post.findAll(pattern)
    }

}

Tweet tweet = new Tweet(post: 'This Groovy Course by @therealdanvega is awesome! #Java #groovylang',
        username: '@therealdanvega', postDateTime: LocalDate.now(ZoneId.systemDefault()))
println tweet

tweet.favorite('@ApacheGroovy')
tweet.retweet('@ApacheGroovy')

println tweet.favorites
println tweet.retweets
println tweet.mentions
println tweet.hashTags




