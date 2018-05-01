package com.antworks.txtprocessor

import scala.language.postfixOps

/**
  * Created by Dennis Saka on 2018/04/30.
  */
  object UserTweetsProcessing extends App {

  if (args.length == 0) {
    println("Usage for scala : scala UserTweetsProcessing.scala /user.txt /tweet.txt")
    println("Usage for java : java -jar scala-txtprocessor-assembly-1.0.0-SNAPSHOT.jar /user.txt /tweet.txt")
  }
  val userfile = args(0)
  val tweetfile = args(1)

  val userFileTokens = new UserTweetFileTXTReader(userfile)
  val tweetFileTokens = new UserTweetFileTXTReader(tweetfile)

  var nodes = Map.empty[String, List[String]]


 def buildUsersWithEmptyTweets(stringsFromUserFile: String) : List[(String, String)] = {
   val strUserTokens = stringsFromUserFile
     .split(Array(',', ' '))
     .filterNot(fStr => fStr == "follows")
     .filter(_.nonEmpty)
     .map(_.trim)
     .toList
     .distinct

   for {
     str <- strUserTokens
    } yield (str, "")

 }
  // create multimap of user and their tweets
  def addNode(key: String, value: String) = {
    nodes += (key -> (value :: (nodes get key getOrElse Nil)))
  }

  def userTweetMap(sequenceFromTweetFile: Seq[String], stringsFromUserFile: String) = {
    val pairs = for {
      str <- sequenceFromTweetFile
      s = str.split("> ").map(_.trim).toList
    } yield (s.head, s.tail mkString)

//    merge users from both txt files
    val allUsersAndTweets = pairs ++ buildUsersWithEmptyTweets(stringsFromUserFile)

    for ((user, tweet) <- allUsersAndTweets.distinct) {
      addNode(user, tweet)
    }

    displayUsersAndTweet
  }

  // Display All users and their tweets
  def displayUsersAndTweet() = {

    nodes.keys.foreach { k =>
      println("\n" + k)
      // clean format users with empty tweets
      for (v <- nodes(k) if v != "") println("\t" + "@" + k + ": " + v)
    }
  }

  userTweetMap(tweetFileTokens.stringsFromTweetFile, userFileTokens.stringsFromUserFile)

}
