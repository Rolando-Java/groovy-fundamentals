package com.thererolando.groovybasics.lesson5practiceclass

@groovy.transform.ToString
class Tweet {

    String user
    String comment
    Integer retweets
    Integer favorites
    Date createdOn

    Tweet(String user, String comment) {
        this.user = user
        this.comment = comment
        this.retweets = 0
        this.favorites = 0
        this.createdOn = new Date()
    }

    void addToRetweets() {
        this.retweets ++
    }

    void addToFavorites() {
        this.favorites ++
    }

}